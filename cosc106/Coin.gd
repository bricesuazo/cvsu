extends Area2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"

export var value = 1


# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.



func _on_Area2D_body_entered(body):
	if body.name == "Player" || body.name == "Player2":
		body.collect_coin(value)
		queue_free()
