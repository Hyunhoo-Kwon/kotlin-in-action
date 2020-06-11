package ch05

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    // 람다 안에 있는 코드는 그 람다가 들어있는 바깥 함수의 변수를 읽거나 쓸 수 있다
    // 람다 안에서 사용하는 외부 변수를 람다가 포획(capture)한 변수라 부른다
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++  // 람다 안에서 밖의 변수를 변경
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun main(args: Array<String>) {
    val responses = listOf("200 OK", "418 I'm a teapot",
        "500 Internal Server Error")
    printProblemCounts(responses)
}
