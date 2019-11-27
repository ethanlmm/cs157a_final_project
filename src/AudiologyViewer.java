import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AudiologyViewer {
	
	private final int TEXTFIELD_WIDTH = 20;
	
	private JButton saveButton = new JButton("Save");
	private JButton cancelButton = new JButton("Cancel");
	
	private JTextField L25TField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField T_PLTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField T_LmTField = new JTextField(TEXTFIELD_WIDTH);
	
	private JTextField R25TField = new JTextField(TEXTFIELD_WIDTH);
	
	public AudiologyViewer(String patientName, String patientTHC, String visitSN, String visitDate)
	{
		JDialog dialog = new JDialog();
		dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		dialog.setLayout(new BorderLayout());
		
		JPanel upperPanel = new JPanel();
		//Patient’s name.
		//Patient’s THC#.
		//Visit’s sequence number for the patient.
		//Visit’s Date.
		JLabel nameLabel = new JLabel("Name: " + patientName);
		JLabel patientTHCLabel = new JLabel("Patient THC: " + patientTHC);
		JLabel visitSNLabel = new JLabel("Visit SN: " + visitSN);
		JLabel visitDateLabel = new JLabel("Visit Date: " + visitDate);
		upperPanel.add(nameLabel);
		upperPanel.add(patientTHCLabel);
		upperPanel.add(visitSNLabel);
		upperPanel.add(visitDateLabel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.add(L25TField);
		leftPanel.add(T_PLTField);
		leftPanel.add(T_LmTField);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(R25TField);
		
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.add(saveButton);
		lowerPanel.add(cancelButton);
		
		dialog.add(upperPanel, BorderLayout.PAGE_START);
		dialog.add(leftPanel, BorderLayout.LINE_START);
		dialog.add(rightPanel, BorderLayout.LINE_END);
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
	
	
	
	

}
