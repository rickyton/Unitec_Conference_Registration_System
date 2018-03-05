package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class InternationalTable extends JFrame{
	private JTable internationalTable;
	private String[] columnNames = {"Participant ID","Name","Surname","Affiliation","Position","Email","Address","Contact number",
			"Attending status","Nationality"};
	private Object[][] internationalData = new Object[][]{};
	
	
	public InternationalTable()
	{
		
		this.internationalTable = new JTable();
		internationalTable.setModel( new DefaultTableModel(internationalData,  columnNames));
		
		JScrollPane scrollPane = new JScrollPane(internationalTable);
		internationalTable.setFillsViewportHeight(true);
		internationalTable.setEnabled(false);
		internationalTable.setDragEnabled(false);
	
		
			
		this.add(scrollPane);
		
		//set width and height
		this.setBounds( 75,75,1200, 400);
				
		//set visible
		this.setVisible(true);
		
		//cannot be resize
		this.setResizable(false);
		
		
	}
	
	
	public void populateInternationalTable(ArrayList<String> InternationalDataArraylist)
	{
		
		for(String line: InternationalDataArraylist)
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
				
				
				
				Object[] row = { data1, data2, data3,data4, data5, data6,data7, data8, data9,data10};
				
				
				DefaultTableModel model = (DefaultTableModel) this.internationalTable.getModel();
				
				model.addRow(row);
				
		
		}
		
		
		
	}
}
