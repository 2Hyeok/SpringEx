package wiring.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //여기서 만든것은 객체다
public class CreateBean {
	// XML 대용
	@Bean
	// 메소드형식으로 만듬
	// Role 객체로 리턴을 시킴
	public Role student() {
		Student student = new Student(); // 객체 생성
		student.setName("홍길동");
		return student;
		
	}
	@Bean // 객체를 만들어 줄때마다 생성
	public Role teacher() {
		Teacher teacher = new Teacher();
		teacher.setName("이순신");
		return teacher;
	}
	
	@Bean
	public Role company() {
		Company company = new Company();
		company.setName("김유신");
		return company;
	}
	
	@Bean
	public Performer actor() { // performer를 리턴하는 actor(객체이름)
		Actor actor = new Actor();
		actor.setName("강감찬");
		actor.setAge(20);
		actor.setRole(company()); // 문자를 받는게아닌 role 객체를받음 자바문법이기에 쓰고싶은 메소드를 호출
		return actor;
	
	}
	// singer 추가하기
	@Bean
	public Song hello() {
		return new Hello();
	}
	
	@Bean
	public Song bounce() {
		return new Bounce();
	}
	@Bean
	public Instrument drum() {
		return new Drum();
	}
	@Bean
	public Instrument piano() {
		return new Piano();
	}
	@Bean
	public Instrument guitar() {
		return new Guitar();
	}
	
	@Bean
	public Performer singer() {
		Singer singer = new Singer();
		singer.setSong(hello());
		singer.setInstrument(piano());
		return singer;
	}
}
