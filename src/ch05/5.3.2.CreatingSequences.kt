package ch05

fun main(args: Array<String>) {
    // generateSequence 함수로 시퀀스를 만들 수 있다
    val naturalNumbers = generateSequence(0) { print("ge($it) "); it + 1 }     // 중간 연산
    val numbersTo100 = naturalNumbers.takeWhile { print("num($it) "); it <= 100 }     // 중간 연산
    println(numbersTo100.sum())     // 최종 연산
}
