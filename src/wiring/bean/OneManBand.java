package wiring.bean;

import java.util.Collection;

public class OneManBand implements Performer {
	// 느슨한결합을위해 
	private Collection<Instrument> instruments; // 악기 여러개를 관리하기에 명시해주어야함
	
	// 매개변수 삽입
	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	public void perform() throws PerformanceException { // 메소드 재정의 및 예외 던지기
		// 악기가 하나가 아니기에 다실행할 것이라면 반복문 사용
		for(Instrument instrument : instruments) {
			instrument.playing();
		}
	}
}
