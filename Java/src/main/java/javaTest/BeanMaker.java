package javaTest;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BeanMaker {

    public static String beanMakerTest(String str){

        StringUtils su = new StringUtils();
        // 마지막이 ) 로 끝나기 전까지의 문자열을 대입
        String temp = StringUtils.substringBeforeLast(str, ")");
        // 첫번재로 나오는 ( 까지의 문자열을 잘라서 대입
        temp = StringUtils.substringAfter(temp, "(");
        // ` 로 시작해 `로 끝나는 단어들 배열 생성
        String [] test = StringUtils.substringsBetween(temp, "`", "`");
        // array -> list
        List<String> al = Arrays.asList(test);
        // list -> arrayList
        ArrayList<String> tl = new ArrayList<String>(al);

        int objCount = 0;
        // 공통된 문자열이 있으면 지움
        for (objCount = 0; objCount < test.length; objCount++) {
            for (int i = objCount+1; i < test.length; i++) {
                if(test[objCount].equals(test[i])){
                    tl.remove(i);
                }
            }
        }

        String answer = "";
        for (int i = 0; i < tl.size(); i++) {
            answer += "private String " + tl.get(i) + ";\n";
        }
        return answer;
    }

    public static void main (String[] args) {

        String str2 = "CREATE TABLE `giwan_in` (\n" +
                "  `giwan_no` varchar(6) NOT NULL DEFAULT '',\n" +
                "  `giwan_ne` varchar(100) DEFAULT NULL,\n" +
                "  `com_cd` varchar(8) DEFAULT NULL,\n" +
                "  `com_ne` varchar(50) DEFAULT NULL,\n" +
                "  `go_url` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`giwan_no`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=euckr;\n";

        BeanMaker bm = new BeanMaker();
        long begin = System.currentTimeMillis();

        System.out.println(bm.beanMakerTest(str2));
        long end = System.currentTimeMillis();
//        System.out.println("time: " + (end - begin));
    }
}
