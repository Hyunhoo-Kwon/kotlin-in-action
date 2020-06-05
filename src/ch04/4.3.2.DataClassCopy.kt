package ch04.ex4_3_2

// 데이터 클래스를 사용하면 컴파일러가 equals, hashCode, toString, copy 등의 메소드를 자동으로 생성해준다
// 주 생성자 밖에 정의된 프로퍼티는 equals, hashCode를 계산할 때 포함되지 않는다
data class Client(val name: String, val postalCode: Int)

fun main(args: Array<String>) {
    val client1 = Client("Bob", 973293)
    val client2 = Client("Bob", 973293)
    println(client1 == client2)
    println(client1.copy(postalCode = 382555))  // copy 메소드로 객체를 복사하면서 일부 프로퍼티를 바꿀 수 있댜
}
