package ch05

fun salute() = println("Salute!")
fun Person.isAdult() = age >= 30

// 멤버 참조
// 메소드, 생성자, 프로퍼티의 이름 앞에 ::을 붙이면 각각에 대한 참조를 만들 수 있다. 그런 참조를 람다 대신 다른 함수에게 넘길 수 있다.
fun main(args: Array<String>) {
    // 코틀린에서는 함수를 값으로 바꿀 수 있다
    // 멤버 참조는 프로퍼티나 메소드를 단 하나만 호출하는 함수 값을 만들어준다
    var getAge = Person::age

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    people.maxBy(Person::age)

    // 최상위 함수나 프로퍼티도 참조할 수 있다
    run(::salute)   // 클래스 이름을 생략하고 ::로 바로 참조

    // 확장 함수도 멤버 함수와 동일하게 참조
    var predicate = Person::isAdult
    println(people.filter(predicate))

    // 생성자 참조
    // 클래스 생성 작업을 연기하거나 저장해둘 수 있다
    val createPerson = ::Person
    val p = createPerson("Alice", 29)
    println(p)
}

// 람다와 차이점
// 람다를 사용해 코드 블록을 다른 함수에게 인자로 넘긴다
// 이미 함수로 선언된 경우 멤버 참조로 만들어 다른 함수에게 넘길 수 있다
