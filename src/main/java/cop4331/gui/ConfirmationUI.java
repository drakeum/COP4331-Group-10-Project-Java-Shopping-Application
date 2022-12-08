
package cop4331.gui;

import javax.swing.JOptionPane;

public class ConfirmationUI {
    
    int confirm;
    public ConfirmationUI(String text, String textType){
        int confirm = JOptionPane.showOptionDialog(null, text, textType, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
    }
    
    public int getSelection(){
         return confirm;
    }
    
}
