package ch06

fun <T> copyElements(source: Collection<T>,
                     target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

// 코틀린은 읽기 전용 컬렉션과 변경 가능한 컬렉션을 구별해 제공한다
fun main(args: Array<String>) {
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)

    copyElements(source, target)
    println(target)
}
