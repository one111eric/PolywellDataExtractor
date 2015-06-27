package PolywellDataExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PolyStoragePage implements PolyProdPage{
	public PolyStoragePage(String url,String modelname,String fileloc)
	{
		this.URL=url;
		this.ModelName=modelname;
		this.FileLocation=fileloc;
		
	}

	@Override
	public void getData() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver wd=new FirefoxDriver();
		wd.manage().window().setPosition(new Point(0,0));
   		wd.manage().window().setSize(new Dimension(1024,768));
   		wd.get(this.URL);
   		Thread.sleep(1000);
   		WebElement SpecTable=wd.findElement(By.xpath("//font[contains(text(),'Specifications')]/../../../../../../../../../../table[2]"));
   		List<WebElement> SpecRows=SpecTable.findElements(By.tagName("tr"));
   		File file=new File(FileLocation);
   		HSSFWorkbook workbook=null;
   		if(file.exists())
   		{
   			try{
   			FileInputStream in=new FileInputStream(new File(FileLocation));
		    workbook=new HSSFWorkbook(in);
   			}
   			catch(Exception e){
   				
   				e.printStackTrace();
   			}
		}
   		else
   			{
   			workbook=new HSSFWorkbook();
   			}
   		HSSFSheet sheet=workbook.createSheet(ModelName);
   		int RowCount=0;   		
   		for(WebElement tr:SpecRows)
   		{
   		    
   			if(!tr.getText().isEmpty())
   			{
   				Row row=sheet.createRow(RowCount++);
   				int CellCount=0;
   			List<WebElement> SpecCells=tr.findElements(By.tagName("td"));
   			for(WebElement td:SpecCells)
   			{
   				
   				Cell cell=row.createCell(CellCount++);
   				cell.setCellValue(td.getText().replace("\n", ";"));  	   				
   			}
   			
   			}
   		}
   		try{
   			
   			FileOutputStream out=new FileOutputStream(new File(FileLocation));
   			workbook.write(out);
   			out.close();
   			System.out.println("write successfully");	
   			workbook.close();
   		}
   		catch(Exception e){
   			e.printStackTrace();
   		}
   		
		wd.close();
   		
	}
	
	private String URL;
	private String ModelName;
	private String FileLocation;
}
