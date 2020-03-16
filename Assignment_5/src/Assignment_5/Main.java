//Darragh O'Connell 17371056
package Assignment_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main{
	public static ArrayList<Inventory> inventoryList  = new ArrayList<Inventory>();			//Creating Inventory ArrayList
	public static ArrayList<Inventory> ShoppingCart1Array  = new ArrayList<Inventory>();	//Creating Shopping Cart ArrayLists
	public static ArrayList<Inventory> ShoppingCart2Array  = new ArrayList<Inventory>();
	
	public static void main(String[] args) {
		
		inventoryList.add(new Inventory("1000", "Apple", 30, 2.50));						//Populating Inventory ArrayList
		inventoryList.add(new Inventory("1001", "Orange", 40, 2));
		inventoryList.add(new Inventory("2001", "Milk", 10, 2.39));
		inventoryList.add(new Inventory("2002", "Orange Juice", 20, 1.99));
		inventoryList.add(new Inventory("3001", "Blue Cheese", 10, 2.25));	
		inventoryList.add(new Inventory("3002", "Cheddar", 20, 2.79));
		inventoryList.add(new Inventory("4001", "Chocolate", 40, 2.99));
		inventoryList.add(new Inventory("4002", "Candy", 30, 0.99));
		inventoryList.add(new Inventory("5001", "Beef", 10, 5.00));
		inventoryList.add(new Inventory("5002", "Chicken", 10, 4.00));
		System.out.println("-----------Inventory----------" + "\n" +"SKU	 ItemName  Price   Quantity ");
		System.out.println(inventoryList.toString()); 										//print Inventory
		
		ShoppingCart Cart_1 = new ShoppingCart("Mark", "13-10-2017");						//Creating ShoppingCart objects
		ShoppingCart Cart_2 = new ShoppingCart("John", "02-02-2018");
		
		Cart_1.addItem("1000","Apple", 2, ShoppingCart1Array);								//Adding items to Cart_1
		Cart_1.addItem("1001", "Orange", 5, ShoppingCart1Array);
		Cart_1.addItem("2001","Milk", 2, ShoppingCart1Array);
		Cart_1.addItem("3001", "Blue Cheese", 4, ShoppingCart1Array);
		Cart_1.addItem("4002", "Candy", 25,ShoppingCart1Array);
		Cart_1.removeItem("4002", "Candy", 5, ShoppingCart1Array);							//Removing item from Cart_1

		String list1 = Cart_1.viewCart(ShoppingCart1Array);									//Print Cart_1
		System.out.println("-----Cart1------\n" + list1);
		
		System.out.println("\n-----------Inventory----------" + "\n" +"SKU	 ItemName  Price   Quantity ");		
		System.out.println(Main.inventoryList.toString());				
	
		Cart_2.addItem("1000", "Apple", 2, ShoppingCart2Array);
		Cart_2.addItem("1001", "Orange", 5, ShoppingCart2Array);
		Cart_2.addItem("2001" ,"Milk", 2, ShoppingCart2Array);
		Cart_2.addItem("3001", "Blue Cheese", 4, ShoppingCart2Array);
		Cart_2.addItem("3002" , "Cheddar", 3, ShoppingCart2Array);
		Cart_2.addItem("5001" ,"Beef", 6, ShoppingCart2Array);
		Cart_2.addItem("4002" , "Candy", 20, ShoppingCart2Array);
		Cart_2.addItem("4001","Chocolate", 10, ShoppingCart2Array);
		Cart_2.addItem("5002", "Chicken", 2, ShoppingCart2Array);
		Cart_2.removeItem("4001" , "Chocolate", 5, ShoppingCart2Array);
		Cart_2.removeItem("3001" , "Blue Cheese", 1, ShoppingCart2Array);
		
		String list2 = Cart_2.viewCart(ShoppingCart2Array);									//Print Cart_2
		System.out.println("-----Cart2------\n" + list2);
		
	
		Collections.sort(ShoppingCart2Array, new Comparator<Inventory>() {					//Arranging Cart_2 in ascending order
			public int compare(Inventory w, Inventory z) {
				double x = w.getTotalPrice();
				double y = z.getTotalPrice();
				return ((Double)x).compareTo((Double)y);
			}
		});
		
		
		String list3 = Cart_2.viewCart(ShoppingCart2Array);									//Printing Ordered Cart_2
		System.out.println("----Ordered List by Price------\n" + list3);
		
		System.out.println("\n-----------Inventory----------" + "\n" +"SKU	 ItemName  Price   Quantity ");		
		System.out.println(Main.inventoryList.toString());									//Reprinting Inventory

	}


}
