package ch04.ex4_2_3

fun getFacebookName(accountId: Int) = "fb:$accountId"

// 코틀린에서는 인터페이스에 추상 프로퍼티 선언을 넣을 수 있다
// 인터페이스에 있는 프로퍼티 선언에는 뒷받침하는 필드나 게터 등의 정보가 들어 있지 않다
interface User {
    val nickname: String
}

// 1. 주 생성자에서 추상 프로퍼티 구현
class PrivateUser(override val nickname: String) : User

// 2. 커스텀 게터로 추상 프로퍼티 구현
class SubscribingUser(val email: String) : User {
    // 뒷받침하는 필드에 값을 저장하지 않고 매번 이메일 주소에서 별명을 계산
    override val nickname: String
        get() = email.substringBefore('@')
}

// 3. 초기화 식으로 추상 프로퍼티 구현
class FacebookUser(val accountId: Int) : User {
    // 객체 초기화 시 계산한 데이터를 뒷받침하는 필드에 저장했다가 불러오는 방식
    override val nickname = getFacebookName(accountId)
}

fun main(args: Array<String>) {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
}
