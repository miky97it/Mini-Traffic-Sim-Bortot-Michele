package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Airplane;
import model.Mean;
import model.MeansTableModel;
import model.Truck;
import view.InputView;
import view.MainView;

public class Manager {
	
	public static void main(String[] args) {
		 
		MainView l = new MainView();
		l.setVisible(true);
	
		MeansTableModel tableModel= new MeansTableModel();
		
		ArrayList<Mean> means=new ArrayList<Mean>();
		means.add(new Mean(0,50,false,"Car",false)); // I could create a dedicated class for car,  but there is no reason
		means.add(new Truck(0,30,true,true));
		means.add(new Airplane(0,200,true,true));
		
        means.forEach((m)->tableModel.addMeanRow(m));
        l.setTableModel(tableModel);

        
        
		l.getBtnPrint().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mean selectedValue = means.get(l.getTable().getSelectedRow());
				if(selectedValue.isPrintable())
				{
					JPanel panel = new JPanel();
					panel.setPreferredSize(new Dimension(60,30));
					panel.add(new JLabel(selectedValue.getName()+" has travelled "+
							selectedValue.getMeters()+" in "+selectedValue.getMeters()/
							selectedValue.getSpeed()+" seconds"));
					JOptionPane.showOptionDialog(panel, panel, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
					
					//demostration of use of a method of an object
					if(selectedValue.getName()=="Truck") {
						((Truck)selectedValue).load();
					}
				}
			}
		});
		
		
		ActionListener startstop=new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mean selectedValue = means.get(l.getTable().getSelectedRow());
				if(((JButton)arg0.getSource()).equals(l.getBtnStop())&& selectedValue.isStarted())
					{
						selectedValue.setStarted(false);
						means.set(means.indexOf(selectedValue),selectedValue);
						tableModel.setValueAt(false, means.indexOf(selectedValue), 3);
					}
				if(((JButton)arg0.getSource()).equals(l.getBtnStart())&& !selectedValue.isStarted())
				{
					selectedValue.setStarted(true);
					means.set(means.indexOf(selectedValue),selectedValue);
					tableModel.setValueAt(true, means.indexOf(selectedValue), 3);
				}
			}
		};
			
		l.getBtnStart().addActionListener(startstop);
		l.getBtnStop().addActionListener(startstop);

		
		//Listener and action of button add means
		l.getBtnAddMeans().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InputView i = new InputView();
				i.setVisible(true);
				
				ArrayList names= new ArrayList<String>(); 
				JComboBox combo=i.getComboBoxTypes();
				
				//I load all the types of transport that I have in the table
				//this permit the next implementations to be auto-included into
				//the combobox
				//select distinct name
		        means.forEach((m)->{
		        	if (!names.contains(m.getName())) {
		        		names.add(m.getName()); //I used a support list because of combo doesn't have .contains
				        combo.addItem(m.getName());
		        	}
		        });
				i.setComboBoxTypes(combo);
				i.getBtnSend().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//check the data
						try {
							if(i.getComboBoxTypes().getSelectedItem()!=null&&
								i.getComboBoxTypes().getSelectedItem()!=null&&
								i.getTextFieldSpeed().getText()!=null&&
								i.getTextFieldMeters().getText()!=null) {
								
							//get the data
							means.add(new Mean(Integer.parseInt(i.getTextFieldMeters().getText()),
									Integer.parseInt(i.getTextFieldSpeed().getText()),
									i.getChckbxStarted().isSelected(), 
									i.getComboBoxTypes().getSelectedItem().toString(),
									i.getCheckBoxPrintable().isSelected()));
							 
							tableModel.addMeanRow(means.get(means.size()-1));
						    l.setTableModel(tableModel);
							//close the window
							i.windowClosing();
							}
							
						//if one of the parse fail the data inside was not ok,
						} catch (NumberFormatException e) { }
					}
				});
			}
		});
		
		
		
		
		
        
        while (true) {
            try {
                Thread.sleep(1000);
                
                //check buttons
                
                means.forEach((m)->{
                	if(m.isStarted())
                	{
                		m.setMeters(m.getMeters()+m.getSpeed());
    					tableModel.setValueAt(m.getMeters(), means.indexOf(m), 0);

                	}
                });
                l.setTableModel(tableModel);

            } catch (InterruptedException e) {
                System.out.println("InterruptedException Exception" + e.getMessage());
            }
        }
	}
}