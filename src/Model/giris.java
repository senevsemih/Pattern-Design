package Model;

public class giris {
	private String kullan�c�;
	private int no;
	private int id;
	
	public giris() {
		super();
		this.kullan�c� = "dp�";
		this.no = 26;
		id = 1;
	}

	public String getKullan�c�() {
		return kullan�c�;
	}

	public void setKullan�c�(String kullan�c�) {
		this.kullan�c� = kullan�c�;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}