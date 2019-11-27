import java.awt.event.ActionEvent;

//creates a visit appointment
public class VisitController 
{
	VisitViewer view;
	
	public VisitController(VisitViewer newView)
	{
		this.view = newView;
		view.addConfirmActionListener(new VisitInfo());
	}
	
	class VisitInfo implements ActionListener
	{
		public void actionPerformed(ActionEvent visit)
		{
			int visitId = view.getVisitId();
			int appointDate = view.getVisitDate();
			String patientName = view.getFullName();
			int thcID = view.getTHCid();
			int visitNum = view.getVisitNum();
			String problemText = view.getProblemText();
			String categoryText = view.getCategoryText();
			String 
		}
	}
}
