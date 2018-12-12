import java.io.*;
/**
 * This class has only one responsibility: start the ATM program!
 */
public class Tester {
	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		ATM atm = null;
		try {
			atm = new ATM(new String("accounts-db.txt"));
		} catch (IOException e) {
			System.out.println("Database file not found, please restart with a valid file");
		}
		atm.mainMenu();
	}
}