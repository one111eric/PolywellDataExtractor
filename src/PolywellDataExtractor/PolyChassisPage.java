package PolywellDataExtractor;

public class PolyChassisPage implements PolyProdPage{
	public PolyChassisPage()
	{
		
	}
	public PolyChassisPage(String url,String modelname,String fileloc)
	{
		this.URL=url;
		this.ModelName=modelname;
		this.FileLocation=fileloc;
		
	}
	public void getData() throws InterruptedException 
	{
		
	}
	private String URL;
	private String ModelName;
	private String FileLocation;
}
