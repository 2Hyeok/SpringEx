package wiring.java;

import org.springframework.beans.factory.annotation.Value;

public class Student implements Role {
	//@Value("이순신")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void play() {
		System.out.println("학생 " + name + " 을 연기합니다.");
	}

}
