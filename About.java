/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import javax.swing.*;

/**
 *
 * @author AL KHAT AL ASWAD
 */
public class About{
    
    JDialog dialog;
    GridBagConstraints c = new GridBagConstraints();
    JPanel p2=new JPanel();
    
    About(JFrame f){
        dialog=new JDialog();
        setPanel();
        dialog.add(p2);
        dialog.setResizable(false);
        dialog.setLocale(f.getLocale());
        dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        dialog.setModal(true);
        dialog.setTitle("About");
        dialog.setSize(500,580);
        dialog.setLocationRelativeTo(f);
        dialog.setVisible(true);
        dialog.setLayout(new GridLayout());
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  
    }
    
    public void setPanel(){
        JLabel logo=new JLabel();
        logo.setIcon(new javax.swing.ImageIcon("logo.png"));
        logo.setBounds(20,10,460,200);
        
        JButton close=new JButton("Close");
        close.setBounds(200,520,80,20);
        //close.setBackground(new java.awt.Color(255, 204, 204));
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        
        JTextArea areaAbout=new JTextArea();
        try{
            FileReader file=new FileReader("About.txt");
            areaAbout.read(file,c);
        }catch(Exception e){
        }
        areaAbout.setBounds(20,220,460,100);
        areaAbout.setEditable(false);
        areaAbout.setLineWrap(true);
        areaAbout.setWrapStyleWord(true);
        areaAbout.setBackground(p2.getBackground());
        areaAbout.setFont(new Font("Dialog", Font.PLAIN, 12));
        
        JTextArea area=new JTextArea(null, 100, 50);
        area.setBackground(Color.white);
        area.setBounds(20,340,460,160);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Garamond", Font.PLAIN, 16));
        try{
            FileReader file=new FileReader("AboutProduct.txt");
            area.read(file,c);
        }catch(Exception e){
        }
        
        p2.setLayout(null);
        p2.add(logo);
        p2.add(close);
        p2.add(areaAbout);
        p2.add(area);
    }
    
}