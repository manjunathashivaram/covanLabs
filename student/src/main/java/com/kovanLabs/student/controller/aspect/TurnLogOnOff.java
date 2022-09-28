package com.kovanLabs.student.controller.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TurnLogOnOff {

	@Around("@annotation(com.kovanLabs.student.controller.aspect.LogRequest)")
	public Object getResult(ProceedingJoinPoint pjp) throws Throwable {

		log.info("getResult running");

		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		LogRequest logOnOff = method.getAnnotation(LogRequest.class);
		boolean turnOffLog = logOnOff.onOffRequest();

		Object obj = null;

		if (turnOffLog) {
			String string = Arrays.toString(pjp.getArgs());
			log.info(string);
			obj = pjp.proceed();
			log.info(obj.toString());
		} else {
			log.error("default value is false ");
		}

		return obj;
	}
}
