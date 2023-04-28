extends KinematicBody2D


onready var ui = get_node("/root/MainScene/CanvasLayer/UI")

export var speed: int = 400
export var jumpForce:int = 700
export var gravity:int = 1500

onready var sprite = $Sprite

var velocity: Vector2  = Vector2()
var grounded: bool = false

func _ready():
	pass

func _physics_process(delta):
	velocity.x = 0
	
	if Input.is_action_pressed("move_left_p2"):
		sprite.play("walk")
		velocity.x -= speed
	elif Input.is_action_pressed("move_right_p2"):
		sprite.play("walk")
		velocity.x += speed
	else:
		sprite.play("idle")
		
	if not is_on_floor():
		sprite.play("air")
	
	velocity = move_and_slide(velocity, Vector2.UP)

	velocity.y += gravity * delta

	if Input.is_action_pressed("jump_p2") and is_on_floor():
		velocity.y -= jumpForce
		
	if velocity.x < 0:
		sprite.flip_h = true
	elif velocity.x > 0:
		sprite.flip_h = false
	
func die():
	get_tree().reload_current_scene()

func collect_coin(value):
	ui.score += value
	
	ui.set_score_text(ui.score)

func _on_FallZone_body_entered(body):
	die()


