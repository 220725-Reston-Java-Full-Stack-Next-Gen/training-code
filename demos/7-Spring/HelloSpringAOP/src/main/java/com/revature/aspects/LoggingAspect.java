package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//Just like with our services and daos, we must mark this class as an Aspect component. We are able to do this by using the @Aspect (mostly for AspectJ) AND @Component annotations above this class
@Aspect
@Component
public class LoggingAspect {
	//For this aspect to do its single job appropriately, we must have a Logger instance to use here
	private static Logger log = Logger.getLogger(LoggingAspect.class);
	
	//here is where we can define the advices and the pointcuts that will be used by the runtime environment to intercept logging events in our services and daos layer (3 methods in total):
	
	@Before(value="execution(* com.revature.*.*.*(..))") //this expression that is used as the value for this annotation is SpEL (aka Spring Expression Language)
	//this expression is the same as this:
	//@Before(value="execution(* com.revature.services.AnimeServiceImpl.getAllAnimeShows(..))")
	//the * serves as a wildcard character
	public void logBefore(JoinPoint joinPoint) {
		
		//here this logic will not trigger until before any given service/repo method is executed in runtime
		log.info(String.format("Before advice for: [ %s : %s ]", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()));
		
		//Q: What does this joinPoint logic look similar to? Answer: Reflections API!
		//Note: DO NOT CONFUSE THIS with the Reflections API - completely different, syntax just looks similar.
		
	}
	
	@After(value="execution(* com.revature.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info(String.format("After advice for: [ %s : %s ]", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()));
	}
	
	//Around advice is the most powerful advice as it controls what happens to this logic during any given class/method execution
	@Around(value="execution(* com.revature.services.*.*(..))") //this method should only execute when any method inside of the AnimeServiceImpl class is called
	public Object logDuring(ProceedingJoinPoint joinPoint) {
		//1. get the arguments returned from the dao layer call that came into the service layer (aka our list)
		Object[] args = joinPoint.getArgs();
		
		//2. provide a log message for this advice
		log.info(String.format("Around advice for: [ %s : %s ]", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName()));
		
		//3. proceed the program flow in this joinPoint's owner method by using the proceed()
		Object result = null;
		
		try {
			result = joinPoint.proceed(args);
			log.info(String.format("Results of this method invoking/proceeding is: %s", result));
		} catch (Throwable e) {
			log.warn(String.format("Unable to execute around advice: %s", e.getMessage()));
		}
		
		//4. end the advice by returning the found results from proceeding
		log.info("End of Around Advice");
		return result;
	}

}
