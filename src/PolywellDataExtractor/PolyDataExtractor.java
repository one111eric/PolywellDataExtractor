package PolywellDataExtractor;
public class PolyDataExtractor {

	public static void main(String[] args) throws InterruptedException {
		PolyITXPage page1=new PolyITXPage("http://polywell.com/us/oem/i1000A8-2.asp","i1000A8-2","C:\\Users\\user\\Desktop\\Miao's work\\20150430\\spec.xls");
		page1.getData();
		
		System.exit(0);
	}
	

}
