package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class DomesticTable extends JFrame{
	private JTable domesticTable;
	private String[] columnNames = {"Participant ID","Name","Surname","Affiliation","Position","Email","Address","Contact number",
			"Attending status"};
	private Object[][] domesticData = new Object[][]{};
	
	
	public DomesticTable()
	{
		
		this.domesticTable = new JTable();
		domesticTable.setModel( new DefaultTableModel(domesticData,  columnNames));
		
		JScrollPane scrollPane = new JScrollPane(domesticTable);
		domesticTable.setFillsViewportHeight(true);
		domesticTable.setEnabled(false);
		domesticTable.setDragEnabled(false);
	
		
			
		this.add(scrollPane);
		
		//set width and height
		this.setBounds( 75,75,1200, 400);
				
		//set visible
		this.setVisible(true);
		
		//cannot be resize
		this.setResizable(false);
		
		
	}
	
	
	public void populateDomesticTable(ArrayList<String> DomesticDataArraylist)
	{
		
		for(String line: DomesticDataArraylist)
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
				
				
				
				Object[] row = { data1, data2, data3,data4, data5, data6,data7, data8, data9};
				
				
				DefaultTableModel model = (DefaultTableModel) this.domesticTable.getModel();
				
				model.addRow(row);
				
		
		}
		
		
		
	}
}
