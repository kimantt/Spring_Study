package aop_01.com.spring_aop.annotation_ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		// 스프링 컨테이너 객체 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config2-2.xml");
		
		// 핵심 기능 bean 등록되어있음
		Circle circle = context.getBean("circle", Circle.class);
		circle.showCircleResult();
		
		Evaluation eval = context.getBean("eval", Evaluation.class);
		eval.showResult();
		
		context.close();
	}

}
