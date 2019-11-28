import javax.swing.*;
import java.awt.event.*;

public class VisitViewer
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

	public VisitViewer()
	{
		JLabel dobLabel = new JLabel("Visit Date:", SwingConstants.RIGHT);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		monthSpinner.setModel(new SpinnerListModel(months));
		daySpinner.setModel(new SpinnerNumberModel(1, 1, 32, 1));
		yearSpinner.setModel(new SpinnerNumberModel(2000, 1900, 3000, 1));
		JPanel dobPanel = new JPanel();
		dobPanel.add(monthSpinner);
		dobPanel.add(daySpinner);
		dobPanel.add(yearSpinner);
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
