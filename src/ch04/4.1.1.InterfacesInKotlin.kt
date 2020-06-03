package ch04.ex4_1_1

// 코틀린 인터페이스 안에는 추상 메소드뿐 아니라 디폴트 구현이 있는 메소드도 정의할 수 있다
// 인터페이스에는 아무런 상태(필드)도 들어갈 수 없다
interface Clickable {
    fun click() // 추상 메소드 선언
    fun showOff() = println("I'm clickable!")   // 디폴트 구현이 있는 메소드
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

// 클래스는 인터페이스를 원하는 만큼 구현할 수 있다
// 클래스는 클래스를 오직 하나만 확장할 수 있다
class Button : Clickable, Focusable {
    // 코틀린에서는 override 변경자를 반드시 사용해야 한다
    override fun click() = println("I was clicked")

    // 동일한 메소드에 대해 둘 이상의 디폴트 구현이 있는 경우 하위 클래스에서 명시적으로 새로운 구현을 제공해야 한다
    override fun showOff() {
        // 상위 타입의 이름을 super<>에 넣어서 상위 타입의 멤버 메소드 호출
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}
