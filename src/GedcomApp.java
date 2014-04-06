import java.io.File;


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
					else{
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
							}
						}
				}
			}			
		}
	}
}