package wiring.auto;

public class Bounce implements Song{
	private String str = "그대가 돌아서면 두 눈이 마주칠까\r\n" + 
			"심장이 bounce bounce 두근대\r\n" + 
			"들릴까 봐 겁나";
	public void singing() {
		System.out.println("Bounce : " + str);
	}
}
