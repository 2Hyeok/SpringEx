package wiring.scan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component
public class Company implements Role{
	
	@Value("김유신")
	private String name;
	public void play() {
		System.out.println("회사원 " + name + " 을 연기합니다");
	}
}
