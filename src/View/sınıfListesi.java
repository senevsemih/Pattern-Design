package View;

import java.sql.SQLException;

public class s�n�fListesi  {

	
public static s�n�fListesi instance = null;
	
	public synchronized static s�n�fListesi getInstance()
	{
		if(instance == null)
		{
			instance = new s�n�fListesi();
		}
		return instance;
	}
	
	public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("Ben e�siz bir par�ay�m");
    }
	
	public void derslikEkle() {
		
		
		
		String no,bina,salon,s�n�f,sql_sorgu;
		excel_2.getInstance();
		no = excel_2.txt_id2.getText();
		bina = excel_2.txt_bina.getText();
		salon = excel_2.txt_salon.getText();
		s�n�f = excel_2.txt_kapasite.getText();
		
		sql_sorgu = "INSERT INTO derslik (id,bina_ad,salon_no,kapasite) VALUES ("+
				no + ",'" + bina + "'," + "'" + salon + "'," + "'" + s�n�f + "')";
		
		try {
			baglanti_2.aktar(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}
	
	public void gozetmenkEkle() {
		

		String id,ad,sql_sorgu;
		excel_2.getInstance();
		id = excel_2.txt_id.getText();
		ad = excel_2.txt_goz.getText();
		
		sql_sorgu = "INSERT INTO gozetmen (id,ad) VALUES ("+ id + ",'" + ad + "')";
		try {
			baglanti_2.aktar(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

