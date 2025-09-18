package aop_01.com.spring_aop.xml2;

public class Evaluation {

	private int koreanScore;
	private int englishScore;
	private int mathScore;
	
	public int getKoreanScore() {
		return koreanScore;
	}
	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}
	public int getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	public void showResult() {
		int total = koreanScore + englishScore + mathScore;
		float avg = (koreanScore + englishScore + mathScore) / 3;
		
		System.out.println("국어 / 영어 / 수학");
		System.out.println("총점 : " + total);
		System.out.println("총점 : " + avg);
	}
	
}
