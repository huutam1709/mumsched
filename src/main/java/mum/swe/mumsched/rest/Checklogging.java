package mum.swe.mumsched.rest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect   
public class Checklogging {  
  
    @Pointcut("execution(* mum.swe.mumsched.controller.*signin(..))")  
    public void checkLogging(){  
        System.out.println("**************The System is logging by someone****************");  
    }  
      
   
    @Before("checkLogging()")  
    public void beforeCheck(){  
        System.out.println(">>>>>>>> Start do logging ..........");  
    }  
      
   
}  