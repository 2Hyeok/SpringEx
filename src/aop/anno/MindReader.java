package aop.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MindReader implements Magician{
	@Pointcut( "execution( * aop.anno.Thinker.thinking( String ) ) && args( thoughts )" ) // String으로 매개변수를 잡은 후 던져 주어야함
	// java 이기때문에 and가 아닌 && 가 들어가야햠
	// 밑에 반드시 포인트컷을 사용할 메소드가 있어야함
	
	public void thinking( String thoughts ) {}
	
	@Before( "thinking( thoughts )" )
	public void intercept(String thoughts) {
		System.out.println("독심술사의 생각은 : " + thoughts);
	}

}
