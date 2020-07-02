package ch06

// 자바는 원시 타입(primitive type)과 참조 타입(reference type)을 구분한다
// 원시 타입의 값을 더 효율적으로 저장하고 전달할 수 있지만, 메소드를 호출하거나 컬렉션에 원시 타입 값을 담을 수는 없다
// 자바는 참조 타입이 필요한 경우 특별한 래퍼 타입으로 원시 타입 값을 감싸서 사용한다

// 코틀린은 원시 타입과 래퍼 타입을 구분하지 않는다
fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100) // 원시 타입의 값에 대해 메소드를 호출할 수 있다
    println("We're ${percent}% done!")
}

fun main(args: Array<String>) {
    showProgress(146)
}

// 대부분의 경우 코틀린 컴파일러는 Int 타입을 자바 원시 타입 int로 컴파일한다
// 제너릭 클래스를 사용하는 경우 Int 타입은 자바 래퍼 타입 java.lang.Integer로 컴파일한다
