package ch03

// 출력 형식 지정하는 함수 직접 구현
fun <T> joinToString(
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

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)

    // toString() 출력 형식: [1, 2, 3]
    println(list)
    // joinToString() 출력 형식: (1; 2; 3)
    println(joinToString(list, "; ", "(", ")"))

    // 이름 붙인 인자를 사용하여 함수 호출의 가독성 향상
    // 중간 인자 생략하거나 순서와 관계없이 인자를 지정할 수 있다
    println(joinToString(list, prefix = "(", postfix = ")", separator = "; "))

    // 함수 파라미터의 디폴트 값을 정의하면 오버로딩한 함수를 정의할 필요성이 줄어든다
    println(joinToString(list))
    println(joinToString(list, "; "))
    println(joinToString(list, prefix = "(", postfix = ")"))
}
