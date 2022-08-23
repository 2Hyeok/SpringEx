package wiring.bean;

import java.util.Iterator;
import java.util.Map;

public class TwoManBand implements Performer {
	private Map<String, Instrument> instruments;
	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}
	public void perform() throws PerformanceException {
		// map 은반복문을 못돌림
		// 이노머레이션 이나 이터레이터 사용해서 반복문 돌림
		Iterator<String> keys = instruments.keySet().iterator(); // 최종 리턴값이 iterator가 된다.
										// 키만 뽑는 함수 이기에 <string> 을 관리하도록 붙여줌
		
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(key + ":");
			instruments.get(key).playing();
		}
	}

}
