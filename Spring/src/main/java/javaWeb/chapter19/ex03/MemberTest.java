package javaWeb.chapter19.ex03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberTest {
    public static void main (String[] args) {
        BeanFactory bf = new XmlBeanFactory(new FileSystemResource("Spring/web/Member.xml"));
        MemberService service = (MemberService) bf.getBean("MemberService");
        service.listMembers();
    }
}
