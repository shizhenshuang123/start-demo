package org.example.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@org.aspectj.lang.annotation.Aspect
public class MyLogAspect {

    private MyLogProperties myLogProperties;

    public MyLogAspect(MyLogProperties myLogProperties) {
        this.myLogProperties = myLogProperties;
    }

    @Pointcut("@annotation(org.example.annotation.MyLog)")
    public void myLogPointCut() {}

    @Around("myLogPointCut()")
    public Object invoke(ProceedingJoinPoint joinPoint){
        System.out.println(myLogProperties.getPerfix()+"---"+ Arrays.toString(joinPoint.getArgs()));
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(myLogProperties.getSubfix()+"---"+ Arrays.toString(joinPoint.getArgs()));
        return proceed;

    }

}
