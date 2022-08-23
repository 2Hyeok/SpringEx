package wiring.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringTest {
	public static void main(String[] args) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/wiring/auto/ApplicationContext.xml");
		
		// 쓸객체
		Performer hong = (Performer) ctx.getBean("hong");
		hong.perform();
		
		// 연습용
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();
	}
}
