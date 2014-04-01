//SSW-555 Spring 2014 - Team 3

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

//Main file to execute gedcom file checker
public class GedcomApp 
{
    public static void main(String args[]) 
    {
    	//Set GEDCOM filename here
    	String fileName = "GedcomTest.ged";
	    try 
	    {
	    	FileReader fr = new FileReader(fileName);
	        BufferedReader br = new BufferedReader(fr);
	        String s;
	        while((s = br.readLine()) != null)
	        {
	            System.out.println(s);
	        }
	        fr.close();
	        System.out.println("--End of '"+fileName+"' file.-- \n");
	    }        
	    catch(Exception e) 
	    {
	        System.out.println("Error: " + e.getMessage());
	    }
	    
        File file = new File(fileName);
        if(!file.exists())
            System.out.println("File '"+fileName+"' can't be found.");
        else
        {
            GedcomReader parser = new GedcomReader();
            parser.readGedcom(file);
            ErrorList el = parser.findErrors();
            
            if (el.size() == 0)
                System.out.println("No Errors Found.");
            else
                System.out.println(el.buildStringOutput());
        }     
    }
    
}
