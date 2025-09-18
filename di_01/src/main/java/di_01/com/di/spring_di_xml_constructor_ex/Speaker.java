package di_01.com.di.spring_di_xml_constructor_ex;

public class Speaker {

	int volume;
	
	public Speaker() {
		volume = 1;
	}
	
	public void volumeDown() {
		volume = Math.max(volume - 1, 0);
		System.out.println("볼륨을 낮춥니다. 현재 볼륨 크기는 " + volume + "입니다.");
	}
	
	public void volumeUp() {
		volume = Math.min(volume + 1, 10);
		System.out.println("볼륨을 키웁니다. 현재 볼륨 크기는 " + volume + "입니다.");
	}
}
