//SSW-555 Spring 2014 - Team 3

public abstract class Error 
{
	private String message;
	private int lineNumber;
	
	public Error(int lineNum, String msg)
	{
		this.lineNumber = lineNum;
		this.message = msg;
	}
	
	public int getLineNumber() 
	{
		return lineNumber;
	}
	
	public String getMessage() 
	{
		return message;
	}

}
