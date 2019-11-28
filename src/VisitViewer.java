import javax.swing.*;
import java.awt.event.*;

public class VisitViewer extends TableViewer
{
	private final int TEXTFIELD_WIDTH = 20;

	private JButton confirmButton = new JButton("OK");

	private JTextField thcNUM = new JTextField(TEXTFIELD_WIDTH);
	private JTextField patientName = new JTextField(TEXTFIELD_WIDTH);
	//supposed to be a random num generator
	private JTextField visitSeqNum = new JTextField(TEXTFIELD_WIDTH);

	private JSpinner monthSpinner = new JSpinner();
	private JSpinner daySpinner = new JSpinner();
	private JSpinner yearSpinner = new JSpinner();

	private JTextField protocolNum = new JTextField(TEXTFIELD_WIDTH);
	private JSpinner Problem = new JSpinner();
	private JSpinner category = new JSpinner();
	private JTextField protocol = new JTextField(); //assigned random number
	private JSpinner instrumental = new ();
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

		JLabel dobLabel = new JLabel("Visit Date:", SwingConstants.RIGHT);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		monthSpinner.setModel(new SpinnerListModel(months));
		daySpinner.setModel(new SpinnerNumberModel(1, 1, 32, 1));
		yearSpinner.setModel(new SpinnerNumberModel(2000, 1900, 3000, 1));
		JPanel dobPanel = new JPanel();
		dobPanel.add(monthSpinner);
		dobPanel.add(daySpinner);
		dobPanel.add(yearSpinner);

		JLabel dobLabel = new JLabel("Next Visit Date:", SwingConstants.RIGHT);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		monthSpinner.setModel(new SpinnerListModel(months));
		daySpinner.setModel(new SpinnerNumberModel(1, 1, 32, 1));
		yearSpinner.setModel(new SpinnerNumberModel(2000, 1900, 3000, 1));
		JPanel dobPanel = new JPanel();
		dobPanel.add(monthSpinner);
		dobPanel.add(daySpinner);
		dobPanel.add(yearSpinner);

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

	public String getVisitDay()
	{
		return (Integer)daySpinner.getValue();
	}

	public String getVisitMonth()
	{
		return (String)monthSpinner.getValue();
	}

	public String getVisitYear()
	{
		return (Integer)yearSpinner.getValue();
	}
}
