/**
 * Just like last time, the ATM class is responsible for managing all
 * of the user interaction. This means login procedures, displaying the
 * menu, and responding to menu selections. In the enhanced version, the
 * ATM class will have the added responsibility of interfacing with the
 * Database class to write and read information to and from the database.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */
import java.util.Scanner;
public class ATM {
	private Scanner in;
	private BankAccount account;
	private Database database;
	
	public static void main(String[] args)
	{
		ATM atm = new ATM(new Database());
		atm.run();
	}

	public ATM(Database database)
	{
		this.database = database;
	}
	
	public ATM(BankAccount account) {
		this.account = account;
	}
	public void run() {
		in = new Scanner(System.in);
		boolean secure = false;
		while(!secure) {
			
			System.out.print("Account # : ");
			long get_account_number = substring(0, 9);
			long longer = in.nextLong();
		
			if (longer == get_account_number)
			{
				System.out.print("    PIN # : ");
				int get_pin_number =  (int) substring(9, 13);
				int pinner = (int) in.nextLong();
		}
			else
			{
				System.out.println("innocrect");
			}
		}
	}
		
		//if (this.account.get_account_number() == (substring(0, 9)) && pin == substring(9, 13)) {
		//	secure = true;		
		//}
		//	else {
		//		System.out.println("Invalid account number and/or PIN.");
		//}
//	}
	//	System.out.print("\nHi " + "! What can I help you with?");
	//	menu();
//	}
	
	private long substring(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void menu() {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);

		int menu = 0;

		System.out.print("\n\n   [1] Deposit\r\n" + 
				"   [2] Withdraw\r\n" + 
				"   [3] View Balance\r\n" + 
				"   [4] Exit\r\n" + 
				"\r\n" + 
				"Make a selection: ");

		while(menu == 0) {
			switch(in.nextInt()) {
			case 1:
				System.out.print("\nDepositing Money.\r\n" + 
						"\r\n" + 
						"Enter Amount: ");
				double deposit = in.nextDouble();

				if(this.account.deposit(deposit) == 0) {

					System.out.print("\nAmount must be greater than $0.00.");

				} else {

					System.out.print("\nDeposited $" + deposit + ". Updated balance is $" + this.account.get_balance() + ".");
				}

				menu();
			case 2:

				if (this.account.get_balance() == 0) {
					System.out.print("\nYou don't have any money to withdraw.");
				}
				else {
					System.out.print("\nWithdrawing some money.\r\n" + 
							"\r\n" + 
							"Enter Amount: ");

					double withdraw = in.nextDouble();

					if(this.account.withdraw(withdraw) == 2) {

						System.out.print("\nWithdrew $" + withdraw + ". Updated balance is $" + this.account.get_balance() + ".");
					} 
					else if(this.account.withdraw(withdraw) == 1) {
						System.out.print("\nAmount must be greater than $0.00.");
					} 
					else {
						System.out.print("\nInsufficient funds.");
					}
				}
				menu();
			case 3:
				System.out.print("\nCurrent balance is $" + this.account.get_balance() + ".");
				menu();
			case 4:
				System.out.print("\nGoodye!");
				break;
			default: 
				menu();
			}
		}

		in.close();
	}	

	}


