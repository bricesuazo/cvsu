extends KinematicBody

export(NodePath) var camera_path
export(NodePath) var weapon_camera_path
export(NodePath) var weapon_manager_path
export(NodePath) var wallrun_node_path

onready var camera = get_node(camera_path)
onready var weapon_camera = get_node(weapon_camera_path)
onready var weapon_manager = get_node(weapon_manager_path)
onready var wallrun_node = get_node(wallrun_node_path)

const MOUSE_SENSITIVITY = 0.1

var velocity = Vector3.ZERO
var velocity_info = Vector3.ZERO
var current_vel = Vector3.ZERO
var dir = Vector3.ZERO
var snap = Vector3.ZERO

const SPEED = 8
const SPRINT_SPEED = 16
const ACCEL = 15.0

const GRAVITY = -40.0
const JUMP_SPEED = 15
var jump_counter = 0
const AIR_ACCEL = 9.0


var can_wallrun = false
var wallrun_delay = 0.2
onready var wallrun_delay_default = wallrun_delay


var is_wallrunning = false
var show_stamina = false
var wallrun_cooldown = false


export(float) var wallrun_angle = 15
var wallrun_current_angle = 0
var side = ""


var is_wallrun_jumping = false
var wall_jump_dir = Vector3.ZERO
export(float) var wall_jump_horizontal_power = 1.5
export(float) var wall_jump_vertical_power = 0.75
export(float, 0, 1) var wall_jump_factor = 0.4



func _ready():
	Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)


func _process(delta):
	window_activity()
	process_weapons(delta)


func _physics_process(delta):
	
	process_movement_inputs()
	process_vertical_movement(delta)
	
	process_wallrun()
	process_wallrun_stamina()
	process_wallrun_rotation(delta)
	
	process_movement(delta)


func process_movement_inputs():
	dir = Vector3.ZERO
	
	if Input.is_action_pressed("forward"):
		dir -= global_transform.basis.z
	if Input.is_action_pressed("backward"):
		dir += global_transform.basis.z
	if Input.is_action_pressed("right"):
		dir += global_transform.basis.x
	if Input.is_action_pressed("left"):
		dir -= global_transform.basis.x
	
	dir = dir.normalized()


func process_vertical_movement(delta):
	if is_on_floor():
		jump_counter = 0
		velocity.y = -0.01
		
		can_wallrun = false
		is_wallrunning = false
		is_wallrun_jumping = false
		wallrun_delay = wallrun_delay_default
	else:
		velocity.y += GRAVITY * delta
		
		wallrun_delay = clamp(wallrun_delay - delta, 0, wallrun_delay_default)
		
		if wallrun_delay == 0:
			if wallrun_cooldown == false:
				can_wallrun = true
	

	if Input.is_action_just_pressed("jump") and is_wallrunning:
		can_wallrun = false
		is_wallrunning = false
		
		current_vel = Vector3.ZERO
		
		velocity.y = JUMP_SPEED * wall_jump_vertical_power
		is_wallrun_jumping = true
		
		if side == "LEFT":
			wall_jump_dir = global_transform.basis.x * wall_jump_horizontal_power
		elif side == "RIGHT":
			wall_jump_dir = -global_transform.basis.x * wall_jump_horizontal_power
		
		wall_jump_dir *= wall_jump_factor
	
	
	if is_wallrun_jumping:
		dir = (dir * (1 - wall_jump_factor)) + wall_jump_dir
		return
	
	if Input.is_action_just_pressed("jump") and jump_counter < 2:
		jump_counter += 1
		velocity.y = JUMP_SPEED
		snap = Vector3.ZERO
	else:
		snap = Vector3.DOWN


func process_movement(delta):
	var speed = 0
	
	if Input.is_action_pressed("sprint") and Input.is_action_pressed("ads") == false:
		speed = SPRINT_SPEED
	else:
		speed = SPEED
	
	var target_vel = dir * speed
	
	var accel = ACCEL if is_on_floor() else AIR_ACCEL
	current_vel = current_vel.linear_interpolate(target_vel, accel * delta)
	
	velocity.x = current_vel.x
	velocity.z = current_vel.z
	
	velocity_info = move_and_slide_with_snap(velocity, snap, Vector3.UP, true, 4, deg2rad(45))
	
	process_movement_effects(speed, delta)


func process_movement_effects(speed, delta):
	if velocity_info.length() < 3.0 or (is_on_floor() == false and is_wallrunning == false):
		$AnimationPlayer.play("HeadBob", 0.1, 0.2)
	elif velocity_info.length() <= SPEED:
		$AnimationPlayer.play("HeadBob", 0.1, 1.0)
	else:
		$AnimationPlayer.play("HeadBob", 0.1, 1.5)
	
	if speed == SPRINT_SPEED and velocity_info.length() > 3.0 and is_wallrunning == false:
		weapon_camera.fov = lerp(weapon_camera.fov, 80, 10 * delta)
	else:
		weapon_camera.fov = lerp(weapon_camera.fov, 70, 10 * delta)





