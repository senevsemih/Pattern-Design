package Model;

public class giris {
	private String kullanýcý;
	private int no;
	private int id;
	
	public giris() {
		super();
		this.kullanýcý = "dpü";
		this.no = 26;
		id = 1;
	}

	public String getKullanýcý() {
		return kullanýcý;
	}

	public void setKullanýcý(String kullanýcý) {
		this.kullanýcý = kullanýcý;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}