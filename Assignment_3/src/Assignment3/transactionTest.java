//Darragh O'Connell (17371056)
package Assignment3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class transactionTest {

	static FileOutputStream fileOutputStream = null;
	static ObjectOutputStream objectOutputStream = null;
	static Transaction[] transactionArray = new Transaction[10];							//Array of transactions
	static Transaction[] transactionArray2 = new Transaction[10];							//Array of transactions after serialization
	
	public static void main(String args[]) throws IOException {
	
	Transaction transaction1 = new Transaction("16/08/2019", "Open Account", 100.0);		//Creating Transactions
	Transaction transaction2 = new Transaction("22/08/2019", "Withdraw", 50.0);
	Transaction transaction3 = new Transaction("23/09/2019", "Deposit", 100.0);
	transactionArray[0]= transaction1;														//Adding Transactions to transaction array
	transactionArray[1]= transaction2;
	transactionArray[2]= transaction3;

	Arrayserialize(transactionArray);														//Serialize Transaction Array
	Transactionsdeserialize();																//Deserialize Transaction Array and print out array to console
	
	BankAccount account1 = new BankAccount("16/08/2017", "Josh Jacobs", 100, 1000);			//Create Bank Account 
	account1.withdraw("22/08/2019", 200);													//Add transactions to Bank account 
	account1.deposit("23/08/2019", 100);
	account1.withdraw("01/09/2019", 50);
	serialize(account1);																	//Serialize Bank Account object
	Accountdeserialize();																	//Deserialize Bank Account object
	
	String output = Transaction.output;
	String transactiondetails = BankAccount.transactiondetails;
	JOptionPane.showMessageDialog(null, output, "All Transactions", JOptionPane.INFORMATION_MESSAGE); // creating dialog box of payroll information
	JOptionPane.showMessageDialog(null, transactiondetails, "Account Details", JOptionPane.INFORMATION_MESSAGE); // creating dialog box of payroll information
	
	//Part 3 of assignment 
	
	PrintWriter writer = new PrintWriter("AssignmentFile.txt", "UTF-8");										//Creating .txt file
	writer.println("Would you like to increase your overdraft? Please type Yes/No at the end of the line.");	//Filling .txt file
	writer.close();
	
		filePrint(); 																								//Print unappended file
	
	Scanner input = new Scanner(System.in);																		//Take in User input
    String userInput = input.nextLine();

    RandomAccessFile fileWriter = new RandomAccessFile("AssignmentFile.txt", "rw");								//writing user input to .txt file 
    fileWriter.seek(fileWriter.length());
    fileWriter.writeUTF(userInput);
    fileWriter.close();
   
    	filePrint();																								//Print appended file
  
	System.exit(0);

	}
	
	public static void Arrayserialize (Transaction[] array) throws IOException {								//Method to Serialize an Array
		fileOutputStream = new FileOutputStream ("transactions.bin");
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(array);
		objectOutputStream.close();
		fileOutputStream.close();
		
	}
	
	public static void serialize (BankAccount bankAccount) throws IOException {									//Method to Serialize a Bank Account Object
		fileOutputStream = new FileOutputStream ("accountdetails.bin");
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(bankAccount);
		objectOutputStream.close();
		fileOutputStream.close();
		
	}
	
	public static void Transactionsdeserialize() throws IOException {											//Method to Deserialize an Array 
	
	        try
	        {
	            FileInputStream fis = new FileInputStream("transactions.bin");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            transactionArray2 = (Transaction[]) ois.readObject();
	            ois.close();
	            fis.close();
	        }
	        catch (IOException ioe){
	            ioe.printStackTrace();
	            return;
	        }
	        catch (ClassNotFoundException c){
	            System.out.println("Class not found");
	            c.printStackTrace();
	            return;}
	         
	        	System.out.println("--Deserialized transactin array--");
	            System.out.println(transactionArray2[0].toString());											//Print out array to console
	}
	
	public static void Accountdeserialize() throws IOException { 												//Method to Deserialize a Bank Account object
        try
        {
            FileInputStream fis = new FileInputStream("accountdetails.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            BankAccount account = (BankAccount) ois.readObject();
            ois.close();
            fis.close();
            System.out.println(account.toString());																//Print out Deserialized Bank Account object
        }
        catch (IOException ioe){
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;}
    	
	}
	
	public static void filePrint() throws IOException {
		InputStream input = new BufferedInputStream(new FileInputStream("AssignmentFile.txt")); 					//Method for printing .txt file to console
		byte[] buffer = new byte[8192];

		try {
		    for (int length = 0; (length = input.read(buffer)) != -1;) {
		        System.out.write(buffer, 0, length);
		    }
		} finally {
		    input.close();
		}
	}
}
