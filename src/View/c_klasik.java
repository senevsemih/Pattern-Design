package View;

import java.sql.ResultSet;
import java.sql.SQLException;

public class c_klasik implements Soru {

	public static c_klasik instance = null;

	public synchronized static c_klasik getInstance()
	{
		if(instance == null)
		{
			instance = new c_klasik();
		}
		return instance;
	}
	// Sýnýfý clone sihirli metoduyla kopyalamaya çalýþtýðýmýzda CloneNotSupportedException ile kopyalanmasýný engelliyoruz.
	 public Object clone() throws CloneNotSupportedException
	    {
	        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
	    }
	
	
	@Override
	public void soruEkle() {
		
		String no,soru,zorluk,puan,kategori,dogrucevap,sql_sorgu;
		
		frm_klasik.getInstance();
		no =frm_klasik. txt_no.getText();
		soru = frm_klasik.txt_soru.getText();
		zorluk = frm_klasik.txt_zorluk.getText();
		puan = frm_klasik.txt_puan.getText();
		kategori = frm_klasik.txt_kategori.getText();
		dogrucevap = frm_klasik.txt_dogrucevap.getText();
		
		sql_sorgu = "INSERT INTO klasik (k_no,k_soru,k_zorluk,k_puan,k_kategori,k_dogrucevap) VALUES ("+
		no + ",'" + soru + "'," + "'"  + zorluk + "'," + "'" + puan + "'," + "'" + kategori + "'," + "'" + dogrucevap + "')";
	
	
		
		baglanti.ekle(sql_sorgu);
		
	}

	@Override
	public void update() {
		
		String no,soru,zorluk,puan,kategori,dogrucevap,sql_sorgu;
		
		no = frm_klasik.txt_no.getText();
		soru = frm_klasik.txt_soru.getText();
		zorluk = frm_klasik.txt_zorluk.getText();
		puan = frm_klasik.txt_puan.getText();
		kategori = frm_klasik.txt_kategori.getText();
		dogrucevap = frm_klasik.txt_dogrucevap.getText();
		
		sql_sorgu = "UPDATE klasik SET k_no="+no+","+"k_soru='"+soru+"',k_zorluk='"+zorluk+"',k_puan='"+puan+"',k_kategori='"+kategori+"',k_dogrucevap='"+dogrucevap+"' "
				+ "                             WHERE k_no="+no;                                                                  
		
		//System.out.println(sql_sorgu);
		
		baglanti.update(sql_sorgu);
		

		
	}

	@Override
	public void sil() {
		
		String no,sql_sorgu;
		
		no = frm_klasik.txt_no.getText();
		
		sql_sorgu = "DELETE FROM klasik WHERE k_no="+no;
		
		baglanti.sil(sql_sorgu);
		
		
	}

	@Override
	public void hazýrla() {
		frm_klasik.modelim.setRowCount(0);
		
		String zorluk = frm_klasik.txt_zorluk2.getText();
		String kategori = frm_klasik.txt_ders.getText();
		
		ResultSet myRs = null;
		
		String sql_sorgu = "select * from klasik where k_zorluk='"+ zorluk +"' AND k_kategori='"+ kategori +"'";
		
		myRs = baglanti.hazýrla(sql_sorgu);
		
		try {
			while(myRs.next()) {
				frm_klasik.satirlar[0] = myRs.getString("k_no");
				frm_klasik.satirlar[1] = myRs.getString("k_soru");
				frm_klasik.satirlar[2] = myRs.getString("k_zorluk");
				frm_klasik.satirlar[3] = myRs.getString("k_puan");
				frm_klasik.satirlar[4] = myRs.getString("k_kategori");
				frm_klasik.satirlar[5] = myRs.getString("k_dogrucevap");
				frm_klasik.modelim.addRow(frm_klasik.satirlar);
				
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		frm_klasik.table.setModel(frm_klasik.modelim);
		
	}

	@Override
	public void listele() {
		frm_klasik.modelim.setRowCount(0);
		
		ResultSet myRs = baglanti.yap();
		
		try {
			while(myRs.next()) {
				frm_klasik.satirlar[0] = myRs.getString("k_no");
				frm_klasik.satirlar[1] = myRs.getString("k_soru");
				frm_klasik.satirlar[2] = myRs.getString("k_zorluk");
				frm_klasik.satirlar[3] = myRs.getString("k_puan");
				frm_klasik.satirlar[4] = myRs.getString("k_kategori");
				frm_klasik.satirlar[5] = myRs.getString("k_dogrucevap");
				frm_klasik.modelim.addRow(frm_klasik.satirlar);
				
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		frm_klasik.table.setModel(frm_klasik.modelim);
		
	}

}
