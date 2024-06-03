package rases;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeMethod {

    @Pointcut("@annotation(rases.Benchmark)")
    public void marker() {}

    @Around("marker()")
    public Object logtime(ProceedingJoinPoint joinPoint){
        long startTime = System.nanoTime();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        long endTime = System.nanoTime();
        long resultTime = endTime - startTime;
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " : " + resultTime + "ns");

        return result;
    }
}
