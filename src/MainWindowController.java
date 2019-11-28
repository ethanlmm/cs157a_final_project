import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowController {
	
	MainWindowViewer viewer;
	
	public MainWindowController(MainWindowViewer _viewer)
	{
		this.viewer = _viewer;
		
		viewer.addPatientButtonAction(new PatientActionListener());
		viewer.addReturnPatientButtonAction(new ReturnActionListener());
		viewer.addCreatePatientButtonAction(new CreatePatientActionListener());
		viewer.addEditPatientAction(new EditPatientActionListener());
		
		viewer.addVisitButtonAction(new VisitActionListener());
	}
	
	public class PatientActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) 
		{
			viewer.switchCard(MainWindowViewer.PATIENT_CARD);
		}
	}
	
	public class VisitActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent val)
		{
			viewer.switchCard(MainWindowViewer.VISIT_CARD);
		}
	}
	
	public class CreatePatientActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			CreatePatientViewer cpv = new CreatePatientViewer();
			CreatePatientController cpc = new CreatePatientController(cpv);
		}
	}
	
	public class EditPatientActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			PatientSearchViewer psv = new PatientSearchViewer();
			PatientSearchController psc = new PatientSearchController(psv);
		}
	}
	
	public class ReturnActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			viewer.switchCard(MainWindowViewer.ETRT_CARD);
		}
	}

}
