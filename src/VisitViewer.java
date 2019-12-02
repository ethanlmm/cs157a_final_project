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
	private JSpinner problem = new JSpinner();
	private JSpinner category = new JSpinner();
	private JTextField protocol = new JTextField(); //assigned random number
	private JSpinner instrumental = new JSpinner();
	private JCheckBox rem = new JCheckBox();
	private JSpinner followUp = new JSpinner();
	private JTextField addComments = new JTextField(50);

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

		JLabel nameLabel = new JLabel("Name", SwingConstants.RIGHT);
		patientName.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 2;
		constraints.gridy = 0;
		dialog.add(nameLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 0;
		dialog.add(patientName, constraints);

		JLabel visitSeqNumLabel = new JLabel("Visit Number:", SwingConstants.RIGHT);
		visitSeqNum.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 1;
		dialog.add(visitSeqNumLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		dialog.add(visitSeqNum, constraints);

		//blank space

		JLabel visitLabel = new JLabel("Visit Date:", SwingConstants.RIGHT);
		prevMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		prevDaySpinner.setModel(new SpinnerNumberModel(1, 1, 32, 1));
		prevYearSpinner.setModel(new SpinnerNumberModel(2000, 1900, 3000, 1));
		JPanel visitPanel = new JPanel();
		visitPanel.add(prevMonthSpinner);
		visitPanel.add(prevDaySpinner);
		visitPanel.add(prevYearSpinner);
		constraints.gridx = 0;
		constraints.gridy = 2;
		dialog.add(visitLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		dialog.add(visitPanel, constraints);

		JLabel nextVisitLabel = new JLabel("Next Visit Date:", SwingConstants.RIGHT);
		nextMonthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		nextDaySpinner.setModel(new SpinnerNumberModel(1, 1, 32, 1));
		nextYearSpinner.setModel(new SpinnerNumberModel(2000, 1900, 3000, 1));
		JPanel nextVisitLabelPanel = new JPanel();
		nextVisitLabelPanel.add(nextMonthSpinner);
		nextVisitLabelPanel.add(nextDaySpinner);
		nextVisitLabelPanel.add(nextYearSpinner);
		constraints.gridx = 2;
		constraints.gridy = 2;
		dialog.add(nextVisitLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 2;
		dialog.add(nextVisitLabelPanel, constraints);

		JLabel protocolNumLabel = new JLabel("Protocol Number:", SwingConstants.RIGHT);
		protocolNum.setHorizontalAlignment(JTextField.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 3;
		dialog.add(protocolNumLabel, constraints);
		constraints.gridx = 1;
		constraints.gridy = 3;
		dialog.add(protocolNum, constraints);

		JLabel problemLabel = new JLabel("Problem", SwingConstants.RIGHT);
		String[] problemOpt = {"THC", "T", "HT"};
		problem.setModel(new SpinnerListModel(problemOpt));
		constraints.gridx = 2;
		constraints.gridy = 3;
		dialog.add(problemLabel, constraints);
		constraints.gridx = 3;
		constraints.gridy = 3;
		dialog.add(problem, constraints);

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

	public String getThcNUM() {
		return thcNUM.getText();
	}

	public String getPatientName() {
		return patientName.getText();
	}

	public String getVisitSeqNum() {
		return visitSeqNum.getText();
	}

	public String getProtocolNum() {
		return protocolNum.getText();
	}

	public String getProblem() {
		return Problem.getValue();
	}

	public int getCategory() {
		return category.getValue();
	}

	public String getProtocol() {
		return protocol.getText();
	}

	public String getInstrumental() {
		return instrumental.getValue();
	}

	/*public String getRem() {
		return rem.get;
	}*/

	public String getFollowUp() {
		return followUp.getValue();
	}

	public String getAddCComments() {
		return addCComments.getText();
	}

	/*public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}*/
}
