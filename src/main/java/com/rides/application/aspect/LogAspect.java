package com.rides.application.aspect;

import com.rides.application.repository.user.UserRepository;
import com.rides.application.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Aspect Log for {@link UserService} .
 *
 * @author Sergei Perminov
 * @version 1.0
 */

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Before("execution(* com.rides.application.service.user.impl.*.*(..))")
    public void beforeServiceMethodInvocation(JoinPoint joinPoint){
        //log.info("Invocation of method " + joinPoint.getSignature());

        if(log.isDebugEnabled()) {
            Object[] args= joinPoint.getArgs();
            Map<String, String> typeValue = new HashMap<>();
            for(Object obj: args) {
                if(obj != null) {
                    typeValue.put(obj.getClass().getName(), obj.toString());
                }
            }
            log.debug("Invocation of method:"
                        + joinPoint.getSignature().getDeclaringTypeName()
                        + ", "
                        + joinPoint.getSignature().getName()
                        + ", Parameter:-> "
                        + typeValue);
        }
    }

//    @Bean
//    public LoggingAspectConfig createBean() {
//        if(loggingAspectConfig==null)
//            return new LoggingAspectConfig();
//        else
//            return loggingAspectConfig;
//    }
//
//
//    private LoggingAspectConfig () {
//
//    }
//
//    @Before("execution(* com.mycom.poc.JcachePoc.service*.*.*(..)) && @annotation(Log)")
//    public void logBefore(JoinPoint joinPoint) {
//        if(log.isDebugEnabled()) {
//            Object[] args= joinPoint.getArgs();
//            Map<String, String> typeValue= new HashMap<>();
//            for(Object obj: args) {
//                if(obj!=null) {
//                    typeValue.put(obj.getClass().getName(), obj.toString());
//                }
//            }
//            //log.debug("calling Method:"+joinPoint.getSignature().getDeclaringTypeName()+", "+joinPoint.getSignature().getName()+", Parameter:-> "+ typeValue);
//        }
//    }
//
//    @AfterReturning(pointcut = "execution(* com.mycom.poc.JcachePoc.service*.*.*(..)) && @annotation(Log)", returning = "result")
//    public void logAfter(JoinPoint joinPoint, Object result) {
//        if (log.isDebugEnabled() && result!=null) {
//            log.debug("Method returned:" +
//                    joinPoint.getSignature().getName() + ", Result: " + result.getClass().getName()+" -->"+result);
//        }
//        //log.info(gson.toJson(result));
}