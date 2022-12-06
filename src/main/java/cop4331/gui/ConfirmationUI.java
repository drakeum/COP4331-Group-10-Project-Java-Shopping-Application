package cop4331.gui;

import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Mark Altshuler
 */
public class ConfirmationUI extends JFrame{
    
 JPanel insidePanel = new JPanel();
 
    public ConfirmationUI(){
        JLabel text = new JLabel("Please confirm or cancel your chances");
        JPanel panel1 = new JPanel(new GridLayout(0, 2));
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
