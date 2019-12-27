package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm_anaSayfa extends JFrame{

	
public static frm_anaSayfa instance = null;
	
	
	
	public synchronized static frm_anaSayfa getInstance()
	{
		if(instance == null)
		{
			instance = new frm_anaSayfa();
		}
		return instance;
	}
	// Sýnýfý clone sihirli metoduyla kopyalamaya çalýþtýðýmýzda CloneNotSupportedException ile kopyalanmasýný engelliyoruz.
	 public Object clone() throws CloneNotSupportedException
	    {
	        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
	    }
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_anaSayfa.getInstance().setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_anaSayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1520, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSoruOlutur = new JButton("Soru Olu\u015Ftur");
		btnSoruOlutur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frm_anaSayfa.getInstance().hide();
				frm_banka.getInstance().setVisible(true);
			}
		});
		btnSoruOlutur.setBounds(60, 302, 341, 225);
		contentPane.add(btnSoruOlutur);
		
		JButton btnSnavHazrla = new JButton("S\u0131nav Haz\u0131rla");
		btnSnavHazrla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_anaSayfa.getInstance().hide();
				frm_sýnavHazýrla.getInstance().setVisible(true);
			}
		});
		btnSnavHazrla.setBounds(472, 302, 377, 225);
		contentPane.add(btnSnavHazrla);
		
		JButton btnSnfListesi = new JButton("S\u0131n\u0131f Listesi");
		btnSnfListesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frm_anaSayfa.getInstance().hide();
				frm_sýnýfL.getInstance().setVisible(true);
			}
		});
		btnSnfListesi.setBounds(907, 302, 433, 225);
		contentPane.add(btnSnfListesi);
		
	}
}
