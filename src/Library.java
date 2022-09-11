/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 * 182037 - Aya Nori Shadi
 * 191020 - Ekhlas Muftah Eshanta
 * 182105 - Fatima Jamal Makhlouf
 * 191093 - Zeynep Ahmet Aydin
 */
public abstract class Library {
    
    Library(){
        
    }
    
    public abstract void setWelcomeFrame();
    
    public abstract void setLoginFrame();
    
    public abstract void setGameFrame();
    
    public abstract void setResultFrame();
    
    public abstract void setAllResultsFrame();
    
    public abstract ActionListener menuItemListeners();
    
    public abstract ActionListener buttonsListener();
    
    public abstract String setRandomNumber(int limit);
    
    public abstract boolean isCorrect();
    
    public abstract Timer setTimer(JLabel timerLabel);
    
    public abstract TimerTask getTimerTask(JLabel timerLabel);
    
    public abstract void begin();
    
    public abstract void check();
    
    public abstract void login();
    
    public abstract void writeToDatabase();
    
    public abstract int getAge(String age);
    
    public abstract void readFromDatabase();
    
    public abstract void setAboutDialog();
    
    public abstract void clearAll();
    
    public abstract void setDigitLimit(String randomNumber, String result);
    
    public abstract void ifCorrect();
    
    public abstract void ifWrong();
    
    public abstract void changeLevel();
    
    public abstract void getResult();
    
    public abstract boolean isTheEnd();
    
    public abstract void reset();
}
