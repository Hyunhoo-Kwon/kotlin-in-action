package ch05

import ch05.java.Button
import ch05.java.OnClickListener
import ch05.java.View

fun createClickListener() : OnClickListener {
    return OnClickListener {  }
}

val instance = createClickListener()

val listener = OnClickListener {  } // SAM 생성자

fun main(args: Array<String>) {
    // 추상 메서드가 단 하나만 있는 인터페이스를 함수형 인터페이스(functional interface) 또는 SAM 인터페이스(single abstract method: 단일 추상 메소드)라고 한다
    // 함수형 인터페이스를 인자로 받는 자바 함수를 호출할 경우 람다를 함수형 인터페이스 인자 대신 넘길 수 있다
    val button = Button()
    button.setOnClickListener { view -> {} }

    // 무명 객체를 명시적으로 만들어서 사용
    button.setOnClickListener(object : OnClickListener {
        override fun onClick(view: View?) {

        }
    })


    // 람다와 무명 객체 차이
    // 객체를 명시적으로 선언하는 경우 메소드를 호출할 때 마다 새로운 객체가 생성된다
    // 외부 변수를 사용하지 않는 람다에 대응하는 무명 객체를 메소드를 호출할 때마다 반복 사용
    // 람다가 외부 변수를 사용(변수 포획)한다면 매 호출마다 변수를 포획한 새로운 인스턴스 생성
}
