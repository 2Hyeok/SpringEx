package aop.anno;

public class Hello implements Song {
	private String str = "아메리카노보단 라떼를\r\n" + 
			"맛있게 내리던 네 집 앞 카페를\r\n" + 
			"매일 같이 갔었었던 그때를\r\n" + 
			"내려줄 게 쓰지 않아 이제는";
	public void singing() {
		System.out.println("Hello : " + str);
	}
}
