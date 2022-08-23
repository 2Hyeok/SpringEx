package aop.xml;

public class MindReader implements Magician{
	public void intercept(String throughts) {
		System.out.println("독심술사의 생각은 : " + throughts);
	}

}
