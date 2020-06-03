package ch04.ex4_1_5

// 1. 인터페이스 구현을 통해 식 표현
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        // else 분기 반드시 필요
        else ->
            throw IllegalArgumentException("Unknown expression")
    }

// 2. sealed 클래스로 식 표현
// 클래스에 sealed를 붙여서 상위 클래스를 상속한 하위 클래스 정의를 제한한다
sealed class ExprSealed {
    // 기반 클래스의 모든 하위 클래스를 중첩 클래스로 나열한다
    class Num(val value: Int) : ExprSealed()
    class Sum(val left: ExprSealed, val right: ExprSealed) : ExprSealed()
}

fun evalSealed(e: ExprSealed): Int =
    // when 식이 모든 하위 클래스를 검사하므로 별도의 else 분기가 없어도 된다
    when (e) {
        is ExprSealed.Num -> e.value
        is ExprSealed.Sum -> evalSealed(e.right) + evalSealed(e.left)
    }

// sealed 인터페이스는 정의할 수 없다
