package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frm_sýnavHazýrla extends JFrame {
	
	
	public static frm_sýnavHazýrla instance = null;

	public synchronized static frm_sýnavHazýrla getInstance()
	{
		if(instance == null)
		{
			instance = new frm_sýnavHazýrla();
		}
		return instance;
	}
	// Sýnýfý clone sihirli metoduyla kopyalamaya çalýþtýðýmýzda CloneNotSupportedException ile kopyalanmasýný engelliyoruz.
	 public Object clone() throws CloneNotSupportedException
	    {
	        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
	    }

	private JPanel contentPane;
	private JTextField txt_soruSayisi;
	private JTable table;
	
	
static DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"No","Soru","A Þýkký","B Þýkký","C Þýkký","D Þýkký","Zorluk","Puan","Kategori","Doðru Cevap"};
	static Object[] satirlar = new Object[20];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_sýnavHazýrla.getInstance().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_sýnavHazýrla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1520, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Soru Say\u0131s\u0131 Giriniz");
		lblNewLabel.setBounds(33, 159, 134, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ders Se\u00E7imi");
		lblNewLabel_1.setBounds(68, 209, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Zorluk Seviyesi");
		lblNewLabel_2.setBounds(54, 302, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Soru Tipi");
		lblNewLabel_3.setBounds(80, 257, 58, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox cb_zorluk = new JComboBox();
		cb_zorluk.setModel(new DefaultComboBoxModel(new String[] {"Kolay", "Orta", "Zor"}));
		cb_zorluk.setBounds(152, 299, 205, 20);
		contentPane.add(cb_zorluk);
		
		JComboBox cb_ders = new JComboBox();
		cb_ders.setModel(new DefaultComboBoxModel(new String[] {"Matematik", "T\u00FCrk\u00E7e", "Tarih"}));
		cb_ders.setBounds(152, 206, 205, 20);
		contentPane.add(cb_ders);
		
		JComboBox cb_soruT = new JComboBox();
		cb_soruT.setModel(new DefaultComboBoxModel(new String[] {"Test", "Klasik", "Do\u011Fru Yanl\u0131\u015F"}));
		cb_soruT.setBounds(148, 254, 209, 20);
		contentPane.add(cb_soruT);
		
		JButton btnNewButton = new JButton("SINAVI OLU\u015ETUR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
	
				
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(152, 333, 205, 38);
		contentPane.add(btnNewButton);
		
		txt_soruSayisi = new JTextField();
		txt_soruSayisi.setBounds(152, 156, 205, 20);
		contentPane.add(txt_soruSayisi);
		txt_soruSayisi.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(457, 65, 918, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		modelim.addRow(satirlar);
		table.setModel(modelim);
		table.setBounds(626, 277, 479, 168);
		scrollPane.setViewportView(table);
		//contentPane.add(table);
	}
}
