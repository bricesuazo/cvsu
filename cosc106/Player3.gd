extends KinematicBody2D

var score:int = 0

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
	
	if Input.is_action_pressed("move_left_p3"):
		velocity.x -= speed
	if Input.is_action_pressed("move_right_p3"):
		velocity.x += speed
	
	velocity = move_and_slide(velocity, Vector2.UP)

	velocity.y += gravity * delta

	if Input.is_action_pressed("jump_p3") and is_on_floor():
		velocity.y -= jumpForce
		
	if velocity.x < 0:
		sprite.flip_h = true
	elif velocity.x > 0:
		sprite.flip_h = false
	
func die():
	get_tree().reload_current_scene()

func collect_coin(value):
	score += value
	
	ui.set_score_text(score)
