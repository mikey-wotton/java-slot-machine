/**
 * User's information will be stored in here, including name and balance
 */

/**
 * @author mikey.wotton
 *
 */
public class AccountDetails {
	private String username = "";
	private double balance = 0.0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public AccountDetails(String uname, double dollar){
		this.username = uname;
		this.balance = dollar;
	}
	public void updateBalance(double amount){
		balance += amount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
