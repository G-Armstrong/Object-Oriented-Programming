import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bank  {
	private String name;
	private String branch;
	private BankAccount[] bankAccounts;
	private int count;
	public static double monthlyFee;
	/**
	 * Constructor
	 * @param name of type String
	 * @param branch of type String
	 */
	public Bank(String name, String branch) {
		this.name = name;
		this.branch=branch;
		bankAccounts = new BankAccount[10];
		count =0;
	}
	
	/**
	 * Constructor
	 * @param n of type String
	 * @param b of type String
	 * @param capacity of type int
	 * @param filename of type String
	 */
	public Bank(String n, String b, int capacity, String filename) {
		name=n;
		branch=b;
		bankAccounts = new BankAccount[capacity];
		readFile(filename);
		
	}
	
	/**
	 * Reads the file
	 * @param filename to be read
	 */
	private void readFile(String filename) {
		File file = new File(filename);
		Scanner readFile =null;
		int count=0;
		int number;
		double balance,rate;
		String type1, owner,type2;
		;
		try {
		 readFile = new Scanner(file); //open file
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		while(readFile.hasNext()) { //read file
			type1 = readFile.next();
			owner = readFile.next();
			number = readFile.nextInt();
			balance = readFile.nextDouble();
			
			if(type1.equals("Checking")) {
				BankAccount c = new CheckingAccount(number,owner,balance);
				bankAccounts[count++] = c;
		
			}
			else if(type1.equals("Savings")) {
				rate = readFile.nextDouble();
				BankAccount s = new SavingsAccount(number,owner,balance,rate);
				bankAccounts[count++] = s;
				
			}
			else if(type1.equals("Investment")) {
				type2=readFile.next();
				BankAccount i = new InvestmentAccount(number,owner,balance,type2);
				bankAccounts[count++] = i;
				
			}
			
		}
		readFile.close(); //close file
		
	}
	
	/**
	 * Saves the file so the program can be exit
	 * @param filename to be written to
	 */
	public void saveFile(String filename) {
		File file = new File(filename);
		PrintWriter writeFile=null;
		try {
			writeFile = new PrintWriter(file); //open for writing
		}
		catch(FileNotFoundException e) {
			
		}
		for(int i=0; i<count;i++) {
			writeFile.println(bankAccounts[i].toString());
		}
		writeFile.close();
	}
	/**
	 * Applies monthly fee to all accounts
	 */
	public void applyMonthlyFee() {
		for(int i=0;i<count;i++) {
			bankAccounts[i].withdraw(monthlyFee);
		}
		
	}
	/**
	 * Gets the account for a specified account number
	 * @param number to be searched for
	 * @return returns account of type BankAccount
	 */
	public BankAccount getAccount(int number) {
		for(int i=0;i<bankAccounts.length;i++) {
			if (bankAccounts[i].getNumber()==number) {
				return bankAccounts[i];
			}
		}
			
		return null;
	}
	/**
	 * Lists all account with proper format
	 */
	public void viewAllAccounts() {
		System.out.println("Bank Name: " + name + "\t" + "Bank Branch: " + branch);
		System.out.println("Type\tAccount number\t\tOwner\t\t\tBalance\t\tInterest/Investment Type");
		for(int i=0; i<bankAccounts.length;i++) {
			System.out.println(bankAccounts[i].toString()); 
			
		}
	}
	
	/**
	 * filters account based on the type
	 * @param filter to define the type
	 * @return retunrs a list of bank account with only the correct type
	 */
	public BankAccount[] filterAccounts(String filter) {
		int count1 = 0;
		int x=0;
		
		for (int i=0;i<count;i++) {
			System.out.println("Here!");

			if(bankAccounts[i].pass(filter) == true) {
				count1++;
			}
		}
		
		BankAccount[] list = new BankAccount[count1];
		
		for(int i=0;i<count;i++) {
			if (bankAccounts[i].pass(filter) == true) {
				list[x] = bankAccounts[i];
				x++;
			}
		}
		
		if(count1 != 0) {
			return list;
		}
		else {
			return null;
		}
		
	}
	/**
	 * Basic sorting method
	 */
	public void sortAccounts() {
		java.util.Arrays.sort(bankAccounts);
	}
	
	
}
