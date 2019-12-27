package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.baglanti;
import View.frm_sýnýfL;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;

public class frm_sýnýfL extends JFrame {
	
	public static frm_sýnýfL instance = null;
	
	public synchronized static frm_sýnýfL getInstance()
	{
		if(instance == null)
		{
			instance = new frm_sýnýfL();
		}
		return instance;
	}
	// Sýnýfý clone sihirli metoduyla kopyalamaya çalýþtýðýmýzda CloneNotSupportedException ile kopyalanmasýný engelliyoruz.
	 public Object clone() throws CloneNotSupportedException
	    {
	        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
	    }
	 
	private JPanel contentPane;
	static JTextField txt_id1;
	static JTextField txt_goz1;
	static JTextField txt_id21;
	static JTextField txt_bina1;
	static JTextField txt_salon1;
	static JTextField txt_kapasite1;
	private JButton btnAktar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_sýnýfL.getInstance().setVisible(true);
					sýnýfListesi.getInstance().derslikEkle();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_sýnýfL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_id1 = new JTextField();
		txt_id1.setBounds(136, 54, 86, 20);
		contentPane.add(txt_id1);
		txt_id1.setColumns(10);
		
		txt_goz1 = new JTextField();
		txt_goz1.setBounds(136, 95, 86, 20);
		contentPane.add(txt_goz1);
		txt_goz1.setColumns(10);
		
		btnAktar = new JButton("KAYDET");
		btnAktar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//sýnýfListesi.getInstance().derslikEkle();
				//JOptionPane.showMessageDialog(null,"Eklendi");
				
			}
		
		
		});
		
		JButton btnKaydet = new JButton("KAYDET");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//	sýnýfListesi.getInstance().gozetmenkEkle();
				
					
			
		//	JOptionPane.showMessageDialog(null,"Eklendi");
				
			}
			
			
		});
		btnKaydet.setBounds(96, 136, 89, 23);
		contentPane.add(btnKaydet);
		
		txt_id1 = new JTextField();
		txt_id1.setBounds(136, 260, 86, 20);
		contentPane.add(txt_id1);
		txt_id21.setColumns(10);
		
		txt_bina1 = new JTextField();
		txt_bina1.setBounds(136, 306, 86, 20);
		contentPane.add(txt_bina1);
		txt_bina1.setColumns(10);
		
		txt_salon1 = new JTextField();
		txt_salon1.setBounds(136, 349, 86, 20);
		contentPane.add(txt_salon1);
		txt_salon1.setColumns(10);
		
		txt_kapasite1 = new JTextField();
		txt_kapasite1.setBounds(136, 391, 86, 20);
		contentPane.add(txt_kapasite1);
		txt_kapasite1.setColumns(10);
		
		btnAktar.setBounds(96, 449, 89, 23);
		contentPane.add(btnAktar);
		
		JLabel lblGztmenGiriniz = new JLabel("G\u00F6zetmen Giriniz : ");
		lblGztmenGiriniz.setBounds(36, 98, 90, 14);
		contentPane.add(lblGztmenGiriniz);
		
		JLabel lblNo = new JLabel("No : ");
		lblNo.setBounds(36, 57, 46, 14);
		contentPane.add(lblNo);
		
		JLabel lblNo_1 = new JLabel("No : ");
		lblNo_1.setBounds(36, 263, 46, 14);
		contentPane.add(lblNo_1);
		
		JLabel lblBinaAd = new JLabel("Bina Ad\u0131 : ");
		lblBinaAd.setBounds(36, 309, 75, 14);
		contentPane.add(lblBinaAd);
		
		JLabel lblSalonNo = new JLabel("Salon No : ");
		lblSalonNo.setBounds(36, 352, 75, 14);
		contentPane.add(lblSalonNo);
		
		JLabel lblSnfKapasite = new JLabel("S\u0131n\u0131f Kapasite : ");
		lblSnfKapasite.setBounds(36, 394, 90, 14);
		contentPane.add(lblSnfKapasite);
		
		table = new JTable();
		table.setBounds(309, 33, 553, 415);
		contentPane.add(table);
		
		JButton btnSnfListesi = new JButton("S\u0131n\u0131f Listesi olu\u015Ftur");
		btnSnfListesi.setBounds(309, 517, 122, 23);
		contentPane.add(btnSnfListesi);
		
		JButton btnPdfOlutur = new JButton("PDF olu\u015Ftur ");
		btnPdfOlutur.setBounds(447, 517, 145, 23);
		contentPane.add(btnPdfOlutur);
		
		JButton btnYoklamaOlutur = new JButton("Yoklama olu\u015Ftur");
		btnYoklamaOlutur.setBounds(727, 517, 122, 23);
		contentPane.add(btnYoklamaOlutur);
	}
}
