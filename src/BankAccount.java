
public class BankAccount {

	private static long generatedAccountNumber = 100000001L;
	private long accountNumber;
	private double balance;
	private User user;
	private int pin;
	private char status; 
	private User accountHolder;

	public BankAccount(double balance, long accountNumber) {
		this.accountNumber = BankAccount.generatedAccountNumber++;
		this.balance = balance;
	}

	public BankAccount(String account) {
		int index = 0;
		this.accountNumber = Long.parseLong(account.substring(index, index += 9));
		int pin = Integer.parseInt(account.substring(index, index += 4));
		this.balance = Double.parseDouble(account.substring(index, index += 15));
		String name = account.substring(index, index += 35);
		String birthday = account.substring(index, index += 8);
		String phone = account.substring(index, index += 10);
		String address = account.substring(index, index += 30);
		String city = account.substring(index, index += 30);
		String state = account.substring(index, index += 2);
		String zip = account.substring(index, index += 5);
		this.status = account.charAt(148);
		this.accountHolder = new User(name, phone, address, city, zip, state, birthday, pin);
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public User getUser() {
		return user;
	}
	public int getPin() {
		return pin;
	}
	public char getStatus() {
		return status;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void setStatus(char status) {
		this.status = status; 
	}
	public int deposit(double amount) {
		if (amount > balance) {
			return 0;
		} else if (amount <= 0) {
			return 1;
		} else {
			balance = balance + amount;
			return 2;
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
	public int transfer(BankAccount destination, double amount) {
		if (destination == null) {
			return -1;
		} else {
			// withdraw from this
			int status = this.withdraw(amount);
			// deposit into destination account
			if (status == 2) {
				status = destination.deposit(amount);
				return 2;
			}
		}
		return 0;
	}
}