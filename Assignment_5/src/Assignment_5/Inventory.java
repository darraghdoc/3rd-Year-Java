//Darragh O'Connell 17371056
package Assignment_5;

public class Inventory {
	
	private double price;														//initializing variables
	private int quantity;
	private String itemName, sku; 
	
	public Inventory(String sku, String itemName,  int quantity, double price) { //Inventory Constructor
		this.sku=sku;
		this.itemName = itemName;
		this.price = price;
		this.quantity= quantity;
		
	}
	//Getter/toString Methods
	
	public String skutoString() {
		return sku;
	}
	
	public String itemNametoString() {
		return itemName;
	}
	
	public double pricetoString() {
		return price;
		}
	
	public int quantitytoString() {
		return quantity;
	}
	
	public double getTotalPrice() {
		return quantity*price;
	}
	
	public String toString() {
		String output = "";
		output += sku + "\t" + itemName + "\t" + price+ "\t" + quantity + "\t\n";
		return output;
	}
	
	//Setter Methods
	public void setPrice(int y)
	{
		price = y;
	}
	
	public void setQuantity(int z)
	{
		quantity = z;
	}
}
	
