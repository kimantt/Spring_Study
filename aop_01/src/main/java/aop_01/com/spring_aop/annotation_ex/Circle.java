package aop_01.com.spring_aop.annotation_ex;

public class Circle {
	
	private double radius;
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

	// 핵심기능 : 원의 넓이와 둘레를 구해서 출력
	public void showCircleResult() {
		System.out.println("넓이 : " +  (Math.PI * radius * radius));
		System.out.println("둘레 : " +  (2 * radius * Math.PI));
	}
	
}
