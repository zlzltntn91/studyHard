package makeSoo;

public class PerformanceTime {

    public void getPerformanceTime(long startTime, long endTime, String t) {
        System.out.println(t + " result : " + (endTime - startTime) * 0.001 + " sec");
    }

}
