package cop4331.gui;
import javax.swing.*;
import java.awt.*;

/**
 * @author Tommy Las
 */
public class PaymentUI extends JFrame {
    public PaymentUI(double totalPrice) {
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("Payment");
        this.setLocation(400, 100);
        this.setResizable(false);
        this.setSize(400,450);
        
    }
}
