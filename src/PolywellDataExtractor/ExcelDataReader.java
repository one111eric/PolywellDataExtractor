package PolywellDataExtractor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class ExcelDataReader {
    public static List<Object> readData(String FileLocation)
    {
    	List<Object> pagecases=new ArrayList<Object>();
    	try {
			FileInputStream in=new FileInputStream(new File(FileLocation));
			HSSFWorkbook workbook=new HSSFWorkbook(in);
			HSSFSheet sheet=workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                             
                    double id=row.getCell(0).getNumericCellValue();
                    String modelname=row.getCell(1).getStringCellValue(); 
                    String url=row.getCell(2).getStringCellValue();
                    String completed=row.getCell(3).getStringCellValue();
                    PageCases pagecase=new PageCases(id,modelname,url,completed);
                    pagecases.add(pagecase);                  
             }                               		
    	}			
       
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return pagecases;
    	
    }
	private String FileLocation;
	
}
