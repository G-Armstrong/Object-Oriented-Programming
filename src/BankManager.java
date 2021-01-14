import java.util.InputMismatchException;
import java.util.Scanner;


public class BankManager {
//main method
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Bank.monthlyFee = 20.0;
		Bank myBank = new Bank("LEHIGH  UNIVERSITY  BANK","Bethlehem", 500,"accounts.txt");
		
		int operation=0,operation2=0;
		double deposit,withdrawl;
		String filter,response;
		
		
		do {
			printMenu();
			try {
			operation= keyboard.nextInt();
			switch(operation) {
			case 1: //manage existing account
				System.out.println("Enter the Account Number of the account you wish to manage: ");
				int account_number = keyboard.nextInt();
				checkAccountNum(account_number);
				if(myBank.getAccount(account_number) == null) {
					System.out.println("Account not found.");
					break;
				}
				else {
					BankAccount account = myBank.getAccount(account_number);
					do {
						printMenu2();
						operation2 = keyboard.nextInt();
						switch(operation2) {
						case 1: //view balance
							System.out.print("Balance: $");
							System.out.printf("%8.2f\n",account.getBalance());
							break;
						case 2: //withdraw
							System.out.println("Enter the withdrawl amount: ");
							withdrawl=keyboard.nextDouble();
							if( account.withdraw(withdrawl) ) {
								System.out.println("Withdrawl completed successfully.\nNewBalance: " + account.getBalance());
							}
							else {
								System.out.println("Error: There is not enough money in your account to make that withdrawl.");
								break;
							}
							break;
						case 3: //deposit
							System.out.println("Enter the deposit amount: ");
							deposit=keyboard.nextDouble();
							account.deposit(deposit);
							System.out.print("Deposit completed successfully.\nNewBalance: $");
							System.out.printf("%8.2f\n", account.getBalance());
							break;
						
						case 4: //view the monthly interest
							if(account.pass("Savings")) {
								System.out.print("Monthly interest : $");
								System.out.printf("%8.2f\n", ((SavingsAccount)account).applyMonthlyInterest() );
								break;
							}
							else {
								System.out.println("Not A Savings Account. Operation is not applicable.");
								break;
							}
							
						case 5: //view the current profit/loss
							if(account.pass("Investment")) {
								
								System.out.print("Profit/Loss : $");
								System.out.printf("%8.2f\n", ((InvestmentAccount)account).applyRisk() );
								break;
							}
							else {
								System.out.println("Not an Investment Account. Operation is not applicable.");
								break;
							}
							
						case 6: //exit manage account
							
							break;
						}
					}while(operation2!=6);
				}
			case 2: //view all accounts
				myBank.viewAllAccounts();
				break;
			case 3: //apply monthly fee
				myBank.applyMonthlyFee();
				break;
			case 4: //sort accounts
				myBank.sortAccounts();
				break;
			case 5: //filter accounts
				System.out.println("Enter the type of account to filter:");
				keyboard.nextLine();
				filter = keyboard.nextLine();
				BankAccount[] list = myBank.filterAccounts(filter);
				System.out.println(list.length + " accounts found.");
				System.out.println("Do you want to display the list of filtered accounts? (yes/no)");
				response = keyboard.nextLine();
				if(response.equals("yes")) {
					System.out.println("Bank Name: LEHIGH  UNIVERSITY  BANK"  + "\t" + "Bank Branch: Bethlehem" + "\n");
					System.out.println("Type\tAccount number\tOwner\t\t\tBalance\tInterest" + "/" + "Investment Type\n");
					for(int i=0;i<list.length;i++) {
						System.out.println(list[i].toString());
					}
					break;
				}
				else {
					break;
				}
				
			case 6:
				myBank.saveFile("accounts.txt");
				System.out.println("Thank you for using LEHIGH  UNIVERSITY  BANK!");
				System.exit(0);	 //program exit
				}
			}
			

			catch(InvalidAccountNumber e) {
				System.out.println(e.getMessage());
			}
			
			
			catch(InputMismatchException e) {
				
			}
			
			
			
			
			
		}while (operation!=6);
		keyboard.close();
	}
	/**
	 * prints first menu
	 */
	public static void printMenu() {
		System.out.println("Select an operation:");
		System.out.println("1: Manage Existing Account");
		System.out.println("2: List All Accounts");
		System.out.println("3: Apply Monthly Fee to all accounts");
		System.out.println("4: Sort Accounts");
		System.out.println("5: Filter Accounts");
		System.out.println("6: Exit");
	}
	/**
	 * prints second menu
	 */
	public static void printMenu2() {
		System.out.println("Select an operation:");
		System.out.println("1: View Balance");
		System.out.println("2: Withdraw");
		System.out.println("3: Deposit");
		System.out.println("4: Monthly Interest (Savings account only)");
		System.out.println("5: Profit/Loss (Investment account only)");
		System.out.println("6: Return to Main Menu");
	}
	
	/**
	 * Checks the Account number for the correct number of digits: 6
	 * @param id: account number specified by the user
	 * @throws InvalidAccountNumber: throws to exception class if the id is invalid
	 */
	public static void checkAccountNum(int id) throws InvalidAccountNumber{
		Integer ID = id; //autoboxing
		if(!ID.toString().matches("\\d{6}"))
			throw new InvalidAccountNumber("Invalid Account Number: " +id + ". Must be 6 digits");
	}

}
