import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 * This class will serve as the intermediary between our ATM program and
 * the database of BankAccounts. It'll be responsible for fetching accounts
 * when users try to login, as well as updating those accounts after any
 * changes are made.
 */

public class Database {
	
	public BankAccount getAccount(long accountNumber) throws Exception
	{
		BankAccount account = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader("accounts-db.txt")))
		{
			String line;
			while ((line = br.readLine()) != null) {
				long acctNum = Long.parseLong(line.substring(0, 9));
				System.out.print("account is"  + acctNum);
				if (acctNum == accountNumber && line.charAt(148) == 'Y') {
					int pin = Integer.parseInt(line.substring(9, 13));
					int balance = Integer.parseInt(line.substring(13,28));
					String last_name = line.substring(28,48).trim();
					String first_name = line.substring(48,63).trim();
					String dob = line.substring(63, 71);
					Long phone_number = Long.parseLong(line.substring(71, 81));
					String location = line.substring(81, 111).trim();
					String city = line.substring (111, 141).trim();
					String state = line.substring(141, 143);
					int zip_code = Integer.parseInt(line.substring(143,148));
					
					return new BankAccount(acctNum, balance, new User (first_name, last_name, pin, dob, phone_number, location, city, state,zip_code));
				}
			
			}
		}
		
		return account;
	}
}
	
//	public void writeStats(int pin)
//	{
//		try (BufferedWriter br = new BufferedWriter (new FileWriter("accounts-db.txt")))
//		{
//			File file = new File("accounts-db.txt");
//			file.createNewFile();
//			writer = new BufferedWriter(new FileWriter(file));
//		}
//	}


