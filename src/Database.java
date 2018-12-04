import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This class will serve as the intermediary between our ATM program and
 * the database of BankAccounts. It'll be responsible for fetching accounts
 * when users try to login, as well as updating those accounts after any
 * changes are made.
 */

public class Database {
	private String path;
	private String[] accounts;
	
	public String[] getAllAccounts() throws FileNotFoundException, IOException {
		String [] accounts = new String[10];
		try (BufferedReader bw = new BufferedReader(new FileReader("accounts-db.txt")))
		{
			String line;
			int index = 0;
			
			while ((line = bw.readLine()) != null)
			{
				if (index >= accounts.length)
				{
					accounts = Arrays.copyOf(accounts, accounts.length + 10);
				}
				accounts[index++]= line;
			}
		}
		return accounts;
	}
	
	
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
					double balance = Double.parseDouble(line.substring(13,28));
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

	public void update_account(BankAccount account, BankAccount destination) throws Exception
	{	
		boolean newAccount = true;
		
		for (int i = 0; i < accounts.length; i++) {			
			if (accounts[i].startsWith(String.valueOf(account.get_account_number()))) {
				accounts[i] = account.toString();
				newAccount = false;
			}
			
			if (destination != null) {
				if (accounts[i].startsWith(String.valueOf(destination.get_account_number()))) {
					accounts[i] = destination.toString();
				}
			}
		}
		
		if (newAccount) {
			accounts = Arrays.copyOf(accounts, accounts.length + 1);
			accounts[accounts.length - 1] = account.toString();
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + File.separator + path))) {
			for (String acct : accounts) {
				bw.write(acct);
				bw.newLine();
			}
		}
	}

	public long get_max_account_number() {
		long max = -1L;
	
		for (String account : accounts) {
			long account_number = Long.parseLong(account.substring(0, 9));
		
		if (account_number > max) {
			max = account_number;
		}
	}
	
	return max;
}
}	
	
//		{
//			File file = new File("accounts-db.txt");
//			file.createNewFile();
//			writer = new BufferedWriter(new FileWriter(file));
//		}
//	}