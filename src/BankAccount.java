/**
 * Just like last time, the BankAccount class is primarily responsible
 * for depositing and withdrawing money. In the enhanced version, there
 * will be the added requirement of transfering funds between accounts.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

public class BankAccount {
	private static long generatedAccountNumber = 100000001L;
	
	private long account_number;
	private int balance;
	private User User;
	
	public BankAccount(long account_number, int balance, User User) {
		this.account_number = BankAccount.generatedAccountNumber++;
		this.balance = balance;
		this.User = User;
	}

	public long get_account_number() {
		return account_number;
	}
	
	public int get_balance() {
		return balance;
	}
	
	public User get_User() {
		return User;
	}
	
	public void set_account_number(long accountNumber) {
		this.account_number = account_number;
	}
	
	public void set_User(User User) {
		this.User = User;
	}
	

	public int deposit(double amount) {
		if (amount <= 0) {
			return 0;
		} else {
			balance = balance + amount;
			return 1;
		}
	}


	public int withdraw(double amount) {
		if (amount > balance) {
			return 0;
		} else if (amount <= 0) {
			return 1;
		} else {
			balance = balance - amount;
			return 2;
		}
	}

}

}