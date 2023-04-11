extends Area2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
export var speed: int = 100
export var moveDist: int = 100

onready var startX:float = position.x
onready var targetX:float = position.x + moveDist

func move_to(current, to, step):
	var new = current
	
	if new < to:
		new += step
		
		if new > to:
			new = to
			
	else:
		new -= step
		
		if new < to:
			new = to
			
	return new
	
func _ready():
	pass # Replace with function body.


func _process(delta):
	rotation_degrees += 1000 * delta
	
func _physics_process(delta):
	position.x = move_to(position.x, targetX, speed * delta)
	
	if position.x == targetX:
		if targetX == startX:
			targetX = position.x + moveDist
		else:
			targetX = startX

func _on_Area2D_body_entered(body):
	if body.name == "Player":
		body.die()
