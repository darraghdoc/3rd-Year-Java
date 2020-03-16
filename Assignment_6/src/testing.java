import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class  testing extends JFrame {

private static JToggleButton lightSwitch;
private JRadioButton manButton;
private JRadioButton timButton;
private JList levelList;
private JButton statButton;

private String lightLevel[] = { "Off", "Level 1", "Level 2", "Level 3", "Level 4" };
private Color colors[] = { Color.black, Color.DARK_GRAY, Color.gray, Color.lightGray, Color.white };

public testing() { // constructor method

 // light switch

 lightSwitch = new JToggleButton("Check this box to flick the light switch");
 manButton = new JRadioButton("Manual");
 timButton = new JRadioButton("Timer");

 Container container = getContentPane();
 container.setLayout(new FlowLayout());

 container.add(lightSwitch);
 container.add(manButton);
 container.add(timButton);

 ToggleButtonHandler handler = new ToggleButtonHandler();
 lightSwitch.addActionListener(handler);

 RadioButtonHandler timHandler = new RadioButtonHandler();
 timButton.addActionListener(timHandler);

 RadioButtonHandler manHandler = new RadioButtonHandler();
 manButton.addActionListener(manHandler);

 setSize(450, 450);
 setVisible(true);

 // light dimmer

 Container listContainer = getContentPane();
 listContainer.setLayout(new FlowLayout());

 levelList = new JList(lightLevel);
 levelList.setVisibleRowCount(5);

 levelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 listContainer.add(new JScrollPane(levelList));

 JListHandler listHandler = new JListHandler();
 levelList.addListSelectionListener(listHandler);

 setSize(350, 150);
 setVisible(true);

 // method to change colours of the panel
 levelList.addListSelectionListener(new ListSelectionListener() {

  public void valueChanged(ListSelectionEvent e) {
   listContainer.setBackground(colors[levelList.getSelectedIndex()]);
  }

 }

 );

 
 // status button declaration
 statButton = new JButton("Current status");
 container.add(statButton);

}

/*
 * public boolean getManual() { return m }
 *
 * public getTimer() { return timButton; }
 *
 */

/*public static void main(String[] args) { // main method to run

 testing app = new testing();
 app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 testing listApp = new testing();
 listApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}*/

private class ToggleButtonHandler implements ActionListener {

 public void actionPerformed(ActionEvent e) {
  JOptionPane.showMessageDialog(null, "You flicked the light switch");
 }
}

public class JListHandler implements ListSelectionListener {

 public void valueChanged(ListSelectionEvent l) {

  // JOptionPane.showMessageDialog(null, "You set the light switch to");

 }
}

public class RadioButtonHandler implements ActionListener {

 public void actionPerformed(ActionEvent e) {

  /*
   * if (e.getSource() == manButton) { JOptionPane.showMessageDialog(null,
   * "Manual setting is on.");
   *
   * }
   *
   * else if (e.getSource() == timButton) { JOptionPane.showMessageDialog(null,
   * "Timer setting is on."); }
   */

 }

}

}