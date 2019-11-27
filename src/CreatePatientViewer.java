import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CreatePatientViewer {
	
	private JButton confirmButton = new JButton("OK");
	
	private final int TEXTFIELD_WIDTH = 20;
	private JTextField firstNameTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField lastNameTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField streetAddressTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField zipcodeTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField cityTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField phoneTField = new JTextField(TEXTFIELD_WIDTH	);
	
	private JSpinner monthSpinner = new JSpinner();
	private JSpinner daySpinner = new JSpinner();
	private JSpinner yearSpinner = new JSpinner();
	
	private JSpinner sexSpinner = new JSpinner();
	
	
	public CreatePatientViewer()
	{
		JDialog dialog = new JDialog();
		dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		
		dialog.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel firstNameLabel = new JLabel("First Name", SwingConstants.RIGHT);
		firstNameTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		dialog.add(firstNameLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 0;
		dialog.add(firstNameTField, constraints);
		
		JLabel lastNameLabel = new JLabel("Last Name", SwingConstants.RIGHT);
		lastNameTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 2;
		constraints.gridy = 0;
		dialog.add(lastNameLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 0;
		dialog.add(lastNameTField, constraints);
		
		JLabel streetAddressLabel = new JLabel("Street Address", SwingConstants.RIGHT);
		streetAddressTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 1;
		dialog.add(streetAddressLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		dialog.add(streetAddressTField, constraints);
		
		JLabel zipcodeLabel = new JLabel("Zipcode", SwingConstants.RIGHT);
		zipcodeTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 2;
		constraints.gridy = 1;
		dialog.add(zipcodeLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 1;
		dialog.add(zipcodeTField, constraints);
		
		JLabel cityLabel = new JLabel("City", SwingConstants.RIGHT);
		cityTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 2;
		dialog.add(cityLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		dialog.add(cityTField, constraints);
		
		JLabel dobLabel = new JLabel("Date of Birth", SwingConstants.RIGHT);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		monthSpinner.setModel(new SpinnerListModel(months));
		daySpinner.setModel(new SpinnerNumberModel(1, 1, 32, 1));
		yearSpinner.setModel(new SpinnerNumberModel(2000, 1900, 3000, 1));
		JPanel dobPanel = new JPanel();
		dobPanel.add(monthSpinner);
		dobPanel.add(daySpinner);
		dobPanel.add(yearSpinner);
		constraints.gridx = 2;
		constraints.gridy = 2;
		dialog.add(dobLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 2;
		dialog.add(dobPanel, constraints);
//		constraints.gridx = 4;
//		constraints.gridy = 2;
//		frame.add(daySpinner, constraints);
//		constraints.gridx = 5;
//		constraints.gridy = 2;
//		frame.add(yearSpinner, constraints);
		
		JLabel sexLabel = new JLabel("Sex", SwingConstants.RIGHT);
		String[] sexes = {"Female", "Male", "Other"};
		sexSpinner.setModel(new SpinnerListModel(sexes));
		constraints.gridx = 0;
		constraints.gridy = 3;
		dialog.add(sexLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 3;
		dialog.add(sexSpinner, constraints);
		
		JLabel phoneLabel = new JLabel("Phone Number", SwingConstants.RIGHT);
		phoneTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 2;
		constraints.gridy = 3;
		dialog.add(phoneLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 3;
		dialog.add(phoneTField, constraints);
		
		
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		dialog.add(confirmButton, constraints);
		
		dialog.pack();
		dialog.setVisible(true);
		
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
	
	public void addConfirmActionListener(ActionListener al)
	{
		confirmButton.addActionListener(al);
	}
	
	public String getFirstName()
	{
		return firstNameTField.getText();
	}
	
	public String getLastName()
	{
		return lastNameTField.getText();
	}
	
	public String getStreetAddress()
	{
		return streetAddressTField.getText();
	}
	
	public String getZipcode()
	{
		return zipcodeTField.getText();
	}
	
	public String getCity()
	{
		return cityTField.getText();
	}
	
	public String getPhone()
	{
		return phoneTField.getText();
	}
	
	public int getBdayDay()
	{
		return (Integer)daySpinner.getValue();
	}
	
	public String getBdayMonth()
	{
		return (String)monthSpinner.getValue();
	}
	
	public int getBdayYear()
	{
		return (Integer)yearSpinner.getValue();
	}

	public String getSex()
	{
		return (String)sexSpinner.getValue();
	}
}
