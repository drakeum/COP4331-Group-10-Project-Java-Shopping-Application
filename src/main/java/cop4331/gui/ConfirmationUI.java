package cop4331.gui;

import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Mark Altshuler
 * basic layout for confirmation
 * returns a panel that can be used by other classes
 */
public class ConfirmationUI extends JFrame{
    
 private JPanel insidePanel = new JPanel();
 private JLabel text = new JLabel("Please confirm or cancel your changes");
 private JPanel panel1 = new JPanel(new GridLayout(0, 2));
 
    public ConfirmationUI(){
        this.setSize(600,600);
        text.setVerticalAlignment(JLabel.CENTER);
        text.setHorizontalAlignment(JLabel.CENTER);
        insidePanel.setBounds(0,0,500,500);
        insidePanel.add(text);
        insidePanel.add(panel1);
        this.add(insidePanel);
        this.setVisible(true);
    }

    public JPanel getPanel(){
        return insidePanel;
    }
    public void dipose(){
        dispose();
    }

}
