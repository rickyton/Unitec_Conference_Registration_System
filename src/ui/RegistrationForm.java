package ui;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import MiscellaneousItems.*;
public class RegistrationForm extends JFrame{
	 
		
		//ui components
		private JPanel panel;
		private JPanel panelSearch;
		private JPanel showDataPanel;
		private JButton addButton;
		private JButton searchButton;
		private JTextField searchField;
		private JLabel participantIdLabel;
		private JTextField participantIdField;
		private JLabel nameLabel; 
		private JTextField nameField;
		private JLabel surnameLabel;
		private JTextField surnameField;
		private JLabel affiliationLabel;
		private JTextField affiliationField;
		private JLabel positionLabel;
		private JTextField positionField;
		private JLabel emailLabel;
		private JTextField emailField;
		private JLabel addressLabel;
		private JTextField addressField;
		private JLabel contactLabel;
		private JTextField contactField;
		private JLabel attendingStatusLabel;
		private JRadioButton yes_radio_button;
		private JRadioButton no_radio_button; 
		private ButtonGroup yes_no_group;
		private JLabel agreementLabel;
		private JCheckBox agreementCheckbox;
		private JLabel participantTypeLabel;
		private JComboBox participantTypeComboBox;
		private JLabel nationalityLabel;
		private JComboBox nationalityComboBox;
		private JLabel topicLabel;
		private JTextField topicField;
		private JButton submit;
		private JButton showData;
		private JButton clear;
		private JComboBox reportTypeComboBox;
		private JButton delete;
		public RegistrationForm()
		{
			
			//set title
			this.setTitle("Registration Form");
			
			//set close operation when a user click a close button on the top right corner
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());			
            panelSearch = new JPanel();
			panelSearch.setLayout(new GridLayout());
			
			//button and text field for search
			 searchField = new JTextField(10);
             searchField.setUI(new HintTextFieldUI("ID or Name", true));
			 searchButton = new JButton("Search");
             addButton = new JButton("Add");
			 panelSearch.add(searchField);
             panelSearch.add(searchButton);
             panelSearch.add(addButton);
             this.add(panelSearch,BorderLayout.NORTH);
			 
			  
			//defined the intermediate container
			 panel = new JPanel();
			 //set a GridBagLayout for a panel
			panel.setLayout(new GridBagLayout());
			
			//constraint for a gridbaglayout
			GridBagConstraints c = new GridBagConstraints();
				
			
			//set gap between components
			c.insets = new Insets(5, 5, 5, 5);
			
			
			//define all components
			//label and text field for participant id
			 participantIdLabel = new JLabel("Participant ID");
			 participantIdField = new JTextField(20);
			 participantIdField.setEnabled(false);
			 participantIdField.setBackground(Color.DARK_GRAY);
			
		
			//label and text field for name
			 nameLabel = new JLabel("Name");
			 nameField = new JTextField(20);
			 
			 
			//label and text field for surname
			 surnameLabel = new JLabel("Surname");
			 surnameField = new JTextField(20);
			 
			 
			//label and text field for affiliation
			 affiliationLabel = new JLabel("Affiliation");
			 affiliationField = new JTextField(20);
			 
			
			//label and text field for position
			 positionLabel = new JLabel("Position");
			 positionField = new JTextField(20);
			 
			 
			//label and text field for email address
			 emailLabel = new JLabel("Email");
			 emailField = new JTextField(20);
			 
			 
			//label and text field for address
			 addressLabel = new JLabel("Address");
			 addressField = new JTextField(20);
			
			 
			//label and text field for contact number
			 contactLabel = new JLabel("Contact number");
			 contactField = new JTextField(20);
			 
			
			//label and radio button for attending status
			 attendingStatusLabel = new JLabel("Attending status");
			 yes_radio_button = new JRadioButton("Yes");
			 yes_radio_button.setActionCommand("Yes");
			 no_radio_button = new JRadioButton("No");
			 no_radio_button.setActionCommand("No");
			//group related radio button together
			 yes_no_group = new ButtonGroup();
		     yes_no_group.add(yes_radio_button);
		     yes_no_group.add(no_radio_button);
		     
		     
		   //label and combo box for type of participants
			 participantTypeLabel = new JLabel("Type of participant");
			 participantTypeComboBox = new JComboBox();
			 participantTypeComboBox.setBackground(Color.WHITE);
			 participantTypeComboBox.addItem("Domestic");
			 participantTypeComboBox.addItem("International");
			 participantTypeComboBox.addItem("Speaker");
			
			//label and combo box for nationality
			 nationalityLabel = new JLabel("Nationality");
			 
			 nationalityComboBox = new JComboBox(getAllCountries());
			 nationalityComboBox.setBackground(Color.WHITE);
			 
			 
			//label and text field for topic
			 topicLabel = new JLabel("Topic");
			 
