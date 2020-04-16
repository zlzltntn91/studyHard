package javaWeb.chapter19.ex02;

import lombok.Data;

public @Data
class PersonServiceImpl implements PersonService {

    String name;
    int age;
    long value;


    PersonServiceImpl(){

    }

    PersonServiceImpl (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonServiceImpl (String name, int age, long value) {
        this.name = name;
        this.age = age;
        this.value = value;
    }

    @Override
    public void sayHello () {
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("가치 : " + value);
    }

}
