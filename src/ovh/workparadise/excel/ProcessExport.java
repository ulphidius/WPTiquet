package ovh.workparadise.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ProcessExport {
	private HSSFWorkbook wb = null;
	private HSSFSheet sheet = null;
	private HSSFRow row = null;
	private String filename;
	
	public ProcessExport(String name) {
		this.filename = "Excel/" + name;
		this.wb = new HSSFWorkbook();
		FileOutputStream fileOut;
		try {
		      fileOut = new FileOutputStream(this.filename);
		      wb.write(fileOut);
		      fileOut.close();
		    
		}catch (FileNotFoundException e) {
		    e.printStackTrace();
		    
		}catch (IOException e) {
			e.printStackTrace();
		   
		}
	}
	
	public void createSheet(String name) {
		this.sheet = this.wb.createSheet(name);
	    FileOutputStream fileOut;
	    try {
	      fileOut = new FileOutputStream(this.filename);
	      	wb.write(fileOut);
	      fileOut.close();  
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}	
	
	public void generateCellNum(String name, float value, int position, int line) {
	    this.sheet = this.wb.getSheet(name);
	    
	    if(this.row == null) {
	    	this.row = sheet.createRow(line);
	    
	    }else {
	    	this.row = sheet.getRow(line);
	    
	    }
	    
	    HSSFCell cell = this.row.createCell((short)position);
	    cell.setCellValue(value);

	    FileOutputStream fileOut;
	    try {
	      fileOut = new FileOutputStream(filename);
	      wb.write(fileOut);
	      fileOut.close();  
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public void generateCellString(String name, String value, int position, int line) {
	    this.sheet = this.wb.getSheet(name);
	    
		if(this.row == null) {
	    	this.row = sheet.createRow(line);
	    
	    }else {
	    	this.row = sheet.getRow(line);
	    
	    }
		HSSFCell cell = this.row.createCell((short)position);
	    cell.setCellValue(new HSSFRichTextString(value));
	    
	    FileOutputStream fileOut;
	    try {
		      fileOut = new FileOutputStream(filename);
		      wb.write(fileOut);
		      fileOut.close();  
		    } catch (FileNotFoundException e) {
		    	e.printStackTrace();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
	}

}
