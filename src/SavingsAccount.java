
public class SavingsAccount extends BankAccount {
	private double yearlyInterest;
	/**
	 * Constructor
	 * @param owner of type String
	 * @param balance of type double
	 * @param rate of type double
	 */
	public SavingsAccount(String owner, double balance, double rate) {
		super(owner,balance);
		yearlyInterest=rate;
	}
	/**
	 * Constructor
	 * @param number of type int
	 * @param owner of type String
	 * @param balance of type double
	 * @param rate of type double
	 */
	public SavingsAccount(int number, String owner, double balance, double rate) {
		super(number,owner,balance);
		yearlyInterest=rate;
	}
	/**
	 * Getter method
	 * @return returns yearlyInterest
	 */
	 public double getInterestRate() {
		 return yearlyInterest;
	 }
	 /**
	  * Setter method
	  * @param ir to be set to yearlyInterest
	  */
	 public void setInterestRate(double ir) {
		 yearlyInterest = ir;
	 }
	 /**
	  * Apply the monthly interest rate to the savings account
	  * @return returns the interest added to the account for the month
	  */
	 public double applyMonthlyInterest() {
		 double interest = (balance * yearlyInterest / 12) / 100;
		 balance+=interest;
		 return interest;
		 
	 }
	 /**
	  * Definition of abstract pass method 
	  */
	 public boolean pass(String filter){
		if(filter=="Savings") {
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
		output = "Savings" + "\t\t" + super.toString() + "\t"+ String.format("%-1.2f",getInterestRate()) + "%";
		return output;
	 }
}
