package mybatis.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class PojoAspectJ {
	
	///Constructor
	public PojoAspectJ() {
		System.out.println(":: PojoAspectJ Default Constructor");
	}
	
	//@Around("execution(* spring.service.aop.*.*(..))")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("[Around before]" + getClass() + ".invoke() start......");
		System.out.println("[Around before] ≈∏∞Ÿ ∞¥√º " +joinPoint.getTarget().getClass().getName());
		System.out.println("[Around before] tagetObject call Method : " + joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length != 0 ) {
			System.out.println("[Around before] tagetObject method ¿¸¥ﬁ argument : " + joinPoint.getArgs()[0]);
		}
		
		//==> targetObject Method Call
		Object obj = joinPoint.proceed();
		
		System.out.println("[Around after] ≈∏∞Ÿ ∞¥√º¿« »≥√‚»ƒ return value : " + obj);
		System.out.println("[Around after] " +getClass() +"invoke() end....");
		
		return obj;
	}
	
}