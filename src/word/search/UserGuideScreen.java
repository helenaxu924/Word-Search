/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

//importing required packages
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The UserGuideScreen is used to display the user guide and continuation options
 * @author helenaxu
 */
public class UserGuideScreen extends JFrame implements ActionListener{    
    
    // Declaring buttons 
    JButton btnQuit, btnMainMenu;
    // Declaring labels
    JLabel lbllmglevel, lblImgHomescreen, lblImgGiveUp, lblImgClear, lblWelcome, lblUseInfo, lblInstallInfo, lblPurposeInfo, lblSpecialInfo, lblInstall, lblPurpose, lblSpecial;
    // Declarations of images displayed
    ImageIcon imgLevel = new ImageIcon("level.png");
    ImageIcon imgHomescreen = new ImageIcon("homescreen.png");
    ImageIcon imgGiveUp = new ImageIcon("giveup.png");
    ImageIcon imgClear = new ImageIcon("clear.png");
    int intLeft;

    public UserGuideScreen(){
        
        super("Word Search Instructions");
        intLeft = 80;
        resize(1300,1000);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        //Setting up the welcome label
        lblWelcome = new JLabel("Word Search User Guide");
        //Changing the font of the display
        lblWelcome.setFont(new Font("Luna", Font.PLAIN, 18));
        //Setting up the location and size
        lblWelcome.setSize(500,50);
        lblWelcome.setLocation(350, 30);
        add(lblWelcome);//adding the label into JFrame

        //Setting up the label
        lblWelcome = new JLabel("Install and Run");
        //Changing the font of the display
        lblWelcome.setFont(new Font("Luna", Font.PLAIN, 15));
        //Setting up the location and size
        lblWelcome.setSize(500,50);
        lblWelcome.setLocation(intLeft, 80);
        add(lblWelcome);//adding the label into JFrame
        
        //Setting up the label
        lblWelcome = new JLabel("Purpose");
        //Changing the font of the display
        lblWelcome.setFont(new Font("Luna", Font.PLAIN, 15));
        //Setting up the location and size
        lblWelcome.setSize(500,50);
        lblWelcome.setLocation(520, 80);
        add(lblWelcome);//adding the label into JFrame
        
        //Setting up the label
        lblWelcome = new JLabel("How to Use");
        //Changing the font of the display
        lblWelcome.setFont(new Font("Luna", Font.PLAIN, 15));
        //Setting up the location and size
        lblWelcome.setSize(500,50);
        lblWelcome.setLocation(intLeft, 180);
        add(lblWelcome);//adding the label into JFrame
        
        //Setting up the label
        lblWelcome = new JLabel("Special and Key Features");
        //Changing the font of the display
        lblWelcome.setFont(new Font("Luna", Font.PLAIN, 15));
        //Setting up the location and size
        lblWelcome.setSize(500,50);
        lblWelcome.setLocation(520, 258);
        add(lblWelcome);//adding the label into JFrame

        //Setting up the label        
        String strInstallInfo = "First, download Netbeans and the game zip. "
                + "Next, in the open projects option, select the folder XuHelenaFinalProject, "
                + "open it, and you are able to play the game by clicking the green play button!";
        lblInstallInfo = new JLabel("<html>"+ strInstallInfo +"</html>");
        //Changing the font of the display
        lblInstallInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblInstallInfo.setSize(400,70);
        lblInstallInfo.setLocation(intLeft, 120);
        add(lblInstallInfo);//adding the label into JFrame

        //Setting up the label        
        String strPurposeInfo = "The purpose of this program is to develop a digital-version of the word search game. "
                + "It is also to serve as an act of community service towards people of all ages for their entertainment. "
                + "Finally, the last purpose of this program is towards the developer's, Helena Xu's CPT project for her "
                + "ICS4UE computer science course. She is able to effectively demonstrate and implement all of the required "
                + "aspects with Java";
        lblPurposeInfo = new JLabel("<html>"+ strPurposeInfo +"</html>");
        //Changing the font of the display
        lblPurposeInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblPurposeInfo.setSize(400,140);
        lblPurposeInfo.setLocation(520, 120);
        add(lblPurposeInfo);//adding the label into JFrame
        
        //Setting up the label
        String strUseInfo = "To play this game, you start by selecting a level of difficulty, easy, medium, or hard. "
                + "In the game screen, middle of the game screen holds all of the buttons that"
                + "are assigned to a letter. You will find a word bank at the bottom of the screen. The words are "
                + "randomized and placed vertically, horizontally, diagonally, and may be backwards or reversed. When "
                + "you start clicking letters the button will turn yellow, and then the word is automatically checked "
                + "as you click the letters. If you want to reset your current letter selections click the clear button. "
                + "The screen will display win when you finish finding all the words, but if you want to give up then "
                + "click the give up button and the answers of the word search will also be displayed to you. Once you "
                + "finish the game you can return to the main menu and play again. ";
        lblUseInfo = new JLabel("<html>"+ strUseInfo +"</html>");
        //Changing the font of the display
        lblUseInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblUseInfo.setSize(400,500);
        lblUseInfo.setLocation(intLeft, 100);
        add(lblUseInfo);//adding the label into JFrame
        
        //Setting up the label
        String strSpecialInfo = "Special and key features of this program includes the following: 1) The ability "
                + "to check if a word is correct automatically after each click to optomize user experience. "
                + "2) The use of colors to indicate when a word is found or being selected (yellow for a word in the "
                + "process of selection, green for a correct found word, and red for displayng answers when the user "
                + "gives up. 3) The different levels of difficulty for the user to chose from. 4) The win and lose count";
        lblSpecialInfo = new JLabel("<html>"+ strSpecialInfo +"</html>");
        //Changing the font of the display
        lblSpecialInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblSpecialInfo.setSize(400,500);
        lblSpecialInfo.setLocation(520, 125);
        add(lblSpecialInfo);//adding the label into JFrame
        
        // Setting up button for quit
        btnQuit = new JButton ();
        btnQuit.setSize(100,50);
        btnQuit.setLocation(800,700);
        btnQuit.setText("Quit Program");
        btnQuit.setActionCommand("Quit");
        btnQuit.addActionListener(this);
        add(btnQuit); 
         
        // Setting up button for main menu
        btnMainMenu = new JButton ();
        btnMainMenu.setSize(150,50);
        btnMainMenu.setLocation(920,700);
        btnMainMenu.setText("Return to Main Menu");
        btnMainMenu.setActionCommand("MainMenu");
        btnMainMenu.addActionListener(this);
        add(btnMainMenu); 
        
        // Setting up the label for the image
        lblImgHomescreen = new JLabel();
        lblImgHomescreen.setIcon(imgHomescreen);
        lblImgHomescreen.setSize(230,230);
        lblImgHomescreen.setLocation(190,500);
        add(lblImgHomescreen);

        // Setting up the label for the image
        lbllmglevel = new JLabel();
        lbllmglevel.setIcon(imgLevel);
        lbllmglevel.setSize(230,230);
        lbllmglevel.setLocation(450,500);
        add(lbllmglevel);
        
        // Setting up the label for the image
        lblImgClear = new JLabel();
        lblImgClear.setIcon(imgClear);
        lblImgClear.setSize(500,230);
        lblImgClear.setLocation(950,100);
        add(lblImgClear);        
        
        // Setting up the label for the image
        lblImgGiveUp = new JLabel();
        lblImgGiveUp.setIcon(imgClear);
        lblImgGiveUp.setSize(500,230);
        lblImgGiveUp.setLocation(950,400);
        add(lblImgGiveUp);
        

    }
    
    public void actionPerformed(ActionEvent e){
        //checking to see whether the btnMainMenu is pressed
        if(e.getActionCommand().equals("MainMenu")){
            IntroScreen myGame = new IntroScreen();
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
