package wiring.scan;

import org.springframework.stereotype.Component;

//@Component
public class Guitar implements Instrument { // Instrument 상속
	public void playing() { // 메소드 재 정의 
		System.out.println("기타 : 띵가 띵가 띵가");
	}
}
