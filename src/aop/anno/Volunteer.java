package aop.anno;

public class Volunteer implements Thinker {
	public void thinking(String thoughts) {
		System.out.println("지원자의 생각은 : " + thoughts);
	}
}
