package MiscellaneousItems;

public class ValidateNumber {
	public static boolean validateNumber(String contact)
	{
		boolean statusContact = false;
	    for (char c : contact.toCharArray())
	    {
	        if (!Character.isDigit(c)) 
	        	statusContact = false;
	        else{
	        	statusContact = true;
	        }
	    }
	    return statusContact;
	}
}
