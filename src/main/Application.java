package main;
import javax.swing.JButton;

import data.*;
import listener.*;

import ui.*;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
				//call a gui
				RegistrationForm rf = new RegistrationForm(); 
				ParticipantsReport pr = new ParticipantsReport();
				
				//create a listener object
				FormsActionListener listener = new FormsActionListener(rf,pr); 
				
				//buttons that will be sources of event
				JButton submit = rf.getSubmit();
				JButton search = rf.getSearchButton();
				JButton showData = rf.getShowData();
				JButton delete = rf.getDelete();
				JButton clear = rf.getClear();
				JButton addButton = rf.getAddButton();
				
						
				
				
				//add a listener to each button
				submit.addActionListener(listener);
				search.addActionListener(listener);
				showData.addActionListener(listener);
				delete.addActionListener(listener);
				clear.addActionListener(listener);
				addButton.addActionListener(listener);
				
				
	}

}
