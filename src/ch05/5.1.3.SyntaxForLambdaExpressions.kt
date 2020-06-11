package ch05

// 람다 식의 문법
fun main(args: Array<String>) {

    // 람다식 축약 표현
    // 1. 축약 전 표현
    // 람다 식은 항상 중괄호로 둘러싸여 있다
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    people.maxBy({ p: Person -> p.age }) // Person 타입의 값을 인자로 받아서 인자의 age를 반환하는 람다 식을 maxBy 함수에 넘긴다

    // 2. 괄호 밖으로 람다 빼기
    // 코틀린에서 함수 호출 시 맨 뒤에 있는 인자가 람다 식이면 그 람다를 괄호 밖으로 빼낼 수 있다
    people.maxBy() { p: Person -> p.age }

    // 3. 괄호 생략
    // 람다가 유일한 인자이고 괄호 밖으로 람다를 뺀 경우 빈 괄호를 생략할 수 있다
    people.maxBy { p: Person -> p.age }

    // 4. 람다 파라미터 타입 제거
    // 컴파일러는 람다 파라미터의 타입을 추론할 수 있으므로 파라미터 타입을 명시할 필요가 없다
    people.maxBy { p -> p.age }

    // 5. 디폴트 파라미터 이름 it 사용
    // 람다의 파라미터가 하나뿐이고 타입을 추론할 수 있는 경우 it을 바로 쓸 수 있다
    people.maxBy { it.age }

    // 람다를 변수에 저장할 때는 파라미터 타입을 추론할 문맥이 존재하지 않는다. 따라서 파라미터 타입을 명시해야 한다
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    // 람다 식을 직접 호출할 수 있지만, run을 사용하여 람다를 실행하는 편이 낫다
    run { println(42) }
}
