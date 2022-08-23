package wiring.scan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component
public class Teacher implements Role{
	
	@Value("이순신")
	private String name;
	public void play() {
		System.out.println("교사 " + name + " 을 연기합니다");
	}
}
