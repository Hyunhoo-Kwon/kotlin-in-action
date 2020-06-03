package ch04.ex4_1_2

interface Clickable {
    fun click()
    fun take()
    fun showOff() = println("I'm clickable!")
}

// 코틀린의 클래스와 메소드는 기본적으로 final이다
// 클래스의 상속을 허용하려면 클래스 앞에 open을 붙여야 한다
open class RichButton : Clickable {

    fun disable() {}    // final 이므로 이 메소드를 오버라이드 할 수 없다

    open fun animate() {}   // 오버라이드를 허용하려면 open을 붙여야 한다

    override fun click() {} // 오버라이드한 메소드는 기본적으로 열려있다

    final override fun take() {}    // 오버로드한 메소드는 열려있으므로 하위 클래스의 오버라이드를 금지하려면 final을 명시해야 한다
}

// abstract 클래스 선언
// 추상 멤버는 항상 열려있으므로 open을 명시할 필요가 없다
abstract class Animated {   // 추상클래스의 인스터스를 만들 수 없다
    abstract fun animate()
}

// 인터페이스 멤버는 final, open, abstract를 사용하지 않는다
// 인터페이스 멤버는 항상 열려 있으며 final로 변경할 수 없다
