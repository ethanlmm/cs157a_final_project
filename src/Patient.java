
public class Patient {
	
	public Patient(String firstName, String lastName, String streetAddress, String zipcode, String city, String dobMonth, String dobDay, String dobYear, String sex, String phone)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.zipcode = zipcode;
		this.city = city;
		this.dobMonth = dobMonth;
		this.dobDay = dobDay;
		this.dobYear = dobYear;
		this.sex = sex;
		this.phone = phone;
	}
	
	//To do: getters and setters

	private String firstName;
	private String lastName;
	private String streetAddress;
	private String zipcode;
	private String city;
	private String dobMonth;
	private String dobDay;
	private String dobYear;
	private String sex;
	private String phone;
	
}
