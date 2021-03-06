# Ch02. 코틀린 기초

### 2.1 기본 요소
#### 함수
- 함수를 정의할 때 fun 키워드 사용
- 파라미터 이름 뒤에 타입 지정
- 함수를 최상위 수준에 정의할 수 있다 (클래스 안에 함수를 넣어야 할 필요가 없다)
- (함수 본문이 식 하나인 경우) 중괄호, return 제거하고 등호(=)로 표현 가능하며 이 경우 반환 타입 생략 가능
```
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max(a: Int, b: Int) = if (a > b) a else b
```

##### 문(statement)과 식(expression)의 구분
- 문은 자신을 둘러싸고 있는 가장 안쪽 블록의 최상위 요소로 존재하며 아무런 값을 만들어내지 않는다
- 식은 값을 만들어 내며 다른 식의 하위 요소로 계산에 참여할 수 있다
- 자바에서 모든 제어 구조가 문인 반면 코틀린에서는 루프를 제외한 대부분의 제어 구조(if, when, try 등)가 식이다

#### 변수
- val (value): 변경 불가능한 변수
- var (variable) 변경 가능한 변수

#### 문자열 템플릿
- 변수 이름 앞에 $를 붙이거나, 식을 ${}로 둘러싸면 변수나 식의 값을 문자열 안에 넣을 수 있다

### 2.2 클래스와 프로퍼티
- 필드와 접근자(getter, setter)를 한데 묶어 프로퍼티(property)라 부른다
- 클래스에서 프로퍼티를 선언할 때 val나 var를 사용
  - val: 읽기 전용 프로퍼티로, 코틀린은 (비공개) 필드와 필드를 읽는 단순한 (공개) getter를 만들어낸다
  - var: 쓸 수 있는 프로퍼티로, 코틀린은 (비공개) 필드, (공개) getter, (공개) setter를 만들어낸다
```
class Person(val name: String)

val person = Person("Bob") // new 키워드를 사용하지 않고 생성자를 호출한다
println(person.name) // 프로퍼티 이름을 직접 사용해도 코틀린이 자동으로 게터를 호출해준다
```
- 커스텀 접근자 작성 방법
```
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}
```

### 2.3 선택 표현과 처리
#### enum
- enum 클래스 정의 방법
```
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
```

#### when
- 코틀린의 when은 자바의 switch와 비슷하지만 더 강력하다
  - when의 분기 조건은 임의의 객체를 허용한다
  - 인자가 없는 when 식을 사용하려면 각 분기의 조건이 boolean 결과를 계산하는 식이어야 한다
  - if나 when 모두 분기에 블록을 사용할 수 있다. 그런 경우 블록의 마지막 문장이 블록 전체의 결과가 된다
```
fun getWarmth(color: Color) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}
```

#### 스마트 캐스트 (smart cast)
- 스마트 캐스트는 타입 검사와 타입 캐스트, 타입 강제 변환을 하나로 엮은 기능이다
- 어떤 변수의 타입을 검사하고 나면 굳이 그 변수를 캐스팅하지 않아도 검사한 타입의 변수처럼 사용할 수 있다. 그런 경우 컴파일러가 스마트 캐스트를 활용해 자동으로 타입을 바꿔준다
  - is를 사용해 변수 타입을 검사한다
  - 원하는 타입으로 명시적으로 타입 캐스팅하려면 as를 사용한다
```
fun eval(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.right) + eval(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }
```

### 2.4 대상을 이터레이션
#### 루프
- 코틀린의 while, do-while 루프를 자바와 동일하다
- 코틀린에서는 컬렉션에 대한 이터레이션을 위해 for <아이템> in <원소> 루프를 사용한다
```
for (i in 1..100)
```
- 맵에 대해 이터레이션 하는 방법
```
val binaryReps = TreeMap<Char, String>()

for ((letter, binary) in binaryReps) {
    println("$letter = $binary")
}
```

#### 범위
- 1..5와 같은 식은 범위를 만들어낸다
- 어떤 값이 범위 안에 들어 있거나 들어있지 않은지 검사하기 위해서 in이나 !in을 사용한다
- 비교 가능한 클래스라면 그 클래스의 인스턴스 객체를 사용해 범위를 만들 수 있다
```
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
```

### 2.5 예외 처리
#### throw
- 코틀린의 예외 처리는 자바와 비슷하다. 함수는 정상적으로 종료할 수 있지만 오류가 발생하면 예외를 던질 (throw) 수 있다
```
if (percentage !in 0..100) {
    throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage")
}
```

#### try, catch, finally
- 예외를 처리하려면 try와 catch, finally 절을 함께 사용한다
- 코틀린에서는 함수가 던질 수 있는 예외를 선언 (throws)하지 않아도 된다
```
fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    } finally {
        reader.close()
    }
}
```
