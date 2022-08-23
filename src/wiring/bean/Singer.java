package wiring.bean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Singer implements Performer {
	private String name;
//	private Song song;
	private List<Song> songs;
	private Map<String, Instrument> instruments;
	
	/*// 부모한태서 상속을 받아오는것이 없고
	// 생성자를 생성해줌
	
	public Singer() {}
	
	// 생성자 오버로딩
	public Singer(Song song, String name) {
		this.song = song;
		this.name = name;
	}
	
	public void perform() throws PerformanceException{ // 재정의 후 예외를 던짐
		System.out.println("가수 : " + name);
		song.singing();
	}
*/
	
	// 프로퍼티 이용
	/*
	public void setName(String name) {
		this.name = name;
	}
	*/
	
	public void setName( String name ) {
		this.name = name;
	}
	public void setSongs( List<Song> songs ) {
		this.songs = songs;
	}
	public void setInstruments( Map<String, Instrument> instruments ) {
		this.instruments = instruments;
	}
/*
	public void setSong(Song song) {
		this.song = song;
	}
	

	public void perform() {
		System.out.println(name + "이 노래 합니다.");
		song.singing();
*/
	public void perform() throws PerformanceException {
		System.out.println( name + "이 노래합니다" );
		for( Song song : songs ) {
			song.singing();
		}
		Iterator<String> keys = instruments.keySet().iterator();
		while( keys.hasNext() ) {
			String key = keys.next();
			System.out.println( key + " : " );
			instruments.get( key ).playing();
		}
	}
}