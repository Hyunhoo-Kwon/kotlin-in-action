package ch06

// 널이 될 수 있는 원시 타입은 자바의 래퍼 타입으로 컴파일된다 (null 참조는 자바의 참조 타입 변수에만 대입할 수 있기 때문)
data class Person(val name: String,
                  val age: Int? = null) {

    fun isOlderThan(other: Person): Boolean? {
        // 컴파일러는 널 검사를 마친 다음 두 값을 일반적인 값처럼 다루게 허용한다
        if (age == null || other.age == null)
            return null
        return age > other.age
    }
}

fun main(args: Array<String>) {
    println(Person("Sam", 35).isOlderThan(Person("Amy", 42)))
    println(Person("Sam", 35).isOlderThan(Person("Jane")))

    // 제네릭 클래스의 경우 래퍼 타입을 사용한다 (JVM은 타입 인자로 원시 타입을 허용하지 않기 때문)
    var listOfInts = listOf(1, 2, 3)
}
