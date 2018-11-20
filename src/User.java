/**
 * Just like last time, the User class is responsible for retrieving
 * (i.e., getting), and updating (i.e., setting) user information.
 * This time, though, you'll need to add the ability to update user
 * information and display that information in a formatted manner.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

//try (bufferedReader br = new BufferedReader (new FileReader(file)))
//{
	//String line;
//	while ((line = br.readLine()) ! = null) {
		//process line
		//build account from pairred account
	//}
//}
public class User {
	private static int generated_pin_number = 1234I;
	
	private String first_name;
	private String last_name;
	private int pin_number;
	private String dob;
	private int phone_number;
	private String location;
	private String city;
	private String state;
	private int zip_code;
	
	
	
	public User(String first_name,String last_name, int pin_number, String dob, int phone_number, String location, String city, String state, int zip_code) {

		this.accountNumber = BankAccount.generatedAccountNumber++;

		this.first_name = first_name;
		this.last_name = last_name;
		this.pin_number = pin_number;
		this.dob = dob;
		this.phone_number = phone_number;
		this.location = location;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;

	}

	public String get_first_name() {
		return first_name;
	}
	
	public String get_last_name() {
		return last_name;
	}

	public int get_pin_number() {
		return pin_number;
	}
	
	public String get_dob() {
		return dob;
	}
	
	public int get_phone_number() {
		return phone_number;
	}
	
	public String get_location() {
		return location;
	}
	
	public String get_city() {
		return city;
	}
	
	public String get_state() {
		return state;
	}
	
	public int get_zip_code() {
		return zip_code;
	}
	
	public void set_pin_number(int pin_number) {
		this.pin_number = pin_number;
	}
	
	public void set_phone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public void set_location(String location) {
		this.location = location;
	}
	
	public void set_city(String city) {
		this.city = city;
	}
	
	public void set_state(String state) {
		this.state = state;
	}
	
	public void set_zip_code(int zip_code) {
		this.zip_code = zip_code;
	}
}