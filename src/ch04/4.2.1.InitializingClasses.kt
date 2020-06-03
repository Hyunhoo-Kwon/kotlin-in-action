package ch04.ex4_2_1

// 1. 주 생성자 (primary construct)
// 1-1. 클래스 이름 뒤에 괄호로 둘러 싼다
// 생성자 인자에 디폴트 값 정의, 이름 지정 가능
open class User(val nickname: String, val isSubscribed: Boolean = true)

// 1-2. 초기화 블록
// 주 생성자는 별도의 코드를 포함할 수 없으므로 초기화 블록이 필요
class User2 constructor(_nickname: String) {
    val nickname: String
    // 초기화 블록: 클래스의 객체가 만들어질 때 실행될 초기화 코드
    init {
        nickname = _nickname
    }
}

// 1-3. 초기화 식
// 주 생성자 앞에 애노테이션이나 가시성 변경자가 없다면 constructor 생략 가능
class User3(_nickname: String) {
    // 프로퍼티를 초기화 하는 식이나 초기화 블록 안에서만 주 생성자의 파라미터를 참조할 수 있다
    val nickname = _nickname
}

// 주 생성자의 파라미터로 프로퍼티를 초기화 한다면 val을 추가하여 프로퍼티 정의와 치가화를 간략히 쓸 수 있다
class User4(val nickname: String)


// 2. 주 생성자에서 기반 클래스의 생성자 호출
// 기반 클래스를 초기화 하려면 기반 클래스 이름 뒤에 괄호를 치고 생성자 인자를 넘긴다
class TwitterUser(nickname: String) : User(nickname)

// 별도 생성자를 정의하지 않으면 인자가 없는 디폴트 생성자를 만들어준다
open class Button

// 반드시 Button 클래스의 생성자 호출
// 기반 클래스의 이름 뒤에는 꼭 빈 괄호가 들어간다
class RadioButton : Button()

// 인터페이스는 생성자가 없기 때문에 인터페이스 이름 뒤에는 괄호가 없다
