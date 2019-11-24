import Function.F;
import util.Util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static util.StatementMaker.*;
import static util.Util.*;
import javax.swing.*;

public class CreatePatientViewer {
	
	
	public CreatePatientViewer()
	{
		JDialog dialog = new JDialog();
		dialog.setModal(true);
		final int TEXTFIELD_WIDTH = 20;
		
		dialog.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel firstNameLabel = new JLabel("First Name", SwingConstants.RIGHT);
		JTextField firstNameTField = new JTextField(TEXTFIELD_WIDTH);
		firstNameTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		dialog.add(firstNameLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 0;
		dialog.add(firstNameTField, constraints);
		
		JLabel lastNameLabel = new JLabel("Last Name", SwingConstants.RIGHT);
		JTextField lastNameTField = new JTextField(TEXTFIELD_WIDTH);
		lastNameTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 2;
		constraints.gridy = 0;
		dialog.add(lastNameLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 0;
		dialog.add(lastNameTField, constraints);
		
		JLabel streetAddressLabel = new JLabel("Street Address", SwingConstants.RIGHT);
		JTextField streetAddressTField = new JTextField(TEXTFIELD_WIDTH);
		streetAddressTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 1;
		dialog.add(streetAddressLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		dialog.add(streetAddressTField, constraints);
		
		JLabel zipcodeLabel = new JLabel("Zipcode", SwingConstants.RIGHT);
		JTextField zipcodeTField = new JTextField(TEXTFIELD_WIDTH);
		zipcodeTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 2;
		constraints.gridy = 1;
		dialog.add(zipcodeLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 1;
		dialog.add(zipcodeTField, constraints);
		
		JLabel cityLabel = new JLabel("City", SwingConstants.RIGHT);
		JTextField cityTField = new JTextField(TEXTFIELD_WIDTH);
		cityTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 2;
		dialog.add(cityLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		dialog.add(cityTField, constraints);
		
		JLabel dobLabel = new JLabel("Date of Birth", SwingConstants.RIGHT);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		JSpinner monthSpinner = new JSpinner(new SpinnerListModel(months));
		JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 32, 1));
		JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(2000, 1900, 3000, 1));
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
		JSpinner sexSpinner = new JSpinner(new SpinnerListModel(sexes));
		constraints.gridx = 0;
		constraints.gridy = 3;
		dialog.add(sexLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 3;
		dialog.add(sexSpinner, constraints);
		
		JLabel phoneLabel = new JLabel("Phone Number", SwingConstants.RIGHT);
		JTextField phoneTField = new JTextField(TEXTFIELD_WIDTH	);
		phoneTField.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 2;
		constraints.gridy = 3;
		dialog.add(phoneLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 3;
		dialog.add(phoneTField, constraints);
		
		
		
		JButton confirmButton = new JButton("OK");
		constraints.gridx = 1;
		constraints.gridy = 4;
		dialog.add(confirmButton, constraints);
		
		class PatientInfoParser implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				//Gets all the ui elements into strings for manipulation
				//I should probably make a Patient class
				String firstName = firstNameTField.getText();
				String lastName = lastNameTField.getText();
				String streetAddress = streetAddressTField.getText();
				String zipcode = zipcodeTField.getText();
				String city = cityTField.getText();
				String dobMonth = (String)monthSpinner.getValue();
				String dobDay = String.valueOf(monthSpinner.getValue());
				String dobYear = String.valueOf(yearSpinner.getValue());
				String sex = (String)sexSpinner.getValue();
				String phone = phoneTField.getText();




				String statement=insert("Patient",list("FirstName","LastName","streetAddress","zipcode","City","dobMonth","DobDay","DobYear","Sex","Phone"),
						                                            list(firstName,lastName,streetAddress, zipcode, city, dobMonth,dobDay, dobYear,sex,phone));


				print(statement);
				//Now you can do stuff with the strings.
				//Right now we could probably add jdbc code here,
				//but it could be better to add it to another class.
				//What I'm thinking is we use this to create a Patient
				//and then we can send the Patient to another class
				//that has all the JDBC functionality
				System.out.println("firstname " + firstName);
				System.out.println("lastName " + lastName);
				System.out.println("streetAddress " + streetAddress);
				System.out.println("zipcode " + zipcode);
				System.out.println("city " + city);
				System.out.println("dobMonth " + dobMonth);
				System.out.println("dobDay " + dobDay);
				System.out.println("dobYear " + dobYear);
				System.out.println("sex " + sex);
				System.out.println("phone " + phone);
				
				System.out.println("");
				
			}
			
		}
		
		confirmButton.addActionListener(new PatientInfoParser());
		
		dialog.pack();
		dialog.setVisible(true);
		
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}

}
