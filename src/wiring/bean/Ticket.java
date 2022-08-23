package wiring.bean;

public class Ticket {
	private int cnt;
	// 객체가 싱글톤으로 잡힘
	public void reservation() {
		System.out.println("티켓 번호는 : " + ++cnt); // 선증가
	}

}
