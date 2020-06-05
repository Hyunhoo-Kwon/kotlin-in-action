package ch04.ex4_4_3

interface JSONFactory<T> {
    fun fromJson(jsonText: String)
}

class Person(val name: String) {
    // 동반 객체도 다른 객체와 마찬가지로 인터페이스를 구현할 수 있다
    companion object : JSONFactory<Person> {
        override fun fromJson(jsonText: String) {}
    }
}

// 외부에서 동반 객체에 대한 확장 함수와 프로퍼티를 정의할 수 있다
fun Person.Companion.min() {

}
