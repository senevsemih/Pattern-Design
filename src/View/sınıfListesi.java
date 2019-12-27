package View;

import java.sql.SQLException;

public class sýnýfListesi  {

	
public static sýnýfListesi instance = null;
	
	public synchronized static sýnýfListesi getInstance()
	{
		if(instance == null)
		{
			instance = new sýnýfListesi();
		}
		return instance;
	}
	
	public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
    }
	
	public void derslikEkle() {
		
		
		
		String no,bina,salon,sýnýf,sql_sorgu;
		excel_2.getInstance();
		no = excel_2.txt_id2.getText();
		bina = excel_2.txt_bina.getText();
		salon = excel_2.txt_salon.getText();
		sýnýf = excel_2.txt_kapasite.getText();
		
		sql_sorgu = "INSERT INTO derslik (id,bina_ad,salon_no,kapasite) VALUES ("+
				no + ",'" + bina + "'," + "'" + salon + "'," + "'" + sýnýf + "')";
		
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

