package javaWeb.chapter20.ex01;

public class Calculator {

    public void add(int x, int y){
        int result = x + y;
        System.out.println("Result : " + result);
    }
    public void substract(int x, int y){
        int result = x - y;
        System.out.println("Result : " + result);
    }
    public void multiply(int x, int y){
        int result = x * y;
        System.out.println("Result : " + result);
    }
    public void divide (int x, int y){
        int result = x / y;
        System.out.println("Result : " + result);
    }
}
