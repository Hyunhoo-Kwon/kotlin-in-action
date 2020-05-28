package ch03

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

// 확장 함수는 오버라이드할 수 없다
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

fun main(args: Array<String>) {
    val view: View = Button()
    view.click()
    view.showOff()  // 확장 함수는 정적으로 결정된다
}
