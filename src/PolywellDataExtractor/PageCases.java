package PolywellDataExtractor;



public class PageCases extends TestCases {

	private double CaseId;
	private String ModelName;
	private String ModelURL;
	private boolean Completed;
	public PageCases(double caseid, String modelname,String modelurl,String completed)
	{
		this.CaseId=caseid;
		this.ModelName=modelname;
		this.ModelURL=modelurl;
		if(completed.toUpperCase()=="Yes")
		{
			this.Completed=true;
			}
		else 
		{
			this.Completed=false;
		}
		
	}
}
