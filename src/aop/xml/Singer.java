package aop.xml;

public class Singer implements Performer {
	private String name;
	private Song song;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSong(Song song) {
		this.song = song;
	}
	
	public void perform() throws PerformanceException {
		System.out.println(name + "이 연주를 합니다");
		song.singing();
	}
}