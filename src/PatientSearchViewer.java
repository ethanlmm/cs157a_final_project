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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class PatientSearchViewer {
	
	private JButton editButton = new JButton("Edit");
	private JButton searchButton = new JButton("Search");
	
	private JTable table;
	private JDialog dialog;
	
	public PatientSearchViewer()
	{
		DefaultTableModel model = new DefaultTableModel(new String[] {"First Name", "Last Name"}, 0);
		
		model.addRow(new String[] {"pls buff", "May"});
		model.addRow(new String[] {"Lilica", "Felchenerow"});
		model.addRow(new String[] {"Lucky", "Chloe"});
		model.addRow(new String[] {"Makoto", "Nanaya"});
		model.addRow(new String[] {"french bread pls giv", "Kaguya"});
		
		
		
		table = new JTable(model);
		JScrollPane tableScrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		JPanel searchPanel = new JPanel();
		final int TEXTFIELD_WIDTH = 20;
		
		JLabel lastNameLabel = new JLabel("Last Name", SwingConstants.RIGHT);
		JTextField lastNameTField = new JTextField(TEXTFIELD_WIDTH);
		lastNameTField.setHorizontalAlignment(JTextField.RIGHT);
		searchPanel.add(lastNameLabel);
		searchPanel.add(lastNameTField);
		
		searchPanel.add(searchButton);
		
		dialog = new JDialog();
		dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		dialog.setLayout(new BorderLayout());
		
		dialog.add(searchPanel, BorderLayout.PAGE_START);
		dialog.add(tableScrollPane, BorderLayout.CENTER);
		dialog.add(editButton, BorderLayout.PAGE_END);
		
		dialog.pack();
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
	}
	
	public void addEditButtonAction(ActionListener al)
	{
		editButton.addActionListener(al);
	}
	
	public void addSearchButtonAction(ActionListener al)
	{
		searchButton.addActionListener(al);
	}
	
	public void setTable(DefaultTableModel model)
	{
		table.setModel(model);
	}
	
}
