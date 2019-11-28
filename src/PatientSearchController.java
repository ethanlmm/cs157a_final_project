import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
		try 
		{
			viewer.setTable(DBConnector.execSelect());
		} catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		} catch (SQLException se)
		{
			SQLUtil.printSQLExceptions(se);
		}
		viewer.addSearchButtonAction(new SearchActionListener());
		viewer.addAddAudiologyButtonAction(new AddAudiologyActionListener());
		viewer.addCloseButtonAction(new CloseButtonActionListener());
	}
	
	//original
//	private class SearchActionListener implements ActionListener
//	{
//		public void actionPerformed(ActionEvent e) 
//		{
//			try 
//			{
//				viewer.setTable(DBConnector.execSelect());
//			} catch (ClassNotFoundException e1) 
//			{
//				e1.printStackTrace();
//			} catch (SQLException se)
//			{
//				SQLUtil.printSQLExceptions(se);
//			}
//		}
//	}
	
	private class SearchActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			String patientTHC = viewer.getPatientTHC();
			String firstName = viewer.getFirstName();
			String lastName = viewer.getLastName();
			String phone = viewer.getPhone();

			ArrayList<String> colNames = new ArrayList<String>();
			ArrayList<String> values = new ArrayList<String>();
			
			if (!patientTHC.isEmpty())
			{
				colNames.add("THC_Num");
				values.add(patientTHC);
			}
			if (!firstName.isEmpty())
			{
				colNames.add("first_name");
				values.add("\""+firstName+"\"");
			}
			if (!lastName.isEmpty())
			{
				colNames.add("last_name");
				values.add("\""+lastName+"\"");
			}
			if (!phone.isEmpty())
			{
				colNames.add("phone_num");
				values.add("\""+phone+"\"");
			}
			
//			System.out.println(patientTHC.length());
//			System.out.println(firstName.length());
//			System.out.println(lastName.length());
//			System.out.println(phone.length());

			
//			for (int i = 0; i < colNames.size(); i++)
//			{
//				System.out.println(colNames.get(i) + " " + values.get(i));
//			}
			
			try 
			{
				viewer.setTable(DBConnector.execSelect(colNames, values));
			} catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} catch (SQLException se)
			{
//				SQLUtil.printSQLExceptions(se);
				se.printStackTrace();
			}
		}
	}
	
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
	
	private class CloseButtonActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			viewer.close();
		}
	}
}