			 topicField = new JTextField(20);
			 
			 
			//label and check box for an agreement
			 agreementLabel = new JLabel("Do you Agree?");
			 agreementCheckbox = new JCheckBox("yes",false);
			
			// button
			 submit = new JButton("      Submit      ");
			 delete = new JButton("      Delete      ");
			 clear = new JButton ("      Clear       ");
			 showData = new JButton("View data");
			//combo box for type of reports
			 reportTypeComboBox = new JComboBox();
			 reportTypeComboBox.setBackground(Color.WHITE);
			 reportTypeComboBox.addItem("All Participants Report");
			 reportTypeComboBox.addItem("Domestic Participants Report");
			 reportTypeComboBox.addItem("International Participants Report");
			 reportTypeComboBox.addItem("Speakers Report");
			 reportTypeComboBox.addItem(" General Report");
			 
			/*
			 *		This is a grid that I want to create
			 *		
			 *		-----------------------------------------
			 * 		|      x=0, y=0		|	x=1, y=0		|
			 * 		-----------------------------------------	
			 * 		|	   x=0, y=1		|	x=1, y=1		|
			 * 		-----------------------------------------
			 *		|	   x=0, y=2		|	x=1, y=2		| 
			 * 		-----------------------------------------
			 *		|	   x=0, y=3		|	x=1, y=3		| 
			 * 		-----------------------------------------
			 * 		|	   ---------	|	--------		| 
			 * 		-----------------------------------------
			 * 
			 */
			
			 
			//set left alignment for all components 
			c.anchor = GridBagConstraints.WEST;
			
            //place at 0,0 cell
			c.gridx = 0 ;
			c.gridy = 0 ;
			//add  label to 0,0 cell
			panel.add(participantIdLabel,c);
			
			//place at 1,0 cell
			c.gridx = 1 ;
			c.gridy = 0 ;
			//add  field to 1,0 cell
			panel.add(participantIdField,c);
			
			//place at 0,1 cell
			c.gridx = 0 ;
			c.gridy = 1 ;
			//add  label to 0,1 cell
			panel.add(nameLabel,c);
			
			//place at 1,1 cell
			c.gridx = 1 ;
			c.gridy = 1 ;
			//add  field to 1,1 cell
			panel.add(nameField,c);
			
			//place at 0,2 cell
			c.gridx = 0 ;
			c.gridy = 2 ;
			//add label at 0,2 cell
			panel.add(surnameLabel,c );
			
			//place at 1,2 cell
			c.gridx = 1 ;
			c.gridy = 2 ;
			//add  field to 1,2 cell
			panel.add(surnameField,c);
			
			//place at 0,3 cell
			c.gridx = 0 ;
			c.gridy = 3 ;
			//add  label to 0,3 cell
			panel.add(affiliationLabel,c); 
			
			//place at 1,3 cell
			c.gridx = 1 ;
			c.gridy = 3 ;
			//add  field to 1,3 cell
			panel.add(affiliationField,c);
			
			//place at 0,4 cell
			c.gridx = 0 ;
			c.gridy = 4 ;
			//add  label to 0,4 cell
			panel.add(positionLabel,c); 
			
			//place at 1,4 cell
			c.gridx = 1 ;
			c.gridy = 4 ;
			//add  field to 1,4 cell
			panel.add(positionField,c);
			
			//place at 0,5 cell
			c.gridx = 0 ;
			c.gridy = 5 ;
			//add  label to 0,5 cell
			panel.add(emailLabel,c); 
			
			//place at 1,5 cell
			c.gridx = 1 ;
			c.gridy = 5 ;
			//add  field to 1,5 cell
			panel.add(emailField,c);
			
			//place at 0,6 cell
			c.gridx = 0 ;
			c.gridy = 6 ;
			//add  label to 0,6 cell
			panel.add(addressLabel,c); 
			
			//place at 1,6 cell
			c.gridx = 1 ;
			c.gridy = 6 ;
			//add  field to 1,6 cell
			panel.add(addressField,c);
			
			//place at 0,7 cell
			c.gridx = 0 ;
			c.gridy = 7 ;
			//add  label to 0,7 cell
			panel.add(contactLabel,c); 
			
			//place at 1,7 cell
			c.gridx = 1 ;
			c.gridy = 7 ;
			//add  field to 1,7 cell
			panel.add(contactField,c);
			
			//place at 0,8 cell
			c.gridx = 0 ;
			c.gridy = 8 ;
			//add  label to 0,8 cell
			panel.add(attendingStatusLabel,c);
			
			
			//create a new panel for radio buttons
			//and use a gridlayout that allows only 1 column 
			JPanel radioPanel = new JPanel(new GridLayout(0,1));
			//place at 1,8 cell
			c.gridx = 1 ;
			c.gridy = 8 ;
			
