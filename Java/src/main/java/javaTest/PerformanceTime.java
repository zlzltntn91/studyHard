package javaTest;

public class PerformanceTime {

    public void getPerformanceTime(long startTime, long endTime){
        System.out.println("result : " + (endTime - startTime)*0.001 + " sec");
    }
}
