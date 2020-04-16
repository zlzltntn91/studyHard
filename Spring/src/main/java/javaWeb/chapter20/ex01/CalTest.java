package javaWeb.chapter20.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CalTest {
    public static void main (String[] args) {

        // src.main.resources.AOPTest.xml
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("Spring/src/main/resources/AOPTest.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("AOPTest.xml");
//        ApplicationContext ctx3 = new ClassPathXmlApplicationContext();
//        System.out.println(ctx3.getApplicationName());
//
        Calculator cal = (Calculator) ctx.getBean("proxyCal");
        cal.add(1, 2);
        System.out.println();
    }
}
