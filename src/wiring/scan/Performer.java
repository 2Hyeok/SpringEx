package wiring.scan;

public interface Performer {
	// 상속 받아서 재정의 해서 사용
	public void perform() throws PerformanceException; // 예외 클래스가 없기때문에 그냥 정의함, 예외 클래스 생성해줘야함
}
