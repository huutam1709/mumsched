package mum.swe.mumsched.rest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect   
@Component
public class Checklogging {  
   /*
    * Maybe you don't need to define pointcuts, but instead just define the advices as this one below
    * and it should take care of inserting
    */
	@Before("execution(* mum.swe.mumsched.rest..*(..))")
	public void checkLogging() {
		System.out.println("**************The system is logging someone*****************");
	}
	
	@After("execution(* mum.swe.mumsched.rest..*(..))")
	public void checkLoggingAfter() {
		System.out.println("**************Someone just finished something******************");
	}
}  