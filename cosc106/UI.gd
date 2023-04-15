extends Control

var score:int = 0

onready var scoreText = get_node("Label")
# Declare member variables here. Examples:
# var a = 2
# var b = "text"

func set_score_text(score):
	scoreText.text = str(score)

# Called when the node enters the scene tree for the first time.
func _ready():
	scoreText.text = "0"


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
