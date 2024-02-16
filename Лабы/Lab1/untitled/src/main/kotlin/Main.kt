fun main() {
    // Запрос ввода натурального числа от пользователя
    println("Введите натуральное число N:")
    val n = readLine()?.toIntOrNull()

    if (n != null && n > 0) {
        // Поиск чисел в интервале с заданными свойствами
        val matchingNumbers = findNumbersWithMatchingProductAndSum(n)

        if (matchingNumbers.isNotEmpty()) {
            // Вывод найденных чисел
            println("Числа в интервале от 1 до ${n - 1} с произведением, равным сумме цифр $n: ${matchingNumbers.joinToString(", ")}")
        } else {
            println("Нет чисел с произведением, равным сумме цифр $n, в интервале от 1 до ${n - 1}.")
        }
    } else {
        println("Некорректный ввод. Пожалуйста, введите положительное натуральное число.")
    }
}

fun findNumbersWithMatchingProductAndSum(n: Int): List<Int> {
    // Создание списка для хранения найденных чисел
    val matchingNumbers = mutableListOf<Int>()

    // Перебор чисел в интервале от 1 до n-1
    for (i in 1 until n) {
        // Вычисление произведения и суммы цифр числа i
        val product = getProductOfDigits(i)
        val sum = getSumOfDigits(i)

        // Сравнение произведения суммы цифр числа i с суммой цифр числа n
        if (product == getSumOfDigits(n)) {
            // Добавление числа i в список, если условие выполняется
            matchingNumbers.add(i)
        }

    }

    // Возвращение списка найденных чисел
    return matchingNumbers
}

fun getProductOfDigits(number: Int): Int {
    // Инициализация переменной для хранения произведения
    var product = 1
    var n = number

    // Цикл для вычисления произведения цифр числа
    while (n > 0) {
        val digit = n % 10
        if (digit != 0) {
            product *= digit
        }
        n /= 10
    }

    // Возвращение произведения
    return product
}

fun getSumOfDigits(number: Int): Int {
    // Инициализация переменной для хранения суммы цифр
    var sum = 0
    var n = number

    // Цикл для вычисления суммы цифр числа
    while (n > 0) {
        sum += n % 10
        n /= 10
    }

    // Возвращение суммы
    return sum
}
