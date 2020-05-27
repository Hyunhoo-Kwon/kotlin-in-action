package strings

// 최상위 함수 정의 (클래스 밖에 위치)
fun <T> join(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator) // 첫 원소 앞에는 구분자를 붙이면 안 된다
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

// 최상위 프로퍼티 정의 (클래스 밖에 위치)
// const로 상수 선언
const val TITLE = "Kotlin IN ACTION"
