package Presenter;

import Model.giris;
import View.frm_anaSayfa;
import View.frm_login;
import View.ý_view;

public class girisP {
	ý_view view;
	
	String log;

	public girisP(ý_view view) {
		this.view = view;
	}
	
	public void checkUser(String kullanýcý, String no){
		
		giris k = new giris();
	
		
		if(k.getKullanýcý().equals(kullanýcý) && k.getNo() == Integer.parseInt(no)){
			view.showMessageBox("Baþarýlý giriþ");
			
		}else
			view.showMessageBox("Kullanýcý adý veya þifre yanlýþ!");
	
		
		
	}
	
	
	
}