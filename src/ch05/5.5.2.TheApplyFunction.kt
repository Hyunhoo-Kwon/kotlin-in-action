package ch05.ex5_5_2

// apply는 자신에게 전달된 객체(수신 객체)를 반환한다
fun alphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    this.append("\nNow I know the alphabet!")
}.toString()

fun main(args: Array<String>) {
    println(alphabet())
}
