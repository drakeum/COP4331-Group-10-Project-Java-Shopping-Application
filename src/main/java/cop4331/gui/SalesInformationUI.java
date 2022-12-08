package cop4331.gui;

import cop4331.client.StoreInfo;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;


/**
Display Information on cost, revenue, sales, and profits.
 * @author Cesaire
 */

public class SalesInformation  {

 
 public static void main(String[] args){

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    frame.setSize(1000, 1000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(panel);

    panel.setLayout(null);

    JLabel label = new JLabel("Sales Information");
    label.setFont(new Font("Verdana", Font.PLAIN, 25));
    label.setBounds(380, 5, 350, 120);
    panel.add(label);
}
}