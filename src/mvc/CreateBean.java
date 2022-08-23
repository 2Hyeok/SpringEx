package mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration  // CreateBean 사용시 해주어야함
public class CreateBean {
	@Bean // 객체생성
	public ViewResolver viewResolver() { // 뷰 리졸버라는 객체를 쓰라한 코드가 없음, 하지만 xml에서 읽히는건 byType이기에 읽힘, 그러기에 객체를 만들어줌
		// 스프링 설정에서 알아서 가져다쓴다
		
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		
		// 생성자를 안만들어서 default가 있음
		// 있다면 construct-arg 넣어주어야함
		
		//viewClass 호출해주어야함
		viewResolver.setViewClass(JstlView.class); // 클래스라는 클래스로 호출?
		viewResolver.setPrefix(""); // 지금은 아무것도 필요없음
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
