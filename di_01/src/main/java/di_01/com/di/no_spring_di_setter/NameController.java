package di_01.com.di.no_spring_di_setter;

public class NameController {
	NameService nameService;
	
	// NameController 클래스는 NameService에 의존적인 클래스
	// setter의 파라미터를 통해서 NameService 객체 인스턴스 전달받음
	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
	
}
