package ch06

import java.lang.IllegalStateException

fun main(args: Array<String>) {
    // Any 타입은 모든 널이 될 수 없는 타입의 조상 타입이며, 자바의 Object에 해당한다
    // 널을 포함하는 모든 값에 대입할 변수를 선언하려면 Any? 타입을 사용
    val answer : Any = 42
    println(answer)

    fail("Error occurred")
}


// 코틀린 Unit 타입은 자바 void와 같은 기능
// void와 달리 Unit을 타입 인자로 쓸 수 있다
fun f() : Unit {}

// 정상적으로 끝나지 않은 함수의 반환 타입을 지정할 때 Nothing 타입을 사용
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}
