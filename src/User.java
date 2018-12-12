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



public class User {
	private int pin;
	private String name;
	private String birthday;
	private String address;
	private String phone;
	private String city;
	private String zip;
	private String state;
	public User(String name, String phone, String address, String city, String zip, String state, String birthday, int pin) {
		this.pin = pin;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone; 
		this.city = city;
		this.zip = zip;
		this.state = state;
	}
	public int getPIN() {
		return pin;
	}
	public String getName() {
		return name;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getAddress() {
		return address;
	}
	String getCity() {
		return city;
	}
	String getState() {
		return state;
	}
	String getZip() {
		return zip;
	}
	String getPhone() {
		return phone;
	}
	public void setPIN(int pin) {
		this.pin = pin;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDOB(String birthday) {
		this.birthday = birthday;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone; 
	}
}