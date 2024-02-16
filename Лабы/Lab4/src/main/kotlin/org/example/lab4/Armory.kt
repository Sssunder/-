package org.example.lab4

open class Weapon(val name: String)

class Firearm(name: String, val barrelLength: Double, val range: Int) : Weapon(name)

class ColdWeapon(name: String, val bladeLength: Double, val sharpness: String, val attackType: String) : Weapon(name)

class Armory {
    private val weapons = mutableListOf<Weapon>()

    fun addWeapon(weapon: Weapon) {
        weapons.add(weapon)
    }

    private fun countWeapons(): Int {
        return weapons.size
    }

    fun getArsenalInfo(): String {
        val content = StringBuilder()
        content.append("Арсенал содержит:\n")
        content.append("Огнестрельное и холодное оружие (${countWeapons()} единиц):\n")
        for (weapon in weapons) {
            when (weapon) {
                is Firearm -> {
                    content.append("- ${weapon.name}, Длина ствола: ${weapon.barrelLength}, Радиус поражения: ${weapon.range} метров\n")
                }
                is ColdWeapon -> {
                    content.append("- ${weapon.name}, Длина лезвия: ${weapon.bladeLength}, Заточка: ${weapon.sharpness}, Тип атаки: ${weapon.attackType}\n")
                }
            }
        }
        return content.toString()
    }
}
