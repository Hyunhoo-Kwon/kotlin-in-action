package ch02

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(5, 5) // new 키워드를 사용하지 않고 생성자를 호출한다.
    println(rectangle.isSquare) // 프로퍼티 이름을 직접 사용해도 코틀린이 자동으로 게터를 호출해준다.
}
