fun main() {
    // Ввод целых чисел с клавиатуры
    println("Введите целые числа через пробел:")
    val inputNumbers = readLine()?.split(" ")?.map { it.toIntOrNull() }

    if (inputNumbers != null) {
        // Вывод чисел, удовлетворяющих условию a_i >= i
        printNumbersSatisfyingCondition(inputNumbers)
    } else {
        println("Некорректный ввод. Пожалуйста, введите целые числа.")
    }
}

fun printNumbersSatisfyingCondition(numbers: List<Int?>?) {
    println("Числа, для которых a_i >= i:")

    // Проверка на null для списка чисел
    if (numbers != null) {
        // Итерация по списку чисел вместе с их индексами
        for ((index, value) in numbers.withIndex()) {
            // Проверка на null и условие a_i >= i
            if (value != null && value >= index + 1) {
                // Вывод числа, удовлетворяющего условию
                println(value)
            }
        }
    }
}
