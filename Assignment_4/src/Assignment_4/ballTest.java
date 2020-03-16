//Darragh O'Connell (17371056)
package Assignment_4;
public class ballTest {

	public static void main(String[] args) {
		//create an array of of all the balls in the enum 
		Ball[] Balls = new Ball[]{Ball.BASEBALL, Ball.BASKETBALL, Ball.FOOTBALL, Ball.GOLF, Ball.POOL, Ball.SOFTBALL, Ball.TENNIS, Ball.VOLLEYBALL};
		
		for(int x = 0 ; x < Balls.length ; x++ )
			System.out.println(Balls[x].info(Balls[x]));			//loop through the array of enum balls and print out weight and diameter of each
		
		System.out.println("\nThe circumferent of a golf = " + Balls[3].getCircumfrance(Balls[3]) + "mm");			//print circumference of golf ball
		System.out.println("\nThe volume of a baseball = " + Balls[0].getVolume(Balls[0]) + "mm^3 \n");				//print volume of baseball
	
	
		Rational r1 = new Rational(Balls[0].getWeight(), Balls[1].getWeight());										//creating rational numbers r1-r5 for calculations 
		Rational r2 = new Rational(Balls[2].getWeight(), Balls[3].getWeight());
		Rational r3 = new Rational(Balls[4].getdiameter(), Balls[5].getdiameter());
		Rational r4 = new Rational(Balls[6].getdiameter(), Balls[7].getdiameter());
		Rational r5 = new Rational(15,40);
		
		System.out.println("15/40 = " + r5);			//Performing calculations using the rational methods and printing results
		r1.Plus(r2);
		r2.Minus(r3);
		r3.Multiply(r4);
		r4.Divide(r1);
		
	}
}
