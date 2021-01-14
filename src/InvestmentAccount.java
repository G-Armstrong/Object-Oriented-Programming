
public class InvestmentAccount extends BankAccount {
	private String type;
	/**
	 * Default Constructor
	 * @param number of type int
	 * @param owner of type String
	 * @param balance of type double
	 * @param type of type String
	 */
	public InvestmentAccount(int number, String owner, double balance, String type) {
		super(number,owner,balance);
		this.type=type;
	}
	/**
	 * Getter method
	 * @return retunrs type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Setter method
	 * @param t to be assigned to type
	 */
	public void setType(String t) {
		type=t;
	}
	/**
	 * Applies the randomly generated risk to the investment account
	 * @return returns the profit or loss to the account
	 */
	public double applyRisk() {
		double risk = (Math.random() * 1);
		double rate = (Math.random() * 1);
		double profitLoss;
		if (risk > 0.5) {
			profitLoss = balance * rate / 100;
		}
		else {
			profitLoss = - balance * rate / 100;
		}
		balance+=profitLoss;
		return profitLoss;
	}
	/**
	 * Defintion of the abstract pass method
	 */
	public boolean pass(String filter) {
		if(filter.equals("Investment")) {
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
		output = "Investment" + "\t" + super.toString() + "\t" + String.format("%-10s",getType());
		return output;
	}
}
