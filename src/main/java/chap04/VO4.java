package chap04;

public class VO4 {
	private int hakbun;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
	public void setInt(int v, int kor, int eng, int mat) {
		this.hakbun = v;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public void setName(String v) {
		this.name = v;
	}
	public String getName() {
		return this.name;
	}
	public int getHakbun() {
		return this.hakbun;
	}
	public int getKor() {
		return this.kor;
	}
	public int getEng() {
		return this.eng;
	}
	public int getMat() {
		return this.mat;
	}
	public void setTot () {
		this.tot = (this.kor+this.eng+this.mat);
	}
	public int getTot() {
		return this.tot;
	}
	public void setAvg() {
		this.avg = (this.tot)/3;
	}
	public double getAvg() {
		return this.avg;
	}
}
