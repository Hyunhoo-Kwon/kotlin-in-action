package ch05.ex5_5_0

// result에 대해 다른 여러 메소드를 호출하면서 매번 result 반복 사용
// >> 객체 이름을 반복하지 않고도 그 객체에 대한 다양한 연산을 수행하자
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun main(args: Array<String>) {
    println(alphabet())
}
