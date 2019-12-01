package frontend;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import frontend.util.Util;


import static backend.Connector.query;
import static backend.StatementMaker.SELECT_STATEMENT;
import static backend.util.Util.arr;
import static backend.util.Util.*;

public class PatientSearchMenu extends TableViewer {
	
	private final int TEXTFIELD_WIDTH = 20;
	private JButton addAudiologyButton = new JButton("Add Audiology to Current Visit");
	private JButton searchButton = new JButton("Search");
	private JButton closeButton = new JButton("Close");
	private JButton saveButton = new JButton("Save");
	private JTextField patientTHCTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField firstNameTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField lastNameTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField phoneTField = new JTextField(TEXTFIELD_WIDTH);
	
//	private JTable table;
	private JDialog dialog;
	
	public PatientSearchMenu()
	{
		super();
		JScrollPane tableScrollPane = new JScrollPane(getTable());

		JPanel searchPanel = new JPanel();
		
		JLabel patientTHCLabel = new JLabel("Patient THC", SwingConstants.RIGHT);
		patientTHCTField.setHorizontalAlignment(JTextField.RIGHT);
		searchPanel.add(patientTHCLabel);
		searchPanel.add(patientTHCTField);
		
		JLabel firstNameLabel = new JLabel("First Name", SwingConstants.RIGHT);
		firstNameTField.setHorizontalAlignment(JTextField.RIGHT);
		searchPanel.add(firstNameLabel);
		searchPanel.add(firstNameTField);
		
		JLabel lastNameLabel = new JLabel("Last Name", SwingConstants.RIGHT);
		lastNameTField.setHorizontalAlignment(JTextField.RIGHT);
		searchPanel.add(lastNameLabel);
		searchPanel.add(lastNameTField);
		
		JLabel phoneLabel = new JLabel("Phone Number", SwingConstants.RIGHT);
		phoneTField.setHorizontalAlignment(JTextField.RIGHT);
		searchPanel.add(phoneLabel);
		searchPanel.add(phoneTField);
		
		searchPanel.add(searchButton);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addAudiologyButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(closeButton);
		
		dialog = new JDialog();
		dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		dialog.setLayout(new BorderLayout());
		
		dialog.add(searchPanel, BorderLayout.PAGE_START);
		dialog.add(tableScrollPane, BorderLayout.CENTER);
		dialog.add(buttonPanel, BorderLayout.PAGE_END);
		
		dialog.pack();
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		addAudiologyButton.addActionListener(e -> {
			String patientName = (String)getTableRowContents(1) + " " + (String)getTableRowContents(2);
			String patientTHC = ""+getTableRowContents(0);
			String visitSN = "3";
			String visitDate = "1998-05-14";

			AudiologyViewer av = new AudiologyViewer(patientName, patientTHC, visitSN, visitDate);
			PharmacologyViewer pv = new PharmacologyViewer(patientName, patientTHC, visitSN, visitDate);

		});




		searchButton.addActionListener(e -> {
			String patientTHC = patientTHCTField.getText();
			String firstName = firstNameTField.getText();
			String lastName = lastNameTField.getText();
			String phone = phoneTField.getText();
			String where="";
			if (!patientTHC.isEmpty()) where = str("THC_Num", "=", patientTHC);
			else if (!firstName.isEmpty()&&!lastName.isEmpty())where = str("first_name", "=", "\'",firstName,"\'", " AND ","last_name", "=","\'", lastName,"\'");
			else if (!phone.isEmpty())  where=str("phone_num", "=", phone);
			String statement =SELECT_STATEMENT("Patient",arr(),where);
			print(statement);
			try {
				ResultSet set=query(statement);
				DefaultTableModel table =new DefaultTableModel(Util.getAttrtibute(set),0);
				Util.getData(table,set);
				this.setTable(table);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		closeButton.addActionListener(e -> {
			dialog.dispose();
		});
	}
	

	
}
