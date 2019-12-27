package View;

import java.sql.ResultSet;
import java.sql.SQLException;

public class c_boslukDoldurma implements Soru{
	
public static c_boslukDoldurma instance = null;
	
	public synchronized static c_boslukDoldurma getInstance()
	{
		if(instance == null)
		{
			instance = new c_boslukDoldurma();
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
		frm_bosluk.getInstance();
		String no,soru,zorluk,puan,kategori,dogrucevap,sql_sorgu;
		
		no = frm_bosluk.txt_no.getText();
		soru = frm_bosluk.txt_soru.getText();
		zorluk = frm_bosluk.txt_zorluk.getText();
		puan = frm_bosluk.txt_puan.getText();
		kategori = frm_bosluk.txt_kategori.getText();
		dogrucevap = frm_bosluk.txt_dogrucevap.getText();
		
		sql_sorgu = "INSERT INTO bosluk (b_no,b_soru,b_zorluk,b_puan,b_kategori,b_dogrucevap) VALUES ("+
		no + ",'" + soru + "'," + "'"+ zorluk + "'," + "'" + puan + "'," + "'" + kategori + "'," + "'" + dogrucevap + "')";
	
		System.out.println(sql_sorgu);
		
		baglanti.ekle(sql_sorgu);
		
		
	}

	@Override
	public void update() {
		String no,soru,zorluk,puan,kategori,dogrucevap,sql_sorgu;
		
		no = frm_bosluk.txt_no.getText();
		soru = frm_bosluk.txt_soru.getText();
		zorluk = frm_bosluk.txt_zorluk.getText();
		puan = frm_bosluk.txt_puan.getText();
		kategori =frm_bosluk. txt_kategori.getText();
		dogrucevap =frm_bosluk. txt_dogrucevap.getText();
		
		sql_sorgu = "UPDATE bosluk SET b_no="+no+","+"b_soru='"+soru+"',b_zorluk='"+zorluk+"',b_puan='"+puan+"',b_kategori='"+kategori+"',b_dogrucevap='"+dogrucevap+"' "
				+ "                             WHERE b_no="+no;                                                                  
		
	
		
		baglanti.update(sql_sorgu);
	}

	@Override
	public void sil() {
		String no,sql_sorgu;
		
		no = frm_bosluk.txt_no.getText();
		
		sql_sorgu = "DELETE FROM bosluk WHERE b_no="+no;
		
		baglanti.sil(sql_sorgu);
		
	}

	@Override
	public void hazýrla() {
		frm_bosluk.modelim.setRowCount(0);
		
		String zorluk = frm_bosluk.txt_zorluk2.getText();
		String kategori =frm_bosluk. txt_ders.getText();
		
		ResultSet myRs = null;
		
		String sql_sorgu = "select * from bosluk where b_zorluk='"+ zorluk +"' AND b_kategori='"+ kategori +"'";
		
		myRs = baglanti.hazýrla(sql_sorgu);
		
		try {
			while(myRs.next()) {
				frm_bosluk.satirlar[0] = myRs.getString("b_no");
				frm_bosluk.satirlar[1] = myRs.getString("b_soru");
				frm_bosluk.satirlar[2] = myRs.getString("b_zorluk");
				frm_bosluk.satirlar[3] = myRs.getString("b_puan");
				frm_bosluk.satirlar[4] = myRs.getString("b_kategori");
				frm_bosluk.satirlar[5] = myRs.getString("b_dogrucevap");
				frm_bosluk.modelim.addRow(frm_bosluk.satirlar);
				
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		frm_bosluk.table.setModel(frm_bosluk.modelim);
	}

	@Override
	public void listele() {
		frm_bosluk.modelim.setRowCount(0);
		
		ResultSet myRs = baglanti.yap();
		
		try {
			while(myRs.next()) {
				frm_bosluk.satirlar[0] = myRs.getString("b_no");
				frm_bosluk.satirlar[1] = myRs.getString("b_soru");
				frm_bosluk.satirlar[2] = myRs.getString("b_zorluk");
				frm_bosluk.satirlar[3] = myRs.getString("b_puan");
				frm_bosluk.satirlar[4] = myRs.getString("b_kategori");
				frm_bosluk.satirlar[5] = myRs.getString("b_dogrucevap");
				frm_bosluk.modelim.addRow(frm_bosluk.satirlar);
				
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		frm_bosluk.table.setModel(frm_bosluk.modelim);
		
	}
	

}
