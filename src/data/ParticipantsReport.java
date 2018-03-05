package data;
import java.io.*;
import java.util.*;
public class ParticipantsReport {
	private final String ALL_PARTICIPANTS_FILE_LOCATION = "form\\All participants details.csv";
	private final String DOMESTIC_PARTICIPANTS_FILE_LOCATION = "form\\Domestic participants details.csv";
	private final String INTERNATIONAL_PARTICIPANTS_FILE_LOCATION = "form\\International participants details.csv";
	private final String SPEAKERS_FILE_LOCATION = "form\\Speakers details.csv";
	private final String GENERAL_REPORT_FILE_LOCATION = "form\\General Report details.csv";
	/*
	 * 
	 *  The method to write all participants data to a csv format file
	 * 
	 * 	
	 */
		public void allParticipantsWriteData(String allParticipantsFormData )
		{
			PrintWriter Writer = null;
			try {
				File file = new File(ALL_PARTICIPANTS_FILE_LOCATION);
				if(file.exists() != true)
				{
					//create folder
					file.getParentFile().mkdir();	
				}
				Writer = new PrintWriter(new FileWriter(ALL_PARTICIPANTS_FILE_LOCATION, true));
				Writer.println(allParticipantsFormData);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				Writer.close();
			}
		}
		/*
		 * 
		 *  The method to read data in a text file and add each line to array 
		 * 
		 */
		public ArrayList<String> allParticipantsReadData() throws FileNotFoundException
		{
			ArrayList<String> AllParticipantsArrayOfString = new ArrayList<String>();
			String line = "";  
			BufferedReader Reader = new BufferedReader(new FileReader(ALL_PARTICIPANTS_FILE_LOCATION));
				try {
					line = Reader.readLine();
					while( line!= null )
					{
						AllParticipantsArrayOfString.add(line) ;
						line = Reader.readLine();
					}
					Reader.close();	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return AllParticipantsArrayOfString;	
		}
		/*
		 * 
		 *  The method to write domestic participants data to a csv format file
		 * 
		 * 	
		 */
			public void domesticParticipantsWriteData(String domesticParticipantsFormData )
			{
				PrintWriter Writer = null;
				try {
					File file = new File(DOMESTIC_PARTICIPANTS_FILE_LOCATION);
					if(file.exists() != true)
					{
						//create folder
						file.getParentFile().mkdir();	
					}
					Writer = new PrintWriter(new FileWriter(DOMESTIC_PARTICIPANTS_FILE_LOCATION, true));
					Writer.println(domesticParticipantsFormData);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					Writer.close();
				}
			}
			/*
			 * 
			 *  The method to read data in a text file and add each line to array 
			 * 
			 */
			public ArrayList<String> domesticParticipantsReadData() throws FileNotFoundException
			{
				ArrayList<String> DomesticParticipantsArrayOfString = new ArrayList<String>();
				String line = "";  
				BufferedReader Reader = new BufferedReader(new FileReader(DOMESTIC_PARTICIPANTS_FILE_LOCATION));
					try {
						line = Reader.readLine();
						while( line!= null )
						{	
							DomesticParticipantsArrayOfString.add(line) ;
							line = Reader.readLine();
						}
						Reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				return DomesticParticipantsArrayOfString;
			}
			/*
			 * 
			 *  The method to write international participants data to a csv format file
			 * 
			 * 	
			 */
				public void internationalParticipantsWriteData(String internationalParticipantsFormData )
				{
					PrintWriter Writer = null;
					try {
						File file = new File(INTERNATIONAL_PARTICIPANTS_FILE_LOCATION);
						if(file.exists() != true)
						{
							//create folder
							file.getParentFile().mkdir();	
						}
						Writer = new PrintWriter(new FileWriter(INTERNATIONAL_PARTICIPANTS_FILE_LOCATION, true));
						Writer.println(internationalParticipantsFormData);	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						Writer.close();
					}
				}
				/*
				 * 
				 *  The method to read data in a text file and add each line to array 
				 * 
				 */
				public ArrayList<String> internationalParticipantsReadData() throws FileNotFoundException
				{
					ArrayList<String> InternationalParticipantsArrayOfString = new ArrayList<String>();
					String line = "";  
					BufferedReader Reader = new BufferedReader(new FileReader(INTERNATIONAL_PARTICIPANTS_FILE_LOCATION));
						try {
							line = Reader.readLine();
							while( line!= null )
							{
								InternationalParticipantsArrayOfString.add(line) ;
								line = Reader.readLine();
							}
							Reader.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					return InternationalParticipantsArrayOfString;
				}
				/*
				 * 
				 *  The method to write speakers data to a csv format file
				 * 
				 * 	
				 */
					public void speakersWriteData(String speakersFormData )
					{
						PrintWriter Writer = null;
						try {
							File file = new File(SPEAKERS_FILE_LOCATION);
							if(file.exists() != true)
							{
								//create folder
								file.getParentFile().mkdir();		
							}
							Writer = new PrintWriter(new FileWriter(SPEAKERS_FILE_LOCATION, true));
							Writer.println(speakersFormData);	
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						finally
						{
							Writer.close();
						}
					}
					/*
					 * 
					 *  The method to read data in a text file and add each line to array 
					 * 
					 */
					public ArrayList<String> speakersReadData() throws FileNotFoundException
					{
						ArrayList<String> SpeakersArrayOfString = new ArrayList<String>();
						String line = "";  
						BufferedReader Reader = new BufferedReader(new FileReader(SPEAKERS_FILE_LOCATION));
							try {
								line = Reader.readLine();
								while( line!= null )
								{
									SpeakersArrayOfString.add(line) ;
									line = Reader.readLine();
								}
								Reader.close();	
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						return SpeakersArrayOfString;	
					}
					
		
			public void generalReportWriteData(String generalReportFormData )
					{
						PrintWriter Writer = null;
						try {
							File file = new File(GENERAL_REPORT_FILE_LOCATION);
							if(file.exists() != true)
							{
								//create folder
								file.getParentFile().mkdir();	
							}
							Writer = new PrintWriter(new FileWriter(GENERAL_REPORT_FILE_LOCATION, true));
							Writer.println(generalReportFormData);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						finally
						{
							Writer.close();
						}
					}
					/*
					 * 
					 *  The method to read data in a text file and add each line to array 
					 * 
					 */
			public ArrayList<String> generalReportReadData() throws FileNotFoundException
			{
				ArrayList<String> generalReportArrayOfString = new ArrayList<String>();
				String line = "";  
				BufferedReader Reader = new BufferedReader(new FileReader(GENERAL_REPORT_FILE_LOCATION));
					try {
						line = Reader.readLine();
						while( line!= null )
						{
							generalReportArrayOfString.add(line) ;
							line = Reader.readLine();
						}
						Reader.close();	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				return generalReportArrayOfString;	
			}
					
}
