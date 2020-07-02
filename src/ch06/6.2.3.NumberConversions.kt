package ch06

// 코틀린은 한 타입의 숫자를 다른 타입의 숫자로 자동 변환하지 않는다
fun main(args: Array<String>) {
    val x = 1
    // var i : Long = x // Type mismatch 컴파일 오류 발생
    println(x.toLong() in listOf(1L, 2L, 3L))

    // 산술 연산자는 다양한 타입 값을 받아들일 수 있게 오버로드돼 있다
    val b: Byte = 1
    val l = b + 1L // 산술 연산자는 Byte와 Long을 인자로 받을 수 있다
    println(l)

    // 문자열을 숫자로 변환
    println("42".toInt())
}
