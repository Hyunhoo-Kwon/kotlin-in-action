package ch04.ex4_2_5

class LengthCounter {
    var counter: Int = 0
        private set     // get set 앞에 가시성 변경자를 추가해서 접근자의 가시성을 변경할 수 있다

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}
