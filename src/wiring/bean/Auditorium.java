package wiring.bean;

public class Auditorium {
	public void turnOn() {// 메소드생성
		System.out.println("조명을 킨다");
	}
	
	// 소멸될때실행
	// 실제론 실행X
	// 객체가 사라질때 출력
	public void turnOff() {// 메소드생성
		System.out.println("조명을 끈다");
	}
}
