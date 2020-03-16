//Darragh O'Connell (17371056)
package Assignment_4;
public enum Ball {								//Creating the Ball enum , storing the weight and diameter of each
	BASEBALL(149, 73), 
    BASKETBALL(624, 239), 
    FOOTBALL(450 , 216), 
    GOLF(46, 43), 
    POOL(156, 60),
    SOFTBALL(180, 97),
    TENNIS(59, 64), 
    VOLLEYBALL(260, 218);
	
  private int weight;							//creating integers to store weight and diameter of each Ball
  private int diameter;
  
  Ball(final int weight) {
	  this.weight = weight;
  }
  Ball(final int weight, final int diameter) {
	  this(weight);
	  this.diameter = diameter;
  }
  public int getWeight() {						//getter method for Weight
  return weight;
  }
  public int getdiameter() {					//getter method for diameter
  return diameter;
  }
  
  public double getCircumfrance(Ball ball) {	//Method to calculate ball circumference
	  double calDiameter, circumfrence = 0;
	  calDiameter = ball.diameter;
	  //Circumference = 2(Pi)*Radius of ball
	  circumfrence = 2*(3.1416)*(calDiameter/2);
	  return circumfrence;
  }
  
  public double getVolume(Ball ball) {			//Method to calculate ball volume
	  double calDiameter=0;
	  double volume = 0;
	  calDiameter = ball.diameter;
	  //Diameter = (4/3)*Pi*r^3
	  volume = (((3.1416)*(Math.pow(calDiameter/2, 3))*4)/3);
	  return volume;
  }
  
  
  public String info(Ball ball) {
	  String infoString = "";
	 infoString += ball.name() + "\t" + ball.weight + "g \t" + ball.diameter + "mm ";
	
	  return infoString;
  }
}