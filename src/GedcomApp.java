import java.io.File;


public class GedcomApp {

	public static void main(String args[]) 
	{
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

					if ( args.length == 1 ) 
					{
						System.out.println("Command argument required");
						System.out.println("Example: java GedcomApp gedcomfile.ged command");
						System.out.println("");
						System.out.println("Commands:");
						System.out.println("errorcheck 	- checks file for errors");
						System.out.println("ancestor 	- lists ancestors of induvidual");
						System.out.println("prodigy 	- lists children of induvidual");
						System.out.println("individual 	- lists information about induvidual");
						System.out.println("listpeople 	- lists all induviduals in file");
						System.out.println("marriage 	- displays induviduals who have married");
						System.out.println("divorce 	- displays induviduals who have divorced");
					}
					else
					{
						switch ( args[1] ) 
						{
						case "errorcheck":
							if ( args.length < 2 )
							{
								System.out.println("No individual ID given for ancestor view");
								break;
							}
							else if ( el.size() == 0 ) 
								{
									System.out.println("File parsed! No Errors or Anomalies Found.");
								}
								else
								{
									System.out.println( el.buildStringOutput() );
								}
								break;
							case "ancestor":
								if ( args.length < 3 )
								{
									System.out.println("No individual ID given for ancestor view");
									break;
								}
								else
								{
									// Call ancestor view
									Individual ind = parser.getIndividual(args[2]);
									if ( ind == null)
									{
										System.out.println("Individual ID not found in given Gedcom file");
										break;
									}
									else
									{
										ind.ancestorDisplay(parser, 0);
										break;
									}
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
									Individual ind = parser.getIndividual(args[2]);
									if ( ind == null)
									{
										System.out.println("Individual ID not found in given Gedcom file");
										break;
									}
									else
									{
										ind.prodigyDisplay(parser, 0);
										break;
									}								}
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
//							case "listpeople":
//								if ( args.length == 2 )
//								{
//									Individual inds = parser.getIndividuals()
//									inds.listpeople();
//								    break;
//								}
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