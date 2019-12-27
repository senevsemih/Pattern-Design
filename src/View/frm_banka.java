package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_banka extends JFrame {
	
public static frm_banka instance = null;
	
	
	
	public synchronized static frm_banka getInstance()
	{
		if(instance == null)
		{
			instance = new frm_banka();
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
					frm_banka.getInstance().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_banka() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1520, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnoktanSemeli = new JButton("\u00C7oktan Se\u00E7meli");
		btnoktanSemeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_banka.getInstance().hide();
				frm_soruOlusturma.getInstance().setVisible(true);
				
				
			}
		});
		btnoktanSemeli.setBounds(46, 281, 393, 304);
		contentPane.add(btnoktanSemeli);
		
		JButton btnKlasik = new JButton("Klasik");
		btnKlasik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_banka.getInstance().hide();
				frm_klasik.getInstance().setVisible(true);
				
			}
		});
		btnKlasik.setBounds(460, 281, 393, 304);
		contentPane.add(btnKlasik);
		
		JButton btnDoruYanl = new JButton("Do\u011Fru Yanl\u0131\u015F");
		btnDoruYanl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_banka.getInstance().hide();
				frm_bosluk.getInstance().setVisible(true);
			}
		});
		btnDoruYanl.setBounds(889, 281, 514, 304);
		contentPane.add(btnDoruYanl);
	}

}
