package Presenter;

import Model.giris;
import View.frm_anaSayfa;
import View.frm_login;
import View.�_view;

public class girisP {
	�_view view;
	
	String log;

	public girisP(�_view view) {
		this.view = view;
	}
	
	public void checkUser(String kullan�c�, String no){
		
		giris k = new giris();
	
		
		if(k.getKullan�c�().equals(kullan�c�) && k.getNo() == Integer.parseInt(no)){
			view.showMessageBox("Ba�ar�l� giri�");
			
		}else
			view.showMessageBox("Kullan�c� ad� veya �ifre yanl��!");
	
		
		
	}
	
	
	
}