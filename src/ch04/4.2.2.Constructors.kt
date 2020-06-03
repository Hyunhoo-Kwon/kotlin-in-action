package ch04.ex4_2_2

import javax.naming.Context
import javax.swing.text.AttributeSet
import javax.swing.text.SimpleAttributeSet

val MY_STYLE = SimpleAttributeSet()

// 오버로드한 생성자가 필요한 상황 중 상당수는 코틀린의 디폴트 파라미터 값과 이름 붙은 인자 문법을 사용해 해결할 수 있다

open class View {
    // 부 생성자 선언
    constructor(ctx: Context) {}

    constructor(ctx: Context, attr: AttributeSet) {}
}

class MyButton : View {
    constructor(ctx: Context) : this(ctx, MY_STYLE) {}  // 이 클래스의 다른 생성자 호출

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {} // 상위 클래스 생성자 호출
}
