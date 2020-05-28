package ch03

// 확장 함수가 정의된 패키지 임포트
import strings.lastChar

fun main(args: Array<String>) {
    println("Kotlin".lastChar())    // String: 수신 객체 타입, "Kotlin": 수신 객체
}
