import java.util.Scanner;
import java.io.IOException;
public class ATM {
	public BankAccount BankAccount;
	public User User;
	private Database database;
	static Scanner in = new Scanner(System.in);
	ATM(String data) throws IOException {
		database = new Database(data);
	}
	public void mainMenu() {
		System.out.println("What would you like to do?\n1) Log in\n2) Create new account\n3) Exit");
		int menuChoice = in.nextInt();
		switch (menuChoice) {
		case 1:
			this.login(); 
			break;
		case 2:
			this.createAccount();
			break;
		case 3:
			break;
		default:
			System.out.println("Not an option. Try again.");
		}
	}
	private void login() {
		int accCheck = 0;
		int pinCheck = 0;
		long newNum;
		int newPin;
		System.out.print("Enter your account number: ");
		while (accCheck == 0) {
			newNum = in.nextLong();
			in.nextLine();
			if (newNum != this.BankAccount.getAccountNumber()) {
				System.out.print("Not a valid account number. Please try again: ");
			}
			else {
				accCheck++;
			}
		}
		System.out.print("Enter your PIN: ");
		while (pinCheck == 0) {
			newPin = in.nextInt();
			in.nextLine();
			if (newPin != this.User.getPIN()) {
				System.out.print("Incorrect PIN. Please try again: ");
			}
			else {
				pinCheck++;
			}
		}
		this.loginScreen();
	}
	private void createAccount() {
		System.out.println("Please insert the account information below.");
		System.out.print("Account Number: ");
		long accountNumber = in.nextLong();
		System.out.print("PIN: ");
		int pin = in.nextInt();
		String name = in.nextLine();
		System.out.print("Date of Birth (YYYYMMDD): ");
		String birthday = in.nextLine();
		System.out.print("Street Address: ");
		String address = in.nextLine();
		System.out.print("Phone Number: ");
		String phone = in.nextLine();
		System.out.print("State: ");
		String city = in.nextLine();
		System.out.print("ZIP: ");
		String zip = in.nextLine();
		System.out.print("State: "); 
		String state = in.nextLine();
		double balance = 0;
		User = new User(name, phone, address, city, zip, state, birthday, pin);
		BankAccount = new BankAccount(balance, accountNumber);
		System.out.println("Your new account is finished!");
		loginScreen();
	}
	public void loginScreen() {
		double amount;
		System.out.println("Please insert task: ");
		System.out.println("1. Check Balance\n2. Deposit Money\n3. Withdraw Money\n4. Transfer Money\n5.Exit ATM");
		int menuChoice = in.nextInt();
		in.nextLine();
		switch (menuChoice) {
		case 1:
			System.out.print("$" + this.BankAccount.getBalance());
			break;
		case 2:
			System.out.print("Insert amount to deposit: ");
			amount = in.nextDouble();
			this.BankAccount.deposit(amount);
			break;
		case 3:
			System.out.print("Insert amount to withdraw: ");
			amount = in.nextDouble();
			this.BankAccount.withdraw(amount);
			break;
		case 4:
			System.out.print("Insert amount to transfer: ");
			amount = in.nextDouble();
			System.out.print("Insert destination account to transfer: ");			
			long accountNumber = in.nextLong();
			BankAccount destination = database.getAccount(accountNumber);
			this.BankAccount.transfer(destination, amount);
		case 5:
			System.exit(0);
		default:
			System.out.println("Not an option. Try again.");
			break;
		}
		loginScreen();
	}
}