//Darragh O'Connell 17371056
package Assignment_7;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant { 
	
	private static String file_line;												//string used to read through txt file line by line
	private static String[] x;														//string used in switch case 
	public static boolean Ready = false;											//Ready to serve variable
	public static Queue <String> ordered_Items = new LinkedList<>();				//list to hold information on Orders
	public static Queue <String> prepared_Items =new LinkedList<>();				//list to hold information on Prepared orders
	public static ReentrantLock control_lock =  new ReentrantLock(true);			//Creating Reentrant Lock  

	
	public static void main(String[] args) throws Exception {
		
		File input_file = new File("orderList.txt");								//creating file to hold random access file information 
		RandomAccessFile RAF = new RandomAccessFile(input_file, "r");				//creating new RandomAccessFile to read in order information txt file
		
		while ((file_line = RAF.readLine()) != null) {								
		file_line = file_line.toLowerCase();										//changes all txt file to lower case
		x = file_line.split(" ");													//reads orderList txt file line by line
		
		switch(x[0]) {																//Adds all orders in Txt file to orders Queue  
		case "fish":
			ordered_Items.add(file_line);
			break;
		case "neapolitan":
			ordered_Items.add(file_line);
			break;
		case "cheese":
			ordered_Items.add(file_line);
			break;
			default:
				
				break;
		}
		
		}
		RAF.close();																//Closing RandomAccessFile													
		
		Server Katie = new Server( "Katie");										//Creating Servers
		Server Andrew = new Server("Andrew");
		Server Emily = new Server("Emily");
		Chef john = new Chef("John");												//Creating Chefs
		Chef Mark = new Chef("Mark");

		john.start();																//Starting Threads for each server and chef
		Mark.start();
		Katie.start();
		Andrew.start();
		Emily.start();
		}
}