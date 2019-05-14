package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class InputView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSpeed;
	private JTextField textFieldMeters;
	private JComboBox comboBoxTypes;
	private JCheckBox chckbxStarted;
	private JButton btnSend;
	private JCheckBox checkBoxPrintable;
	
	/**
	 * Create the frame.
	 */
	public InputView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 199, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		
		JLabel lblType = new JLabel("Type");
		contentPane.add(lblType, "cell 0 0,alignx trailing");
		
		comboBoxTypes = new JComboBox();
		contentPane.add(comboBoxTypes, "cell 1 0,growx");
		
		JLabel lblSpeed = new JLabel("Speed");
		contentPane.add(lblSpeed, "cell 0 1,alignx trailing");
		
		textFieldSpeed = new JTextField();
		contentPane.add(textFieldSpeed, "cell 1 1,growx");
		textFieldSpeed.setColumns(10);
		
		JLabel lblIsStarted = new JLabel("Is started");
		contentPane.add(lblIsStarted, "cell 0 2,alignx trailing");
		chckbxStarted = new JCheckBox("");
		contentPane.add(chckbxStarted, "cell 1 2");
		
		JLabel lblMetersTravelled = new JLabel("Meters");
		contentPane.add(lblMetersTravelled, "cell 0 3,alignx trailing");
		
		textFieldMeters = new JTextField();
		contentPane.add(textFieldMeters, "cell 1 3,growx");
		textFieldMeters.setColumns(10);
		 
		 JLabel lblIsPrintable = new JLabel("Is printable");
		 contentPane.add(lblIsPrintable, "cell 0 4");
		 
		 checkBoxPrintable = new JCheckBox("");
		 contentPane.add(checkBoxPrintable, "cell 1 4");
		
		 btnSend = new JButton("Send");
		
		contentPane.add(btnSend, "cell 0 5 2 1,growx");
	}



	public JComboBox getComboBoxTypes() {
		return comboBoxTypes;
	}

	public void setComboBoxTypes(JComboBox comboBoxTypes) {
		this.comboBoxTypes = comboBoxTypes;
	}

	public JTextField getTextFieldSpeed() {
		return textFieldSpeed;
	}

	public JCheckBox getCheckBoxPrintable() {
		return checkBoxPrintable;
	}


	public JTextField getTextFieldMeters() {
		return textFieldMeters;
	}

	public JCheckBox getChckbxStarted() {
		return chckbxStarted;
	}

	public JButton getBtnSend() {
		return btnSend;
	}
	
	public void windowClosing()
    {
      dispose();
    }
}
