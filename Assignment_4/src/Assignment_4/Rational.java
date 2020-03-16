//Darragh O'Connell (17371056)
package Assignment_4;
import java.text.DecimalFormat;

public class Rational {
	private double Num1, Num2;
	DecimalFormat deciamlPrecision = new DecimalFormat("0.00");
	
	public Rational(double Num1, double Num2) {
		this.Num1 = Num1;
		this.Num2 = Num2;
			
	}
	public double getNum1() {							//getter methods for each number taken in to the Rational class
		return Num1;
	}
	public double getNum2() {
		return Num2;
	}
	
	public String simplify() {										//Method to simplify the rational number to its lowest form
		for(double x = Num1; x > 1; x--) {
			if(Num1%x == 0) {
				if(Num2%x == 0) {
					if(Num2/x == 1) {
						return String.valueOf((int)(Num1/x));
				}
					return (int)(Num1/x) + "/" + (int)(Num2/x);		
				}
			}
		}
		return (int)(Num1) + "/" + (int)(Num2);						//Returns lowest form of the rational number
	}
	
	//Below are the Multiply, Divide, Plus and Minus methods for this rational class
	
	public void Multiply(Rational Multiply) {
		String multiplyOutput = "(" + (int)Num1 + "/" + (int)Num2 + ")" + "*" +  "(" + (int)Multiply.getNum1() + "/" + (int)Multiply.getNum2() + ") = " ; //Creating initial Calculation string
		
		Rational result = new Rational(Num1 * Multiply.getNum1(), Num2 * Multiply.getNum2());						//Creating Rational object for calculations
		System.out.println(multiplyOutput  + result); 																//Print out initial calculation + simplified faction + decimal result of calculation
	}
	
	public void Divide(Rational Divide) {
		String divideOutput = "(" + (int)Num1 + "/" + (int)Num2 + ")" + "/" +  "(" + (int)Divide.getNum1() + "/" + (int)Divide.getNum2() + ") = " ;		//Creating initial Calculation string		
		
		Rational result = new Rational(Num1 * Divide.getNum2(), Num2 * Divide.getNum1());							//Creating Rational object for calculations
		System.out.println(divideOutput + result);																	//Print out initial calculation + simplified faction + decimal result of calculation
	}
		
	public void Plus(Rational Plus) {
		String plusOutput = "(" + (int)Num1 + "/" + (int)Num2 + ")" + "+" +  "(" + (int)Plus.getNum1() + "/" + (int)Plus.getNum2() + ") = " ;			//Creating initial Calculation string
		
		Rational result = new Rational(Num1 * Plus.getNum2() + Plus.getNum1() * Num2, Num2 * Plus.getNum2());		//Creating Rational object for calculations
		System.out.println(plusOutput + result);																	//Print out initial calculation + simplified faction + decimal result of calculation
	}
	
	public void Minus(Rational Minus) {
		String minusOutput = "(" + (int)Num1 + "/" + (int)Num2 + ")" + "-" +  "(" + (int)Minus.getNum1() + "/" + (int)Minus.getNum2() + ") = " ;		//Creating initial Calculation string
		
		Rational result = new Rational(Num1 * Minus.getNum2() - Minus.getNum1() * Num2, Num2 * Minus.getNum2());	//Creating Rational object for calculations
		System.out.println(minusOutput + result);																	//Print out initial calculation + simplified faction + decimal result of calculation
	}
	

	public String toString() {
		return simplify() + " = " + deciamlPrecision.format(Num1/Num2);			//print out lowest form of the rational number followed by the decimal form of the number					
	}
}
