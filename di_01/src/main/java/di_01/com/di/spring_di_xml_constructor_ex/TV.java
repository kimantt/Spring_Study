package di_01.com.di.spring_di_xml_constructor_ex;

public class TV {

	Speaker speaker;
	
	public TV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
}
