package model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MeansTableModel extends DefaultTableModel
{
	//the data has to be a vector
	public void addMeanRow(Mean mean) {
		Vector vector= new Vector(4);
		vector.add(mean.getMeters());
		vector.add(mean.getSpeed());
		vector.add(mean.getName());
		vector.add(mean.isStarted());
		this.addRow(vector);
	}
	
	//set the header
	public MeansTableModel(){
		
		setColumnIdentifiers(new String[]{"Meters Moved","Speed","Means Type","Started"});
	}

	public boolean isCellEditable(int row, int column)
    {
      return false;
    }
	
	//to show the checkbox on the bolean column
	 @Override
     public Class<?> getColumnClass(int columnIndex) {
         return getValueAt(0,columnIndex).getClass();
     }
}
