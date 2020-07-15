package kr.co.api.docuchain.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.io.IOException;

/**
 * <pre>
 * <b>스프링 AOP를 활용해 로깅 구현 </b>
 *
 * before           : 호출 시점을 출력한다.
 * around           : 성능을 출력한다.
 * afterReturning   : 반환값을 출력한다.
 *</pre>
 * @author  Kim Eun Soo
 * @since 2020.07.14
 * @version 0.1
 */
public class LoggingAopXml {

    Logger logger = Logger.getLogger(this.getClass());

    public void getJoinPointLog(JoinPoint joinPoint) {
        StringBuilder className = new StringBuilder(joinPoint.getTarget().getClass().getName());
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        String logString = className.insert(0, "───────────────────────── ").append(".").append(joinPoint.getSignature().getName()).append("() ─────────────────────────").toString();
        logger.debug(logString);
        logger.debug("─────── adviceName : " + caller);
    }

    public void beforeTest(JoinPoint j) {
        getJoinPointLog(j);
    }

    public Object aroundTest(ProceedingJoinPoint j) throws Throwable {
        getJoinPointLog(j);
        long beginTime = System.currentTimeMillis();
        Object obj = j.proceed();
        long endTime = System.currentTimeMillis();
        logger.debug("─────── performance : " + ((endTime - beginTime) * 0.001) + " sec");
        return obj;
    }

    public void afterReturningTest(JoinPoint j, Object retVal) {
        getJoinPointLog(j);
        logger.debug("─────── result : " + retVal);
    }

    public void afterTest(JoinPoint j) {
        getJoinPointLog(j);
    }

    public void afterThrowingTest(JoinPoint j, Exception e) throws IOException {
        getJoinPointLog(j);
        logger.error("####### exception " + e);
        e.printStackTrace();
    }
}
