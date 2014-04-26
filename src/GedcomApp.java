import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;


public class GedcomApp {

	public static void main(String args[]) {
		if(args.length < 1)
		{
			System.out.println("Please enter a GEDCOM File");
		}
		else
		{
			String fileName = args[0];
			if(!fileName.endsWith(".ged"))
			{
				System.out.println("Please enter a file ending in \".ged\"");
			}
			else
			{
				File file = new File(fileName);
				if(!file.exists())
				{
					System.out.println("File '"+fileName+"' can't be found or doesn't exist");
				}
				else
				{
					GedcomReader parser = new GedcomReader();
					parser.readGedcom(file);
					ErrorList el = parser.findErrors();	
					
					if ( el.size() == 0 ) {
						System.out.println("File parsed! No Errors or Anomalies Found.");
					}
					else
					{
						System.out.println( el.buildStringOutput() );
					}
					if ( args.length > 1 ) {
						switch ( args[1] ) {
							case "ancestor":
								if ( args.length < 3 )
								{
									System.out.println("No individual ID given for ancestor view");
									break;
								}
								else
								{
									// Call ancestor view
									break;
								}
							case "prodigy":
								if ( args.length < 3 )
								{
									System.out.println("No individual ID given for prodigy view");
									break;
								}
								else
								{
									// Call prodigy view
									break;
								}
							case "individual":
								if ( args.length < 3 )
								{
									System.out.println("No individual ID given for individual view");
									break;
								}
								else
								{
									// Find the individual
									Individual ind = parser.getIndividual(args[2]);
									if ( ind == null)
									{
										System.out.println("Individual ID not found in given Gedcom file");
									}
									else
									{
										ind.display();
									}
									break;
								}
							case "listpeople":
								if ( args.length < 2 )
								{
									System.out.println("Argument Required");
									break;
								}
								else
								{
								    try 
								    {
								        FileReader fr = new FileReader(fileName);
								        BufferedReader br = new BufferedReader(fr);
								        String s;
								        while((s = br.readLine()) != null)
								        {
								        	String[] records = s.split("\\s");
								        	String tag = records[1];
								        	String data = records[2];
							        		if (tag.equals("NAME"))
							        		{
							        			System.out.println(tag + " " + data);
							        		}
								        }
								        fr.close();
								    }
								    catch(Exception e) 
								    {
								        System.out.println("Error: " + e.getMessage());
								    }//end try catch
								    break;
								}
							case "marriage":
								if ( args.length < 2 )
								{
									System.out.println("Argument Required");
									break;
								}
								else
								{
									// Call marriage view
									break;
								}
							case "divorce":
								if ( args.length < 2 )
								{
									System.out.println("Argument Required");
									break;
								}
								else
								{
									// Call divorce view
									break;
								}
							}
						}
				}
			}			
		}
	}
}