//Darragh O'Connell (17371056)
package Assignment3;

import java.io.Serializable;

public class Transaction implements Serializable {
	
	//Creating local variables
	private String Date = "";
	private String Type;
	private double Amount;
	private static int Transaction_Increment = 100;
	private int Transaction_Number ;
	public static String output = " ";

	public Transaction(String date, String type, double amount) {
	Date = date;
	Type = type;
	Amount = amount;
	Transaction_Increment++;													//creating Transaction Number
	Transaction_Number = Transaction_Increment;
	
	output += "Transaction Number: " + Transaction_Number + "\n Transaction Type: " + Type + "\n Transaction Date: " + Date + "\n Transaction Amount: " + Amount + "\n\n"  ;
	}
	
	public String toString() {
		return output;
	}
}