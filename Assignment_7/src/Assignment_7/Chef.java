//Darragh O'Connell 17371056
package Assignment_7;

public class Chef extends Thread{											//Chef class
	
	private String name;													//String for servers name
	private int total, Pizza, FishnChips, CheeseBurger;						//Int to track number of orders served by each server
	String output_String;													//String used to print information to console
	
	public Chef( String name) {
		
		this.name = name;
	}
	
	public void total(String order) {
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
		
		while (Restaurant.ordered_Items.size()>0) {															//While there is items in the Ordered or Prepared Queue this code will run								
			Restaurant.control_lock.lock();																	//reentrant lock is locked
			try {
			if(Restaurant.Ready == false && Restaurant.ordered_Items.size()>0) {							//If there is a Ordered item to be prepared the following code will be ran
				output_String = Restaurant.ordered_Items.poll();											//Retrieves head of the Ordered Items queue
				System.out.println("Chef " + name + " is preparing " + output_String);						//Print out information of the chefs actions
				
				total(output_String);																		//Calls total method and passes output_string
				Restaurant.prepared_Items.add(output_String);												//adding current item to the prepared items queue
				
				Restaurant.Ready = true;																	//setting Ready to serve variable to true
				sleep(50);																					//10 millisecond delay
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			finally {
				
				Restaurant.control_lock.unlock();															//reentrant lock unlocked
			}
		}
		System.out.println(toString());																		//when all items have been prepared print chef tostring to console
	}
	
	public String toString() {
		return "Chef "+ name + " has finished preparing "+ total+ " including "+ CheeseBurger + " burgers, "+ Pizza + " pizzas and "+ FishnChips +" fish and chips";
	}

	
	
	}

