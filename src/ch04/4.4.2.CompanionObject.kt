package ch04.ex4_4_2

import ch04.ex4_2_3.getFacebookName

class User private constructor(val nickname: String) {
    // 동반 객체는 자바의 정적 메소드와 필드 정의를 대신한다 (코틀린 클래스 안에는 정적인 멤버가 없다. static 키워드 지원 X)
    // 최상위 함수와 동반 객체 차이점: 동반 객체는 클래스 내부 정보에 접근해야 하는 함수가 필요할 때 사용
    companion object {
        fun newSubscribingUser(email: String) = User(email.substringBefore('@'))    // 팩토리 메소드
        fun newFacebookUser(accountId: Int) = User(getFacebookName(accountId))
    }
}

fun main(args: Array<String>) {
    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname)
}
