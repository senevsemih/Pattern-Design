package facade;

import java.io.IOException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import jxl.read.biff.BiffException;
import Excel.ExcelOku;

public class tD {
	
public   DefaultTableModel okuE(String file) throws IOException, BiffException {
		
		
		ExcelOku e = new ExcelOku();
		e.setInputFile(file);
		e.read();
		
		return e.read();
	}
}
