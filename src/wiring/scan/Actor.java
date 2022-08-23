package wiring.scan;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hong") // 메인에 hong으로 받아주기 때문에 이런식으로 hong 이라 써주어야한다
					// 안써주면 actor로 자동생성이라 변경해주는것임
public class Actor implements Performer{
	
	@Value("양규호")
	private String name;
	@Value("28")
	private int age;
	
	@Resource(name="company")
	private Role role;
	
	public void perform() { // perform  재정의
		System.out.println("이름 : " + name + "\t" + "나이 : " + age);
		role.play();
	}
}
