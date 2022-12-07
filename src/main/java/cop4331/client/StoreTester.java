package cop4331.client;

import cop4331.gui.CartUI;
import cop4331.gui.InventoryUI;
import cop4331.gui.LoginUI;
import cop4331.gui.PaymentUI;

import javax.swing.*;

/**
 * @author Hunter B, Tommy L, Mark A
 */
public class StoreTester
{
    public static void main(String[] args)
    {

        Inventory inventory = Inventory.getInstance();

        
        new LoginUI();

    }
}
