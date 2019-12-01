import frontend.AudiologyViewer;
import frontend.PatientSearchMenu;
import frontend.PharmacologyViewer;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static backend.Connector.*;


import static backend.StatementMaker.*;
import static backend.util.Util.*;
public class PatientSearchController {

	private PatientSearchMenu viewer;
//	private PatientSearchModel model;
	
//	public PatientSearchController(frontend.PatientSearchViewer _viewer, PatientSearchModel _model)
//	{
//		this.viewer = _viewer;
//		this.model = _model;
//		
//		viewer.addSearchButtonAction(new SearchActionListener());
//		
//		
//	}
	


	
	private class AddAudiologyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//get relevant patient info from viewer
			//then use it to pass into another viewer
			//right now this button opens two things,
			//but that's just for testing
			//will split that later.
			//Check the audiology and pharmacology controllers to see
			//what db functions need to be implemented.
			
//			String patientName = "Sol Badguy";
//			String patientTHC = "1";
//			String visitSN = "3";
//			String visitDate = "1998-05-14";
			
			String patientName = (String)viewer.getTableRowContents(1) + " " + (String)viewer.getTableRowContents(2);
			String patientTHC = ""+viewer.getTableRowContents(0);
			String visitSN = "3";
			String visitDate = "1998-05-14";
			
			AudiologyViewer av = new AudiologyViewer(patientName, patientTHC, visitSN, visitDate);
			AudiologyController ac = new AudiologyController(av);
				
			PharmacologyViewer pv = new PharmacologyViewer(patientName, patientTHC, visitSN, visitDate);
			PharmacologyController pc = new PharmacologyController(pv);
		}
	}
	


	
	private class SaveButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
