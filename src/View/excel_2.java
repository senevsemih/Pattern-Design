package View;

import java.awt.*; 
import java.awt.event.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.*; 
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.awt.print.*;
import java.sql.*;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Statement;

import jxl.Cell; 
import jxl.Sheet; 
import jxl.Workbook; 
import jxl.read.biff.BiffException;


public class excel_2 extends JFrame {
	
public static sýnýfListesi instance = null;
	
	public synchronized static sýnýfListesi getInstance()
	{
		if(instance == null)
		{
			instance = new sýnýfListesi();
		}
		return instance;
	}
	
	public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("Ben eþsiz bir parçayým");
    }
	
	 Connection con;
	 java.sql.Statement st;
	 ResultSet rs;
	
	static JTable table;
	static JScrollPane tblEmployee;
	static Vector headers = new Vector();
	static DefaultTableModel model;
	static Vector data = new Vector();
	static JButton jbClick;
	static JFileChooser jChooser;
	static int tableWidth = 0;
	static int tableHeight = 0;
	static JTextField txt_id;
	static JTextField txt_goz;
	static JTextField txt_id2;
	static JTextField txt_bina;
	static JTextField txt_salon;
	static JTextField txt_kapasite;
	JComboBox comboBox2 = new JComboBox();
	JComboBox comboBox3 = new JComboBox();
	
	public excel_2() {
		super("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(346, 33, 424, 33);
		buttonPanel.setBackground(Color.white);
		jChooser = new JFileChooser();
		jbClick = new JButton("SINIF L\u0130STES\u0130");
		buttonPanel.add(jbClick, BorderLayout.CENTER);
		
		super.setLocationRelativeTo(null);
		
		jbClick.addActionListener(new ActionListener() {
		
			@Override
			   public void actionPerformed(ActionEvent arg0) {
			    jChooser.showOpenDialog(null);
			    
			    File file = jChooser.getSelectedFile();
			    if(!file.getName().endsWith("xls")){ 
			    	JOptionPane.showMessageDialog(null, "Please select only Excel file.", "Error",JOptionPane.ERROR_MESSAGE); 
			    }
			    else 
			    { 
			    	fillData(file);
			    	model = new DefaultTableModel(data, headers);
			    	tableWidth = model.getColumnCount() * 100; 
			    	tableHeight = model.getRowCount() * 25; 
			    	table.setPreferredSize(new Dimension( tableWidth, tableHeight)); 
			    	table.setModel(model); }
			    }
			});

		table = new JTable();
		table.setAutoCreateRowSorter(true); 
		model = new DefaultTableModel(data, headers);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		)); 
		table.setBackground(Color.white);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		table.setRowHeight(25); 
		table.setRowMargin(4);

		tableWidth = model.getColumnCount() * 150;
		tableHeight = model.getRowCount() * 25;
		table.setPreferredSize(new Dimension( tableWidth, tableHeight));
		
		tblEmployee = new JScrollPane(table);
		tblEmployee.setBounds(346, 77, 424, 567);
		tblEmployee.setBackground(Color.white);
		tblEmployee.setPreferredSize(new Dimension(300, 300));
		tblEmployee.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tblEmployee.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().setLayout(null);
		getContentPane().add(buttonPanel);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				MessageFormat header = new MessageFormat("TASARIM DESENLERÝ FÝNAL SINAVI");			
				MessageFormat footer = new MessageFormat("Page{0,number,integer}");
				
				try {
					table.print(JTable.PrintMode.NORMAL,header,footer);
				
				}
					catch (java.awt.print.PrinterException e)
				       {
				           System.err.format("Cannot print %s %n",e.getMessage());
				       }
				
				
			}
		});
		buttonPanel.add(btnPdf);
		getContentPane().add(tblEmployee);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(163, 163, 86, 20);
		getContentPane().add(txt_id);
		
		txt_goz = new JTextField();
		txt_goz.setColumns(10);
		txt_goz.setBounds(163, 204, 86, 20);
		getContentPane().add(txt_goz);
		
		JButton button = new JButton("KAYDET");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sýnýfListesi.getInstance().gozetmenkEkle();
				
				JOptionPane.showMessageDialog(null,"Eklendi");
				Test();
			
			}
			
		});
		
		
		button.setBounds(123, 245, 89, 23);
		getContentPane().add(button);
		
		txt_id2 = new JTextField();
		txt_id2.setColumns(10);
		txt_id2.setBounds(163, 369, 86, 20);
		getContentPane().add(txt_id2);
		
		txt_bina = new JTextField();
		txt_bina.setColumns(10);
		txt_bina.setBounds(163, 415, 86, 20);
		getContentPane().add(txt_bina);
		setSize(1407, 727); setResizable(true);
		setVisible(true);

		txt_salon = new JTextField();
		txt_salon.setColumns(10);
		txt_salon.setBounds(163, 458, 86, 20);
		getContentPane().add(txt_salon);
		
		txt_kapasite = new JTextField();
		txt_kapasite.setColumns(10);
		txt_kapasite.setBounds(163, 500, 86, 20);
		getContentPane().add(txt_kapasite);
		
		JButton button_1 = new JButton("KAYDET");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sýnýfListesi.getInstance().derslikEkle();
				JOptionPane.showMessageDialog(null,"Eklendi");
				Tes2();
				
			}
		});
		button_1.setBounds(123, 558, 89, 23);
		getContentPane().add(button_1);
		
		JLabel label = new JLabel("G\u00F6zetmen Giriniz : ");
		label.setBounds(63, 207, 90, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("No : ");
		label_1.setBounds(63, 166, 46, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("No : ");
		label_2.setBounds(63, 372, 46, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Bina Ad\u0131 : ");
		label_3.setBounds(63, 418, 75, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Salon No : ");
		label_4.setBounds(63, 461, 75, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("S\u0131n\u0131f Kapasite : ");
		label_5.setBounds(63, 503, 90, 14);
		getContentPane().add(label_5);
		
		
		comboBox2.setBounds(996, 103, 180, 20);
		getContentPane().add(comboBox2);
		
		JLabel lblGzetmenSeiniz = new JLabel("G\u00F6zetmen Se\u00E7iniz : ");
		lblGzetmenSeiniz.setBounds(841, 106, 155, 14);
		getContentPane().add(lblGzetmenSeiniz);
		
		JLabel lblDerslikSeiniz = new JLabel("Derslik Se\u00E7iniz : ");
		lblDerslikSeiniz.setBounds(841, 183, 155, 14);
		getContentPane().add(lblDerslikSeiniz);
		
		comboBox3.setBounds(996, 180, 180, 20);
		getContentPane().add(comboBox3);
	
	}
	
	public void Test()
    {

    try{
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banka2?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
      st = con.createStatement();
      String s = "SELECT * FROM banka2.gozetmen;";
      rs = st.executeQuery(s);
        while(rs.next())
        {
        	comboBox2.addItem(rs.getString("ad"));
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "ERROR");
    }finally{
        try{
            st.close();
            rs.close();
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR CLOSE");
        }
    }
    }
	
	public void Tes2()
    {

    try{
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banka2?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
      st = con.createStatement();
      String s = "SELECT * FROM banka2.derslik;";
      rs = st.executeQuery(s);
        while(rs.next())
        {
        	comboBox3.addItem(rs.getString("salon_no"));
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "ERROR");
    }finally{
        try{
            st.close();
            rs.close();
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR CLOSE");
        }
    }
    }

	void fillData(File file) { 
		Workbook workbook = null; 
		try {
			try { 
				workbook = Workbook.getWorkbook(file); 
				} catch (IOException ex) {
					Logger.getLogger( excel_2.class. getName()).log(Level.SEVERE, null, ex); 
					}
			Sheet sheet = workbook.getSheet(0); 
			headers.clear();
			for (int i = 0; i < sheet.getColumns(); i++) { 
				Cell cell1 = sheet.getCell(i, 0);
				headers.add(cell1.getContents());
				} 
			data.clear();
			for (int j = 1; j < sheet.getRows(); j++) { 
				Vector d = new Vector(); 
				for (int i = 0; i < sheet.getColumns(); i++) { 
					Cell cell = sheet.getCell(i, j);
					d.add(cell.getContents());
					} 
				d.add("\n");
				data.add(d);
				} 
			} catch (BiffException e) {
				e.printStackTrace(); } 
		}

	
	public static void main(String[] args) {
		
		new excel_2();
		}
	}

