package di_01.com.di.no_spring_no_di;

public class NameController {

	// NameController 클래스는 NameService에 의존적인 클래스
	NameService nameService = new NameService();
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
	
}
