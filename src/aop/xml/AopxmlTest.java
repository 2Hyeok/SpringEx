package aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopxmlTest {
	public static void main(String[] args) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/aop/xml/ApplicationContext.xml");
		
		Performer hong = (Performer)ctx.getBean("hong");
		hong.perform();
		
		Performer singer = (Performer)ctx.getBean("singer");
		singer.perform();
		
		Thinker thinker = (Thinker)ctx.getBean("volunteer");
		thinker.thinking("양규호");
	}
}
