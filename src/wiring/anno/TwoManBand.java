package wiring.anno;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

public class TwoManBand implements Performer {
	@Value("이순신, 김유신") // or @Value("#{singer.name}, 김유신")
	private String[] name;
	
	// 이름은 있어야함
	// ApplicationContext에서 리스트를 만들어줌
	// 값이 아니기 에 value값이 들어가면 안됨
	@Resource(name="names") // 오토와이어와 쿼리파이어를 동시에 함 or @Value("names")
	private List<String> names;
	
	@Resource(name="instruments")
	private List<Instrument> instruments;
	
	@Resource(name="songs")
	private Map<String, Song> songs;
	
	public void perform() throws PerformanceException {
		for(String n : name) {
			System.out.print( n + "\t");
		}
		System.out.println();
		
		for(String name : names) {
			System.out.println(name + "\t");
		}
		System.out.println();
		for(Instrument instrument : instruments) {
			instrument.playing();
		}
		System.out.println();
		Iterator<String> keys = songs.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			Song song = songs.get(key);
			System.out.println(key);
			song.singing();
		}
	}

}
