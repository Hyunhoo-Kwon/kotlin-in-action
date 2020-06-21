package ch05.java;

public class Button {
    public void setOnClickListener(OnClickListener onClickListener) { };

    public static void main(String[] args) {
        Button button = new Button();

        // 무명 클래스의 인스턴스 생성
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        // 자바8 람다식
        button.setOnClickListener((view) -> {});
    }
}
