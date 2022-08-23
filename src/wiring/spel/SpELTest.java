package wiring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/wiring/spel/ApplicationContext.xml"); // 경로값 설정
		
		// 느슨한 결합이 아니기에 Prop로 바로받음
		Prop prop = (Prop) ctx.getBean("prop");
		System.out.println("값 : " + prop.getStr()); // 값 출력
	}
}
