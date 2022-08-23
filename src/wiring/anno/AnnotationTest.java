package wiring.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
	public static void main(String[] args) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/wiring/anno/ApplicationContext.xml");
		
		Performer hong = (Performer) ctx.getBean("hong");
		hong.perform();
		
		Performer singer = (Performer) ctx.getBean("singer");
		singer.perform();
		
		Performer kim = (Performer) ctx.getBean("kim");
		kim.perform();

	}
}
