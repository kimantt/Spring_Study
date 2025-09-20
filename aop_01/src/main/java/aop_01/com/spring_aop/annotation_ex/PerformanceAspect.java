package aop_01.com.spring_aop.annotation_ex;

import java.time.LocalDateTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformanceAspect {
	@Pointcut("within(aop_01.com.spring_aop.annotation_ex.*)")
	private void pointcutMethod() {
		
	}
	
	// 공통기능 메서드 포함
	// 시작시간 / 종료시간 로그 출력
	// 핵심기능 수행 전/후
	// 공통기능 메서드(메서드명 임의설정)
	@Around("pointcutMethod()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		// JoinPoint : 특정포인트(핵심 기능 메서드 호출 시 삽입)
		Signature s = joinPoint.getSignature(); // 설정되어있는 핵심기능에 대한 정보를 추출
		String methodName = s.getName(); // 핵심기능 메서드명
		
		Object result = null; // 반환결과 저장 변수
		
		// 공통작업 코드
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] Before : " + methodName + "() 실행 시작");
		System.out.println("[Log] Before : 시작 시간 " + LocalDateTime.now());
		System.out.println("-----------------------------------------------------------------");
		
		try {
			joinPoint.proceed(); // 핵심 기능 수행
			
		} catch(Exception e) {
			System.out.println("[Log] Exception : " + methodName);
		}
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] After : " + methodName + "() 실행 종료");
		System.out.println("[Log] After : 종료 시간 " + LocalDateTime.now());
		System.out.println("-----------------------------------------------------------------");
		
		return result;
	}
}
