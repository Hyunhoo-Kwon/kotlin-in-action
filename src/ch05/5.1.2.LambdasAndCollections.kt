package ch05

data class Person(val name: String, val age: Int)

// 자바 에서는 컬렉션 라이브러리가 적었으며, 필요한 컬레션 기능을 직접 작성했다
fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)

    // 코틀린에서 제공하는 컬렉션 라이브러리 함수
    // maxBy는 가장 큰 원소를 찾기 위해 비교에 사용할 값을 돌려주는 함수를 인자로 받는다
    println(people.maxBy { it.age })
    println(people.minBy { it.age })
}
