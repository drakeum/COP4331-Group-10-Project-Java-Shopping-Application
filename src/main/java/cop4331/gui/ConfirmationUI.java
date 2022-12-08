
package cop4331.gui;

import javax.swing.JOptionPane;
/*
* Mark A.
* class for confirming a slection
*/
public class ConfirmationUI {
    
    int confirm;
    /*
    * Constructor for the confirmationUI
    * @param text - the text value shown the user
    * @param textType - the string value corresponding to the type of confirmation
    */
    public ConfirmationUI(String text, String textType){
        int confirm = JOptionPane.showOptionDialog(null, text, textType, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
    }
    
    /*
    * Mark A.
    * returns an int value corresponding to the selected value
    * @return integer 0 or 1 representing the selected value
    */
    public int getSelection(){
         return confirm;
    }
    
}
