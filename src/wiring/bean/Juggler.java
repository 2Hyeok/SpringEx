package wiring.bean;

public class Juggler implements Performer{ //Performer 상속
	// 느슨한 결합을 위한 클래스 생성
	
	private int beanBags = 3; // 저글링할 공의 갯수
	
	// 디폴트 생성자가 없으면 에러가남
	// 생성자를 만듬
	public Juggler() {}
	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}
	
	
	
	// 메서드 재정의
	public void perform() throws PerformanceException {
		// 실제 공연을 하는 메서드
		System.out.println(beanBags + "개를 저글링 합니다"); // beanBags라는 변수가 있어야함 (공의 갯수)
	}
}
