package ch04.ex4_2_4

// field 식별자를 통해 프로퍼티 접근자(게터와 세터) 안에서 프로퍼티의 데이터를 저장하는 데 쓰이는 뒷받침하는 필드를 참조할 수 있다
// field를 사용하지 않는 커스틈 접근자 구현을 정의한다면 뒷받침하는 필드는 존재하지 않는다

class User(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())  // 뒷받침하는 필드 값 읽기
            field = value   // 뒷박침하는 빌드 값 변경하기
        }
}

fun main(args: Array<String>) {
    val user = User("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
}
