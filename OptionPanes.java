/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AL KHAT AL ASWAD
 */
public class OptionPanes {
    
    
    OptionPanes(JFrame f, String name){
        //pane.setFont(new Font("Algerian", Font.BOLD, 30));
        if(name.equals("age limit")){
            JOptionPane.showMessageDialog(f, "You must be 5 to 14 years old to continue!","WARNING!",JOptionPane.WARNING_MESSAGE);
        }
        if(name.equals("NumberFormatException")){
            JOptionPane.showMessageDialog(f, "Age not found","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
        if(name.equals("wrongs")){
            JOptionPane.showMessageDialog(f, "You've got 5 wrongs. Logging out!","LIMIT REACHED!",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
}
