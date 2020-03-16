//Darragh O'Connell 17371056
package Assignment_7;

public class Server extends Thread{											//Server class
	private String name;													//String for servers name
	private int total, Pizza, FishnChips, CheeseBurger;						//Int to track number of orders served by each server
	String output_String;													//String used to print information to console
	
	public Server( String name) {													
		this.name = name;
	
	}
	
	public void total(String order) {										//Reads through orders Queue and adds to INT value that item for this server
		total++;
		String[] X;
		X = order.split(" ");
		switch(X[0]) {
		case "fish":
			FishnChips++;
			break;
		case "neapolitan":
			Pizza++;
			break;
		case "cheese":
			CheeseBurger++;
			break;
		}
	}
	
	public void run() {
		
		while (Restaurant.prepared_Items.size()>0 || Restaurant.ordered_Items.size()>0) {			//While there is items in the Ordered or Prepared Queue this code will run
			Restaurant.control_lock.lock();															//reentrant lock is locked
			
			try {
			if(Restaurant.Ready == true && Restaurant.prepared_Items.size()>0) {					//If there is a prepared item to be served the following code will be ran
				output_String = Restaurant.prepared_Items.poll();									//Retrieves head of the Prepared Items queue
				System.out.println("Server " + name + " is serving " + output_String);				//Print out information of servers actions
			
				total(output_String);																//Calls total method and passes output_string 
				Restaurant.Ready = false;															//set Ready to serve variable to false 
				sleep(50);																			//Delays for 10 milliseconds
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			finally {
				Restaurant.control_lock.unlock();													//Reentrant lock unlocked
			}
		}
		System.out.println(toString());																//when all items are served print server toString						

	}
	
	public String toString() {
		return "Server "+ name + " has finished serving "+ total+ " orders, including "+ CheeseBurger + " burgers, "+ Pizza + " pizzas and "+ FishnChips +" fish and chips";
	}

}


