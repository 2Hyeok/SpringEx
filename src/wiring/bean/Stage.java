package wiring.bean;

public class Stage {
	private static Stage stage = new Stage();
	public static Stage getInstance() { // stage를 return하는 stage 메소드 생성
		return stage;
	}
}
