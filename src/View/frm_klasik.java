package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frm_klasik extends JFrame {
	
	public static frm_klasik instance = null;
	
	
	
	public synchronized static frm_klasik getInstance()
	{
		if(instance == null)
		{
			instance = new frm_klasik();
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
	
	Object[] kolonlar = {"No","Soru","Zorluk","Puan","Kategori","Doðru Cevap"};
	static Object[] satirlar = new Object[10];
	public static JTextField txt_no;
	public static JTextField txt_soru;
	public static JTextField txt_kategori;
	public static JTextField txt_zorluk;
	public static JTextField txt_puan;
	public static JTextField txt_dogrucevap;
	public static JTextField txt_ders;
	public static JTextField txt_zorluk2;
	public static JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frm_klasik.getInstance().setVisible(true);
					c_klasik.getInstance().listele();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_klasik() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1520, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(642, 35, 695, 469);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(642, 330, 290, 123);
		scrollPane.setViewportView(table);
		
		JLabel lblSoruNumaras = new JLabel("Soru Numaras\u0131 :");
		lblSoruNumaras.setBounds(22, 60, 112, 29);
		contentPane.add(lblSoruNumaras);
		
		txt_no = new JTextField();
		txt_no.setBounds(120, 64, 86, 20);
		contentPane.add(txt_no);
		txt_no.setColumns(10);
		
		JLabel lblSoru = new JLabel("Soru :");
		lblSoru.setBounds(63, 136, 46, 14);
		contentPane.add(lblSoru);
		
		txt_soru = new JTextField();
		txt_soru.setBounds(102, 126, 432, 35);
		contentPane.add(txt_soru);
		txt_soru.setColumns(10);
		
		JLabel lblZorluk = new JLabel("Zorluk :");
		lblZorluk.setBounds(46, 219, 46, 14);
		contentPane.add(lblZorluk);
		
		JLabel lblKategori = new JLabel("Kategori :");
		lblKategori.setBounds(303, 259, 61, 14);
		contentPane.add(lblKategori);
		
		txt_kategori = new JTextField();
		txt_kategori.setBounds(370, 256, 134, 20);
		contentPane.add(txt_kategori);
		txt_kategori.setColumns(10);
		
		JLabel lblPuan = new JLabel("Puan :");
		lblPuan.setBounds(46, 286, 46, 14);
		contentPane.add(lblPuan);
		
		txt_zorluk = new JTextField();
		txt_zorluk.setBounds(95, 216, 86, 20);
		contentPane.add(txt_zorluk);
		txt_zorluk.setColumns(10);
		
		JLabel lblKolayOrta = new JLabel("Kolay - Orta - Zor");
		lblKolayOrta.setBounds(92, 191, 150, 14);
		contentPane.add(lblKolayOrta);
		
		txt_puan = new JTextField();
		txt_puan.setBounds(95, 283, 86, 20);
		contentPane.add(txt_puan);
		txt_puan.setColumns(10);
		
		JLabel label = new JLabel("5 - 10 - 15 -20");
		label.setBounds(105, 259, 101, 14);
		contentPane.add(label);
		
		JLabel lblMatematikTrke = new JLabel("Matematik - T\u00FCrk\u00E7e - Tarih");
		lblMatematikTrke.setBounds(370, 231, 184, 14);
		contentPane.add(lblMatematikTrke);
		
		JLabel lblDoruCevap = new JLabel("Do\u011Fru Cevap :");
		lblDoruCevap.setBounds(34, 343, 135, 14);
		contentPane.add(lblDoruCevap);
		
		txt_dogrucevap = new JTextField();
		txt_dogrucevap.setBounds(120, 330, 414, 40);
		contentPane.add(txt_dogrucevap);
		txt_dogrucevap.setColumns(10);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_klasik.getInstance().soruEkle();
				
			}
		});
		btnKaydet.setBounds(34, 548, 172, 75);
		contentPane.add(btnKaydet);
		
		JButton btnYeniSoru = new JButton("Yeni Soru");
		btnYeniSoru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_klasik.getInstance().setVisible(true);
			}
		});
		btnYeniSoru.setBounds(216, 548, 150, 75);
		contentPane.add(btnYeniSoru);
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c_klasik.getInstance().listele();
				
			}
		});
		btnListele.setBounds(370, 548, 164, 75);
		contentPane.add(btnListele);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			c_klasik.getInstance().sil();
				
			
			}
		});
		btnSil.setBounds(216, 455, 150, 82);
		contentPane.add(btnSil);
		
		JButton btnDeitir = new JButton("De\u011Fi\u015Ftir");
		btnDeitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			c_klasik.getInstance().update();
					
			}
		});
		btnDeitir.setBounds(376, 455, 158, 82);
		contentPane.add(btnDeitir);
		
		JLabel lblSoruHazrla = new JLabel("Soru Haz\u0131rla : ");
		lblSoruHazrla.setBounds(642, 522, 158, 14);
		contentPane.add(lblSoruHazrla);
		
		JLabel lblDersAd = new JLabel("Ders Ad\u0131 :");
		lblDersAd.setBounds(686, 578, 61, 14);
		contentPane.add(lblDersAd);
		
		txt_ders = new JTextField();
		txt_ders.setBounds(738, 575, 108, 20);
		contentPane.add(txt_ders);
		txt_ders.setColumns(10);
		
		JLabel lblZorluk_1 = new JLabel("Zorluk :");
		lblZorluk_1.setBounds(876, 578, 67, 14);
		contentPane.add(lblZorluk_1);
		
		txt_zorluk2 = new JTextField();
		txt_zorluk2.setBounds(926, 575, 86, 20);
		contentPane.add(txt_zorluk2);
		txt_zorluk2.setColumns(10);
		
		JLabel lblMatematikTrke_1 = new JLabel("Matematik - T\u00FCrk\u00E7e - Tarih");
		lblMatematikTrke_1.setBounds(723, 548, 172, 14);
		contentPane.add(lblMatematikTrke_1);
		
		JLabel lblKolayOrta_1 = new JLabel("Kolay - Orta - Zor");
		lblKolayOrta_1.setBounds(920, 548, 134, 14);
		contentPane.add(lblKolayOrta_1);
		
		JButton btnHazrla = new JButton("Haz\u0131rla");
		btnHazrla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			c_klasik.getInstance().hazýrla();
			}
		});
		btnHazrla.setBounds(1085, 558, 221, 45);
		contentPane.add(btnHazrla);
		
		JButton btnAnaSayfa = new JButton("Ana Sayfa");
		btnAnaSayfa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_anaSayfa.getInstance().setVisible(true);
				frm_klasik.getInstance().hide();
			}
		});
		btnAnaSayfa.setBounds(576, 674, 134, 52);
		contentPane.add(btnAnaSayfa);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txt_no.setText((String) modelim.getValueAt(table.getSelectedRow(),0));
				txt_soru.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				txt_zorluk.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				txt_puan.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				txt_kategori.setText((String) modelim.getValueAt(table.getSelectedRow(),4));
				txt_dogrucevap.setText((String) modelim.getValueAt(table.getSelectedRow(),5));
				
			}
		});
	}
}
