package wiring.java;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

public class Actor implements Performer{
	//@Value("강감찬")
	private String name;
	//@Value("28")
	private int age;
	//@Resource(name="company")
	private Role role;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public void perform() {
		System.out.println("이름 : " + name + "\t" + "나이 : " + age);
		role.play();
	}
}
