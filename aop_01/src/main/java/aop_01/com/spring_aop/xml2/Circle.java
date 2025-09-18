package aop_01.com.spring_aop.xml2;

public class Circle {
	
	private int radius;
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	// 핵심기능 : 원의 넓이와 둘레를 구해서 출력
	public void showCircleResult() {
		System.out.println("넓이 : " +  (Math.PI * radius * radius));
		System.out.println("둘레 : " +  (2 * radius * Math.PI));
	}
	
}
