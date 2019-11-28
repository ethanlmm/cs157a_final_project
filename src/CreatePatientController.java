import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static backend.Connector.update;
import static backend.StatementMaker.INSERT_STATEMENT;
import static backend.util.Util.*;

public class CreatePatientController {

	CreatePatientViewer view;
	
	public CreatePatientController(CreatePatientViewer _view)
	{
		this.view = _view;
		view.addConfirmActionListener(new PatientInfoParser());
	}
	
	
	class PatientInfoParser implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//Gets all the ui elements into strings for manipulation
			//I should probably make a Patient class
			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			String streetAddress = view.getStreetAddress();
			String zipcode = view.getZipcode();
			String city = view.getCity();
			String dobMonth = ""+view.getBdayMonth();
			String dobDay = ""+view.getBdayDay();
			String  dobYear =""+ view.getBdayYear();
			String sex = view.getSex();
			String phone = view.getPhone();



			String statement = INSERT_STATEMENT("PATIENT", arr("THC_num","first_name", "last_name", "street_address", "zip_code", "city", "date_of_birth", "gender", "phone_num"),
					arr(""+str(firstName,lastName,dobYear).hashCode(),firstName, lastName, streetAddress, zipcode, city,str(dobYear,"-",dobMonth,"/",dobDay), sex, phone));
			print(statement);
			try {
				update(statement);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

//			print(statement);
			//Now you can do stuff with the strings.
			//Right now we could probably add jdbc code here,
			//but it could be better to add it to another class.
			//What I'm thinking is we use this to create a Patient
			//and then we can send the Patient to another class
			//that has all the JDBC functionality

		}
		
	}
}
