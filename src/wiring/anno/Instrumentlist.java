package wiring.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Instrumentlist implements Performer{
	//@Value("Hello")
	@Value("#{singer.name}") // singer의 name이 private이기 때문에 에러가남
	private String song;
	
	@Autowired(required = false) //변수위 오토 와이어드 @Autowired(required = false) - 와이어링을 못할경우 null표시
	@Qualifier("piano") // 객체 넣을것을 지정
	private Instrument instrument;
	
	
	// performer 상속받아서 perform 메소드 생성
	public void perform() {
		System.out.println(song + "을 연주 합니다");
		instrument.playing();
	}
}
