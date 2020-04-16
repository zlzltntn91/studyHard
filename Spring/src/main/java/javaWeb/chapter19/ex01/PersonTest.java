package javaWeb.chapter19.ex01;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
    public static void main (String[] args) {
        // 기존방식
        PersonService psOrigin = new PersonServiceImpl();
        psOrigin.sayHello();

        // DI 방식 1
        BeanFactory bf = new XmlBeanFactory(new FileSystemResource("Spring/web/Person.xml"));
        PersonService ps = (PersonService) bf.getBean("PersonService");
        ps.sayHello();

        // Deprecate
        ApplicationContext apc = new FileSystemXmlApplicationContext(new String[] {"Spring/web/Person.xml"});
        BeanFactory substitute = apc;
        PersonService ps2 = (PersonService) substitute.getBean("PersonService");
        ps2.sayHello();
    }
}
