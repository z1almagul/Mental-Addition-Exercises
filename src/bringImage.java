/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author AL KHAT AL ASWAD
 */
public class bringImage {
    
    public ImageIcon createIcon(String path) {
        try{
            //BufferedImage image = ImageIO.read(new ImageIcon().getClass().getClassLoader().getResource("picture1.jpg"));
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(path));
            return icon;
        }catch(Exception e){
        }
        return null;
    }
    
}
