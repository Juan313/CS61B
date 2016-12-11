package sortedlist;

public class BadTransactionException extends Exception {
	private int widrMoney;
	public BadTransactionException (int widrMoney){
		super("Invalid withdraw number: " + widrMoney);
		this.widrMoney=widrMoney;
	}

}
