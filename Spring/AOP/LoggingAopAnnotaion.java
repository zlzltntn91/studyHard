package kr.co.api.docuchain.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <pre>
 * <b>스프링 AOP를 활용해 로깅 구현 </b>
 * around -> before -> after -> afterReturning -> around
 * before           : 호출 시점을 출력한다.
 * around           : 성능을 출력한다.
 * after            : targetMethod의 정상 작동 여부에 상관없이 실행된다
 * afterReturning   : 반환값을 출력한다.
 * afterThrowing    : 예외 발생시 출력한다.
 *
 * Java 5 어노테이션을 사용한 일반 Java 클래스로 관점(Aspect)를 정의하는 방식이다.
 * AspectJ 5 버전에서 소개되었으며, Spring은 2.0 버전부터 AspectJ 5 어노테이션을 지원한다.
 * Spring AOP 실행환경은 AspectJ 컴파일러나 직조기(Weaver)에 대한 의존성이 없이 @AspectJ 어노테이션을 지원한다.
 * {@code
 *
 *      <aop:aspectj-autoproxy/>
 *      <bean id="Logging" class="......LoggingAopAnnotaion" />
 *
 *      Spring 설정에 추가한다.
 *
 *      또는
 *
 *      @Component 어노테이션으로 Bean에 등록한다
 *
 * }
 *</pre>
 * @author  Kim Eun Soo
 * @since 2020.07.14
 * @version 0.1
 */
@Aspect
@Order(1)
public class LoggingAopAnnotaion {

    Logger logger = Logger.getLogger(this.getClass());
/*
    execution: 메소드 실행 결합점(join points)과 일치시키는데 사용된다.
    within: 특정 타입에 속하는 결합점을 정의한다.
    this: 빈 참조가 주어진 타입의 인스턴스를 갖는 결합점을 정의한다.
    target: 대상 객체가 주어진 타입을 갖는 결합점을 정의한다.
    args: 인자가 주어진 타입의 인스턴스인 결합점을 정의한다.
    @target: 수행중인 객체의 클래스가 주어진 타입의 어노테이션을 갖는 결합점을 정의한다.
    @args: 전달된 인자의 런타입 타입이 주어진 타입의 어노테이션을 갖는 결합점을 정의한다.
    @within: 주어진 어노테이션을 갖는 타입 내 결합점을 정의한다.
    @annotation: 결합점의 대상 객체가 주어진 어노테이션을 갖는 결합점을 정의한다.

    포인트컷 표현식은 '&&', '||' 그리고 '!' 를 사용하여 조합할 수 있다.
    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {}

    @Pointcut("within(com.xyz.someapp.trading..*)")
    private void inTrading() {}

    @Pointcut("anyPublicOperation() && inTrading()")
    private void tradingOperation() {}

    execution(public * *(..))	public 메소드 실행
    execution(* set*(..))	이름이 set으로 시작하는 모든 메소드명 실행
    execution(* set*(..))	이름이 set으로 시작하는 모든 메소드명 실행
    execution(* com.xyz.service.AccountService.*(..))	AccountService 인터페이스의 모든 메소드 실행
    execution(* com.xyz.service.*.*(..))	service 패키지의 모든 메소드 실행
    execution(* com.xyz.service..*.*(..))	service 패키지와 하위 패키지의 모든 메소드 실행
    within(com.xyz.service.*)	service 패키지 내의 모든 결합점
    within(com.xyz.service..*)	service 패키지 및 하위 패키지의 모든 결합점
    this(com.xyz.service.AccountService)	AccountService 인터페이스를 구현하는 프록시 개체의 모든 결합점
    target(com.xyz.service.AccountService)	AccountService 인터페이스를 구현하는 대상 객체의 모든 결합점
    args(java.io.Serializable)	하나의 파라미터를 갖고 전달된 인자가 Serializable인 모든 결합점
    @target(org.springframework.transaction.annotation.Transactional)	대상 객체가 @Transactional 어노테이션을 갖는 모든 결합점
    @within(org.springframework.transaction.annotation.Transactional)	대상 객체의 선언 타입이 @Transactional 어노테이션을 갖는 모든 결합점
    @annotation(org.springframework.transaction.annotation.Transactional)	실행 메소드가 @Transactional 어노테이션을 갖는 모든 결합점
    @args(com.xyz.security.Classified)	단일 파라미터를 받고, 전달된 인자 타입이 @Classified 어노테이션을 갖는 모든 결합점
    bean(accountRepository)	“accountRepository” 빈
    !bean(accountRepository)	“accountRepository” 빈을 제외한 모든 빈
    bean(*)	모든 빈
    bean(account*)	이름이 'account'로 시작되는 모든 빈
    bean(*Repository)	이름이 “Repository”로 끝나는 모든 빈
    bean(accounting/*)	이름이 “accounting/“로 시작하는 모든 빈
    bean(*dataSource) || bean(*DataSource)	이름이 “dataSource” 나 “DataSource” 으로 끝나는 모든 빈
*/
    @Pointcut("execution(* kr.co.api.docuchain..*(..))")
    public void targetMethod(){

    }

    @Before("targetMethod()")
    public void before(){

    }

    @After("targetMethod()")
    public void after(JoinPoint j) {
        getJoinPointLog(j);
    }

    @AfterReturning(pointcut = "targetMethod()", returning = "retVal")
    public void afterReturning(JoinPoint j, Object retVal) {
        getJoinPointLog(j);
        logger.debug("afterReturning");
        logger.debug("─────── result : " + retVal);
    }

    @Around("targetMethod()")
    public Object around(ProceedingJoinPoint j) throws Throwable {
        getJoinPointLog(j);
        long beginTime = System.currentTimeMillis();
        Object obj = j.proceed();
        long endTime = System.currentTimeMillis();
        logger.debug("─────── performance : " + ((endTime - beginTime) * 0.001) + " sec");
        return obj;
    }

    @AfterThrowing(pointcut = "targetMethod()", throwing = "e")
    public void afterThrowing(JoinPoint j, Exception e) throws IOException {
        getJoinPointLog(j);
        logger.error("####### exception " + e);
        e.printStackTrace();
    }

    public void getJoinPointLog(JoinPoint joinPoint) {
        StringBuilder className = new StringBuilder(joinPoint.getTarget().getClass().getName());
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        String logString = className.insert(0, "───────────────────────── ").append(".").append(joinPoint.getSignature().getName()).append("() ─────────────────────────").toString();
        logger.debug(logString);
        logger.debug("─────── adviceName : " + caller);
    }
}
