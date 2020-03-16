//Darragh O'Connell (17371056)
package Assignment3;

import java.io.Serializable;

public class BankAccount implements Serializable{
	
	//creating Local variables
	private String Date, Name, Transaction, DepositDate, WithdrawDate;  				
	private double Balance, Overdraft, Deposit, Withdraw;
	private static int Account_Increment  = 1000;
	private int Account_Number;
	public static String transactiondetails = " ";
	private Transaction[] AccountTransactions = new Transaction[10]; //Array to store Bank Account transactions
	private int x=0; 												// counts number of transactions in a bank account
	
	public BankAccount(String date, String name, double balance, double overdraft){
		Date = date;
		Name = name;
		Balance = balance;
		Overdraft = overdraft;
		
		Account_Increment++;
		Account_Number = Account_Increment;
		transactiondetails += "----New Account Created----\nAccount Number : " + Account_Number + "\nAccount Name : " + name + "\nOpening Date : " + date +"\n Balance : " + Balance; 
	}
	
	public void deposit(String date, double amount) { 								//Method to create Deposit transaction for Bank Account
		DepositDate = date;
		Deposit = amount;
		Balance = Balance + amount;
		Transaction accountTransaction = new Transaction(DepositDate, "Deposit", Deposit);
		AccountTransactions[x]= accountTransaction;
		x++;
		transactiondetails += "\n\n----New Deposit Made----\nDeposit Amount : " + Deposit + "\nDeposit Date : " + DepositDate + "\n Balance : " + Balance;
	}
	 
	public void withdraw(String date, double amount) {								//Method to create Withdrawal transaction for Bank Account
		WithdrawDate = date;
		Withdraw = amount;
		if(Withdraw <= Balance) { 													//If amount to withdraw is greater than balance, withdrawal can not be processed
			Balance = Balance - amount;
			Transaction accountTransaction = new Transaction(WithdrawDate, "Withdrawl", Withdraw);
			AccountTransactions[x]= accountTransaction;
			x++;
			transactiondetails += "\n\n----New Withdraw Made----\nWithdraw Amount : " + Withdraw + "\nWithdraw Date : " + WithdrawDate + "\n Balance : " + Balance;
		}
		else 
			System.out.println("Insufficent Funds");
			
	}
	public String getTransactionDetail() {											//Returns details of transactions made in a Bank Account
		return transactiondetails;
		
	}
	
	public String toString() {								
		return getTransactionDetail();
	}
}
