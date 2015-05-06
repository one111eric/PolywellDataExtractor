package PolywellDataExtractor;



public class PageCases implements TestCases {

	private double CaseId;
	private String ModelName;
	private String ModelURL;
	private boolean Completed;
	public PageCases(double caseid, String modelname,String modelurl,String completed)
	{
		this.CaseId=caseid;
		this.ModelName=modelname;
		this.ModelURL=modelurl;
		if(completed.contains("Yes"))
		{
			this.Completed=true;
			}
		else 
		{
			this.Completed=false;
		}
		
	}
	public double getCaseId()
	{
		return this.CaseId;
	}
	public String getModelName()
	{
		return this.ModelName;
	}
	public String getModelURL()
	{
		return this.ModelURL;
	}
	public boolean getCompleted()
	{
		return this.Completed;
	}
}
