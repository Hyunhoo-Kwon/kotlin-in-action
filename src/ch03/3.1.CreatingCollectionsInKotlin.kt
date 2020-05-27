package ch03

val set = hashSetOf(1, 14, 2)
val list = arrayListOf("first", "second", "fourteenth")
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun main(args: Array<String>) {
    // 코틀린 컬렉션은 자바 컬렉션과 똑같은 클래스다. (코틀린은 자체 컬렉션을 정의하지 않는다)
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    // 코틀린은 자바 클래스를 확장해서 더 풍부한 기능을 제공한다
    println(list.last())
    println(set.max())
}
