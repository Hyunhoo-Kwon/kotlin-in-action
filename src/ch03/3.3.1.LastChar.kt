package strings

// 확장 함수는 어떤 클래스의 멤버 메소드인 것처럼 호출할 수 있지만 그 클래스 밖에 선언된 함수다
// 확장 함수를 만들려면 추가하려는 함수 이름 앞에 그 함수가 확장할 클래스의 이름을 덧붙인다
// 클래스 이름을 수신 객체 타입(receiver type)이라 부르며, 호출되는 대상이 되는 값(객체)을 수신 객체(receiver object)라 부른다
fun String.lastChar(): Char = this.get(this.length - 1)

// fun String.lastChar(): Char = get(length - 1)    // this 생략 가능

// 내부적으로 확장 함수는 수신 객체를 첫 번째 인자로 받는 정적 메소드다
// fun lastChar(string: String): Char = string.get(string.length - 1)
