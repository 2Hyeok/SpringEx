package wiring.bean;

public class Picnic implements Poem { // poem 상속
	private String str = "나 하늘로 돌아가리라.\r\n" + 
			"\r\n" + 
			"새벽빛 와 닿으면 스러지는\r\n" + 
			"\r\n" + 
			"이슬 더불어 손에 손을잡고,";
	public void recite() {
		System.out.println("Picnic : " + str);
	}

}
