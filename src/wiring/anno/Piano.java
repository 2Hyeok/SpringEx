package wiring.anno;

public class Piano implements Instrument { // Instrument 상속
	public void playing() { // 메소드 재 정의
		System.out.println("피아노 : 띵동 띵동 띵동 ");
	}
}
