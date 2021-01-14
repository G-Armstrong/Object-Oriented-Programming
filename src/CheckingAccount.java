
public class CheckingAccount extends BankAccount {
	/**
	 * Constructor
	 * @param ownerof type String
	 * @param balance of type double
	 */
	public CheckingAccount(String owner, double balance) {
		super(owner,balance);
	}
	/**
	 * Constructor
	 * @param number of type int
	 * @param owner of type String
	 * @param balance of type double
	 */
	public CheckingAccount(int number, String owner, double balance) {
		super(number,owner,balance);
	}
	/**
	 * Definition of pass abstract method
	 */
	public boolean pass(String filter) {
		if(filter=="Checking") {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Returns formatted output
	 */
	public String toString() {
		String output;
		output = "Checking" + "\t" + super.toString();
		return output;
	}
}
