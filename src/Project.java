package classes;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class Project extends Library{
    //Declaration of fields (the ones for public use through all methods)
    JFrame frame=new JFrame(), frame2=new JFrame(),frame3=new JFrame(), frame4=new JFrame(), frame5=new JFrame();
    JLabel image=new JLabel(),second = new JLabel(),first = new JLabel(),time = new JLabel(), resultname=new JLabel(), resultage=new JLabel(), resulttime=new JLabel(), resultresult=new JLabel();
    int secondsPassed=0, minutesPassed=0, totalCounter=0,wrongCounter=0, correctCounter=0, level=0;
    JTextField nametxt = new JTextField(), agetxt = new JTextField(), number = new JTextField();
    String[] levels = {"level 1", "level 2", "level 3", "level 4"};
    JComboBox com = new JComboBox(levels);
    JButton correct = new JButton("Correct"), check = new JButton("Check"), clear = new JButton("Clear"), wrong = new JButton("Wrong"), result = new JButton("Result"), start = new JButton("Start");
    JPanel sp=new JPanel(), p=new JPanel();
    Font f1 = new Font("Garamond", Font.BOLD, 20), f2 = new Font("Algerian", Font.BOLD, 30), f3 = new Font("Garamond Bold", Font.ITALIC, 20);
    
    Timer timer= setTimer(time);
    
    Connection con=null;
    
    //Constructor
    public Project(){
        timer.scheduleAtFixedRate(getTimerTask(time), 1000, 1000);
        setWelcomeFrame();
        setLoginFrame();
        setGameFrame();
        setResultFrame();
        setAllResultsFrame();
    }

    @Override
    public void setWelcomeFrame() {
        //frame = new JFrame();
        frame.setSize(750, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Mental Addition Exercises for Kids");
        frame.setResizable(false);

        JPanel pane = new JPanel(null);
        pane.setBounds(0, 0, 750, 700);
        pane.setBackground(Color.WHITE);
        //pane.setBorder(BorderFactory.createTitledBorder());
        frame.add(pane);
        

        
//        JProgressBar  jProgressBar1 = new javax.swing.JProgressBar();
//        jProgressBar1.setBackground(new java.awt.Color(255, 102, 0));
//        jProgressBar1.setBounds(0, 700, 750, 700);
//         JLabel Bar = new JLabel(" % ");
//         pane.add(Bar);
//        pane.add( jProgressBar1);
               
        JLabel gamename = new JLabel(" Welcome to THE INTELLIGENCE GAME ");
        gamename.setFont(new java.awt.Font("Algerian", 3, 24));
        gamename.setBounds(90, 50, 700, 50);
        gamename.setForeground(Color.DARK_GRAY);
        pane.add(gamename);

        JLabel imgen = new JLabel();
        //imgen.setIcon(new javax.swing.ImageIcon("picture1.jpg")); // NOI18N
        imgen.setIcon(new bringImage().createIcon("picture1.jpg"));
        imgen.setBounds(151, 11, 700, 700);
        pane.add(imgen);

        JButton b = new JButton("Log in");
        b.setBounds(100, 111, 111, 40);
        b.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18));
        b.setBorder(null);
        b.setBackground(new java.awt.Color(255, 204, 204));
        b.setToolTipText("Please enter here ");
        b.addActionListener(buttonsListener());
        pane.add(b);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(b);

    }

    @Override
    public void setLoginFrame() {
        frame2.setSize(700, 700);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setLayout(null);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);

        JPanel pane2 = new JPanel(null);
        pane2.setBounds(0, 0, 700, 700);
        pane2.setBackground(Color.WHITE);
        //pane.setBorder(BorderFactory.createTitledBorder());
        frame2.add(pane2);

        JLabel welcome = new JLabel("Log in ");
        welcome.setBounds(190, 50, 200, 50);
        welcome.setFont(f2);
        welcome.setForeground(Color.magenta);
        pane2.add(welcome);

        JLabel name = new JLabel("Enter Your Name :");
        name.setBounds(40, 150, 200, 20);
        name.setFont(f1);
        pane2.add(name);

        
        nametxt.setBounds(40, 180, 150, 40);
        pane2.add(nametxt);

        JLabel age = new JLabel("Enter Your Age : ");
        age.setBounds(40, 240, 200, 30);
        age.setFont(f1);
        pane2.add(age);

        agetxt.setBounds(40, 270, 150, 40);
        pane2.add(agetxt);

        JLabel lev = new JLabel("Chose level :");
        lev.setBounds(20, 350, 120, 30);
        lev.setFont(f1);
        lev.setForeground(Color.magenta);
        pane2.add(lev);

        
        com.setBounds(140, 350, 100, 30);
        com.setBackground(Color.white);
        com.setForeground(Color.MAGENTA);
        //com.addActionListener(menuItemListeners());
        pane2.add(com);

        JButton play = new JButton("Let's Play");
        play .setToolTipText("Please enter here ");
        play.setBounds(60, 410, 120, 60);
        play.setFont(f1);
        play.setBackground(Color.magenta);
        play.addActionListener(buttonsListener());
        pane2.add(play);
        frame2.getRootPane().setDefaultButton(play);

        JLabel imgen2 = new JLabel();
        imgen2.setIcon(new bringImage().createIcon("IMG_20220401_221210_883 (2).jpg")); // NOI18N
        imgen2.setBounds(250, 90, 450, 500);
        pane2.add(imgen2);

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("File");
        
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(menuItemListeners());
        JMenuItem home = new JMenuItem("Home");
        home.addActionListener(menuItemListeners());
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(menuItemListeners());
        bar.setBackground(Color.GRAY);
        bar.add(menu);
        menu.add(about);
        menu.add(home);
        menu.add(exit);

        frame2.setJMenuBar(bar);
    }

    @Override
    public void setGameFrame() {
        //JFrame frame3 = new JFrame();
        frame3.setSize(600, 550);
        frame3.setLocationRelativeTo(null);
        frame3.setLayout(null);
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.getRootPane().setDefaultButton(start);
        frame3.setResizable(false);

        JPanel pane3 = new JPanel(null);
        pane3.setBounds(0, 0, 700, 700);
        pane3.setBackground(Color.WHITE);
        //pane.setBorder(BorderFactory.createTitledBorder());
        frame3.add(pane3);

        first.setBounds(80, 80, 80, 20);
        first.setFont(f1);
        pane3.add(first);

        second.setBounds(300, 80, 80, 20);
        second.setFont(f1);
        pane3.add(second);
        JLabel plus = new JLabel("+");
        plus.setBounds(130, 80, 40, 20);
        plus.setFont(f1);
        pane3.add(plus);
        JLabel eq = new JLabel("=");
        eq.setBounds(260, 80, 40, 20);
        eq.setFont(f1);
        pane3.add(eq);

        
        number.setBounds(160, 80, 80, 20);
        number.setEnabled(false);
        number.setFont(f1);
        pane3.add(number);

        time.setBounds(420, 290, 100, 40);
        time.setFont(f1);
        time.setVisible(false);
        pane3.add(time);

        JLabel timetxt = new JLabel("Time :");
        timetxt.setBounds(320, 300, 200, 20);
        timetxt.setFont(f2);
        timetxt.setForeground(Color.magenta);
        pane3.add(timetxt);

        
        check .setToolTipText("Please enter here ");
        check.setBounds(150, 150, 120, 30);
        check.setFont(f1);
        check.addActionListener(buttonsListener());
        check.setEnabled(false);
        pane3.add(check);

        
        clear .setToolTipText("Please enter here ");
        clear.setBounds(150, 280, 120, 30);
        clear.setFont(f1);
        clear.addActionListener(buttonsListener());
        clear.setEnabled(false);
        pane3.add(clear);

        
        result.setToolTipText("Please enter here ");
        result.setBounds(150, 360, 120, 30);
        result.setFont(f1);
        result.addActionListener(buttonsListener());
        result.setEnabled(false);
        pane3.add(result);

        
        start.setToolTipText("Please enter here ");
        start.setBounds(150, 320, 120, 30);
        start.setFont(f1);
        start.addActionListener(buttonsListener());
        pane3.add(start);

        
        wrong.setToolTipText("Please enter here ");
        wrong.setBounds(260, 220, 120, 30);
        wrong.setFont(f1);
        wrong.addActionListener(buttonsListener());
        wrong.setEnabled(false);
        pane3.add(wrong);

        
        correct.setToolTipText("Please enter here ");
        correct.setBounds(40, 220, 120, 30);
        correct.setFont(f1);
        correct.setEnabled(false);
        correct.addActionListener(buttonsListener());
        correct.setEnabled(false);
        pane3.add(correct);
        
        image.setBounds(450, 80, 80, 80);
        pane3.add(image);

        JMenuBar bar3 = new JMenuBar();
        JMenu menu3 = new JMenu("File");
        JMenuItem about3 = new JMenuItem("About");
        about3.addActionListener(menuItemListeners());
        JMenuItem home3 = new JMenuItem("Home");
        home3.addActionListener(menuItemListeners());
        JMenuItem exit3 = new JMenuItem("Exit");
        exit3.addActionListener(menuItemListeners());
        JMenu menu1 = new JMenu("Level 1");
        for(int i=5;i<=20;i++){
            JMenuItem item=new JMenuItem(Integer.toString(i));
            menu1.add(item);
            item.addActionListener(menuItemListeners());
        }
        JMenu menu2 = new JMenu("Level 2");
        for(int i=30;i<=90;i=i+10){
            JMenuItem item=new JMenuItem(Integer.toString(i));
            menu2.add(item);
            item.addActionListener(menuItemListeners());
        }
        JMenu menu5 = new JMenu("Level 3 ");
        for(int i=100;i<=900;i=i+100){
            JMenuItem item=new JMenuItem(Integer.toString(i));
            menu5.add(item);
            item.addActionListener(menuItemListeners());
        }
        JMenu menu6 = new JMenu("Level 4");
        for(int i=1000;i<=5000;i=i+1000){
            JMenuItem item=new JMenuItem(Integer.toString(i));
            menu6.add(item);
            item.addActionListener(menuItemListeners());
        }
        bar3.setBackground(Color.LIGHT_GRAY);
        bar3.add(menu3);
        bar3.add(menu1);
        bar3.add(menu2);
        bar3.add(menu5);
        bar3.add(menu6);
        menu3.add(about3);
        menu3.add(home3);
        menu3.add(exit3);
        frame3.setJMenuBar(bar3);
    }

    @Override
    public void setResultFrame() {
        frame4.setSize(850, 600);
        frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame4.setLayout(null);
        frame4.setLocationRelativeTo(null);
        JPanel pane4 = new JPanel(null);
        pane4.setBounds(0, 0, 850, 600);
        pane4.setBackground(Color.WHITE);
        //pane.setBorder(BorderFactory.createTitledBorder());
        frame4.add(pane4);
        frame4.setResizable(false);
      
        JLabel imgen4 = new JLabel();
        imgen4 .setIcon(new bringImage().createIcon("Untitled.png")); // NOI18N
        imgen4.setBounds(470, 35, 450, 500);
        pane4.add(imgen4);
        JLabel yourres = new JLabel("YOUR RESULT IS : ");
        JLabel resname = new JLabel("Name : ");
        JLabel resage = new JLabel("Age : ");
        JLabel restime = new JLabel("Time : ");
        JLabel resresult = new JLabel("Result : ");
        JLabel thanks = new JLabel(" Thank You For Playing ");
        JButton bye = new JButton("Bye");
        bye.setToolTipText("Please enter here ");
        bye.addActionListener(buttonsListener());

        yourres.setBounds(35, 50, 450, 40);
        yourres.setFont(f2);
        yourres.setForeground(Color.MAGENTA);
        resname.setBounds(40, 105, 80, 30);
        resname.setFont(f1);
        resultname.setBounds(120, 105, 200, 30);
        resultname.setFont(f1);
        resage.setBounds(40, 145, 80, 30);
        resage.setFont(f1);
        resultage.setBounds(120, 145, 80, 30);
        resultage.setFont(f1);
        restime.setBounds(40, 185, 80, 30);
        restime.setFont(f1);
        resulttime.setBounds(120, 185, 150, 30);
        resulttime.setFont(f1);
        resresult.setBounds(40, 225, 80, 30);
        resresult.setFont(f1);
        resultresult.setBounds(120, 225, 300, 30);
        resultresult.setFont(f1);
        thanks.setBounds(15, 270, 500, 50);
        thanks.setFont(f2);
        thanks.setForeground(Color.MAGENTA);
        bye.setBounds(210, 330, 150, 30);
        bye.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18));
        bye.setBackground(new java.awt.Color(255, 204, 204));
        JButton all =new JButton("All results");
        all.setBounds(50, 330, 150, 30);
        all.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18));
        all.setBackground(new java.awt.Color(255, 204, 204));
        all.addActionListener(buttonsListener());
        all.setToolTipText("Please enter here ");
        pane4.add(all);
        pane4.add(yourres);
        pane4.add(resname);
        pane4.add(resultname);
        pane4.add(resage);
        pane4.add(resultage);
        pane4.add(bye);
        pane4.add(restime);
        pane4.add(resulttime);
        pane4.add(resresult);
        pane4.add(resultresult);
        pane4.add(thanks);

        JMenuBar bar4 = new JMenuBar();
        JMenu menu4 = new JMenu("File");
        JMenuItem about4 = new JMenuItem("About");
        about4.addActionListener(menuItemListeners());
        JMenuItem home4 = new JMenuItem("Home");
        home4.addActionListener(menuItemListeners());
        JMenuItem exit4 = new JMenuItem("Exit");
        exit4.addActionListener(menuItemListeners());
        bar4.setBackground(Color.lightGray);
        bar4.add(menu4);
        menu4.add(about4);
        menu4.add(home4);
        menu4.add(exit4);
        frame4.setJMenuBar(bar4);

    }
    
    @Override
    public void setAllResultsFrame(){
        JLabel rname=new JLabel("Name: "), rage=new JLabel("Age: ");
        sp.setBounds(10, 120, 340, 250);
        sp.setBackground(Color.white);
        JScrollPane scp=new JScrollPane(sp,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JLabel rlevel=new JLabel("Level");
        JLabel rtotal=new JLabel("Total");
        JLabel rcorrect=new JLabel("Correct");
        JLabel rwrong=new JLabel("Wrong");
        JLabel rtime=new JLabel("Time");
        scp.setBorder(null);
        rlevel.setFont(f1);
        rtime.setFont(f1);
        rname.setFont(f1);
        rage.setFont(f1);
        rcorrect.setFont(f1);
        rwrong.setFont(f1);
        rtotal.setFont(f1);
        sp.add(rlevel);sp.add(rtotal);sp.add(rcorrect);sp.add(rwrong);sp.add(rtime);
        sp.setLayout(new GridLayout(1,5));
        scp.setBounds(10, 120, 390, 250);
        frame5.add(scp);
        rname.setBounds(30, 50, 100, 30);
        rage.setBounds(30, 80, 100, 30);
        frame5.setResizable(true);
        frame5.setLocationRelativeTo(null);
        frame5.setLocation(frame4.getX()+450, frame4.getY()+20);
        p.setBounds(0, 0, 400, 400);
        p.setBackground(Color.white);
        p.setLayout(null);
        p.add(rname);
        p.add(rage);
        frame5.add(p);
        frame5.setVisible(false);
        frame5.setResizable(false);
        frame5.setSize(405, 430);
        frame5.setLayout(null);
        frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame5.setBackground(Color.white);
    }
    
    //to set what happens when home menuItem is invoked
    @Override
    public void reset(){
        frame.setVisible(true);
        nametxt.setText("");
        agetxt.setText("");
        time.setVisible(false);
        check.setEnabled(false);
        start.setEnabled(true);
        wrong.setEnabled(false);
        correct.setEnabled(false);
        secondsPassed=0;
        minutesPassed=0;
        totalCounter=0;
        wrongCounter=0;
        correctCounter=0;
        result.setEnabled(false);
        clear.setEnabled(false);
        first.setText("");
        second.setText("");
        number.setText("");
        frame3.getRootPane().setDefaultButton(start);
        image.setVisible(false);
        correct.setBackground(start.getBackground());
        wrong.setBackground(start.getBackground());
        frame2.setVisible(false);
        frame3.setVisible(false);
        frame4.setVisible(false);
    }
    
    //ActionListener to all MenuItems
    @Override
    public ActionListener menuItemListeners() {
        ActionListener action=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                switch(e.getActionCommand()){
                    case "Home": reset();break;
                    case "Exit": System.exit(0);break;
                    case "About": setAboutDialog();break;
                    case "5": second.setText("5"); changeLevel();level=1; break;
                    case "6": second.setText("6"); changeLevel();level=1; break;
                    case "7": second.setText("7"); changeLevel();level=1; break;
                    case "8": second.setText("8"); changeLevel();level=1; break;
                    case "9": second.setText("9"); changeLevel();level=1; break;
                    case "10": second.setText("10"); changeLevel();level=1; break;
                    case "11": second.setText("11"); changeLevel();level=1; break;
                    case "12": second.setText("12"); changeLevel();level=1; break;
                    case "13": second.setText("13"); changeLevel();level=1; break;
                    case "14": second.setText("14"); changeLevel();level=1; break;
                    case "15": second.setText("15"); changeLevel();level=1; break;
                    case "16": second.setText("16"); changeLevel();level=1; break;
                    case "17": second.setText("17"); changeLevel();level=1; break;
                    case "18": second.setText("18"); changeLevel();level=1; break;
                    case "19": second.setText("19"); changeLevel();level=1; break;
                    case "20": second.setText("20"); changeLevel();level=1; break;
                    case "30": second.setText("30"); changeLevel();level=2; break;
                    case "40": second.setText("40"); changeLevel();level=2; break;
                    case "50": second.setText("50"); changeLevel();level=2; break;
                    case "60": second.setText("60"); changeLevel();level=2; break;
                    case "70": second.setText("70"); changeLevel();level=2; break;
                    case "80": second.setText("80"); changeLevel();level=2; break;
                    case "90": second.setText("90"); changeLevel();level=2; break;
                    case "100": second.setText("100"); changeLevel();level=3; break;
                    case "200": second.setText("200"); changeLevel();level=3; break;
                    case "300": second.setText("300"); changeLevel();level=3; break;
                    case "400": second.setText("400"); changeLevel();level=3; break;
                    case "500": second.setText("500"); changeLevel();level=3; break;
                    case "600": second.setText("600"); changeLevel();level=3; break;
                    case "700": second.setText("700"); changeLevel();level=3; break;
                    case "800": second.setText("800"); changeLevel();level=3; break;
                    case "900": second.setText("900"); changeLevel();level=3; break;
                    case "1000": second.setText("1000"); changeLevel();level=4; break;
                    case "2000": second.setText("2000"); changeLevel();level=4; break;
                    case "3000": second.setText("3000"); changeLevel();level=4; break;
                    case "4000": second.setText("4000"); changeLevel();level=4; break;
                    case "5000": second.setText("5000"); changeLevel();level=4; break;
                }
            }
            
        };
        return action;
    }

    //ActionListener to all buttons
    @Override
    public ActionListener buttonsListener() {
        ActionListener action=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(e.getActionCommand()){
                    case "Log in": frame.setVisible(false); frame2.setVisible(true); break;
                    case "Start": begin();
                        break;
                    case "Check": check();
                        break;
                    case "Result": getResult(); break;
                    case "Let's Play": login();break;
                    case "Bye": System.exit(0);
                    case "All results": frame5.setVisible(true); readFromDatabase();break;
                    case "Clear": clearAll(); break;
                    case "Wrong": ifWrong(); break;
                    case "Correct": ifCorrect(); break;
                }
            }
            
        };
        return action;
    }
    
    @Override
    public String setRandomNumber(int limit){
        return (Integer.toString(new Random().nextInt(limit+1)));
    }

    @Override
    public boolean isCorrect() {
        try{
            Integer.parseInt(number.getText());
            return Integer.parseInt(first.getText())+Integer.parseInt(number.getText())==Integer.parseInt(second.getText());
        }catch(NumberFormatException e){
            //A message stating entered value is either not a number or empty
            return false;
        }
    }

    @Override
    public Timer setTimer(JLabel timerLabel) {
        secondsPassed=0;
        minutesPassed=0;
        timerLabel.setVisible(true);
        timer =new Timer();
        timer.purge();
        return timer;
    }
    
    @Override
    public TimerTask getTimerTask(JLabel timerLabel){
        TimerTask task=new TimerTask(){
            @Override
            public void run() {
                secondsPassed++;
                if(secondsPassed==60){
                    minutesPassed++;
                    secondsPassed=0;
                }
                timerLabel.setText(minutesPassed+" : "+secondsPassed);
            }
        };
        return task;
    }


    @Override
    public void begin() {
        image.setVisible(true);
        image.setIcon(new bringImage().createIcon("check.jpg"));
        start.setEnabled(false);
        check.setEnabled(true);
        clear.setEnabled(true);
        number.setEnabled(true);
        result.setEnabled(true);
        first.setText(setRandomNumber(Integer.parseInt(second.getText())));
        secondsPassed=0;
        minutesPassed=0;
        time.setVisible(true);
        setDigitLimit(first.getText(), second.getText());
        number.requestFocusInWindow();
        frame3.getRootPane().setDefaultButton(check);
    }

    @Override
    public void check() {
        check.setEnabled(false);
        totalCounter++;
        if(isCorrect()){
            correct.setBackground(Color.green);
            correct.setEnabled(true);
            correctCounter++;
            image.setIcon(new bringImage().createIcon("correct.jpg"));
            frame3.getRootPane().setDefaultButton(correct);
        }else{
            wrong.setBackground(Color.red);
            wrong.setEnabled(true);            
            wrongCounter++;
            image.setIcon(new bringImage().createIcon("wrong.jpg"));
            frame3.getRootPane().setDefaultButton(wrong);
        }
        if(isTheEnd()){
            //Display amessage stating maximum time or amount of wrongs has been reached
            new OptionPanes(frame3, "wrongs");
            getResult(); return;
        }
    }
    
    @Override
    public void login(){
        try{
            if(getAge(agetxt.getText())<5||getAge(agetxt.getText())>14){
            //explanatory message(in the form of label, dialog box, option pane, etc.) stating access isn't granted because of age restriction
            new OptionPanes(frame2,"age limit");
            agetxt.setText("");
        }else{
            switch(levels[com.getSelectedIndex()]){
                                            case "level 1": second.setText("5");level=1;break;
                                            case "level 2": second.setText("30");level=2;break;
                                            case "level 3": second.setText("100");level=3;break;
                                            case "level 4": second.setText("1000");level=4;break;
                }
                frame3.setVisible(true);
                frame2.setVisible(false);
                frame.setVisible(false);
        }
        }catch(NumberFormatException e){
            //Explanatory message stating age is not entered or incorrect
            new OptionPanes(frame, "NumberFormatException");
        }    
        
    }

    @Override
    public void writeToDatabase() {
        if(totalCounter==0){
            return;
        }
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost;databaseName=Trial;User=sa;Password=sysadmin";
            con=DriverManager.getConnection(url);
            Statement s=con.createStatement();
            String st="create table Result(Name varchar(20),Age int,Level int,Total int,Correct int,Wrong int,Time varchar(7))";
            s.executeUpdate(st);
            String q="insert into Result(Name,Age,Level,Total,Correct,Wrong,Time)values(?,?,?,?,?,?,?)";
            PreparedStatement pre=con.prepareStatement(q);
            pre.setString(1, nametxt.getText());
            pre.setInt(2, getAge(agetxt.getText()));
            pre.setInt(3, level);
            pre.setInt(4, totalCounter);
            pre.setInt(5, correctCounter);
            pre.setInt(6, wrongCounter);
            pre.setString(7, time.getText());
            pre.executeUpdate();
        }catch(ClassNotFoundException e){
            
        }catch(SQLException ex){
            try{
                String q="insert into Result(Name,Age,Level,Total,Correct,Wrong,Time)values(?,?,?,?,?,?,?)";
                PreparedStatement pre=con.prepareStatement(q);
                pre.setString(1, nametxt.getText());
                pre.setInt(2, getAge(agetxt.getText()));
                pre.setInt(3, level);
                pre.setInt(4, totalCounter);
                pre.setInt(5, correctCounter);
                pre.setInt(6, wrongCounter);
                pre.setString(7, time.getText());
                pre.executeUpdate();}
            catch(Exception e){
            }
        }
    }

    @Override
    public int getAge(String age) {
        return Integer.parseInt(age);
    }

    @Override
    public void readFromDatabase() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost;databaseName=Trial;User=sa;Password=sysadmin";
            con=DriverManager.getConnection(url);
            Statement s=con.createStatement();
            String n=nametxt.getText();
            String q="select* from Result where Name='"+n+"'";
            ResultSet st=s.executeQuery(q);
            JLabel rname2=new JLabel(n), rage2=new JLabel(agetxt.getText());
            rname2.setFont(f1);
            rage2.setFont(f1);
            rname2.setBounds(120, 50, 100, 30);
            rage2.setBounds(120, 80, 100, 30);
            p.add(rname2);
            p.add(rage2);
            int i=1;
            while(st.next()){
                sp.add(new JLabel(String.valueOf(st.getInt(3))));
                sp.add(new JLabel(String.valueOf(st.getInt(4))));
                sp.add(new JLabel(String.valueOf(st.getInt(5))));
                sp.add(new JLabel(String.valueOf(st.getInt(6))));
                sp.add(new JLabel(st.getString(7)));
                sp.setFont(f1);
                i++;
            }
            sp.setLayout(new GridLayout(i,5));
        }catch(Exception e){
            sp.removeAll();
            sp.add(new JTextArea(e.getMessage(),10,100));
            sp.repaint();
        }
        JLabel im=new JLabel();
        im.setBounds(0, 0, 405, 430);
        im.setIcon(new bringImage().createIcon("resim.jpg"));
        p.add(im);
    }

    //for what the about menuitem will display in file
    @Override
    public void setAboutDialog() {
        new About(frame);
    }

    @Override
    public void clearAll() {
        number.setText("");
        correct.setEnabled(false);
        wrong.setEnabled(false);
        check.setEnabled(true);
        first.setText(setRandomNumber(Integer.parseInt(second.getText())));
        writeToDatabase();
        totalCounter=0;
        correctCounter=0;
        wrongCounter=0;
        secondsPassed=0;
        minutesPassed=0;
        time.setVisible(true);
        setDigitLimit(first.getText(), second.getText());
        writeToDatabase();
    }
    
    @Override
    public void setDigitLimit(String randomNumber, String result){
        int userNumber=Integer.parseInt(result)-Integer.parseInt(randomNumber);
        int digit=1;
        while((userNumber/10)!=0){
            userNumber=userNumber/10;
            digit++;
        }
        number.setDocument(new JTextFieldCharLimit(digit));
    }

    @Override
    public void ifCorrect() {
        image.setIcon(new bringImage().createIcon("check.jpg"));
        number.setText("");
        first.setText(setRandomNumber(Integer.parseInt(second.getText())));
        correct.setEnabled(false);
        check.setEnabled(true);
        setDigitLimit(first.getText(), second.getText());
        number.requestFocusInWindow();
        frame3.getRootPane().setDefaultButton(check);
        correct.setBackground(wrong.getBackground());
    }

    @Override
    public void ifWrong() {
        image.setIcon(new bringImage().createIcon("check.jpg"));
        number.setText("");
        wrong.setEnabled(false);
        check.setEnabled(true);
        number.requestFocusInWindow();
        frame3.getRootPane().setDefaultButton(check);
        wrong.setBackground(correct.getBackground());
        setDigitLimit(first.getText(), second.getText());
    }

    @Override
    public void changeLevel() {
        secondsPassed=0;
        minutesPassed=0;
        image.setVisible(false);
        time.setVisible(false);
        start.setEnabled(true);
        number.setEnabled(false);
        check.setEnabled(false);
        clear.setEnabled(false);
        first.setText("");
        totalCounter=0;
        correctCounter=0;
        wrongCounter=0;
        number.requestFocusInWindow();
        frame3.getRootPane().setDefaultButton(start);
        writeToDatabase();
    }
    
    
    //gets the result of the game and user name and age and sets them to labels
    @Override
    public void getResult(){
        //timer.cancel();
        resultname.setText(nametxt.getText());
        resultage.setText(agetxt.getText());
        resulttime.setText(minutesPassed+" min "+secondsPassed+ " sec");
        resultresult.setText("Total "+totalCounter+", "+ correctCounter+" correct and "+ wrongCounter+" wrong");
        frame4.setVisible(true);
        frame3.setVisible(false);
        frame2.setVisible(false);
        frame.setVisible(false);
        writeToDatabase();
    }
    
    @Override
    public boolean isTheEnd(){
        return wrongCounter==5;
    }
    

}
