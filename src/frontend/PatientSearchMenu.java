package frontend;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		DefaultTableModel model = new DefaultTableModel(new String[] {"First Name", "Last Name"}, 0);
		
		model.addRow(new String[] {"pls buff", "May"});
		model.addRow(new String[] {"Lilica", "Felchenerow"});
		model.addRow(new String[] {"Lucky", "Chloe"});
		model.addRow(new String[] {"Makoto", "Nanaya"});
		model.addRow(new String[] {"french bread pls giv", "Kaguya"});
		
		
//		table = new JTable(model);
		JScrollPane tableScrollPane = new JScrollPane(getTable());
//		table.setFillsViewportHeight(true);
//		table.setAutoCreateRowSorter(true);
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.changeSelection(0, 0, false, false);
		
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

		closeButton.addActionListener(e -> {
			close();
		});
	}
	
	public void addAddAudiologyButtonAction(ActionListener al)
	{
		addAudiologyButton.addActionListener(al);
	}
	
	public void addSearchButtonAction(ActionListener al)
	{
		searchButton.addActionListener(al);
	}
	
	public void addCloseButtonAction(ActionListener al)
	{
		closeButton.addActionListener(al);
	}
	
	public void addSaveButtonAction(ActionListener al)
	{
		saveButton.addActionListener(al);
	}
	
	public String getPatientTHC()
	{
		return patientTHCTField.getText();
	}
	
	public String getFirstName()
	{
		return firstNameTField.getText();
	}
	
	public String getLastName()
	{
		return lastNameTField.getText();
	}
	
	public String getPhone()
	{
		return phoneTField.getText();
	}
	
	public void close()
	{
		dialog.dispose();
	}
	
}
