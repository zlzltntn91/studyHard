package day1;

public class Yerim {

    boolean flag = true;

    // 정수
    byte b = 97;         // 1byte
    char c = 'a';       // 2
    short s = 2;        // 2
    int i = 333;        // 4
    long l = 1_000_000;   // 8

    // 실수 ( 부동 소숫점 )
    float f = 5.5f;      // 4
    double d = 500.5;   // 8

    String str = "kimyerim";


    public static void main(String[] args) {
        Yerim yerim = new Yerim();

        int e = yerim.str.length(); // 길이

        System.out.println(yerim.str.substring(3,5));


    }
}
