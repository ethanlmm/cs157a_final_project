import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PatientSearchController {

	private PatientSearchViewer viewer;
//	private PatientSearchModel model;
	
//	public PatientSearchController(PatientSearchViewer _viewer, PatientSearchModel _model)
//	{
//		this.viewer = _viewer;
//		this.model = _model;
//		
//		viewer.addSearchButtonAction(new SearchActionListener());
//		
//		
//	}
	
	public PatientSearchController(PatientSearchViewer _viewer)
	{
		this.viewer = _viewer;
		
		viewer.addSearchButtonAction(new SearchActionListener());
	}
	
	public class SearchActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try {
				viewer.setTable(DBConnector.execSelect());
			} catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} catch (SQLException se)
			{
				SQLUtil.printSQLExceptions(se);
			}
		}
		
	}
}
