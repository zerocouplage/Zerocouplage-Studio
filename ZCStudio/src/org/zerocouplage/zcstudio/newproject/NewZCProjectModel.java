package org.zerocouplage.zcstudio.newproject;
import org.eclipse.core.resources.IProject; 
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;




/**
 * Model class containing the data for the holiday wizard
 */
/**
 * Model class containing the data for the holiday wizard
 */
public class NewZCProjectModel
{
	public static final String copyright = "(c) Copyright IBM Corporation 2002.";
		
	// date of departure as a String day, month, year
	protected String departureDate;
	
	// date of return as a String day, month, year
	protected String returnDate;


	
	// holiday departure point
	protected String departure;
	
	// flag indicating whether the user will use the plane
	protected boolean usePlane;
	
	// true if the flisgts need to be reset
	protected boolean resetFlights;

	// flight details for the holiday by plane
	protected String selectedFlight;
	
	// flight price 
	float price;
	
	// seat choice  for the holiday be plane
	protected String seatChoice;
	
	// rental company for the holiday by car
	protected String rentalCompany;
	Copy cp=new Copy();
	
	
	
	
	

	// flag is set if a folder called Discounts is selected 
	// when the wizard is started; a discount is offered in this case
	boolean discounted = false;	

	public String toString()
	{
		String s;
		s= "Your project: \n";
		if (usePlane) s= s+"Flying from ";
		else s = s+"Driving from ";
		s= s +departure+ " to "+
			"\nleaving on "+departureDate +" returning on "+returnDate;
		if (usePlane)
			s = s + "\nflight: " + selectedFlight + "\nseat: "+seatChoice+
				"\nprice: "+price + " "+cp.workspaceDirectory;
	
		return s;	
	}
	
//Création de projet vide	
	public void creatEmptyProject() throws CoreException{
		//copy the existing project example from SDK to the workspace of eclipse 
		
		cp.copy();

		//Programmatically import the project into Eclipse
		
IProjectDescription description = ResourcesPlugin
	.getWorkspace().loadProjectDescription(   new Path("C:/Users/Doaae K/Desktop/ws/ana/.project"));
			

IProject project = ResourcesPlugin.getWorkspace()
				   .getRoot().getProject(departure);
				
				project.create(description,null);
			
				project.open(null);
				
				
				
				

	      }

			
	
	
			    
}

			
	
	

