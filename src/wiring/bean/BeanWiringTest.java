package wiring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanWiringTest {
	// 실행을 하려는 클래스
	// 매인이 있어야함
	public static void main(String[] args) throws PerformanceException{
		// applicationcontext.xml 파일이 필요함
		// applicationcontext.xml 을 패키지에 넣어줌
		// Performer 인터페이스를 생성할것(패키지 안)
		
		
		// 강한결합 - 바꿀 수 없는 결합
//		Juggler kim = new Juggler(); //생성자가 default라 값넣지말자
//		kim.perform(); // 예외를 던져줘야함
		
		// 무대는 하나지만 공연자는 여러명이라 갈아끼울수 있도록
		// 공연자들이 계속 바뀌어야함
		// 참조변수도 juggler 인스턴스도 juggler이기에 갈아끼울 수없음
		
		// 해결을위해 느슨한결합을 해주어야함
		// 느슨한결합 - 바꾸기 편하게 느슨한 결합을 위한 인터페이스를 끼워넣음
//		Performer hong = new Juggler(); // 계속 바꿀 수 있음 자식클레스에 아무거나 넣어도 됨
//		hong.perform();
		// 무대 하나를 여러명이 돌려씀
		// 자바로는 여기까지 밖에 못함
		// 갈아끼울라면 자바소스를 코딩해서 건드려야함
		// 갈아끼울 수 있긴하지만 코드를 수정해야해서 DI를 사용함
		
		// DI - 종속 객체 주입
		// applicationCintext
		// 객체 만드는 법이 달라짐
		// 찾아서 써야함 - 컨테이너가 관리해줌
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/wiring/bean/ApplicationContext.xml"); 
			// applicationcontext 객체 생성, new 해서 이렇게 생성
			// 경로설정을 해줌
			// /wiring/bean/ApplicationContext.xml 을 읽어와라 라는 뜻
			// 에러가 없어야 제대로 작동
		// Performer lee = (Performer) ctx.getBean("lee"); // lee를 찾아씀, 형변환 해주어야함
//		Performer lee = (Performer) ctx.getBean("park"); // applicationcontext에서 만든 생성자에서 5를 받아옴
//		lee.perform();
		
		
//		Performer hong = (Performer) ctx.getBean("hong"); // hong을 찾아씀, 형변환 해주어야함
//		hong.perform();
		
		
		
		// singleton / prototype
		Ticket t1 = (Ticket) ctx.getBean("ticket");
		t1.reservation();
		System.out.println(t1);
		Ticket t2 = (Ticket) ctx.getBean("ticket");
		t2.reservation();
		System.out.println(t2);
		// 같은 객체를 주기때문에 1, 2 로 넘어옴
		
		
		Performer hong = (Performer) ctx.getBean("hong");
		hong.perform();
		
		// 연습용
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();
		
	}
}
