package wiring.java;

import org.springframework.beans.factory.annotation.Value;

public class Company implements Role {
	//@Value("홍길동")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void play() {
		System.out.println("회사원 " + name + " 을 연기합니다");
	}
}
