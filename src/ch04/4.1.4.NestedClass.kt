package ch04.ex4_1_4

import java.io.Serializable

interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) { /*...*/ }

    // 코틀린의 중첩 클래스는 기본적으로 내부 클래스가 아니다 (바깥쪽 클래스 인스턴스에 대한 접근 권한이 없다)
    class ButtonState : State { /*...*/ }
}

class Outer {
    // inner 키워드를 붙여 내부 클래스로 만든다 (깥쪽 클래스에 대한 참조를 중첩 클래스 안에 포함)
    inner class Inner {
        // 바깥쪽 클래스 참조에 접근하려면 this@를 붙인다
        fun getOuterReference(): Outer = this@Outer
    }
}