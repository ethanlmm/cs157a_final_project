package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VisitViewer extends TableViewer
{
	private final int TEXTFIELD_WIDTH = 20;

	private JButton confirmButton = new JButton("OK");

	private JTextField thcNUM = new JTextField(TEXTFIELD_WIDTH);
	private JTextField patientName = new JTextField(TEXTFIELD_WIDTH);
	//supposed to be a random num generator
	private JTextField visitSeqNum = new JTextField(TEXTFIELD_WIDTH);

	private JSpinner prevMonthSpinner = new JSpinner();
	private JSpinner prevDaySpinner = new JSpinner();
	private JSpinner prevYearSpinner = new JSpinner();
	
	private JSpinner nextMonthSpinner = new JSpinner();
	private JSpinner nextDaySpinner = new JSpinner();
	private JSpinner nextYearSpinner = new JSpinner();

	private JTextField protocolNum = new JTextField(TEXTFIELD_WIDTH);
	private JSpinner Problem = new JSpinner();
	private JSpinner category = new JSpinner();
	private JTextField protocol = new JTextField(); //assigned random number
	private JSpinner instrumental = new JSpinner();
	private JCheckBox rem = new JCheckBox();
	private JSpinner followUp = new JSpinner();
	private JTextField addCComments = new JTextField(50);

	private JButton saveButton = new JButton("Save");
	private JButton cancelButton = new JButton("Cancel");

	public VisitViewer()
	{
		JDialog dialog = new JDialog();
		dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

		dialog.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;

		JLabel thcLabel = new JLabel("THC Number:", SwingConstants.RIGHT);
		thcNUM.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 0;
		dialog.add(thcLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 0;
		dialog.add(thcLabel, constraints);

		JLabel visitLabel = new JLabel("Visit Date:", SwingConstants.RIGHT);
		prevMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		prevDaySpinner.setModel(new SpinnerNumberModel(1, 1, 32, 1));
		prevYearSpinner.setModel(new SpinnerNumberModel(2000, 1900, 3000, 1));
		JPanel visitPanel = new JPanel();
		visitPanel.add(prevMonthSpinner);
		visitPanel.add(prevDaySpinner);
		visitPanel.add(prevYearSpinner);

		JLabel nextVisitLabel = new JLabel("Next Visit Date:", SwingConstants.RIGHT);
		nextMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		nextDaySpinner.setModel(new SpinnerNumberModel(1, 1, 32, 1));
		nextYearSpinner.setModel(new SpinnerNumberModel(2000, 1900, 3000, 1));
		JPanel nextVisitLabelPanel = new JPanel();
		nextVisitLabelPanel.add(nextMonthSpinner);
		nextVisitLabelPanel.add(nextDaySpinner);
		nextVisitLabelPanel.add(nextYearSpinner);

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

	public int getPrevVisitDay()
	{
		return (Integer)prevDaySpinner.getValue();
	}

	public int getPrevVisitMonth()
	{
		return (Integer)prevMonthSpinner.getValue();
	}

	public int getPrevVisitYear()
	{
		return (Integer)prevYearSpinner.getValue();
	}
	
	public int getNextVisitDay()
	{
		return (Integer)nextDaySpinner.getValue();
	}

	public int getNextVisitMonth()
	{
		return (Integer)nextMonthSpinner.getValue();
	}

	public int getNextVisitYear()
	{
		return (Integer)nextYearSpinner.getValue();
	}

	public JTextField getThcNUM() {
		return thcNUM;
	}

	public JTextField getPatientName() {
		return patientName;
	}

	public JTextField getVisitSeqNum() {
		return visitSeqNum;
	}

	public JTextField getProtocolNum() {
		return protocolNum;
	}

	public JSpinner getProblem() {
		return Problem;
	}

	public JSpinner getCategory() {
		return category;
	}

	public JTextField getProtocol() {
		return protocol;
	}

	public JSpinner getInstrumental() {
		return instrumental;
	}

	public JCheckBox getRem() {
		return rem;
	}

	public JSpinner getFollowUp() {
		return followUp;
	}

	public JTextField getAddCComments() {
		return addCComments;
	}

	public JButton getSaveButton() {
		return saveButton;
	}
}
