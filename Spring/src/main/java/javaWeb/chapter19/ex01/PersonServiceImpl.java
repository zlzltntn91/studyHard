package javaWeb.chapter19.ex01;

import lombok.Data;

public @Data class PersonServiceImpl implements PersonService {

    String name;
    int age;



    @Override
    public void sayHello () {
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println();
    }

}
