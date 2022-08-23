package aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	// 얘도 객체가 만들어 주어야함
	// 맴버 변수의 상태 유지 가능
	public void takeSeat() { // 공연전
		System.out.println("자리에 앉는다");
	}
	public void turnOffPhone() { // 공연 시작 전
		System.out.println("핸드폰을 끈다");
	}
	
	// 실행후 에러유무 확인
	public void applaud() { // 공연 정상 종료
		System.out.println("짝! 짝! 짝");
	}
	
	public void refund() { // 공연의 실패 했을때
		System.out.println("우~ 우~ 우~ 돈내놔라~!");
	}
	// arround 추가
	// 특정 메소드를 둘러싸고 실행(앞 뒤로 실행됨)
	// 특정 메소드를 지칭하는 매개변수를 받을수 있음
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
