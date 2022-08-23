package wiring.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanTest {
	public static void main( String[] args ) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "/wiring/scan/ApplicationContext.xml" );
		
		Performer singer = (Performer) ctx.getBean( "singer" );
		singer.perform();
		
		Performer hong = (Performer) ctx.getBean( "hong" );
		hong.perform();
	}
}
