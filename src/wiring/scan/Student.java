package wiring.scan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component // 객체이름이 소문자로 자동으로 만들어짐
public class Student implements Role { // Role 상속
	
	@Value("홍길동")
	private String name;
	
	// 재정의
	public void play() {
		System.out.println("학생 " + name + " 을 연기합니다.");
	}

}
