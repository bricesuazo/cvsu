extends Spatial
class_name Weapon

var weapon_manager = null
var player = null
var ray = null

var is_equipped = false

export var weapon_name = "Weapon"
export(Texture) var weapon_image = null


func equip():
	pass

func unequip():
	pass

func is_equip_finished():
	return true

func is_unequip_finished():
	return true


func update_ammo(action = "Refresh"):
	
	var weapon_data = {
		"Name" : weapon_name,
		"Image" : weapon_image
	}
	
	weapon_manager.update_hud(weapon_data)
