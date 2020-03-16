 // Darragh O'Connell (17371056)
 import java.awt.*;
 import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


 public class GUIAssignment extends JFrame implements ItemListener {
	 																//Declarations of variables to be used
private JToggleButton On_Off, Info;									//Toggle Buttons				
private JRadioButton Manual, Timed;									//Radio Buttons
private JSlider Colour_Slider;										//Slider
private Color Colour1, Colour2, Colour3, Colour4;					//Colour options
private Container Main_Container;									//Container
private JButton Light;												//Button to act as light
private ButtonGroup Buttons;										//Button group (Timed and Manual buttons)


public GUIAssignment() {
	
	super("Assignment 5 Light Panel");
	
	Light = new JButton();
	Light.setBackground(Color.black);
	Light.setPreferredSize(new Dimension(50,50));							//Create Light
	
	Info = new JToggleButton("Light Info");									//Shows status of light in a separate window
	On_Off = new JToggleButton("On/Off");									//turns the light on and off
	Manual = new JRadioButton("Manual Mode", true);							//sets mode of light
	Timed = new JRadioButton("Timer Mode", false);
	Buttons = new ButtonGroup();											//Creating button Group
	Buttons.add(Manual);													//Adding items to button group
	Buttons.add(Timed);
	
	Main_Container = getContentPane();										//Creating container 
	Main_Container.setLayout(new FlowLayout());								//Setting Layout to flowlayout
	
	Main_Container.add(Info);												//Adding items to the Container
	Main_Container.add(On_Off);	
	Main_Container.add(Manual);
	Main_Container.add(Timed);
	Main_Container.add(Light);
	
	 setSize(500, 200);														//Setting size of Container
	 setVisible(true);
	
	 ButtonHandler Infohandler = new ButtonHandler();							//Creating button handler for Info button
	 ButtonHandler2 Modehandler = new ButtonHandler2();							//Creating button handler for Mode buttons
	 
	 Info.addActionListener( Infohandler ); 									//adding action listener to info button
	 Timed.addActionListener( Modehandler );									//adding action listener to Timed button
	 Manual.addActionListener( Modehandler );									//adding action listener to Manual button
	 
	 On_Off.addItemListener(this);											//adding event handle for On_Off button On Button
	 
	 Colour_Slider = new JSlider(SwingConstants.HORIZONTAL,0,4,0);			//Creating JSlider to select Light level
	 Colour_Slider.setMajorTickSpacing(1);									
	 Colour_Slider.setPaintTicks(true);
	 Colour_Slider.setPaintLabels(true);
	 
	 Main_Container.add(Colour_Slider);
	 Colour1 = new Color(255,255,153);										//Creating colour levels for slider
	 Colour2 = new Color(255,244,153);
	 Colour3 = new Color(255,233,153);
	 Colour4 = new Color(255,222,153);
	 
	 Colour_Slider.addChangeListener(										//Creating change listener for slider, allows the colour selected on the slider to appear on the light
			 new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
				if(On_Off.isSelected()) {									//Light must be turned on before any adjustments are made by the slider
					if(Colour_Slider.getValue()==1) {
						Light.setBackground(Colour1);
						System.out.println("\nslider has entered colour level 1\n");}
					
					else if(Colour_Slider.getValue()==2){
						Light.setBackground(Colour2);
						System.out.println("\nslider has entered colour level 2\n");}
					
					else if(Colour_Slider.getValue()==3){
						Light.setBackground(Colour3);
						System.out.println("\nslider has entered colour level 3\n");}
					
					else if(Colour_Slider.getValue()==4){
						Light.setBackground(Colour4);
						System.out.println("\nslider has entered colour level 4\n");}
					else
						Light.setBackground(Color.black);
				}
				else 
					Light.setBackground(Color.black);
			 }
		 }	 
			 
	);
	
	setVisible(true);
}

private class ButtonHandler implements ActionListener {						//Button hander for Info button, created a window that displays the status of the light

	public void actionPerformed( ActionEvent event ) {
		
		if(Info.isSelected()) {
			System.out.println("\nInfo button has been pressed\n");
			String Output = "";												//Strings to track status of Light
			String on_off = "OFF";
			String mode = "Manual";
			String slider_level= "0";
			
				if(On_Off.isSelected())
					on_off = "ON";
		
				if(Timed.isSelected())
					mode = "Timed";
				
				if(Colour_Slider.getValue()==1)
					slider_level = "1";
				
				else if(Colour_Slider.getValue()==2)
					slider_level = "2";
				
				else if(Colour_Slider.getValue()==3)
					slider_level = "3";
				
				else if(Colour_Slider.getValue()==4)
					slider_level = "1";
				
				else if(Colour_Slider.getValue()==0)
					slider_level = "0";
				
				Output = "Light Ststus: " + on_off +"\n\nLighting Mode: " + mode + "\n\nColour from slider: " + slider_level;
				JOptionPane.showMessageDialog(null, Output, "Info on Lighting System", JOptionPane.INFORMATION_MESSAGE);		//prints the status of the light to a JOptionPane window
		     }	
		
		if(Timed.isSelected()) {
			System.out.println("\nLight is in Timed Mode\n");
		}
		if(Manual.isSelected()) {
			System.out.println("\nLight is in Manual mode\n");
		}
	 }
}

private class ButtonHandler2 implements ActionListener {						//Button hander for Mode buttons, created a window that displays the status of the light

	public void actionPerformed( ActionEvent event ) {
	
		if(Timed.isSelected()) {
			System.out.println("\nLight is in Timed Mode\n");
		}
		if(Manual.isSelected()) {
			System.out.println("\nLight is in Manual mode\n");
		}
	 }
}


public void itemStateChanged(ItemEvent e) {									//Event handler for On_Off button
	if(On_Off.isSelected()) {
		System.out.println("\nLight has been turned on\n");
		Light.setBackground(Colour1);
		Colour_Slider.setValue(1);											//Light level set to slider value 1 if turned on
	}
	else { 
		System.out.println("\nLight has been turned off\n");
		Light.setBackground(Color.black);									//If not turned on the light will stay black
		Colour_Slider.setValue(0);
	}
  }


public static void main( String args[] )									
 {
 GUIAssignment application = new GUIAssignment();							//Initializing GUI
 application.setDefaultCloseOperation(
 JFrame.EXIT_ON_CLOSE );
 }

}