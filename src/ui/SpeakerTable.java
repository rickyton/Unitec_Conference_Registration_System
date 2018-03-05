package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class SpeakerTable extends JFrame {
	private JTable speakerTable;
	private String[] columnNames = {"Participant ID","Name","Surname","Affiliation","Position","Email","Address","Contact number"
			};
	private Object[][] speakerData = new Object[][]{};
	
	
	public SpeakerTable()
	{
		
		this.speakerTable = new JTable();
		speakerTable.setModel( new DefaultTableModel(speakerData,  columnNames));
		
		JScrollPane scrollPane = new JScrollPane(speakerTable);
		speakerTable.setFillsViewportHeight(true);
		speakerTable.setEnabled(false);
		speakerTable.setDragEnabled(false);
	
		
			
		this.add(scrollPane);
		
		//set width and height
		this.setBounds( 75,75,1000, 400);
				
		//set visible
		this.setVisible(true);
		
		//cannot be resize
		this.setResizable(false);
		
		
	}
	
	
	public void populateSpeakerTable(ArrayList<String> SpeakerDataArraylist)
	{
		
		for(String line: SpeakerDataArraylist)
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
				
				
				
				
				
				Object[] row = { data1, data2, data3,data4, data5, data6,data7, data8};
				
				
				DefaultTableModel model = (DefaultTableModel) this.speakerTable.getModel();
				
				model.addRow(row);
				
		
		}
		
		
		
	}
}
