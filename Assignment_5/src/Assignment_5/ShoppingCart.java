//Darragh O'Connell 17371056
package Assignment_5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.math.RoundingMode;


public class ShoppingCart {
	
	private static DecimalFormat format = new DecimalFormat("#.##");
	 
	private String customerName, date;
	public static ArrayList<Inventory> ShoppingCartArray  = new ArrayList<Inventory>();
	
	public ShoppingCart(String customerName, String date) {
		this.customerName=customerName;
		this.date=date;
	}
	
	public static int searchInventory(String sku) 							//Binary Search to find item in the Inventory Array
	{	
		String item;														//Initializing Mid, Low and High values for Binary Search 
		int ValLow = 0, ValMid;					 
	    int ValHigh = Main.inventoryList.size() - 1; 		
	    
	    while (ValLow <= ValHigh)
	    {
	        ValMid = (ValLow + ValHigh) / 2;								//Setting Middle value for Binary Search
	        item = Main.inventoryList.get(ValMid).skutoString();            //Getting SKU of mid value
	       
	        if (item.compareTo(sku) < 0)									//comparing Mid value SKU to SKU to be found
	        {
	            ValLow = ValMid + 1;										//Adjust Value LOW
	        } 
	        else if (item.compareTo(sku) > 0) 								//compare Mid SKU to SKU of item to be found
	        {
	            ValHigh = ValMid - 1;										//Adjust Value HIGH
	        } 
	        else
	        {
	            return ValMid;												//SKU is now = value MID 
	        }
	    }
	    return -1;															//if not found, return -1
	}
	
	public void addItem(String sku, String itemName, int quantity, ArrayList<Inventory> Array)		//method to add item to ShoppingCart
	{
		int i = searchInventory(sku); 																//The inventory ArrayList will be searched for this Item
		
		if (i == -1) 														
		{
			System.out.printf("\n Item not Found \n");												//if item is not in the ArrayList print this 
		}
		else
		{
			if ( Main.inventoryList.get(i).quantitytoString() >= quantity)							//quantity being added to the cart is less than or equal to the quantity remaining in the inventory
			{
				Inventory invItem =  Main.inventoryList.get(i); 									//set invItem to the Item i in inventory
				Inventory newItem = new Inventory(invItem.skutoString(), invItem.itemNametoString(), quantity, invItem.pricetoString()); // Copy of Item to be added to ShoppingCart with desired quantity
				invItem.setQuantity(Main.inventoryList.get(i).quantitytoString() - quantity);		// Set quantity of item in inventory to the current quantity minus the quantity being added to the cart
				Array.add(newItem);																	// add the new item to the Shopping Cart Array
			}
			else if (Main.inventoryList.get(i).quantitytoString() == 0) 							// Quantity of item in inventory is 0
			{
				System.out.printf(" \"%s\" is not available\n\n", itemName);
			}
			else 																					// Quantity in Inventory < quantity to be added to the cart
			{
				Inventory invItem =  Main.inventoryList.get(i);										//set invItem to the Item i in inventory	
				System.out.printf("There is only %d \"%s\" in stock\n\n", invItem.quantitytoString(), itemName);
				Inventory newItem = new Inventory(invItem.skutoString(), invItem.itemNametoString(), invItem.quantitytoString(), invItem.pricetoString());
				invItem.setQuantity(0);																// Set quantity to 0 because all remaining items of this type have been removed
				Array.add(newItem);																	// add remaining items of this type to Shopping Cart
			}
		}
	}
		

		public void removeItem(String sku,String itemName, int quantity, ArrayList<Inventory> Array)		//Method to remove item from Cart and add it back into inventory
		{
			int j = searchInventory(sku);																	//The inventory ArrayList will be searched for this Item
			Inventory newItem = new Inventory("", "", 0000, 0.0);											//create empty inventory Item
			
			if (j == -1) 																					// If item is not found in Inventory
			{
				System.out.println("Item not available"); 
			}
			else 
			{
				Inventory inventoryItem = Main.inventoryList.get(j);										//set inventoryItem to the Item j in inventory
				inventoryItem.setQuantity(inventoryItem.quantitytoString() + quantity);						// update quantity of this item in inventory

				for (Inventory b : Array)																	//find item in shopping cart and adjust its quantity
				{
					if (sku.equals(b.skutoString()))
					{
						newItem = b;
						break;
					}
				}
				
				if ((newItem.quantitytoString() - quantity) == 0)											// full quantity is being removed
				{
					Array.remove(newItem);
				}
				else																						//Modify quantity in cart
				{
					newItem.setQuantity(newItem.quantitytoString() - quantity);
				}
			}
		}
	
		public String viewCart(ArrayList<Inventory> Array)													//Method to print out contents of cart and print total price in Cart
		{
			double TotalCost = 0;
			String Output_Cart = "Name: " + customerName + " Date: " + date + "\n" + "SKU     Item Name  TotalPrice \n";
			for (Inventory i : Array)																		//Loop through shopping cart
			{
				TotalCost += (i.pricetoString()*i.quantitytoString());										//Price x quantity
				Output_Cart += i.skutoString() + "\t" + i.itemNametoString() + "\t" +"€" + i.getTotalPrice() +"\n";														//print Information on each item in Cart
			}
			
			Output_Cart += "Cost:  €" + format.format(TotalCost) + "\n";									//print total cost in cart
			return Output_Cart;
		}
		
}

