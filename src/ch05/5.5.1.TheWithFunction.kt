package ch05.ex5_5_1

// with 함수는 첫 번째 인자로 받은 객체를 두 번째 인자로 받은 람다의 수신 객체로 만든다
// 인자로 받은 람다 본문에서는 this를 사용해 그 수신 객체에 접근한다 (this. 생략 가능)
// with가 반환하는 값은 람다 코드를 실행한 결과이다
fun alphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun alphabet1() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun main(args: Array<String>) {
    println(alphabet())
}
