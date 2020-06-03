package ch04.ex4_1_3

import ch04.ex4_1_1.Focusable

// 코틀린의 가시성 변경자
// public(기본 가시성)
// internal
// protected
// private

internal open class TalkativeButton : Focusable {
    private fun yell() {}
    protected fun whisper() {}
}

// 메소드의 시그니처에 사용된 모든 타입의 가시성은 그 메소드의 가시성과 같거나 더 높아야 한다
// 클래스를 확장한 함수는 그 클래스의 private나 protected 멤버에 접근할 수 없다
internal fun TalkativeButton.giveSpeech() { // giveSpeech() 함수 안에서 가시성이 더 낮은 타입을 참조하지 못한다
    // yell()
    // whisper()
}
