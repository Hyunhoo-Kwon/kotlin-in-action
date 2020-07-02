package ch06

// 코틀린은 널이 될 수 있는 타입을 명시적으로 지원한다 > 오류를 컴파일 시점에 미리 감지
// 모든 타입은 기본적으로 널이 될 수 없는 타입이며 타입 이름 뒤에 물음표를 붙이면 null 참조를 저장할 수 있다
fun strLenSafe(s: String?): Int {
    // return s.length      // 널이 될 수 있는 타입인 변수에 대해 메소드를 직접 호출할 수 없다 (변수.메소드())
    return if (s != null) s.length else 0   // null 검사를 추가하면 코드가 컴파일된다
}

fun main(args: Array<String>) {
    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))
}
