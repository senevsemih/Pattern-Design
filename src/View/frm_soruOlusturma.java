package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.frm_soruOlusturma;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frm_soruOlusturma extends JFrame {
	
	public static frm_soruOlusturma instance = null;
	
	
	
	public synchronized static frm_soruOlusturma getInstance()
	{
		if(instance == null)
		{
			instance = new frm_soruOlusturma();
		}
		return instance;
	}
	// Sýnýfý clone sihirli metoduyla kopyalamaya çalýþtýðýmýzda CloneNotSupportedException ile kopyalanmasýný engelliyoruz.
	 public Object clone() throws CloneNotSupportedException
	    {
	        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
	    }
	 
	 
	private JPanel contentPane;
	static JTable table;
	
	static DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"No","Soru","A Þýkký","B Þýkký","C Þýkký","D Þýkký","Zorluk","Puan","Kategori","Doðru Cevap"};
	static Object[] satirlar = new Object[20];
	public static JTextField txt_soru;
	public static JTextField txt_a;
	public static JTextField txt_b;
	public static JTextField txt_c;
	public static JTextField txt_d;
	public static JTextField txt_zorluk;
	public static JTextField txt_puan;
	public static JTextField txt_kategori;
	public static JTextField txt_dogrucevap;
	public static JTextField txt_no;
	public static JScrollPane scrollPane;
	public static JTextField txt_ders;
	public static JTextField txt_zorluk2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frm_soruOlusturma.getInstance().setVisible(true);
					c_coktanSecmeli.getInstance().listele();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private frm_soruOlusturma() {
		
		
	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1520, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 23, 966, 545);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(560, 203, 356, 206);
		scrollPane.setViewportView(table);
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				c_coktanSecmeli.getInstance().listele();
				
			}
		});
		btnListele.setBounds(356, 537, 150, 68);
		contentPane.add(btnListele);
		
		txt_soru = new JTextField();
		txt_soru.setBounds(96, 89, 308, 35);
		contentPane.add(txt_soru);
		txt_soru.setColumns(10);
		
		txt_a = new JTextField();
		txt_a.setBounds(95, 140, 208, 23);
		contentPane.add(txt_a);
		txt_a.setColumns(10);
		
		txt_b = new JTextField();
		txt_b.setColumns(10);
		txt_b.setBounds(96, 174, 208, 23);
		contentPane.add(txt_b);
		
		txt_c = new JTextField();
		txt_c.setColumns(10);
		txt_c.setBounds(95, 208, 208, 23);
		contentPane.add(txt_c);
		
		txt_d = new JTextField();
		txt_d.setColumns(10);
		txt_d.setBounds(96, 245, 208, 23);
		contentPane.add(txt_d);
		
		txt_zorluk = new JTextField();
		txt_zorluk.setBounds(64, 338, 86, 20);
		contentPane.add(txt_zorluk);
		txt_zorluk.setColumns(10);
		
		txt_puan = new JTextField();
		txt_puan.setColumns(10);
		txt_puan.setBounds(64, 426, 86, 20);
		contentPane.add(txt_puan);
		
		txt_kategori = new JTextField();
		txt_kategori.setColumns(10);
		txt_kategori.setBounds(318, 380, 86, 20);
		contentPane.add(txt_kategori);
		
		txt_dogrucevap = new JTextField();
		txt_dogrucevap.setColumns(10);
		txt_dogrucevap.setBounds(96, 499, 86, 20);
		contentPane.add(txt_dogrucevap);
		
		JLabel lblA = new JLabel("A :");
		lblA.setBounds(64, 140, 54, 23);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B :");
		lblB.setBounds(64, 174, 54, 23);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C :");
		lblC.setBounds(64, 210, 54, 18);
		contentPane.add(lblC);
		
		JLabel lblD = new JLabel("D :");
		lblD.setBounds(64, 245, 54, 23);
		contentPane.add(lblD);
		
		JLabel lblSoru = new JLabel("Soru :");
		lblSoru.setBounds(20, 94, 74, 25);
		contentPane.add(lblSoru);
		
		JLabel lblZorluk = new JLabel("Zorluk :");
		lblZorluk.setBounds(20, 338, 100, 20);
		contentPane.add(lblZorluk);
		
		JLabel lblPuan = new JLabel("Puan :");
		lblPuan.setBounds(20, 425, 54, 23);
		contentPane.add(lblPuan);
		
		JLabel lblKategori = new JLabel("Kategori :");
		lblKategori.setBounds(257, 373, 74, 34);
		contentPane.add(lblKategori);
		
		JLabel lblDoruCevap = new JLabel("Do\u011Fru Cevap :");
		lblDoruCevap.setBounds(20, 484, 100, 51);
		contentPane.add(lblDoruCevap);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				c_coktanSecmeli.getInstance().soruEkle();

			}
		});
		btnKaydet.setBounds(40, 539, 140, 64);
		contentPane.add(btnKaydet);
		
		txt_no = new JTextField();
		txt_no.setBounds(96, 52, 86, 20);
		contentPane.add(txt_no);
		txt_no.setColumns(10);
		
		JLabel lblSoruNumaras = new JLabel("Soru Numaras\u0131 :");
		lblSoruNumaras.setBounds(10, 45, 94, 35);
		contentPane.add(lblSoruNumaras);
		
		JButton btnYeniSoru = new JButton("Yeni Soru");
		btnYeniSoru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_soruOlusturma.getInstance().setVisible(true);
				
			}
		});
		btnYeniSoru.setBounds(190, 537, 156, 66);
		contentPane.add(btnYeniSoru);
		
		JLabel lblKolayOrta = new JLabel("Kolay - Orta - Zor");
		lblKolayOrta.setBounds(64, 304, 162, 35);
		contentPane.add(lblKolayOrta);
		
		JLabel label = new JLabel("5 - 10 - 15 - 20 ");
		label.setBounds(64, 380, 140, 49);
		contentPane.add(label);
		
		JLabel lblMatematikTrke = new JLabel("Matematik - T\u00FCrk\u00E7e - Tarih");
		lblMatematikTrke.setBounds(300, 338, 200, 42);
		contentPane.add(lblMatematikTrke);
		
		JButton btnDegistir = new JButton("De\u011Fi\u015Ftir");
		btnDegistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				c_coktanSecmeli.getInstance().update();
				
			}
		});
		btnDegistir.setBounds(356, 449, 150, 77);
		contentPane.add(btnDegistir);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				c_coktanSecmeli.getInstance().sil();

			}
			
		});
		btnSil.setBounds(192, 449, 154, 70);
		contentPane.add(btnSil);
		
		JLabel lblSnavHazrla = new JLabel("S\u0131nav Haz\u0131rla");
		lblSnavHazrla.setBounds(560, 579, 120, 51);
		contentPane.add(lblSnavHazrla);
		
		JLabel lblDersAd = new JLabel("Ders Ad\u0131 :");
		lblDersAd.setBounds(656, 627, 86, 35);
		contentPane.add(lblDersAd);
		
		txt_ders = new JTextField();
		txt_ders.setBounds(719, 630, 130, 28);
		contentPane.add(txt_ders);
		txt_ders.setColumns(10);
		
		JLabel lblMatematikTrke_1 = new JLabel("Matematik - T\u00FCrk\u00E7e - Tarih");
		lblMatematikTrke_1.setBounds(709, 597, 184, 33);
		contentPane.add(lblMatematikTrke_1);
		
		JLabel lblZorluk_1 = new JLabel("Zorluk :");
		lblZorluk_1.setBounds(878, 619, 169, 51);
		contentPane.add(lblZorluk_1);
		
		txt_zorluk2 = new JTextField();
		txt_zorluk2.setBounds(938, 627, 120, 35);
		contentPane.add(txt_zorluk2);
		txt_zorluk2.setColumns(10);
		
		JLabel lblKolayOrta_1 = new JLabel("Kolay - Orta - Zor");
		lblKolayOrta_1.setBounds(949, 588, 220, 33);
		contentPane.add(lblKolayOrta_1);
		
		JButton btnHazrla = new JButton("Haz\u0131rla");
		btnHazrla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				c_coktanSecmeli.getInstance().hazýrla();

			}
		});
		btnHazrla.setBounds(1175, 626, 169, 37);
		contentPane.add(btnHazrla);
		
		JButton btnAnaSayfa = new JButton("Ana Sayfa");
		btnAnaSayfa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_anaSayfa.getInstance().setVisible(true);
				frm_soruOlusturma.getInstance().hide();
			}
		});
		btnAnaSayfa.setBounds(443, 688, 220, 38);
		contentPane.add(btnAnaSayfa);
		//contentPane.add(table);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txt_no.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
				txt_soru.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				txt_a.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				txt_b.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				txt_c.setText((String) modelim.getValueAt(table.getSelectedRow(),4));
				txt_d.setText((String) modelim.getValueAt(table.getSelectedRow(),5));
				txt_zorluk.setText((String) modelim.getValueAt(table.getSelectedRow(),6));
				txt_puan.setText((String) modelim.getValueAt(table.getSelectedRow(),7));
				txt_kategori.setText((String) modelim.getValueAt(table.getSelectedRow(),8));
				txt_dogrucevap.setText((String) modelim.getValueAt(table.getSelectedRow(),9));
				
			}
		});
	}
}
