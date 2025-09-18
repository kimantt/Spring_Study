package di_01.com.di.spring_di_xml_setter;

// 다른 사용자 정의 클래스를 의존하지 않음
public class NameService {
	
	public String showName(String name) {
		System.out.println("NameService showName() 메서드");
		String myName = "내 이름은 " + name + "입니다.";
		return myName;
	}
	
}
