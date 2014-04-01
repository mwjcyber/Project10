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
			if (ind.getBirthDate().after(dd)) 
			{
				return true;
			}
		}
		return false;
	}
	
	//Method to verify a person stated gender and marriage role match
	public static boolean checkGender(Hashtable<String, Family> famIndex, Individual ind)
	{
//		if(ind.getGender().equals("F"))
//		{
//			if (ind.getId() == famIndex.get(ind).getWife());
//			{
//				return true;
//			}			
//		}			
//		else if(ind.getGender().equals("M"))
//		{
//			if (ind.getId() == famIndex.get(ind).getHusb());
//			{
//				return true;
//			}
//		}
//		else
//		{
			return false;
//		}
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
	
}