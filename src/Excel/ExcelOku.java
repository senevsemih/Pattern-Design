package Excel;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelOku {

		private String inputFile;
		Vector headers = new Vector();
		Vector  data = new Vector();	
		
		public void setInputFile(String inputFile) {
			this.inputFile = inputFile;
		}
		
		public  Vector getData() throws IOException, BiffException{
			
			
			return data;	
			
		}
		public  Vector getHeader() throws IOException, BiffException{
			
			
			return headers;	
			
		}
		
		public DefaultTableModel read() throws IOException, BiffException{
			
				
			File file  = new File(inputFile);
			DefaultTableModel model = null;
			
			try {
				Workbook workbook = Workbook.getWorkbook(file);
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
				
				model = new DefaultTableModel(data,headers);
				
				
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return model;
			
		
		}
		
	
}
