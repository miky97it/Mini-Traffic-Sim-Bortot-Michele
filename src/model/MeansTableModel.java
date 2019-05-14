package model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MeansTableModel extends DefaultTableModel
{
	public void addMeanRow(Mean mean) {
		Vector vector= new Vector(4);
		vector.add(mean.getMeters());
		vector.add(mean.getSpeed());
		vector.add(mean.getName());
		vector.add(mean.isStarted());
		this.addRow(vector);
	}
	
	public MeansTableModel(){

		setColumnIdentifiers(new String[]{"Meters Moved","Speed","Means Type","Started"});
	}

	public boolean isCellEditable(int row, int column)
    {
      return false;
    }
	
	 @Override
     public Class<?> getColumnClass(int columnIndex) {
         return getValueAt(0,columnIndex).getClass();
     }
}
