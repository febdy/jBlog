package com.javaex.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeCheckAdvice {

	//private static final Logger logger = LoggerFactory.getLogger(TimeCheckAdvice.class);
	
	@Around("within(com.javaex.service..*)")
	public Object timelog(ProceedingJoinPoint joinPoint) throws Throwable {
		String signature = joinPoint.getSignature().toShortString();
		System.out.println(signature + " is started.");
		//logger.info(signature + "is started.");
		long st = System.currentTimeMillis();
		
		try {
			System.out.println(signature + " is running.");
			//logger.info(signature + " is running.");
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signature + " is finished.");
			System.out.println(signature + " 경과시간 : " + (et - st) + "\n");
			
			//logger.info(signature + "is finished.");
			//logger.info(signature + "경과시간 : " + (et - st));
		}
	}
}
