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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AudiologyViewer extends Viewer{
	
	private final int TEXTFIELD_WIDTH = 20;
	
	private JButton saveButton = new JButton("Save");
	private JButton cancelButton = new JButton("Cancel");
	
	private static String[] T_XmInputs = new String[] {"PT","NB","NBN","WN"};
	
	private JTextField L25TField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField T_PLTField = new JTextField(TEXTFIELD_WIDTH);
	private JComboBox T_LmComboBox = new JComboBox(T_XmInputs);
	private JTextField T_LLTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField Th_LTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField T_LsTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField WNLTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField MRLTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField MLBTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField MBLTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField L_SDTField = new JTextField(TEXTFIELD_WIDTH);
	
	private JTextField R25TField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField T_PRTField = new JTextField(TEXTFIELD_WIDTH);
	private JComboBox T_RmComboBox = new JComboBox(T_XmInputs);
	
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
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.fill = GridBagConstraints.HORIZONTAL;
//		gbc.weightx = 1;
//		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		leftPanel.setLayout(new GridBagLayout());
		
		leftPanel.add(convertToPanel("L25", L25TField));
		leftPanel.add(convertToPanel("T_PL", T_PLTField));
		leftPanel.add(convertToPanel("T_Lm", T_LmComboBox));
		leftPanel.add(convertToPanel("T_LL", T_LLTField));
		leftPanel.add(convertToPanel("Th_L", Th_LTField));
		leftPanel.add(convertToPanel("WNL", WNLTField));
		leftPanel.add(convertToPanel("MRL", MRLTField));
		leftPanel.add(convertToPanel("MLB", MLBTField));
		leftPanel.add(convertToPanel("MBL", MBLTField));
		leftPanel.add(convertToPanel("L_SD", L_SDTField));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(convertToPanel("R25", R25TField));
		rightPanel.add(convertToPanel("T_PR", T_PRTField));
		rightPanel.add(convertToPanel("T_Rm", T_RmComboBox));
//		leftPanel.add(convertToPanel("T_LL", T_LLTField));
//		leftPanel.add(convertToPanel("Th_L", Th_LTField));
//		leftPanel.add(convertToPanel("WNL", WNLTField));
//		leftPanel.add(convertToPanel("MRL", MRLTField));
//		leftPanel.add(convertToPanel("MLB", MLBTField));
//		leftPanel.add(convertToPanel("MBL", MBLTField));
//		leftPanel.add(convertToPanel("L_SD", L_SDTField));
		
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
