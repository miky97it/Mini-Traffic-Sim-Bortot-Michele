package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.MeansTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnStart;
	private JButton btnAddMeans;
	private JButton btnStop;
	private JButton btnPrint;
	/**
	 * JUST FOR TESTS.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainView frame = new MainView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[195.00px,grow,fill][59.00px,grow,fill][49.00px,grow,fill][grow,fill]", "[center][fill][grow,fill]"));
		
		btnAddMeans = new JButton("Add means of transport");
	
		contentPane.add(btnAddMeans, "cell 0 0,growx,aligny center");
		
		btnStart = new JButton("Start");
		contentPane.add(btnStart, "cell 1 0,growx,aligny center");
		
		btnStop = new JButton("Stop");

		contentPane.add(btnStop, "flowx,cell 2 0,growx,aligny center");
		
		btnPrint = new JButton("Print");
		contentPane.add(btnPrint, "cell 3 0,growx,aligny center");
		
		table = new JTable(new Object[][] {},new String[]{"Meters Moved","Speed","Means Type","Started"});
		contentPane.add(table.getTableHeader(),"cell 0 1 5 1,grow");
		contentPane.add(table, "cell 0 2 4 1,alignx center,growy");
	}

	public void setTableModel(MeansTableModel model) {

		table.setModel(model);
		
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public JButton getBtnAddMeans() {
		return btnAddMeans;
	}

	public JButton getBtnStop() {
		return btnStop;
	}

	public JButton getBtnPrint() {
		return btnPrint;
	}
	

}
