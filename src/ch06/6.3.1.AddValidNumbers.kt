package ch06

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException
import java.util.ArrayList

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()  // 널이 될 수 있는 Int 값으로 이뤄진 리스트를 만든다
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        }
        catch(e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
}
