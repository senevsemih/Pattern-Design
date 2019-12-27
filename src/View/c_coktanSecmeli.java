package View;

import java.sql.ResultSet;
import java.sql.SQLException;

public class c_coktanSecmeli implements Soru {

	public static c_coktanSecmeli instance = null;
	
	public synchronized static c_coktanSecmeli getInstance()
	{
		if(instance == null)
		{
			instance = new c_coktanSecmeli();
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
		
		String no,soru,a,b,c,d,zorluk,puan,kategori,dogrucevap,sql_sorgu;
		
		frm_soruOlusturma.getInstance();
		no = frm_soruOlusturma.txt_no.getText();
		soru = frm_soruOlusturma.txt_soru.getText();
		a = frm_soruOlusturma.txt_a.getText();
		b = frm_soruOlusturma.txt_b.getText();
		c = frm_soruOlusturma.txt_c.getText();
		d = frm_soruOlusturma.txt_d.getText();
		zorluk = frm_soruOlusturma.txt_zorluk.getText();
		puan = frm_soruOlusturma.txt_puan.getText();
		kategori = frm_soruOlusturma.txt_kategori.getText();
		dogrucevap = frm_soruOlusturma.txt_dogrucevap.getText();
		

		sql_sorgu = "INSERT INTO test (soru_no,soru_soru,soru_a,soru_b,soru_c,soru_d,soru_zorluk,soru_puan,soru_kategori,soru_dogrucevap) VALUES ("+
		no + ",'" + soru + "'," + "'" + a + "'," + "'" + b + "'," + "'" + c + "'," + "'" + d + "'," + "'" + zorluk + "'," + "'" + puan + "'," + "'" + kategori + "'," + "'" + dogrucevap + "')";
	
		
		
		baglanti.ekle(sql_sorgu);
		
		
	}

	@Override
	public void update() {
		
		String no,soru,a,b,c,d,zorluk,puan,kategori,dogrucevap,sql_sorgu;
		
		no = frm_soruOlusturma.txt_no.getText();
		soru = frm_soruOlusturma.txt_soru.getText();
		a = frm_soruOlusturma.txt_a.getText();
		b = frm_soruOlusturma.txt_b.getText();
		c =frm_soruOlusturma. txt_c.getText();
		d = frm_soruOlusturma.txt_d.getText();
		zorluk = frm_soruOlusturma.txt_zorluk.getText();
		puan = frm_soruOlusturma.txt_puan.getText();
		kategori =frm_soruOlusturma. txt_kategori.getText();
		dogrucevap = frm_soruOlusturma.txt_dogrucevap.getText();
		
		sql_sorgu = "UPDATE test SET soru_no="+no+","+"soru_soru='"+soru+"',soru_a='"+a+"',soru_b='"+b+"',soru_c='"+c+"',soru_d='"+d+"',soru_zorluk='"+zorluk+"',soru_puan='"+puan+"',soru_kategori='"+kategori+"',soru_dogrucevap='"+dogrucevap+"' "
				+ "                             WHERE soru_no="+no;                                                                  
		
		
		
		baglanti.update(sql_sorgu);
		
		
		
		
	}

	@Override
	public void sil() {
		
		String no,sql_sorgu;
		
		no = frm_soruOlusturma.txt_no.getText();
		
		sql_sorgu = "DELETE FROM test WHERE soru_no="+no;
		
		baglanti.sil(sql_sorgu);
		
		
		
		
	}

	@Override
	public void hazýrla() {
		
		
		frm_soruOlusturma.modelim.setRowCount(0);
		
		String zorluk = frm_soruOlusturma.txt_zorluk2.getText();
		String kategori =frm_soruOlusturma. txt_ders.getText();
		
		ResultSet myRs = null;
		
		String sql_sorgu = "select * from test where soru_zorluk='"+ zorluk +"' AND soru_kategori='"+ kategori +"'";
		
		myRs = baglanti.hazýrla(sql_sorgu);
		
		try {
			while(myRs.next()) {
				frm_soruOlusturma.satirlar[0] = myRs.getString("soru_no");
				frm_soruOlusturma.satirlar[1] = myRs.getString("soru_soru");
				frm_soruOlusturma.satirlar[2] = myRs.getString("soru_a");
				frm_soruOlusturma.satirlar[3] = myRs.getString("soru_b");
				frm_soruOlusturma.satirlar[4] = myRs.getString("soru_c");
				frm_soruOlusturma.satirlar[5] = myRs.getString("soru_d");
				frm_soruOlusturma.satirlar[6] = myRs.getString("soru_zorluk");
				frm_soruOlusturma.satirlar[7] = myRs.getString("soru_puan");
				frm_soruOlusturma.satirlar[8] = myRs.getString("soru_kategori");
				frm_soruOlusturma.satirlar[9] = myRs.getString("soru_dogrucevap");
				frm_soruOlusturma.modelim.addRow(frm_soruOlusturma.satirlar);
				
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		frm_soruOlusturma.table.setModel(frm_soruOlusturma.modelim);
		
		
	}

	@Override
	public void listele() {
		frm_soruOlusturma.modelim.setRowCount(0);
		
		ResultSet myRs = baglanti.yap();
		
		try {
			while(myRs.next()) {
				frm_soruOlusturma.satirlar[0] = myRs.getString("soru_no");
				frm_soruOlusturma.satirlar[1] = myRs.getString("soru_soru");
				frm_soruOlusturma.satirlar[2] = myRs.getString("soru_a");
				frm_soruOlusturma.satirlar[3] = myRs.getString("soru_b");
				frm_soruOlusturma.satirlar[4] = myRs.getString("soru_c");
				frm_soruOlusturma.satirlar[5] = myRs.getString("soru_d");
				frm_soruOlusturma.satirlar[6] = myRs.getString("soru_zorluk");
				frm_soruOlusturma.satirlar[7] = myRs.getString("soru_puan");
				frm_soruOlusturma.satirlar[8] = myRs.getString("soru_kategori");
				frm_soruOlusturma.satirlar[9] = myRs.getString("soru_dogrucevap");
				frm_soruOlusturma.modelim.addRow(frm_soruOlusturma.satirlar);
				
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		frm_soruOlusturma.table.setModel(frm_soruOlusturma.modelim);
		
	}

	

}
