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
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * The GameScreen class is used to display the game, and implement different algorithms
 * for each of the levels
 * @author helenaxu
 */
public class GameScreen extends JFrame implements ActionListener{     
    
    // Declaring labels
    JLabel lblMessage, lblIntro, lblWordBank, lblWinCount, lblLoseCount, lblInfo;
    // Declaring buttons
    JButton btnGiveUp, btnClear, btnMainMenu;
    // Declaring a player class placeholder that will be instantiated when the constructor is called
    Player player;
    // Declaring a grid class placeholder that will be instantiated when the constructor is called
    Grid grid;
    // Declaring a puzzleword class placeholder arraylist that will be instantiated when the constructor is called
    ArrayList<PuzzleWord> puzzleWords = new ArrayList<PuzzleWord>();
    // Declaring a wordsfile class placeholder that will be instantiated when the constructor is called
    WordsFile wordFile;
    // Declaring a playerfile class placeholder that will be instantiated when the constructor is called
    PlayerFile playerFile;
    
    
    public GameScreen(String level){
        // creating the JFrame
        super("Word Search Game");
        resize(1000,1000);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
       
        // Setting up button for giveup
        btnGiveUp = new JButton ();
        btnGiveUp.setSize(100,50);
        btnGiveUp.setLocation(700,450);
        btnGiveUp.setText("Give Up");
        btnGiveUp.setActionCommand("GiveUp");
        btnGiveUp.addActionListener(this);
        add(btnGiveUp);
    
        // Setting up button for clear
        btnClear = new JButton ();
        btnClear.setSize(150,50);
        btnClear.setLocation(800,450);
        btnClear.setText("Clear Selection");
        btnClear.setActionCommand("clear");
        btnClear.addActionListener(this);
        add(btnClear);

        // Setting up button for main menu
        btnMainMenu = new JButton ();
        btnMainMenu.setSize(150,50);
        btnMainMenu.setLocation(700,450);
        btnMainMenu.setText("Return to Main Menu");
        btnMainMenu.setActionCommand("MainMenu");
        btnMainMenu.addActionListener(this);
        btnMainMenu.setVisible(false);
        add(btnMainMenu); 
        
        //Setting up the welcome message
        lblMessage = new JLabel();
        lblMessage.setText("");
        //Changing the font of the display
        lblMessage.setFont(new Font("Luna", Font.PLAIN, 20));
        //Setting up the location and size
        lblMessage.setSize(200,100);
        lblMessage.setLocation(60, 600);
        lblMessage.setVisible(false);
        add(lblMessage);//adding the label into JFrame
        

        lblIntro = new JLabel("Welcome to the word search! Your level is: " + level);
        //Changing the font of the display
        lblIntro.setFont(new Font("Luna", Font.PLAIN, 14));
        //Setting up the location and size
        lblIntro.setSize(600,50);
        lblIntro.setLocation(130, 30);
        add(lblIntro);//adding the label into JFrame
        
        lblWordBank = new JLabel("Word Bank:");
        //Changing the font of the display
        lblWordBank.setFont(new Font("Luna", Font.PLAIN, 14));
        //Setting up the location and size
        lblWordBank.setSize(600,50);
        lblWordBank.setLocation(750, 90);
        add(lblWordBank);//adding the label into JFrame
        
        //Setting up the win count label
        lblWinCount = new JLabel();
        lblWinCount.setText("");
        //Changing the font of the display
        lblWinCount.setFont(new Font("Luna", Font.PLAIN, 18));
        //Setting up the location and size
        lblWinCount.setSize(200,100);
        lblWinCount.setLocation(220, 600);
        add(lblWinCount);//adding the label into JFrame
        
        //Setting up the lose count label
        lblLoseCount = new JLabel();
        lblLoseCount.setText("");
        //Changing the font of the display
        lblLoseCount.setFont(new Font("Luna", Font.PLAIN, 18));
        //Setting up the location and size
        lblLoseCount.setSize(200,100);
        lblLoseCount.setLocation(350, 600);
        add(lblLoseCount);//adding the label into JFrame
        
        String strInfo = "Click the letters to match a word. Words can be horizontal, vertical, diagonal, and reversed/backwards order. "
                + "You can select the letters in any order. Press clear to reset your letter selection. After each letter the program "
                + "will automatically check if the word is correct and the word will "
                + "turn green if it is correct. Click give up if you want the answers to be revealed to you.";
        lblInfo = new JLabel("<html>"+ strInfo +"</html>");
        //Changing the font of the display
        lblInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        //Setting up the location and size
        lblInfo.setSize(275,500);
        lblInfo.setLocation(700, 350);
        add(lblInfo);//adding the label into JFrame
        
        // Instantiation that is assigning to the placeholder
        player = new Player(level);
        grid = new Grid();
        wordFile = new WordsFile();
        playerFile = new PlayerFile();
        
        // defining the complexities between each level. the default is 4
        int intComplexity = 4;
        // switch case for medium and hard
        switch(level) {
            case "Medium":
                intComplexity = 5;
                break;
            case "Hard":
                intComplexity = 6;
                break;
            default:
                break;
        }
        
        // getting the words for the wordsearch in puzzleWords class using complexity above
        ArrayList<String> words = wordFile.getWords(intComplexity);
        for (int i = 0; i < words.size(); i++) {
            puzzleWords.add(new PuzzleWord(words.get(i)));
        }
        
        // looping through the words and going through the letters
        for (int i = 0; i < puzzleWords.size(); i++) {
            // setting up the JLabel for each letter
            JLabel lblWords;
            lblWords = new JLabel(puzzleWords.get(i).strWord);
            lblWords.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
            lblWords.setSize(500,80);
            lblWords.setLocation(750, 120 + (i * 50));
            add(lblWords);
            
            // placing the word on the grid
            grid.placeWordRandom(puzzleWords.get(i));
        }
        
        // once the grid is full of answers, add random letters
        grid.randomLetters();
        
        // for loop running through the 2D grid array and settingg an actionListener
        for (int i = 0; i < grid.btnGridArray.length; i++) {
            for (int j = 0; j < grid.btnGridArray[i].length; j++) {  
                JButton btnLetter = grid.btnGridArray[i][j];
                btnLetter.addActionListener(this);
                add(btnLetter);

            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        //checking to see whether the giveUp button is pressed
        if(e.getActionCommand().equals("GiveUp")){
            // using savePlayerData method to store winCount and loseCount
            playerFile.savePlayerData(false);

            // loop through all the puzzleWord in the word bank
            for (int i = 0; i < puzzleWords.size(); i++) {
                PuzzleWord puzzleWord = puzzleWords.get(i);
                
                // getting the arrayList of wordSpan for the the puzzleWord in the loop
                ArrayList<String> wordSpan = puzzleWord.getWordSpan();
                
                // loop through each letter's coordinates to update the button appearance
                for (int j = 0; j < wordSpan.size(); j++) {
                    String strActionCommand = "letter" + wordSpan.get(j);
                    JButton btnLetter = grid.getCellButton(strActionCommand);
                    btnLetter.setBackground(Color.red);
                    btnLetter.setOpaque(true);
                }
            }
            
            // getting player data to display winCount and loseCount
            int[] playerData = playerFile.getPlayerData();
            int winCount = playerData[0], loseCount = playerData[1];
            
            // updating displays for buttons and to display the win and lose count after game
            btnGiveUp.setVisible(false);
            btnClear.setVisible(false);
            btnMainMenu.setVisible(true);
            lblMessage.setText("You lose!");
            lblMessage.setVisible(true);
            lblLoseCount.setText("Losses: " + Integer.toString(loseCount));
            lblWinCount.setText("Wins: " + Integer.toString(winCount));

        }
        
        //checking to see whether the mainmenu button is pressed
        if(e.getActionCommand().equals("MainMenu")){
            IntroScreen myGame = new IntroScreen();
            myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myGame.setVisible(true);
            this.dispose();//This will close the currently active Frame
        }
        
        if(e.getActionCommand().equals("clear")){
            // using clearSelection method to empty out playerSelection array in the player object
            player.clearSelection();
            
            // loop through all the JButtons in the grid
            for (int i = 0; i < grid.btnGridArray.length; i++) {
                for (int j = 0; j < grid.btnGridArray[i].length; j++) {  
                    // update the grid back to original state
                    JButton btnLetter = grid.btnGridArray[i][j];
                    btnLetter.setBackground(Color.PINK);
                    btnLetter.setOpaque(true);
                }
            }
            
            // loop through all the puzzleWords
            for (int i = 0; i < puzzleWords.size(); i++) {
                PuzzleWord puzzleWord = puzzleWords.get(i);
                
                // skip the word if it hasn't been matched yet
                if (!puzzleWord.blnIsMatched) {
                    continue;
                }
                
                // declared wordSpan array list to change all the letters JButton on the grid visually
                ArrayList<String> wordSpan = puzzleWord.getWordSpan();
                
                // loop through each letter in the wordSpan array and change appearance to green when correct
                for (int j = 0; j < wordSpan.size(); j++) {
                    String strActionCommand = "letter" + wordSpan.get(j);
                    JButton btnLetter = grid.getCellButton(strActionCommand);
                    btnLetter.setBackground(Color.GREEN);
                    btnLetter.setOpaque(true);
                }
            }
        }
            

        // checking if the button that was pressed had 'letter' at the beginning
        // all the grid JButtons.actionCommand starts with 'letter' and then programmed to actual coordinates
        if(e.getActionCommand().startsWith("letter")) {
            // 
            String strBtnCoordinates = e.getActionCommand().replace("letter", "");
            
            // using getCellButton method of the grid to get the JButton in order to modify the look
            JButton btnLetter = grid.getCellButton(e.getActionCommand());
            btnLetter.setBackground(Color.YELLOW);
            btnLetter.setOpaque(true);
            
            // using addSelection method of the player class to store player's button press coordinates
            player.addSelection(strBtnCoordinates);
               
            // loops through all the puzzleWord in the word bank
            for (int i = 0; i < puzzleWords.size(); i++) {
                // declaring PuzzleWord to store the current puzzleword of the loop
                PuzzleWord puzzleWord = puzzleWords.get(i);
                
                // skip through all the words that have already been matched previously
                if (puzzleWord.blnIsMatched) continue;
                
                // using checkPlacement method of puzzleWord class to check if the 
                // player selection matches the current word of the loop
                boolean blnIsMatch = puzzleWord.checkPlacement(player.strSelections);
                
                // if the word matches what the player has selected
                if (blnIsMatch) {
                    // change the puzzleWord status to isMatched to avoid checking again and also check if the player has won
                    puzzleWord.blnIsMatched = blnIsMatch;
                    
                    // declared wordSpan array list to change all the letters JButton on the grid visually
                    ArrayList<String> wordSpan = puzzleWord.getWordSpan();
                
                    // loop through each letter in the wordSpan array
                    for (int j = 0; j < wordSpan.size(); j++) {
                        String strActionCommandWord = "letter" + wordSpan.get(j);
                        // get the JButton by actionCommand which stores the coordinates
                        JButton btnLetterWord = grid.getCellButton(strActionCommandWord);
                        // change appearance of the button to represent a match
                        btnLetterWord.setBackground(Color.GREEN);
                        btnLetterWord.setOpaque(true);
                    }
                }
            }
                 
            // checking if all the puzzleWords have been matched
            for (int i = 0; i < puzzleWords.size(); i++) {
                PuzzleWord puzzleWord = puzzleWords.get(i);
                if (!puzzleWord.blnIsMatched) return;
            }
            
            // using savePlayerData method to store winCount and loseCount
            playerFile.savePlayerData(true);
            
            // getting player data to display winCount and loseCount
            int[] playerData = playerFile.getPlayerData();
            int winCount = playerData[0], loseCount = playerData[1];

            // updating displays for buttons and to display the win and lose count after game            
            btnGiveUp.setVisible(false);
            btnClear.setVisible(false);
            btnMainMenu.setVisible(true);
            lblMessage.setText("You win!");
            lblWinCount.setText("Wins: " + Integer.toString(winCount));
            lblMessage.setVisible(true);
            lblLoseCount.setText("Losses: " + Integer.toString(loseCount));

        }
    }
}
