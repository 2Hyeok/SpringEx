package aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	@Pointcut("execution( * aop.anno.Performer.perform(..))")
	// perform 메소드를 대신할 메소드를 생성
	
	public void performance() {}
	
	
	@Before("performance()")
	public void takeSeat() { // 공연전
		System.out.println("자리에 앉는다");
	}
	
	@Before("performance()")
	public void turnOffPhone() { // 공연 시작 전
		System.out.println("핸드폰을 끈다");
	}
	
	@AfterReturning("performance()") // 퍼포먼스 메소드 다음에
	public void applaud() { // 공연 정상 종료
		System.out.println("짝! 짝! 짝");
	}
	
	@AfterThrowing("performance()")
	public void refund() { // 공연의 실패 했을때
		System.out.println("우~ 우~ 우~ 돈내놔라~!");
	}

	@Around("performance()")
	public void performance(ProceedingJoinPoint joinPoint) {
		
		try {
			long start = System.currentTimeMillis();
			joinPoint.proceed(); // 특정 메소드 지정
			long end = System.currentTimeMillis();
			System.out.println("공연 시간은 : " + (end-start) );
		}catch(Throwable t) {
			t.printStackTrace();
		}
	}
}
