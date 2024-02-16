open class Weapon(val name: String)  // Открытый класс "Weapon" с полем "name", представляющим название оружия.

// Класс "Firearm" наследуется от класса "Weapon" и представляет огнестрельное оружие с дополнительными параметрами.
class Firearm(name: String, val barrelLength: Double, val range: Int) : Weapon(name)
// Класс "ColdWeapon" наследуется от класса "Weapon" и представляет холодное оружие с дополнительными параметрами.
class ColdWeapon(name: String, val bladeLength: Double, val sharpness: String, val attackType: String) : Weapon(name)
class Armory {
    private val firearms = mutableListOf<Firearm>()  // Приватное свойство "firearms" - список огнестрельного оружия.
    private val coldWeapons = mutableListOf<ColdWeapon>()  // Приватное свойство "coldWeapons" - список холодного оружия.

    fun addFirearm(firearm: Firearm) {  // Метод "addFirearm" добавляет огнестрельное оружие в список "firearms".
        firearms.add(firearm)
    }

    fun addColdWeapon(coldWeapon: ColdWeapon) {  // Метод "addColdWeapon" добавляет холодное оружие в список "coldWeapons".
        coldWeapons.add(coldWeapon)
    }

    fun countFirearms(): Int {  // Метод "countFirearms" возвращает количество огнестрельного оружия в арсенале.
        return firearms.size
    }

    fun countColdWeapons(): Int {  // Метод "countColdWeapons" возвращает количество холодного оружия в арсенале.
        return coldWeapons.size
    }

    fun displayContent() {  // Метод "displayContent" выводит информацию о содержимом арсенала.
        println("Арсенал содержит:")
        println("Огнестрельное оружие (${countFirearms()} единиц):")
        for (firearm in firearms) {
            println("- ${firearm.name}, Длинна ствола: ${firearm.barrelLength} ," +
                    " Радиус поражения: ${firearm.range} метров")
        }

        println("Холодное оружие (${countColdWeapons()} единиц):")
        for (coldWeapon in coldWeapons) {
            println("- ${coldWeapon.name}, Длинна лезвия: ${coldWeapon.bladeLength} , " +
                    "Заточка: ${coldWeapon.sharpness}, Attack Type: ${coldWeapon.attackType}")
        }
    }
}

fun main() {
    val armory = Armory()  // Создание экземпляра класса "Armory".

    while (true) {
        println("\nМеню:")
        println("1. Добавить огнестрельное оружие")
        println("2. Добавить холодное оружие")
        println("3. Отобразить содержимое арсенала")
        println("4. Выход")
        print("Введите ваш выбор: ")

        val choice = readLine()?.toIntOrNull() ?: continue

        when (choice) {
            1 -> {
                print("Введите название огнестрельного оружия: ")
                val firearmName = readLine() ?: continue

                print("Введите длину ствола : ")
                val barrelLength = readLine()?.toDoubleOrNull() ?: continue

                print("Введите дальность поражения (метры): ")
                val range = readLine()?.toIntOrNull() ?: continue

                armory.addFirearm(Firearm(firearmName, barrelLength, range))
                println("Огнестрельное оружие добавлено.")
            }

            2 -> {
                print("Введите название холодного оружия: ")
                val coldWeaponName = readLine() ?: continue

                print("Введите длину лезвия : ")
                val bladeLength = readLine()?.toDoubleOrNull() ?: continue

                print("Введите тип заточки: ")
                val sharpness = readLine() ?: continue

                print("Введите тип атаки (колющее или режущее): ")
                val attackType = readLine() ?: continue

                armory.addColdWeapon(ColdWeapon(coldWeaponName, bladeLength, sharpness, attackType))
                println("Холодное оружие добавлено.")
            }

            3 -> {
                armory.displayContent()
            }

            4 -> {
                println("Выход из программы.")
                return
            }

            else -> {
                println("Некорректный выбор. Пожалуйста, введите допустимую опцию.")
            }
        }
    }
}