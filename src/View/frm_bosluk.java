package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frm_bosluk extends JFrame {
	
public static frm_bosluk instance = null;
	
	
	
	public synchronized static frm_bosluk getInstance()
	{
		if(instance == null)
		{
			instance = new frm_bosluk();
		}
		return instance;
	}
	// Sýnýfý clone sihirli metoduyla kopyalamaya çalýþtýðýmýzda CloneNotSupportedException ile kopyalanmasýný engelliyoruz.
	 public Object clone() throws CloneNotSupportedException
	    {
	        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
	    }
	 
	
	
	private JPanel contentPane;
	public static JTable table;
	
	static DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"No","Soru","Zorluk","Puan","Kategori","Doðru Cevap"};
	static Object[] satirlar = new Object[20];
	public static JTextField txt_soru;
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
					frm_bosluk.getInstance().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_bosluk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1520, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Soru Numaras\u0131 :");
		label.setBounds(35, 32, 112, 29);
		contentPane.add(label);
		
		txt_no = new JTextField();
		txt_no.setColumns(10);
		txt_no.setBounds(133, 36, 86, 20);
		contentPane.add(txt_no);
		
		JLabel label_1 = new JLabel("Soru :");
		label_1.setBounds(76, 108, 46, 14);
		contentPane.add(label_1);
		
		txt_soru = new JTextField();
		txt_soru.setColumns(10);
		txt_soru.setBounds(115, 98, 432, 35);
		contentPane.add(txt_soru);
		
		JLabel label_2 = new JLabel("Zorluk :");
		label_2.setBounds(59, 191, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Kategori :");
		label_3.setBounds(316, 231, 61, 14);
		contentPane.add(label_3);
		
		txt_kategori = new JTextField();
		txt_kategori.setColumns(10);
		txt_kategori.setBounds(383, 228, 134, 20);
		contentPane.add(txt_kategori);
		
		JLabel label_4 = new JLabel("Puan :");
		label_4.setBounds(59, 258, 46, 14);
		contentPane.add(label_4);
		
		txt_zorluk = new JTextField();
		txt_zorluk.setColumns(10);
		txt_zorluk.setBounds(108, 188, 86, 20);
		contentPane.add(txt_zorluk);
		
		JLabel label_5 = new JLabel("Kolay - Orta - Zor");
		label_5.setBounds(105, 163, 150, 14);
		contentPane.add(label_5);
		
		txt_puan = new JTextField();
		txt_puan.setColumns(10);
		txt_puan.setBounds(108, 255, 86, 20);
		contentPane.add(txt_puan);
		
		JLabel label_6 = new JLabel("5 - 10 - 15 -20");
		label_6.setBounds(118, 231, 101, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Matematik - T\u00FCrk\u00E7e - Tarih");
		label_7.setBounds(383, 203, 184, 14);
		contentPane.add(label_7);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c_boslukDoldurma.getInstance().soruEkle();
				
		
			}
		});
		btnKaydet.setBounds(47, 520, 172, 75);
		contentPane.add(btnKaydet);
		
		JButton btnYeniSoru = new JButton("Yeni Soru");
		btnYeniSoru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_bosluk.getInstance().setVisible(true);
			
			}
		});
		btnYeniSoru.setBounds(229, 520, 150, 75);
		contentPane.add(btnYeniSoru);
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			c_boslukDoldurma.getInstance().listele();
				
			}
			
		});
		btnListele.setBounds(383, 520, 164, 75);
		contentPane.add(btnListele);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c_boslukDoldurma.getInstance().sil();
				
			}
		
		});
		btnSil.setBounds(229, 427, 150, 82);
		contentPane.add(btnSil);
		
		JButton btnDeitir = new JButton("De\u011Fi\u015Ftir");
		btnDeitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c_boslukDoldurma.getInstance().update();
			}
		});
		btnDeitir.setBounds(389, 427, 158, 82);
		contentPane.add(btnDeitir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(626, 62, 834, 447);
		contentPane.add(scrollPane);
		
		JLabel label_9 = new JLabel("Soru Haz\u0131rla : ");
		label_9.setBounds(626, 549, 158, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Ders Ad\u0131 :");
		label_10.setBounds(670, 605, 61, 14);
		contentPane.add(label_10);
		
		txt_ders = new JTextField();
		txt_ders.setColumns(10);
		txt_ders.setBounds(722, 602, 108, 20);
		contentPane.add(txt_ders);
		
		JLabel label_11 = new JLabel("Zorluk :");
		label_11.setBounds(860, 605, 67, 14);
		contentPane.add(label_11);
		
		txt_zorluk2 = new JTextField();
		txt_zorluk2.setColumns(10);
		txt_zorluk2.setBounds(910, 602, 86, 20);
		contentPane.add(txt_zorluk2);
		
		JLabel label_12 = new JLabel("Matematik - T\u00FCrk\u00E7e - Tarih");
		label_12.setBounds(707, 575, 172, 14);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Kolay - Orta - Zor");
		label_13.setBounds(904, 575, 134, 14);
		contentPane.add(label_13);
		
		JButton btnHazrla = new JButton("Haz\u0131rla");
		btnHazrla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c_boslukDoldurma.getInstance().hazýrla();
						
		
			}
		});
		btnHazrla.setBounds(1069, 585, 221, 45);
		contentPane.add(btnHazrla);
		
		JLabel lblDoruCevap = new JLabel("Do\u011Fru Cevap :");
		lblDoruCevap.setBounds(133, 338, 112, 14);
		contentPane.add(lblDoruCevap);
		
		txt_dogrucevap = new JTextField();
		txt_dogrucevap.setBounds(217, 335, 97, 20);
		contentPane.add(txt_dogrucevap);
		txt_dogrucevap.setColumns(10);
		
		JLabel lblDoruYanl = new JLabel("Do\u011Fru - Yanl\u0131\u015F");
		lblDoruYanl.setBounds(224, 304, 134, 23);
		contentPane.add(lblDoruYanl);
		
		JButton btnAnaSayfa = new JButton("Ana Sayfa");
		btnAnaSayfa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_anaSayfa.getInstance().setVisible(true);
				frm_bosluk.getInstance().hide();
			}
		});
		btnAnaSayfa.setBounds(533, 681, 150, 45);
		contentPane.add(btnAnaSayfa);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(751, 304, 408, 147);
		scrollPane.setViewportView(table);
		//contentPane.add(table);
		
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
