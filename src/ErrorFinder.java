//SSW-555 Spring 2014 - Team 3

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class ErrorFinder 
{
	//Method to verify person's death date doesn't proceed birth date
	public static boolean checkDeathBeforeBirth(Individual ind)
	{
		for (GregorianCalendar dd : ind.getDeathDate()) 
		{
			if (ind.getBirthDay().after(dd)) 
			{
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean checkGender(Hashtable<String, Family> famIndex, Hashtable<String, Individual> indIndex, Individual ind)
	{
		Iterator<String> i = ind.getFamS().iterator();
		while(i.hasNext())
		{
			if(ind.getGender().equals("F"))
			{
				String s = i.next();
				if (famIndex.containsKey(s))
				{
					if (!famIndex.get(s).getWife().isEmpty());
					return true;
				}
			}
			else if(ind.getGender().equals("M"))
			{
				String s = i.next();
				if (famIndex.containsKey(s))
				{
					if (!famIndex.get(s).getHusb().isEmpty());
					return true;
				}
			}
		}		
		return false;
	}
	
	//Method to identify is siblings are listed as married
	public static boolean checkIncest(Hashtable<String, Family> famIndex, Hashtable<String, Individual> indIndex, Individual ind)
	{
		ArrayList<String> indSpouses = ind.getAllSpousesIDs(famIndex);
		ArrayList<String> allRelations = new ArrayList<String>();
		for(String spouseID: indSpouses)
		{
			allRelations.addAll(indIndex.get(spouseID).getFamC());
		}
		Iterator<String> i = ind.getFamC().iterator();
		while(i.hasNext())
		{
			if(allRelations.contains(i.next()))
				return true;
		}
		return false;
	}
	
	//Method to identify more than one death date per person
	public static boolean checkDeaths(Individual ind)
	{
		ArrayList<GregorianCalendar> deaths;
		deaths = ind.getDeathDate();
		if(deaths.size() > 1)
			return true;
		return false;
	}

	//Method to identify more than one birth date per person
	public static boolean checkBirths(Individual ind)
	{
		ArrayList<GregorianCalendar> births;
		births = ind.getBirthDate();
		if(births.size() > 1)
			return true;
		return false;
	}
	
	//Method to identify more than one spouse date per person
	public static boolean checkSpouseCount(Hashtable<String, Family> famIndex, Hashtable<String, Individual> indIndex, Individual ind) 
	{
		if ( ind.getFamS().size() >= 2 )
			return true;
		return true;
	}
}