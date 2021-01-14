
public abstract class BankAccount implements Comparable<BankAccount>,Filter{
	private int number;
	private String owner;
	protected double balance;
	/**
	 * Constructor
	 * @param o of type String
	 * @param b of type double
	 */
	protected BankAccount(String o, double b) {
		owner=o;
		balance=b;
		number=(int)(Math.random() * 999999) + 100000;
	}
	/**
	 * Constructor with 3 params
	 * @param n of type int
	 * @param o of type String
	 * @param b of type double
	 */
	protected BankAccount(int n, String o, double b) {
		number=n;
		owner=o;
		balance=b;
	}
	/**
	 * Getter method
	 * @return retunrs number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * getter method
	 * @return returns owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * Getter method
	 * @return returns balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * Deposits amount in balance of bank account
	 * @param amount of type double to be deposited
	 */
	public void deposit(double amount) {
		balance+=amount;
	}
	/**
	 * Withdraws amount in balance of bank account
	 * @param amount of type double to be withdrawn
	 */
	public boolean withdraw(double amount) {
		if(balance>amount) {
			balance-=amount;
			return true;
		}
		return false;
	}
	
	/**
	 * Comapers two account number for equality 
	 * @retrun returns a boolean value
	 */
	public boolean equals(Object obj) {
		BankAccount obj1 = (BankAccount)obj;
		if (obj1.getNumber()==getNumber() ) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * compares two bank account balances
	 * @return returns an iteger to define the comparison
	 */
	public int compareTo(BankAccount ba) {
		if(getBalance()==ba.getBalance()) {
			return 0;
		}
		else if(getBalance() > ba.getBalance()) {
			return 1;
		}
		else
			return -1;
		
	}
	/**
	 * abstract method pass
	 * @param filter: type filter
	 * no return value
	 */  
	public abstract boolean pass(String filter);
	
	public String toString() {
		return String.format("%-15d\t%-20s\t%-8.2f",getNumber(),getOwner(),
				getBalance());
	}
	

}
