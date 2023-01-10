/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

// importing required packages
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * The IntroScreen class is used to display the intro screen using JFrame
 * and all of the buttons to continue the game
 * @author helenaxu
 */
public class IntroScreen extends JFrame implements ActionListener{
    
    // Declaring labels under JLabel
    JLabel lblWelcome, lblIntroPNG, lblInfo, lblOptions;
    // Declaring buttons for options to proceed
    JButton btnStart, btnUserGuide, btnQuit;
    // Declaring decorative image
    ImageIcon intro = new ImageIcon("titlewordsearch.png");

    public IntroScreen(){
        
        // Setting up the JFrame 
        super("Helena's Word Search");
        resize(600,600);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        
        //Setting up the welcome label
        lblWelcome = new JLabel("Welcome to Helena's Word Search Game!");
        //Changing the font of the display
        lblWelcome.setFont(new Font("Luna", Font.PLAIN, 18));
        //Setting up the location and size
        lblWelcome.setSize(500,50);
        lblWelcome.setLocation(60, 30);
        add(lblWelcome);//adding the label into JFrame
        
        //Setting up the info label
        String strInfo = "This program is an online-version of the classic word search game. "
                + "Your task is to search for the words in the wordbank within the letter grid. "
                + "There will be three levels for you to pick from so get ready to play!";
        lblInfo = new JLabel("<html>"+ strInfo +"</html>"); // using HTML formatting so that text is wrapped
        //Changing the font of the display
        lblInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblInfo.setSize(500,80);
        lblInfo.setLocation(50, 345);
        add(lblInfo);//adding the label into JFrame

        //Setting up the options label        
        lblOptions = new JLabel("Please select from the following...");
        //Changing the font of the display
        lblOptions.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblOptions.setSize(400,50);
        lblOptions.setLocation(50, 412);
        add(lblOptions);//adding the label into JFrame
        
        // Setting up button for start
        btnStart = new JButton ();
        btnStart.setSize(100,50);
        btnStart.setLocation(90,470);
        btnStart.setText("Play game");
        btnStart.setActionCommand("Start");
        btnStart.addActionListener(this);
        add(btnStart); 
        
        // Setting up button for user guide
        btnUserGuide = new JButton ();
        btnUserGuide.setSize(100,50);
        btnUserGuide.setLocation(250,470);
        btnUserGuide.setText("User Guide");
        btnUserGuide.setActionCommand("UserGuide");
        btnUserGuide.addActionListener(this);
        add(btnUserGuide); 
        
        // Setting up button for quit
        btnQuit = new JButton ();
        btnQuit.setSize(100,50);
        btnQuit.setLocation(400,470);
        btnQuit.setText("Quit Program");
        btnQuit.setActionCommand("Quit");
        btnQuit.addActionListener(this);
        add(btnQuit); 
        
        // Setting up the label for the image
        lblIntroPNG = new JLabel();
        lblIntroPNG.setIcon(intro);
        lblIntroPNG.setSize(359,250);
        lblIntroPNG.setLocation(107,90);
        add(lblIntroPNG);
    }
    
    public void actionPerformed(ActionEvent e){
        //checking to see whether the btnUserGuide is pressed and opening UserGuideScreen
        if(e.getActionCommand().equals("UserGuide")){
            UserGuideScreen myGame = new UserGuideScreen();
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame
        }
        //checking to see whether the btnStart is pressed and opening LevelScreen
        if(e.getActionCommand().equals("Start")){
            LevelScreen myGame = new LevelScreen();
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame
        }

        //checking to see whether the btnQuit is pressed 
        if(e.getActionCommand().equals("Quit")){
            // Exiting the program
            System.exit(0);
        }
    }
}
