import frontend.VisitViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//creates a visit appointment
public class VisitController
{
	VisitViewer view;

	public VisitController(VisitViewer newView)
	{
		this.view = newView;
		view.addConfirmActionListener(new VisitInfoParser());
	}

	class VisitInfoParser implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String thcNum = view.getThcNUM();
			String patientName = view.getPatientName();
			String visitSeqNum = view.getVisitSeqNum();
			String visitMonth = "" + view.getPrevVisitMonth();
			String visitDay = "" + view.getPrevVisitDay();
			String visitYear = "" + view.getPrevVisitYear();
			String nextVisitMonth = "" + view.getNextVisitMonth();
			String nextVisitDay = "" + view.getNextVisitDay();
			String nextVisitYear = "" + view.getNextVisitYear();
			String protocolNum = view.getProtocolNum();
			String problem = "" + view.getProblem();

			//not sure if i should add something here...
		}
	}
}
