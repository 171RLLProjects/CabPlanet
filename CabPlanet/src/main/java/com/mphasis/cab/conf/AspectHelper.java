package com.mphasis.cab.conf;

import java.util.Arrays;



import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class AspectHelper {
    private static Logger logger=Logger.getLogger(AspectHelper.class);
    
    @Before("execution(* com.mphasis.cab.*.*.*(..))")
    public void beforeMethod(JoinPoint joinpoint) {
        logger.debug("before the method"+joinpoint.getSignature().getName());
        logger.debug(Arrays.toString(joinpoint.getArgs()));
      //  System.err.println("lol");
        
    }
    @After("execution(* com.mphasis.cab.*.*.*(..))")
    public void afterMethod(JoinPoint joinpoint) {
        logger.debug("after the method"+joinpoint.getSignature().getName());
        logger.debug(Arrays.toString(joinpoint.getArgs()));
    }
    
}
