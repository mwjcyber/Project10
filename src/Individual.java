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
	private GregorianCalendar birthDay;
	private ArrayList<GregorianCalendar> birthDate;
	private ArrayList<GregorianCalendar> deathDate;
	private HashSet<String> famS;
	private HashSet<String> famC;
	private int lineNumber;
	
	public Individual(String id)
	{
		this.id = id;
		this.birthDate = new ArrayList<GregorianCalendar>();		
		this.deathDate = new ArrayList<GregorianCalendar>();
		this.famS = new HashSet<String>();
		this.famC = new HashSet<String>();
		setLineNumber(0);
	}
	
	public Individual(String id, int lineNumber)
	{
		this.id = id;
		this.birthDate = new ArrayList<GregorianCalendar>();		
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
	
	public GregorianCalendar getBirthDay()
	{
		return this.birthDay;
	}
	
	public void setBirthDay(GregorianCalendar birthDay)
	{
		this.birthDay = birthDay;
	}
	
	public ArrayList<GregorianCalendar> getBirthDate()
	{
		return this.birthDate;
	}
	
	public void addBirthDate(GregorianCalendar birthDate)
	{
		this.birthDate.add(birthDate);
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

	public void display()
	{
		System.out.println("ID:	"+id);
		System.out.println("Name:	"+name);
		System.out.println("Gender:	"+gender);
		System.out.println("Birth Date:	"+birthDay.getTime().toString());
		if ( deathDate.size() > 0 )
		{
				for (int i = 0; i<deathDate.size(); i++)
				{
					System.out.println("Death Date:		"+deathDate.get(i).getTime().toString());
				}
		}
		if ( !famS.isEmpty() )
		{
			String line = "Families Where a Spouse:	";
			for (Iterator i = famS.iterator(); i.hasNext();)
				line = line + i.next() + " ";
			System.out.println(line);
		}
		if ( !famC.isEmpty() )
		{
			String line = "Families Where a Child:	";
			for (Iterator i = famC.iterator(); i.hasNext();)
				line = line + i.next() + " ";
			System.out.println(line);
		}
		System.out.println("Line Number	"+lineNumber);
	}
	
	public void listpeople()
	{
		while ( !id.isEmpty() )
		{
			System.out.println("ID:	"+id);
			System.out.println("Name:	"+name);
		}
	}

	public void marriage()
	{
		Iterator<String> i = getFamS().iterator();
		if ( !famS.isEmpty() )
		{
			String line = "Individuals who married:	";
			for (i = famS.iterator(); i.hasNext();)
				line = line + i.next() + " ";
			System.out.println(line);
		}	
	}
}