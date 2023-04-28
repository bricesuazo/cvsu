extends Area2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
export var speed: int = 100
export var moveDist: int = 100

onready var startY:float = position.y
onready var targetY:float = position.y + moveDist

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
	position.y = move_to(position.y, targetY, speed * delta)
	
	if position.y == targetY:
		if targetY == startY:
			targetY = position.y + moveDist
		else:
			targetY = startY

func _on_Area2D_body_entered(body):
	if body.name == "Player" || body.name == "Player2":
		body.die()
