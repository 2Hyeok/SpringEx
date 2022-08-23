package wiring.java;

import org.springframework.beans.factory.annotation.Value;

public class Teacher implements Role {
	//@Value("김유신")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void play() {
		System.out.println("교사 " + name + " 을 연기합니다");
	}
}
