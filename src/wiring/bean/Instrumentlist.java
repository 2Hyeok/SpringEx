package wiring.bean;

public class Instrumentlist implements Performer{
	private String song;
	private Instrument instrument;
	
	// set 메소드
	public void setSong(String song) {
		this.song = song;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	// performer 상속받아서 perform 메소드 생성
	public void perform() {
		System.out.println(song + "을 연주 합니다");
		instrument.playing();
	}
}
