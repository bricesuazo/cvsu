extends KinematicBody
# Declare member variables here. Examples:
# var a = 2
# var b = "text"


onready var interaction = get_node("Camera/Interaction")
onready var hand = get_node("Camera/Hand")

var pickedObject
var pullPower:float = 10.0

func pickObject():
	var collider = interaction.get_collider()
	
	if collider != null and collider is RigidBody:
		print("Test is working")
		pickedObject = collider

func dropObject():
	if pickedObject != null:
		print("Dropping?")
		pickedObject = null

export var moveSpeed: float = 5.0
export var jumpForce: float = 50.0
export var gravity: float = 300.0

var minLookAngle: float = -90.0
var maxLookAngle: float = 90.0
var lookSensitivity: float = 0.5

var velocity: Vector3 = Vector3()
var mouseDelta: Vector2 = Vector2()

onready var camera = get_node("Camera")

func _input(event):
	if event is InputEventMouseMotion:
		mouseDelta = event.relative
		
func _physics_process(delta):
	Input.set_mouse_mode(Input.MOUSE_MODE_CAPTURED)
	
	if Input.is_action_just_pressed("pickup_object"):
		if pickedObject == null:
			pickObject()
		else:
			dropObject()
	
		
	
	if pickedObject != null:
		var a = pickedObject.global_transform.origin
		var b = hand.global_transform.origin
		pickedObject.set_linear_velocity((b - a) * pullPower)
	
	velocity.x = 0
	velocity.y = 0
	var input = Vector2()

	moveSpeed = 5
	if Input.is_action_pressed("move_forward"):
		input.y -= moveSpeed
	if Input.is_action_pressed("move_backward"):
		input.y += moveSpeed
	if Input.is_action_pressed("move_left"):
		input.x -= moveSpeed
	if Input.is_action_pressed("move_right"):
		input.x += moveSpeed
	
	if Input.is_action_pressed("sprint") and is_on_floor():
		moveSpeed = 10
	elif Input.is_action_just_released("sprint") and is_on_floor():
		moveSpeed = 5
	
	input = input.normalized()
	
	var forward = global_transform.basis.z
	var right = global_transform.basis.x
	
	velocity.z = (forward * input.y + right * input.x).z * moveSpeed
	velocity.x = (forward * input.y + right * input.x).x * moveSpeed
	
	velocity.y -= gravity * delta
	
	if Input.is_action_just_pressed("jump") and is_on_floor():
		velocity.y = jumpForce * 2
	velocity = move_and_slide(velocity, Vector3.UP)
		
		

func _process(delta):
	camera.rotation_degrees -= Vector3(rad2deg(mouseDelta.y), 0, 0) * lookSensitivity * delta
	
	camera.rotation_degrees.x = clamp(camera.rotation_degrees.x, minLookAngle, maxLookAngle)
	
	rotation_degrees -= Vector3(0, rad2deg(mouseDelta.x), 0) * lookSensitivity * delta
	
	mouseDelta = Vector2()


# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
