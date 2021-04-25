package com.codegym.library.concern;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LibraryLog {
    private static int action;
    @AfterReturning(pointcut = "execution(public * com.codegym.library.services.*.*(..))")
    public void log(){
        action++;
        System.out.println("[Log 2] -- Số lượng truy cập thư viện: " + action);
    }
}
