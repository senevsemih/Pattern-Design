package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Presenter.girisP;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_login extends JFrame implements ý_view{
	
	public static frm_login instance = null;
	
	
	
	public synchronized static frm_login getInstance()
	{
		if(instance == null)
		{
			instance = new frm_login();
		}
		return instance;
	}
	// Sýnýfý clone sihirli metoduyla kopyalamaya çalýþtýðýmýzda CloneNotSupportedException ile kopyalanmasýný engelliyoruz.
	 public Object clone() throws CloneNotSupportedException
	    {
	        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
	    }

	private JPanel contentPane;
	private JTextField txt_ka;
	private JTextField txt_sifre;
	
	private girisP Presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_login.getInstance().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGiri = new JButton("Giri\u015F");
		btnGiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Presenter.checkUser(txt_ka.getText(),txt_sifre.getText());
				frm_login.getInstance().hide();
				frm_anaSayfa.getInstance().setVisible(true);
			
			}
		});
		btnGiri.setBounds(157, 164, 135, 49);
		contentPane.add(btnGiri);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullancAd.setBounds(100, 68, 91, 22);
		contentPane.add(lblKullancAd);
		
		txt_ka = new JTextField();
		txt_ka.setBounds(190, 69, 86, 20);
		contentPane.add(txt_ka);
		txt_ka.setColumns(10);
		
		JLabel lblifre = new JLabel("\u015Eifre :");
		lblifre.setBounds(114, 124, 77, 14);
		contentPane.add(lblifre);
		
		txt_sifre = new JTextField();
		txt_sifre.setBounds(190, 121, 86, 20);
		contentPane.add(txt_sifre);
		txt_sifre.setColumns(10);
		
		Presenter = new girisP(this);
	}

	@Override
	public void showMessageBox(String message) {
		
		JOptionPane.showMessageDialog(null, message);
	}

}
