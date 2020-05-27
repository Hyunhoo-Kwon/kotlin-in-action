package ch03

// 최상위 함수가 정의된 패키지 임포트
import strings.join
// 최상위 프로퍼티가 정의된 패키지 임포트
import strings.TITLE

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    println(join(list, "; ", "(", ")"))
    println(TITLE)
}
