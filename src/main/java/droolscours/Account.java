package droolscours;

public class Account {
	private long accountno;
	private double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public  Account(int accountno, int balance) {
		super();
		this.accountno = accountno;
		this.balance = balance;
	}
	
	
	
	public long getAccountno() {
		return accountno;
	}
	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", balance=" + balance + "]";
	}
	
}
