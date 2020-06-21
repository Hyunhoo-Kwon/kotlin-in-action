package ch05

fun main(args: Array<String>) {
    // 컬렉션 함수를 연쇄하면 매 단계마다 계산 중간 결과를 새로운 컬렉션에 임시로 담는다
    // 아래 연쇄 호출이 리스트 2개를 만든다
    listOf(1, 2, 3, 4)
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }

    println()


    // 시퀀스(Sequence)를 사용하면 중간 결과를 담는 컬렉션을 생성하지 않고도 컬렉션에 대한 여러 연산을 조합할 수 있다
    // 시퀀스에 대한 연산은 중간(intermediate) 연산과 최종(terminal) 연산으로 나뉜다
    // 중간 연산은 다른 시퀀스를 반환하며 항상 지연(lazy) 계산된다
    // 최종 연산은 결과를 반환하며, 최종 연산을 호출해야 연기됐던 모든 계산이 수행된다
    listOf(1, 2, 3, 4).asSequence() // 원본 컬렉션을 시퀀스로 변환
        .map { print("map($it) "); it * it }        // 중간 연산
        .filter { print("filter($it) "); it % 2 == 0 }  // 중간 연산
        .toList()       // 최종 연산

    println()


    // 컬렉션과 시퀀스 연산 수행 순서 차이
    // 즉시 계산(컬렉션 사용)은 전체 컬렉션에 연산을 적용
    // 지연 계산(시퀀스 사용)은 원소를 한번에 하나씩 처리


    // 연산 순서에 따른 차이
    listOf(1, 2, 3, 4).asSequence() // 원본 컬렉션을 시퀀스로 변환
        .filter { print("filter($it) "); it % 2 == 0 }  // 중간 연산
        .map { print("map($it) "); it * it }        // 중간 연산
        .toList()       // 최종 연산


    // 자바 스트림과 코틀린 시퀀스 비교
    // 자바 8 스트림과 코틀린 시퀀스는 같은 개념
    // 스트림 연산은 병렬 기능 제공. 시퀀스는 병렬 기능 제공 X
}
