package wiring.auto;

class InherSuper {
	String name = "부모클래스"; // default
	public String getName() {
		return name;
	}
}


public class InherTest extends InherSuper{ // 상속
	String name = "자식클래스"; // default
	public String getName() {
		return name;
	}
	public static void main(String[] args) {
		// 힙영역과 스택영역
		
		// 부모클래스 참조변수 = 부모클래스 인스턴스
		// 주소가 들어갈 참조변수 생성후 객채 생성
		InherSuper is = new InherSuper();
		System.out.println("is : " + is.name);
		System.out.println("is : " + is.getName());
		
		
		// 자식클래스 참조변수 = 자식클래스 인스턴스
		InherTest it = new InherTest();
		System.out.println("it : " + it.name);
		System.out.println("it : " + it.getName());
		
		//-----------------여기까지는 이상 무--------------------
		
		
		// 부모클래스 참조변수 = 자식클래스 인스턴스
		is = new InherTest();
		System.out.println("is : " + is.name);
		System.out.println("is : " + is.getName()); // 메서드는 하나이기때문에 자식이라 출력
		
		
		// 자식클래스 참조변수 = 부모클래스 인스턴스
		// 실행은 안됨
		// 많이씀
		// 기본적으로는 에러가남 부모가 더 큰개념이기 때문에
		// 부모를 자식에게 넣는것 불가 형변환을 해주어야함
		it = (InherTest) new InherSuper();
		
		
	}
}
