package javaTest.string_buffer_builder;

import org.apache.log4j.Logger;


public class Test {
    Logger logger = Logger.getLogger(this.getClass());
    Test(){
        System.out.println("Test Constructor");
    }
    int loopSize = 200_000;
    String str = null;
    StringBuilder strBulider = new StringBuilder("");
    StringBuffer strtBuffer = new StringBuffer("");

    // String
    public void stringTest(){
        for (int i = 0; i < loopSize; i++) {
            str += "@@/";
        }
    }
    // StringBuilder
    public void builderTest(){
        for (int i = 0; i < loopSize; i++) {
            strBulider.append("@@/");
        }
    }

    public void bufferTest(){
        for (int i = 0; i < loopSize; i++) {
            strtBuffer.append("@@/");
        }
    }

    public static void main (String[] args) {
        Test t = new Test();

        long startTime2 = System.currentTimeMillis();
        t.builderTest();
        long endTime2 = System.currentTimeMillis();
        System.out.println((endTime2 - startTime2)*0.001 + " StringBuilder Test");

        long startTime3 = System.currentTimeMillis();
        t.builderTest();
        long endTime3 = System.currentTimeMillis();
        System.out.println((endTime3 - startTime3)*0.001 + " StringBuffer Test");

        long startTime = System.currentTimeMillis();
        t.stringTest();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime)*0.001 + " String Test");
    }
}