func process_wallrun():
	if can_wallrun:
		if is_on_wall() and Input.is_action_pressed("forward") and Input.is_action_pressed("sprint"):
			var collision = get_slide_collision(0)
			var normal = collision.normal
			
			var wallrun_dir = Vector3.UP.cross(normal)
			
			var player_view_dir = -camera.global_transform.basis.z
			var dot = wallrun_dir.dot(player_view_dir)
			if dot < 0:
				wallrun_dir = -wallrun_dir
			
			
			var wallrun_axis_2d = Vector2(wallrun_dir.x, wallrun_dir.z)
			var view_dir_2d = Vector2(player_view_dir.x, player_view_dir.z)
			var angle = wallrun_axis_2d.angle_to(view_dir_2d)
			
			angle = rad2deg(angle)
			if dot < 0:
				angle = -angle
			
			if angle > 85:
				is_wallrunning = false
				return
		
		
			wallrun_dir += -normal * 0.01
			
			is_wallrunning = true
			
			side = get_side(collision.position)
			
			velocity.y = -0.01
			dir = wallrun_dir
			
			if show_stamina == false:
				$HUD/StaminaBar/AnimationPlayer.play("FadeIn")
				show_stamina = true
		
		else:
			is_wallrunning = false



func process_wallrun_rotation(delta):
	if is_wallrunning:
		
		if side == "RIGHT":
			wallrun_current_angle += delta * 70
			wallrun_current_angle = clamp(wallrun_current_angle, -wallrun_angle, wallrun_angle)
		elif side == "LEFT":
			wallrun_current_angle -= delta * 70
			wallrun_current_angle = clamp(wallrun_current_angle, -wallrun_angle, wallrun_angle)
			
	else:
		if wallrun_current_angle > 0:
			wallrun_current_angle -= delta * 40
			wallrun_current_angle = max(0, wallrun_current_angle)
		elif wallrun_current_angle < 0:
			wallrun_current_angle += delta * 40
			wallrun_current_angle = min(wallrun_current_angle, 0)
	
	
	wallrun_node.rotation_degrees = Vector3(0, 0, 1) * wallrun_current_angle



func process_wallrun_stamina():
	if is_wallrunning and $HUD/StaminaBar.value > 0.0:
		$HUD/StaminaBar.decrease()
	
	elif is_wallrunning and $HUD/StaminaBar.value == 0.0:
		is_wallrunning = false
		can_wallrun = false
		wallrun_cooldown = true
	
	elif is_wallrunning == false and $HUD/StaminaBar.value < 100.0:
		$HUD/StaminaBar.increase()
		
		if $HUD/StaminaBar.value > 50.0:
			wallrun_cooldown = false
			
			if show_stamina:
				$HUD/StaminaBar/AnimationPlayer.play("FadeOut")
				show_stamina = false


func get_side(point):
	point = to_local(point)
	
	if point.x > 0:
		return "RIGHT"
	elif point.x < 0:
		return "LEFT"
	else:
		return "CENTER"


func process_weapons(delta):
	if Input.is_action_just_pressed("empty"):
		weapon_manager.change_weapon("Empty")
	if Input.is_action_just_pressed("primary"):
		weapon_manager.change_weapon("Primary")
	if Input.is_action_just_pressed("secondary"):
		weapon_manager.change_weapon("Secondary")
	
	if Input.is_action_pressed("fire"):
		weapon_manager.fire()
	if Input.is_action_just_released("fire"):
		weapon_manager.fire_stop()
	
	if Input.is_action_just_pressed("reload"):
		weapon_manager.reload()
	
	if Input.is_action_just_pressed("drop"):
		weapon_manager.drop_weapon()
	
	weapon_manager.process_weapon_pickup()
	
	if weapon_manager.current_weapon.name != "Unarmed":
		weapon_manager.current_weapon.sway(delta)
	
	if Input.is_action_pressed("ads"):
		weapon_manager.current_weapon.aim_down_sights(true, delta)
	else:
		weapon_manager.current_weapon.aim_down_sights(false, delta)



func _input(event):
	if event is InputEventMouseMotion:
		$CamRoot.rotate_x(deg2rad(event.relative.y * MOUSE_SENSITIVITY * -1))
		$CamRoot.rotation_degrees.x = clamp($CamRoot.rotation_degrees.x, -75, 75)
		
		self.rotate_y(deg2rad(event.relative.x * MOUSE_SENSITIVITY * -1))
	
	if event is InputEventMouseButton:
		if event.pressed:
			match event.button_index:
				BUTTON_WHEEL_UP:
					weapon_manager.next_weapon()
				BUTTON_WHEEL_DOWN:
					weapon_manager.previous_weapon()


func window_activity():
	if Input.is_action_just_pressed("ui_cancel"):
		get_tree().quit()
#		if Input.get_mouse_mode() == Input.MOUSE_MODE_CAPTURED:
#			Input.set_mouse_mode(Input.MOUSE_MODE_VISIBLE)
#		else:
#			Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)