			//add radio button to the panel
			radioPanel.add(yes_radio_button);
			yes_radio_button.setSelected(true);
			radioPanel.add(no_radio_button);
			//add radio panel to the panel
			panel.add(radioPanel,c);

			//place at 0,9 cell
			c.gridx = 0 ;
			c.gridy = 9 ;
			//add  label to 0,9 cell
			panel.add(participantTypeLabel,c);
			
			//place at 1,9 cell
			c.gridx = 1 ;
			c.gridy = 9 ;
			//add  label to 1,9 cell
			panel.add(participantTypeComboBox,c);
            
			
			//place at 0,10 cell
			c.gridx = 0 ;
			c.gridy = 10 ;
			//add nationalityLabel to the panel
			panel.add(nationalityLabel,c);
			
            
			//place at 1,10 cell
			c.gridx = 1 ;
			c.gridy = 10 ;
			
			//add nationalityField to the panel
			panel.add(nationalityComboBox,c);
                        
           
			//place at 0,11 cell
			c.gridx = 0 ;
			c.gridy = 11 ;
			
			//add topicLabel to the panel
			panel.add(topicLabel,c);
			
			//place at 1,11 cell
			c.gridx = 1 ;
			c.gridy = 11 ;
			
			//add topicField to the panel
			panel.add(topicField,c);
            
			//place at 0,12 cell
			c.gridx = 0 ;
			c.gridy = 12 ;
			//add Label to the panel
			panel.add(agreementLabel,c);
			
			//place at 1,12 cell
			c.gridx = 1 ;
			c.gridy = 12 ;
			//add check box to the panel
			panel.add(agreementCheckbox,c);
			
		
			//set center alignment for a button
			c.anchor = GridBagConstraints.CENTER;
			c.gridx = 0 ;
			c.gridy = 13 ; 
			panel.add(submit,c);
			
			c.gridx = 1 ;
			c.gridy = 13 ;
			panel.add(delete,c);
			
						
			
			//add a panel to frame
			this.add(panel,BorderLayout.CENTER);
			
			showDataPanel = new JPanel();
			showDataPanel.setLayout(new GridLayout());
			showDataPanel.add(reportTypeComboBox);
			showDataPanel.add(showData);
			showDataPanel.add(clear);
            this.add(showDataPanel,BorderLayout.SOUTH);
			
			//set width and height
			this.setSize(500, 620);
			
			//set Location
			this.setLocation(500, 150);
					
			//set visible
			this.setVisible(true);
			
			//cannot be resize
			this.setResizable(false);	
				
		}
		
		public JTextField getSearchField() {
			return searchField;
		}
		
		public JButton getSearchButton() {
			return searchButton;
		}
		
		public JButton getAddButton() {
			return addButton;
		}
				
		public JTextField getParticipantIdField() {
			return participantIdField;
		}

		public JTextField getNameField() {
			return nameField;
		}

		public JTextField getSurnameField() {
			return surnameField;
		}

		public JTextField getAffiliationField() {
			return affiliationField;
		}
		
		public JTextField getPositionField() {
			return positionField;
		}

		public JTextField getEmailField() {
			return emailField;
		}
		
		public JTextField getAddressField() {
			return addressField;
		}
		
		public JTextField getContactField() {
			return contactField;
		}

		public JRadioButton getYes_radio_button() {
			return yes_radio_button;
		}

		public JRadioButton getNo_radio_button() {
			return no_radio_button;
		}

		public ButtonGroup getYes_no_group() {
			return yes_no_group;
		}

		public JComboBox getParticipantTypeComboBox() {
			return participantTypeComboBox;
		}
		
		public JLabel getNationalityLabel(){
			return nationalityLabel;
		}
		
		public JComboBox getNationalityComboBox() {
			return nationalityComboBox;
		}
		
		public JLabel getTopicLabel(){
			return topicLabel;
		}
		
		public JTextField getTopicField() {
			return topicField;
		}

		public JCheckBox getAgreementCheckbox() {
			return agreementCheckbox;
		}

		public JButton getSubmit() {
			return submit;
		}
		
		public JButton getDelete() {
			return delete;
		}
		
		public JButton getClear(){
			return clear;
		}
	
		public JButton getShowData() {
			return showData;
		}
		
		public JComboBox getReportType(){
			return reportTypeComboBox;
		}
		
		public String[] getAllCountries() {
		    String[] countries = new String[Locale.getISOCountries().length];
		    String[] countryCodes = Locale.getISOCountries();
		    for (int i = 0; i < countryCodes.length; i++) {
		        Locale obj = new Locale("", countryCodes[i]);
		        countries[i] = obj.getDisplayCountry();
		    }
		    return countries;
	     }
}
