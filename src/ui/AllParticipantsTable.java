package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class AllParticipantsTable extends JFrame{
	private JTable allParticipantsTable;
	private String[] columnNames = {"Participant ID","Name","Surname","Affiliation","Position","Email","Address","Contact number",
			"Attending status","Type of participant","Nationality"};
	private Object[][] allParticipantsData = new Object[][]{};
	
	
	public AllParticipantsTable()
	{
		
		this.allParticipantsTable = new JTable();
		allParticipantsTable.setModel( new DefaultTableModel(allParticipantsData,  columnNames));
		
		JScrollPane scrollPane = new JScrollPane(allParticipantsTable);
		allParticipantsTable.setFillsViewportHeight(true);
		allParticipantsTable.setEnabled(false);
		allParticipantsTable.setDragEnabled(false);
	
		
			
		this.add(scrollPane);
		
		//set width and height
		this.setBounds( 75,75,1300, 400);
				
		//set visible
		this.setVisible(true);
		
		//cannot be resize
		this.setResizable(false);
		
		
	}
	
	
	public void populateAllParticipantsTable(ArrayList<String> AllParticipantsDataArraylist)
	{
		
		for(String line: AllParticipantsDataArraylist)
		{
		
				StringTokenizer tokenizer = new StringTokenizer(line, ","); 
				
				
				String data1 = tokenizer.nextToken();
				String data2 = tokenizer.nextToken();
				String data3 = tokenizer.nextToken();
				String data4 = tokenizer.nextToken();
				String data5 = tokenizer.nextToken();
				String data6 = tokenizer.nextToken();
				String data7 = tokenizer.nextToken();
				String data8 = tokenizer.nextToken();
				String data9 = tokenizer.nextToken();
				String data10 = tokenizer.nextToken();
				String data11 = tokenizer.nextToken();

				
				Object[] row = { data1, data2, data3,data4, data5, data6,data7, data8, data9,data10, data11};
				
				
				DefaultTableModel model = (DefaultTableModel) this.allParticipantsTable.getModel();
				
				model.addRow(row);
				
		
		}
		
		
		
	}
	
	
	
}
