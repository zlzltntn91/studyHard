package yerim;

// 클래스
public class 붕어빵 {

    //생성자
    붕어빵(){
        System.out.println("나는 붕어빵이야");
    }

    // 변수
    String 반죽 = "흙";

    // 메서드     파라미터
    String 굽다 (String 반죽, String 속) {
        return 반죽 + "랑 " + 속 + "으로 만든 " + "붕어빵";
    }


    public static void main(String[] args) {
        붕어빵 b = new 붕어빵();
        System.out.println(b.굽다("밀가루", "팥"));

    }
}
