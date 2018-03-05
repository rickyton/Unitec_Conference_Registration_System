package listener;
import MiscellaneousItems.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import data.*;

import data.ParticipantsReport;
import ui.RegistrationForm;
import ui.AllParticipantsTable;
import ui.DomesticTable;
import ui.InternationalTable;
import ui.SpeakerTable;


public class FormsActionListener implements ActionListener {
	private RegistrationForm registrationForm;
	private ParticipantsReport participantsReport; 
	
	
	public FormsActionListener(RegistrationForm registrationForm,ParticipantsReport participantsReport )
	{
		this.registrationForm = registrationForm;
		this.participantsReport = participantsReport;
	}
	
	@Override
	
	public void actionPerformed(ActionEvent event) {
		
		
		
        if (event.getSource() == registrationForm.getAddButton()){
        	try {
        		int id=0;
        		
            	ArrayList<String> dataArrayList = this.participantsReport.allParticipantsReadData();
            	String line = dataArrayList.get(dataArrayList.size()-1);
				String []data = line.split(",");
				String lastParticipantId = data[0].trim();
				id = Integer.parseInt(lastParticipantId)+1;
				String ID = String.valueOf(id);
				registrationForm.getParticipantIdField().setText(ID);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block				
				JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
			}
        	registrationForm.getNameField().setText(null);
			registrationForm.getSurnameField().setText(null);
			registrationForm.getAffiliationField().setText(null);
			registrationForm.getPositionField().setText(null);
			registrationForm.getEmailField().setText(null);
			registrationForm.getAddressField().setText(null);
			registrationForm.getContactField().setText(null);
			registrationForm.getParticipantTypeComboBox().setSelectedIndex(0);
			registrationForm.getNationalityComboBox().setSelectedIndex(0);
			registrationForm.getTopicField().setText(null);
			registrationForm.getYes_radio_button().setSelected(true);
			registrationForm.getAgreementCheckbox().setSelected(false);
        	
        }
        
        else if(event.getSource() == registrationForm.getClear()){
        	registrationForm.getSearchField().setText(null);
        	registrationForm.getParticipantIdField().setText(null);
			registrationForm.getNameField().setText(null);
			registrationForm.getSurnameField().setText(null);
			registrationForm.getAffiliationField().setText(null);
			registrationForm.getPositionField().setText(null);
			registrationForm.getEmailField().setText(null);
			registrationForm.getAddressField().setText(null);
			registrationForm.getContactField().setText(null);
			registrationForm.getParticipantTypeComboBox().setSelectedIndex(0);
			registrationForm.getNationalityComboBox().setSelectedIndex(0);
			registrationForm.getTopicField().setText(null);
			registrationForm.getYes_radio_button().setSelected(true);
			registrationForm.getAgreementCheckbox().setSelected(false);
        }
        
        else if(event.getSource()== registrationForm.getSearchButton()){
        	String Search_Error_Message ="";
        	String search = registrationForm.getSearchField().getText().trim();
        	if (search.isEmpty()){
        		Search_Error_Message = " You must enter ID or Name in the search field";
        		JOptionPane.showMessageDialog(registrationForm, Search_Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
        	}
        	
        	else {
                try {
                	ArrayList<String> dataArrayList = this.participantsReport.allParticipantsReadData();
					for(String line: dataArrayList)
					{    
						String []data = line.split(",");
						String participantId = data[0].trim();
						String name = data[1].trim();
						String surname = data[2].trim();
						String affiliation = data[3].trim();
						String position = data[4].trim();
						String email = data[5].trim();
						String address = data[6].trim();
						String contact = data[7].trim();
						String attendingStatus = data[8].trim();
						String typeOfParticipant = data[9].trim();
						String nationality = data[10].trim();
                        
						if(participantId.equals(search)||name.equalsIgnoreCase(search)||surname.equalsIgnoreCase(search)){
							registrationForm.getParticipantIdField().setText(participantId);
							registrationForm.getNameField().setText(name);
							registrationForm.getSurnameField().setText(surname);
							registrationForm.getAffiliationField().setText(affiliation);
							registrationForm.getPositionField().setText(position);
							registrationForm.getEmailField().setText(email);
							registrationForm.getAddressField().setText(address);
							registrationForm.getContactField().setText(contact);
							if (attendingStatus.equalsIgnoreCase("Yes")){
								registrationForm.getYes_radio_button().setSelected(true);
							}
							else{
								registrationForm.getNo_radio_button().setSelected(true);
							}
							registrationForm.getParticipantTypeComboBox().setSelectedItem(typeOfParticipant);					
							registrationForm.getNationalityComboBox().setSelectedItem(nationality);
							
							
						}
						
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block				
					JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
				}
        		
        	}
        	
        }
		
		
		//check whether this is submit button or not
	    else if(event.getSource() == registrationForm.getSubmit())
		{	
	    	
	    		//confirm form submission
				int confirmation = JOptionPane.showConfirmDialog(this.registrationForm, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
				
				if(confirmation == JOptionPane.YES_OPTION )
				{	
					
					//if yes, we get data from inputs and validate it
					String participantId = registrationForm.getParticipantIdField().getText();
					String name = registrationForm.getNameField().getText();
					String surname = registrationForm.getSurnameField().getText();
					String affiliation = registrationForm.getAffiliationField().getText();
					String position = registrationForm.getPositionField().getText();
					String email = registrationForm.getEmailField().getText();
					String address = registrationForm.getAddressField().getText();
					String contact = registrationForm.getContactField().getText();
					String participantType = registrationForm.getParticipantTypeComboBox().getSelectedItem().toString();
					String nationality = registrationForm.getNationalityComboBox().getSelectedItem().toString();
					String topic = registrationForm.getTopicField().getText();
					
					if(participantType.equalsIgnoreCase("Domestic")){
						nationality = "New Zealand";
						topic = "";
					}
					else if (participantType.equalsIgnoreCase("International")){
						topic ="";
					}
					else{
						if (nationality=="New Zealand"){
							nationality="Domestic";
						}
						else{
							nationality="International";
						}
					}
					
					ButtonGroup yes_no_group = registrationForm.getYes_no_group();
					Boolean agreement = registrationForm.getAgreementCheckbox().isSelected();
				    Boolean all_data_valid = true;
				    String Error_Message = "";
					
					//Data validation
					if( (name.length() <2) || (surname.length() <2) )
					{
						Error_Message  += "+ You must enter your exact name and surname \n";
						all_data_valid = false;
					}
					
					if(affiliation.isEmpty())
					{
						Error_Message  += "+ You must enter affiliation \n";
						all_data_valid = false;
					}
									
					if(position.isEmpty())
					{
						Error_Message  += "+ You must enter position \n";
						all_data_valid = false;
					}
					
					boolean status = Validate.validateEmail(email);
					if(status==false)
					{
						Error_Message  += "+ You must enter email \n";
						all_data_valid = false;
					}
					
					if(address.isEmpty())
					{
						Error_Message  += "+ You must enter address \n";
						all_data_valid = false;
					}
					
					boolean statusContact = ValidateNumber.validateNumber(contact);
					if(statusContact==false)
					{
						Error_Message  += "+ You must enter contact number \n";
						all_data_valid = false;
					}
									
					if(yes_no_group.getSelection() == null )
					{
						Error_Message  += "+ You must select atttending status.\n";
						all_data_valid = false;
					}	
					
					if(agreement == false)
					{
						Error_Message  += "+ You must agree our term.\n";
						all_data_valid = false;
					}
					
								
					//check whether there is any error or not	
					if(all_data_valid == true )	
					{	
						//this is the way to get data from radio buttons
						String  attendingStatus = yes_no_group.getSelection().getActionCommand();
						
						//concat string
						//call ParticipantsReport method to write a line in a text file
						
						String CSV_AllParticipants = participantId+","+name+","+surname+","+affiliation+","+position+","+email+","+address+","+
								contact+","+attendingStatus+","+participantType+","+nationality+","+topic;
						this.participantsReport.allParticipantsWriteData(CSV_AllParticipants);
						
						
						if (participantType.equalsIgnoreCase("Domestic")){
						String CSV_DomesticParticipant = participantId+","+name+","+surname+","+affiliation+","+position+","+email+","+address+","+
								contact+","+attendingStatus;
						this.participantsReport.domesticParticipantsWriteData(CSV_DomesticParticipant);
						}
						else if(participantType.equalsIgnoreCase("International")){
							String CSV_InternationalParticipant = participantId+","+name+","+surname+","+affiliation+","+position+","+email+","+address+","+
									contact+","+attendingStatus+","+nationality;
							this.participantsReport.internationalParticipantsWriteData(CSV_InternationalParticipant);
						}
						else{
							String CSV_Speaker = participantId+","+name+","+surname+","+affiliation+","+position+","+email+","+address+","+
									contact+","+topic;
							this.participantsReport.speakersWriteData(CSV_Speaker);
						}
						
						
							JOptionPane.showMessageDialog(registrationForm, "Your details have been saved", "Info Message", JOptionPane.INFORMATION_MESSAGE);
							
							//reset form
							registrationForm.getSearchField().setText(null);
							registrationForm.getParticipantIdField().setText(null);
							registrationForm.getNameField().setText(null);
							registrationForm.getSurnameField().setText(null);
							registrationForm.getAffiliationField().setText(null);
							registrationForm.getPositionField().setText(null);
							registrationForm.getEmailField().setText(null);
							registrationForm.getAddressField().setText(null);
							registrationForm.getContactField().setText(null);
							registrationForm.getParticipantTypeComboBox().setSelectedIndex(0);
							registrationForm.getNationalityComboBox().setSelectedIndex(0);
							registrationForm.getTopicField().setText(null);
							registrationForm.getAgreementCheckbox().setSelected(false);
					}
					
					
					else
					{
						//if there are errors, show the message
						JOptionPane.showMessageDialog(registrationForm, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);	
					}
					
					
					
					
				}	
		}
		else if(event.getSource() == registrationForm.getShowData())
		{
			if(registrationForm.getReportType().getSelectedItem()=="All Participants Report"){
				try {
					ArrayList<String> dataArrayList = this.participantsReport.allParticipantsReadData();
					AllParticipantsTable allParticipantsTable = new AllParticipantsTable();
					allParticipantsTable.populateAllParticipantsTable(dataArrayList);				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block				
					JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
				}
			}
			else if (registrationForm.getReportType().getSelectedItem()=="Domestic Participants Report"){
				try {
					ArrayList<String> dataArrayList = this.participantsReport.domesticParticipantsReadData();
					DomesticTable domesticParticipantsTable = new DomesticTable();
					domesticParticipantsTable.populateDomesticTable(dataArrayList);				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block				
					JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
				}
			}
			else if (registrationForm.getReportType().getSelectedItem()=="International Participants Report"){
				try {
					ArrayList<String> dataArrayList = this.participantsReport.internationalParticipantsReadData();
					InternationalTable internationalParticipantsTable = new InternationalTable();
					internationalParticipantsTable.populateInternationalTable(dataArrayList);				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block				
					JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
				}
			}
			else if(registrationForm.getReportType().getSelectedItem()=="Speakers Report"){
				try {
					ArrayList<String> dataArrayList = this.participantsReport.speakersReadData();
					SpeakerTable speakerTable = new SpeakerTable();
					speakerTable.populateSpeakerTable(dataArrayList);				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block				
					JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
				}
			}
			
			
		}
		else if (event.getSource() == registrationForm.getDelete()){
			//confirm form submission
			int confirmation = JOptionPane.showConfirmDialog(this.registrationForm, "Do you want to delete?" , "Form deletion",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{	
			try {
            	ArrayList<String> dataArrayList = this.participantsReport.allParticipantsReadData();
				for(int i =0;i<dataArrayList.size()-1;i++)
				{    
					String []data = dataArrayList.get(i).split(",");
					String participantId = data[0].trim();
					String name = data[1].trim();
					String surname = data[2].trim();
					String affiliation = data[3].trim();
					String position = data[4].trim();
					String email = data [5].trim();
					String address = data[6].trim();
					String contact = data[7].trim();
					String attendingStatus = data[8].trim();
					String participantType = data[9].trim();
					String nationality = data[10].trim();
					if (participantId.equals(registrationForm.getParticipantIdField().getText())){
						dataArrayList.remove(i);
						String CSV_AllParticipants = participantId+","+name+","+surname+","+affiliation+","+position+","+email+","+address+","+
								contact+","+attendingStatus+","+participantType+","+nationality;
						this.participantsReport.allParticipantsWriteData(CSV_AllParticipants);
					}
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block				
				JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
			}
			
			try {
            	ArrayList<String> dataArrayList = this.participantsReport.domesticParticipantsReadData();
				for(int i =0;i<dataArrayList.size()-1;i++)
				{    
					String []data = dataArrayList.get(i).split(",");
					String participantId = data[0].trim();
					String name = data[1].trim();
					String surname = data[2].trim();
					String affiliation = data[3].trim();
					String position = data[4].trim();
					String email = data [5].trim();
					String address = data[6].trim();
					String contact = data[7].trim();
					String attendingStatus = data[8].trim();
					if (participantId.equals(registrationForm.getParticipantIdField().getText())){
						dataArrayList.remove(i);
						String CSV_DomesticParticipant = participantId+","+name+","+surname+","+affiliation+","+position+","+email+","+address+","+
								contact+","+attendingStatus;
						this.participantsReport.allParticipantsWriteData(CSV_DomesticParticipant);
					}
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block				
				JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
			}
			
			try {
            	ArrayList<String> dataArrayList = this.participantsReport.internationalParticipantsReadData();
				for(int i =0;i<dataArrayList.size()-1;i++)
				{    
					String []data = dataArrayList.get(i).split(",");
					String participantId = data[0].trim();
					String name = data[1].trim();
					String surname = data[2].trim();
					String affiliation = data[3].trim();
					String position = data[4].trim();
					String email = data [5].trim();
					String address = data[6].trim();
					String contact = data[7].trim();
					String attendingStatus = data[8].trim();
					String nationality = data[9].trim();
					if (participantId.equals(registrationForm.getParticipantIdField().getText())){
						dataArrayList.remove(i);
						String CSV_InternationalParticipant = participantId+","+name+","+surname+","+affiliation+","+position+","+email+","+address+","+
								contact+","+attendingStatus+","+nationality;
						this.participantsReport.allParticipantsWriteData(CSV_InternationalParticipant);
					}
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block				
				JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
			}
			
			try {
            	ArrayList<String> dataArrayList = this.participantsReport.speakersReadData();
				for(int i =0;i<dataArrayList.size()-1;i++)
				{    
					String []data = dataArrayList.get(i).split(",");
					String participantId = data[0].trim();
					String name = data[1].trim();
					String surname = data[2].trim();
					String affiliation = data[3].trim();
					String position = data[4].trim();
					String email = data [5].trim();
					String address = data[6].trim();
					String contact = data[7].trim();
					String topic = data[8].trim();
					
					if (participantId.equals(registrationForm.getParticipantIdField().getText())){
						dataArrayList.remove(i);
						String CSV_Speaker = participantId+","+name+","+surname+","+affiliation+","+position+","+email+","+address+","+
								contact+","+topic;
						this.participantsReport.allParticipantsWriteData(CSV_Speaker);
					}
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block				
				JOptionPane.showMessageDialog(registrationForm, "Data file is not found.\n Please add data!", "Info Message", JOptionPane.ERROR_MESSAGE);				
			}
		}
        registrationForm.getSearchField().setText(null);
		registrationForm.getParticipantIdField().setText(null);
		registrationForm.getNameField().setText(null);
		registrationForm.getSurnameField().setText(null);
		registrationForm.getAffiliationField().setText(null);
		registrationForm.getPositionField().setText(null);
		registrationForm.getEmailField().setText(null);
		registrationForm.getAddressField().setText(null);
		registrationForm.getContactField().setText(null);
		registrationForm.getParticipantTypeComboBox().setSelectedIndex(0);
		registrationForm.getNationalityComboBox().setSelectedIndex(0);
		registrationForm.getTopicField().setText(null);
		registrationForm.getAgreementCheckbox().setSelected(false);
        
	}
	}
}

