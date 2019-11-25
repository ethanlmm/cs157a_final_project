import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			String dobMonth = view.getBdayMonth();
			int dobDay = view.getBdayDay();
			int dobYear = view.getBdayYear();
			String sex = view.getSex();
			String phone = view.getPhone();

//			String statement=insert("Patient",list("FirstName","LastName","streetAddress","zipcode","City","dobMonth","DobDay","DobYear","Sex","Phone"),
//					                                            list(firstName,lastName,streetAddress, zipcode, city, dobMonth,dobDay, dobYear,sex,phone));
//
//
//			print(statement);
			//Now you can do stuff with the strings.
			//Right now we could probably add jdbc code here,
			//but it could be better to add it to another class.
			//What I'm thinking is we use this to create a Patient
			//and then we can send the Patient to another class
			//that has all the JDBC functionality
			System.out.println("firstname " + firstName);
			System.out.println("lastName " + lastName);
			System.out.println("streetAddress " + streetAddress);
			System.out.println("zipcode " + zipcode);
			System.out.println("city " + city);
			System.out.println("dobMonth " + dobMonth);
			System.out.println("dobDay " + dobDay);
			System.out.println("dobYear " + dobYear);
			System.out.println("sex " + sex);
			System.out.println("phone " + phone);
			
		}
		
	}
}
