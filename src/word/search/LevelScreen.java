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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The LevelScreen class is used to display the different level buttons and passes
 * the parameter onto the GameScreen class when selected by user
 * @author helenaxu
 */
public class LevelScreen extends JFrame implements ActionListener{  
    
    // Declaring buttons for level options to proceed
    JButton btnEasy, btnMedium, btnHard;
    // Declaring labels under JLabel
    JLabel lblMessage, lblInfoOne, lblInfoTwo, lblInfoThree;

    public LevelScreen(){
        
        // Setting up the JFrame 
        super("Word Search Level of Difficulty");
        resize(600,600);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        
        //Setting up the message label
        lblMessage = new JLabel("Before you start the game, choose a level!");
        //Changing the font of the display
        lblMessage.setFont(new Font("Luna", Font.PLAIN, 16));
        //Setting up the location and size
        lblMessage.setSize(600,50);
        lblMessage.setLocation(70, 50);
        add(lblMessage);//adding the label into JFrame

        //Setting up the message label
        String strMessage = "The words will be hidden vertically, horizontally, diagonally, and can be in reverse/backwards!";
        lblMessage = new JLabel("<html>"+ strMessage +"</html>"); // using HTML formatting so that text is wrapped
        //Changing the font of the display
        lblMessage.setFont(new Font("Luna", Font.PLAIN, 13));
        //Setting up the location and size
        lblMessage.setSize(500,100);
        lblMessage.setLocation(60, 120);
        add(lblMessage);//adding the label into JFrame
        
        //Setting up the info for level one label
        String strInfoOne = "Easy Level: There are 4 words for you to find, with each consisting of four letters.";
        lblInfoOne = new JLabel("<html>"+ strInfoOne +"</html>");// using HTML formatting so that text is wrapped
        //Changing the font of the display
        lblInfoOne.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblInfoOne.setSize(500,100);
        lblInfoOne.setLocation(60, 200);
        add(lblInfoOne);//adding the label into JFrame
       
        //Setting up the info for level two label
        String strInfoTwo = "Medium Level: There are 5 words for you to find, with each consisting of four letters.";        
        lblInfoTwo = new JLabel("<html>"+ strInfoTwo +"</html>");// using HTML formatting so that text is wrapped
        //Changing the font of the display
        lblInfoTwo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblInfoTwo.setSize(500,100);
        lblInfoTwo.setLocation(60, 270);
        add(lblInfoTwo);//adding the label into JFrame
        
        //Setting up the info for level three label
        String strInfoThree = "Hard Level: There are 6 words for you to find, with each consisting of four letters.";
        lblInfoThree = new JLabel("<html>"+ strInfoThree +"</html>");// using HTML formatting so that text is wrapped
        //Changing the font of the display
        lblInfoThree.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblInfoThree.setSize(500,100);
        lblInfoThree.setLocation(60, 340);
        add(lblInfoThree);//adding the label into JFrame
        
        // Setting up button for easy
        btnEasy = new JButton ();
        btnEasy.setSize(100,50);
        btnEasy.setLocation(100,450);
        btnEasy.setText("Easy Level");
        btnEasy.setActionCommand("Easy");
        btnEasy.addActionListener(this);
        add(btnEasy); 
        
        // Setting up button for medium
        btnMedium = new JButton ();
        btnMedium.setSize(100,50);
        btnMedium.setLocation(250,450);
        btnMedium.setText("Medium Level");
        btnMedium.setActionCommand("Medium");
        btnMedium.addActionListener(this);
        add(btnMedium); 
        
        // Setting up button for hard
        btnHard = new JButton ();
        btnHard.setSize(100,50);
        btnHard.setLocation(400,450);
        btnHard.setText("Hard Level");
        btnHard.setActionCommand("Hard");
        btnHard.addActionListener(this);
        add(btnHard);
    }
    
    public void actionPerformed(ActionEvent e){
        // Declaring a string to avoid repeaeting actioncommand
        String level = e.getActionCommand();
        //checking to see whether any of the levels are pressed
        if(level.equals("Easy") || level.equals("Medium") || level.equals("Hard")){
            // instantiating game screen object and passing it "level" parameter
            GameScreen myGame = new GameScreen(level);
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame
        }
    }   
}
