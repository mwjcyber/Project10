//SSW-555 Spring 2014 - Team 3

import java.util.Vector;
import java.util.GregorianCalendar;

//Class to generate family data structure
public class Family 
{
	private Vector<String> children;
	private int lineNumber;
	private String famID;
	private String husband;
	private String wife;
	private GregorianCalendar divorced;
	private GregorianCalendar married;
	
	public Family(String id)
	{
		children = new Vector<String>();
		famID = id;
		divorced = null;
		married = null;
		setLineNumber(0);
	}
	
	public Family(String id, int LineNum)
	{
		children = new Vector<String>();
		famID = id;
		divorced = null;
		married = null;
		setLineNumber(LineNum);
	}
	
	public String getID()
	{
		return famID;
	}
	
	public void setLineNumber(int lineNum) 
	{
		this.lineNumber = lineNum;
	}
	
	public int getLineNumber() 
	{
		return lineNumber;
	}
	
	public void addChild(String cID)
	{
		children.add(cID);
	}
	
	public int getChildSize()
	{
		return children.size();
	}
	
	public Vector<String> getChildren()
	{
		return children;
	}
	
	public void setHusb(String hID)
	{
		husband = hID;
	}
	
	public String getHusb()
	{
		return husband;
	}
	
	public void setWife(String wID)
	{
		wife = wID;
	}
	
	public String getWife()
	{
		return wife;
	}
	
	public void setMarriage(GregorianCalendar m)
	{
		married = m;
	}
	
	public GregorianCalendar getMD()
	{
		return married;
	}
	
	public void setDivorce(GregorianCalendar d)
	{
		divorced = d;
	}
	
	public GregorianCalendar getDD()
	{
		return divorced;
	}
		
}