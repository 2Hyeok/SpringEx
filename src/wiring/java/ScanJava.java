package wiring.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScanJava {
	public static void main(String[] args) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/wiring/java/ApplicationContext.xml");
		
		Performer actor = (Performer) ctx.getBean("actor");
		actor.perform();
		
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();

	}
}
