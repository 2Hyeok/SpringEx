package wiring.anno;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Singer implements Performer {
	
	
	//name 이 TwoMAnBand와 충돌이나기에 get메소드 하나 생성해주자
	@Value("김동현")
	private String name;
	
	@Resource( name="ss" )
	private Song[] songs;
	
	@Resource( name="ins" )
	private Map<String, Instrument> instruments;
	
	
	public String getName() {
		return name;
	}
	/*
	@Value("김동현")
	private String name;
	
	@Autowired(required=false)
	@Qualifier("hello")
	private Song song;
	
	public String getName() {
		return name;
	}
	
	*/
	
	public void perform() throws PerformanceException {
	/*
		System.out.println(name + "이 연주를 합니다");
		song.singing();
	*/
		System.out.println(name);
		
		for(Song song : songs) {
			song.singing();
		}
		Iterator<String> keys = instruments.keySet().iterator();
		while( keys.hasNext() ) {
			String key = keys.next();
			Instrument instrument = instruments.get( key );
			System.out.println( key );
			instrument.playing();
		}
	}
}