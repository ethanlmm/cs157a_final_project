import javax.swing.*;
import java.awt.*;
import Function.F;
import util.StatementMaker.*;
import java.awt.event.*;
import util.Util.*;

public class VisitViewer 
{
	private JButton confirmButton = new JButton("OK");
	
	private JSpinner monthSpinner = new JSpinner();
	private JSpinner daySpinner = new JSpinner();
	private JSpinner yearSpinner = new JSpinner();
	
	public VisitViewer()
	{
		
	}
	
	public void addConfirmActionListener(ActionListener al)
	{
		confirmButton.addActionListener(al);
	}
	
	/*public String getVisitDay()
	{
		
	}
	
	public String getVisitMonth()
	{
		
	}
	
	public String getVisitYear()
	{
		
	}*/
}
