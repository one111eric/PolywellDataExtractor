package PolywellDataExtractor;

import java.util.ArrayList;
import java.util.List;

public class PolyDataExtractor {

	public static void main(String[] args) throws InterruptedException {
		List<TestCases> cases=new ArrayList<TestCases>();
		cases=ExcelDataReader.readData("C:\\Users\\user\\Desktop\\cases.xls");
		int num=cases.size();
		for(int i=0;i<num;i++)
		{
			if(cases.get(i).getCompleted()==false)
			{
				PageCases pagecase=(PageCases)cases.get(i);
				PolyITXPage page=new PolyITXPage(pagecase.getModelURL(),pagecase.getModelName(),"C:\\Users\\user\\Desktop\\Miao's work\\20150430\\spec.xls");
				page.getData();
				
			}
			
		}
		System.out.println("Finished!");
		System.exit(0);
	}
	

}
