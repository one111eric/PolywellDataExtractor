package PolywellDataExtractor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class ExcelDataReader {
    public static void readData(String FileLocation)
    {
    	try {
			FileInputStream in=new FileInputStream(new File(FileLocation));
			HSSFWorkbook workbook=new HSSFWorkbook(in);
			HSSFSheet sheet=workbook.getSheetAt(0);
			
		} 
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	//private String FileLocation;
	
}
