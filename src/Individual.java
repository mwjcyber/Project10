//SSW-555 Spring 2014 - Team 3

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

//Class to generate individual data structure
public class Individual 
{
	private String id;
	private String name;
	private String gender;
	private GregorianCalendar birthDate;
	private ArrayList<GregorianCalendar> deathDate;
	private HashSet<String> famS;
	private HashSet<String> famC;
	private int lineNumber;
	
	public Individual(String id)
	{
		this.id = id;
		this.deathDate = new ArrayList<GregorianCalendar>();
		this.famS = new HashSet<String>();
		this.famC = new HashSet<String>();
		setLineNumber(0);
	}
	
	public Individual(String id, int lineNumber)
	{
		this.id = id;
		this.deathDate = new ArrayList<GregorianCalendar>();
		this.famS = new HashSet<String>();
		this.famC = new HashSet<String>();
		setLineNumber(lineNumber);
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public GregorianCalendar getBirthDate()
	{
		return this.birthDate;
	}
	
	public void setBirthDate(GregorianCalendar birthDate)
	{
		this.birthDate = birthDate;
	}
	
	public ArrayList<GregorianCalendar> getDeathDate()
	{
		return this.deathDate;
	}
	
	public void addDeathDate(GregorianCalendar deathDate)
	{
		this.deathDate.add(deathDate);
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public HashSet<String> getFamS()
	{
		return this.famS;
	}
	
	public void addFamS(String famS)
	{
		this.famS.add(famS);
	}
	
	public HashSet<String> getFamC()
	{
		return this.famC;
	}
	
	public void addFamC(String famC)
	{
		this.famC.add(famC);
	}

	public int getLineNumber() {
		return lineNumber;
	}
	
	public void setLineNumber(int lineNum) {
		this.lineNumber = lineNum;
	}
	
	public ArrayList<String> getAllSpousesIDs(Hashtable<String, Family> family)
	{
		ArrayList<String> indSpouses = new ArrayList<String>();		
		Iterator<String> i = getFamS().iterator();
		while(i.hasNext())
		{
			if(gender.equals("F"))
			{
				String s = i.next();
				if (family.containsKey(s))
				{
					indSpouses.add(family.get(s).getHusb());
				}
			}				
			else if(gender.equals("M"))
			{
				String s = i.next();
				if (family.containsKey(s))
				{
					indSpouses.add(family.get(s).getWife());
				}
			}
		}		
		return indSpouses;
	}	
	
}