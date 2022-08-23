package aop.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hong")
public class Instrumentlist implements Performer{
	
	@Value("Hello")
	private String song;
	
	@Resource(name="piano")
	private Instrument instrument;
	
	// set 메소드
	public void setSong(String song) {
		this.song = song;
	}
	
	public void setInstrument(Instrument instrument) { // byType 이면 instrument로 받겠다
		this.instrument = instrument;
	}
	
	// performer 상속받아서 perform 메소드 생성
	public void perform() {
		System.out.println(song + "을 연주 합니다");
		instrument.playing();
	}
}
