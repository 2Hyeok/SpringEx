package wiring.scan;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("singer")
public class Singer implements Performer {
	
	@Resource(name="hello")
	private Song song;
	
	@Resource(name="drum")
	private Instrument instrument;
	
	
	public void perform() throws PerformanceException {
		song.singing();
		instrument.playing();
	}
	
}