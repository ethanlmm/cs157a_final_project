import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class PharmacologyViewer extends TableViewer{
	
	private final int TEXTFIELD_WIDTH = 20;
	
	private JButton addMedication = new JButton("Add Medication");
	private JButton saveButton = new JButton("Save");
	private JButton cancelButton = new JButton("Cancel");
	
	private static String[] T_XmInputs = new String[] {"PT","NB","NBN","WN"};
	
	private JTextField L25TField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField T_PLTField = new JTextField(TEXTFIELD_WIDTH);
	private JComboBox T_LmComboBox = new JComboBox(T_XmInputs);
	
	private JTextField R25TField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField T_PRTField = new JTextField(TEXTFIELD_WIDTH);
	private JComboBox T_RmComboBox = new JComboBox(T_XmInputs);
	
//	private JTable table;
	
	private JDialog dialog = new JDialog();
	
	public PharmacologyViewer(String patientName, String patientTHC, String visitSN, String visitDate)
	{
//		super();
		
		dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		dialog.setLayout(new BorderLayout());
		
		JPanel upperPanel = new JPanel();
		//Patient�s name.
		//Patient�s THC#.
		//Visit�s sequence number for the patient.
		//Visit�s Date.
		JLabel nameLabel = new JLabel("Name: " + patientName);
		JLabel patientTHCLabel = new JLabel("Patient THC: " + patientTHC);
		JLabel visitSNLabel = new JLabel("Visit SN: " + visitSN);
		JLabel visitDateLabel = new JLabel("Visit Date: " + visitDate);
		upperPanel.add(nameLabel);
		upperPanel.add(patientTHCLabel);
		upperPanel.add(visitSNLabel);
		upperPanel.add(visitDateLabel);
		
		JPanel middlePanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel(new String[] {"First Name", "Last Name"}, 0);
//		model.addRow(new String[] {"pls buff", "May"});
//		model.addRow(new String[] {"Lilica", "Felchenerow"});
//		model.addRow(new String[] {"Lucky", "Chloe"});
//		model.addRow(new String[] {"Makoto", "Nanaya"});
//		model.addRow(new String[] {"french bread pls giv", "Kaguya"});
//		table = new JTable(model);
		JScrollPane tableScrollPane = new JScrollPane(getTable());
		
//		table.changeSelection(0, 0, false, false);
		middlePanel.add(tableScrollPane);
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.add(saveButton);
		lowerPanel.add(cancelButton);
		
		dialog.add(upperPanel, BorderLayout.PAGE_START);
		dialog.add(middlePanel, BorderLayout.CENTER);
		dialog.add(lowerPanel, BorderLayout.PAGE_END);
		
		dialog.pack();
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public void addSaveButtonAction(ActionListener al)
	{
		saveButton.addActionListener(al);
	}
	
	public void addCancelButtonAction(ActionListener al)
	{
		cancelButton.addActionListener(al);
	}
	
	public void close()
	{
		dialog.dispose();
	}
	
	

}
