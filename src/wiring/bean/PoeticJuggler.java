package wiring.bean;

public class PoeticJuggler extends Juggler { // Juggler를 상속, Juggler역시 Performer를 상속해야하기에 생성 해줌
	private Poem poem;
	public PoeticJuggler() {}
	public PoeticJuggler(int beanBags, Poem poem) { // beanBags는 부모에게 빌려옴
		super(beanBags); // 부모쪽 생성자로 던져라 라는 super, 빈백받아주는 생성자 호출
		// 변수생성
		this.poem = poem; // 자기가 처리
	}
	
	public void perform() throws PerformanceException {
		super.perform(); // 부모쪽 perform을 불러옴
		poem.recite(); // 호출시 str출력
	}
}
