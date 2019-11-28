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
	
	private JTextField ptalTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField t_plTField = new JTextField(TEXTFIELD_WIDTH);
	private JComboBox t_lmComboBox = new JComboBox(T_XmInputs);
	private JTextField t_llTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField th_lTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField wnlTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField mmlTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField lsdTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField pt_ldlTField = new JTextField(TEXTFIELD_WIDTH);
	
	
	private JTextField ptarTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField t_prTField = new JTextField(TEXTFIELD_WIDTH);
	private JComboBox t_rmComboBox = new JComboBox(T_XmInputs);
	private JTextField t_lrTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField th_rTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField wnrTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField mmrTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField rsdTField = new JTextField(TEXTFIELD_WIDTH);
	private JTextField pt_rdlTField = new JTextField(TEXTFIELD_WIDTH);
	
	private JTextField commentsTField = new JTextField(TEXTFIELD_WIDTH);
	
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
		
		leftPanel.add(convertToPanel("L25", ptalTField));
		leftPanel.add(convertToPanel("T_PL", t_plTField));
		leftPanel.add(convertToPanel("T_Lm", t_lmComboBox));
		leftPanel.add(convertToPanel("T_LL", t_llTField));
		leftPanel.add(convertToPanel("Th_L", th_lTField));
		leftPanel.add(convertToPanel("WNL", wnlTField));
		leftPanel.add(convertToPanel("MML", mmlTField));
		leftPanel.add(convertToPanel("LSD", lsdTField));
		leftPanel.add(convertToPanel("PT_LD", pt_ldlTField));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(convertToPanel("R25", ptarTField));
		rightPanel.add(convertToPanel("T_PR", t_prTField));
		rightPanel.add(convertToPanel("T_Rm", t_rmComboBox));
		rightPanel.add(convertToPanel("T_LR", t_lrTField));
		rightPanel.add(convertToPanel("Th_R", th_rTField));
		rightPanel.add(convertToPanel("WNR", wnrTField));
		rightPanel.add(convertToPanel("MMR", mmrTField));
		rightPanel.add(convertToPanel("RSD", rsdTField));
		rightPanel.add(convertToPanel("PT_RD", pt_rdlTField));
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BorderLayout());
		JPanel topLowerPanel = new JPanel();
		topLowerPanel.add(convertToPanel("Comments:", commentsTField));
		JPanel botLowerPanel = new JPanel();
		botLowerPanel.add(saveButton);
		botLowerPanel.add(cancelButton);
//		lowerPanel.add(saveButton);
//		lowerPanel.add(cancelButton);
		lowerPanel.add(topLowerPanel, BorderLayout.PAGE_START);
		lowerPanel.add(botLowerPanel,BorderLayout.PAGE_END);
		
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

	public int getPtal() {
		return Integer.parseInt(ptalTField.getText());
	}

	public int getT_pl() {
		return Integer.parseInt(t_plTField.getText());
	}

	public String getT_lm() {
		return t_lmComboBox.getSelectedItem().toString();
	}

	public int getT_ll() {
		return Integer.parseInt(t_llTField.getText());
	}

	public int getTh_l() {
		return Integer.parseInt(th_lTField.getText());
	}

	public int getWnl() {
		return Integer.parseInt(wnlTField.getText());
	}

	public String getMml() {
		return mmlTField.getText();
	}

	public int getLsd() {
		return Integer.parseInt(lsdTField.getText());
	}

	public int getPt_ldl() {
		return Integer.parseInt(pt_ldlTField.getText());
	}

	public int getPtar() {
		return Integer.parseInt(ptarTField.getText());
	}

	public int getT_pr() {
		return Integer.parseInt(t_prTField.getText());
	}

	public String getT_rm() {
		return t_rmComboBox.getSelectedItem().toString();
	}

	public int getT_lr() {
		return Integer.parseInt(t_lrTField.getText());
	}

	public int getTh_r() {
		return Integer.parseInt(th_rTField.getText());
	}

	public int getWnr() {
		return Integer.parseInt(wnrTField.getText());
	}

	public String getMmr() {
		return mmrTField.getText();
	}

	public int getRsd() {
		return Integer.parseInt(rsdTField.getText());
	}

	public int getPt_rdl() {
		return Integer.parseInt(pt_rdlTField.getText());
	}

	public String getComments() {
		return commentsTField.getText();
	}
	
	public Object[] getAllFields()
	{
		Object[] fields = new Object[] { getPtal(), getT_pl(), getT_lm(), getT_ll(), getTh_l(), 
				getWnl(), getMml(), getLsd(), getPt_ldl(), getPtar(), getT_pr(), getT_rm(), 
				getT_lr(), getTh_r(), getWnr(), getMmr(), getRsd(), getPt_rdl(), getComments()};
		return fields;
	}

}
