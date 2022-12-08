package cop4331.gui;

import cop4331.client.StoreInfo;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;


/**
Display Information on cost, revenue, sales, and profits.
 * @author Cesaire
 */

public class SalesInformationUI extends JFrame   {

 
  public SalesInformationUI() {
      //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      StoreInfo store = StoreInfo.getInstance();
      
      double s1 = store.getTotalCosts();
      String s2 = String.valueOf(s1);

      double s3 = store.getTotalProfits();
      String s4 = String.valueOf(s3);
      
      double s5 = store.getTotalRevenue();
      String s6 = String.valueOf(s5);
      
    JPanel panel = new JPanel();
    this.setSize(1000, 1000);
    this.add(panel);

    panel.setLayout(null);

    JLabel userlabel = new JLabel("Sales Information");
    userlabel.setFont(new Font("Verdana", Font.PLAIN, 25));
    userlabel.setBounds(380, 5, 350, 120);
    panel.add(userlabel);
    
    
    JLabel totalcostLabel = new JLabel (s2);
    totalcostLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
    totalcostLabel.setBounds(550, 5, 350, 550);
    panel.add(totalcostLabel);
    
    JLabel totalprofitsLabel = new JLabel (s4 );
    totalprofitsLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
    totalprofitsLabel.setBounds(550, 5, 350, 650);
    panel.add(totalprofitsLabel);
    
     JLabel totalrevenueLabel = new JLabel (s6);
    totalrevenueLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
    totalrevenueLabel.setBounds(550, 5, 350, 750);
    panel.add(totalrevenueLabel);
    
    
    
    
    
    JLabel totalcostpLabel = new JLabel ("Total Cost:");
    totalcostpLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
    totalcostpLabel.setBounds(250, 5, 350, 550);
    panel.add(totalcostpLabel);
    
    JLabel totalprofitspLabel = new JLabel ("Total Profits:" );
    totalprofitspLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
    totalprofitspLabel.setBounds(250, 5, 350, 650);
    panel.add(totalprofitspLabel);
    
     JLabel totalrevenuepLabel = new JLabel ("Total Revenue:");
    totalrevenuepLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
    totalrevenuepLabel.setBounds(250, 5, 350, 750);
    panel.add(totalrevenuepLabel);

    this.setVisible(true);

}
}