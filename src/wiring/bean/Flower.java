package wiring.bean;

public class Flower implements Poem { //poem을 상속받음
	String str = "내가 그의 이름을 불러주기 전에는\r\n" + 
			"그는 다만\r\n" + 
			"하나의 몸짓에 지나지 않았다.\r\n"; // 문자를 붙여넣으면 자동으로 칸이 떨어짐
	public void recite() {
		System.out.println("Flower : " + str); // flower의 str 출력
	}

}
