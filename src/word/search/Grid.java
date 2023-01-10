/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

// importing required packages
import java.util.Random;
import javax.swing.JButton;

/**
 * The Grid class is used to set up the grid using JButtons in each cell. 
 * It also is used to place a word into the grid randomly and generate a puzzle
 * of random letters to fill the grid.
 * @author helenaxu
 */
public class Grid {

    //Declaring a 2D button array to store the letters
    JButton[][] btnGridArray = new JButton[9][9];
    // Declaring a string array that holds each of the letters 
    String[] strAlphabetsArray = "abcdefghijklmnopqrstuvwxyz".split("");
    
    /**
     * This is the Grid class constructor that generates a 2D array of JButtons in a 9 by 9 grid
     */
    public Grid() {
        int intGridButtonSize = 55;
        // looping through the 2D array
        for (int i = 0; i < btnGridArray.length; i++){
            for (int j = 0; j < btnGridArray[i].length; j++){
                // setting up a new JButton for each letter
                JButton btnLetter = new JButton();
                btnLetter.setSize(intGridButtonSize,intGridButtonSize);
                btnLetter.setLocation(120+ (j*intGridButtonSize),100 + (i*intGridButtonSize));
                // Setting text as '.' temporarily until letter is inserted
                btnLetter.setText(".");
                btnLetter.setActionCommand("letter" + Integer.toString(i) + Integer.toString(j));
                btnGridArray[i][j] = btnLetter;
            }
        }
    }

    /**
     * 
     * @param intRow is the integer value of the row of the current selected cell
     * @param intColumnis the integer value of the column of the current selected cell
     * @return the letter that is assigned to the cell
     */
    public String getCellValue (int intRow, int intColumn) {
        return btnGridArray[intRow][intColumn].getText();
    }
    
    /**
     * 
     * @param intRow is the integer value of the randomized row for the cell
     * @param intColumn is the integer value of the randomized column for the cell
     * @param strLetter is the string value of the letter to set the integers for
     */
    public void setCellValue (int intRow, int intColumn, String strLetter){
         btnGridArray[intRow][intColumn].setText(strLetter);   
    }    
    
    /**
     * 
     * @param strActionCommand is the string that is assigned to the strActionCommand 
     * @return the letter button (Jbutton) if the input is the same as the action command, and 
     * returns a new JButton after the inner for loop for the next cell and letter
     */
    public JButton getCellButton (String strActionCommand){
        // looping through the 2D array grid
        for (int i = 0; i < btnGridArray.length; i++){
            for (int j = 0; j < btnGridArray[i].length; j++){
                // declaring a button for the current cell
                JButton btnLetter = btnGridArray[i][j];
                if (btnLetter.getActionCommand().equals(strActionCommand)) {
                    return btnLetter;
                }
            }
        }
        return new JButton();
    }
    
    /**
     * 
     * @param strPuzzleWord is the string of the word that is in the word search to be found
     */
    public void placeWordRandom(PuzzleWord strPuzzleWord) {
        // Declaring boolean that randomly sets word backward of forward
        boolean blnIsBackward = strPuzzleWord.decideIsBackward();
        // Declaring int that randomly places word on the grid along the y axis
        int intRowIndex = strPuzzleWord.randomizeRowIndex(this.btnGridArray.length);
        // Declaring int that randomly places word on the grid along the x axis
        int intColumnIndex = strPuzzleWord.randomizeColumnIndex(this.btnGridArray[0].length);
        // Declaring string that decides on a direction between horizontal, vertical or diagonal
        String direction = strPuzzleWord.decideDirection();
        
        // reversing the word if the word is supposed to be displayed backwards
        if (blnIsBackward) {
            strPuzzleWord.strWord = new StringBuilder(strPuzzleWord.strWord).reverse().toString();
        }
        
        // Declaring int that counts the amount of time the while loop ran to avoid an infinite loop
        int intRetryCount = 0;
        // Declaring boolean that checks if the word was placed to stop the loop
        boolean wordPlaced = false;
        
        // Loop until the word is placed or maximum 1000 times
        while(!wordPlaced && intRetryCount < 1000) {
            // canPlaceWord method called to check if the word can be placed on the grid 
            // with the random y, x and direction value generated earlier
            if (canPlaceWord(strPuzzleWord, intRowIndex, intColumnIndex, direction, blnIsBackward)) {
                // placeWord method called to place the word on the grid
                placeWord(strPuzzleWord, intRowIndex, intColumnIndex, direction, blnIsBackward);
                // setting wordPlaced boolean to true to stop the loop
                wordPlaced = true;
            }
            // counter updated on every loop
            intRetryCount++;
        }
        // if the word is not placed and we have tried 1000 times, placeWordRandom will
        // be called to place the word randomly within the grid available cells
        if (!wordPlaced) {
            placeWordRandom(strPuzzleWord);
        }
    }
    
    /**
     * 
     * @param strPuzzleWord is the string of the word that is in the word search to be found
     * @param intRow is the integer value of the randomized row for the cell
     * @param intColumn is the integer value of the randomized column for the cell
     * @param strDirection is the direction of the word
     * @param blnIsBackward is a boolean of whether the word is backwards or not
     * @return false if the cell is not empty and you cannot place the letter
     * or return true if the word can be placed in the random cell
     */
    public boolean canPlaceWord(PuzzleWord strPuzzleWord, int intRow, int intColumn, String strDirection, boolean blnIsBackward) {
        // loop through each character in the word
        for (int i = 0; i < strPuzzleWord.strWord.length(); i++) {
            // declaring r and c int variables to store x and y values passed to this method
            int r = intRow, c = intColumn;
            
            // if direction is vertical or diagonal add i to the r int
            if (strDirection.equals("vertical") || strDirection.equals("diagonal")) {
                r += i;
            }
            
            // if direction is horizontal or diagonal add i to the c int
            if (strDirection.equals("horizontal") || strDirection.equals("diagonal")) {
                c += i;
            }
            
            // checking if the cell we are attempting to place the letter on is empty
            // if not, the canPlaceWord method will exit and return false;
            if (!getCellValue(r, c).equals(".")) {
                return false;
            }
        }
        
        // if we reached this line that means the word can be placed in the random cell
        return true;
    }
    
    /**
     * The above code is duplicated to actually place the word where canPlaceWord method approves the word to be placed
     * @param strPuzzleWord is the string of the word that is in the word search to be found
     * @param intRow is the integer value of the randomized row for the cell
     * @param intColumn is the integer value of the randomized column for the cell
     * @param strDirection is the direction of the word
     * @param blnIsBackward is a boolean of whether the word is backwards or not
     */
    public void placeWord(PuzzleWord strPuzzleWord, int intRow, int intColumn, String strDirection, boolean blnIsBackward) {
        for (int i = 0; i < strPuzzleWord.strWord.length(); i++) {
            int r = intRow, c = intColumn;
            if (strDirection.equals("vertical") || strDirection.equals("diagonal")) {
                r += i;
            }
            if (strDirection.equals("horizontal") || strDirection.equals("diagonal")) {
                c += i;
            }
            
            // changing cell value to the letter of the word
            setCellValue(r, c, strPuzzleWord.getLetters()[i]);
            // setting puzzleWord x, y, direction and isBackward for later checks
            strPuzzleWord.place(intRow, intColumn, strDirection, blnIsBackward);
        }
    }
    
    /**
     * this serves to randomize the letters in the alphabet to fill the grid
     */
    public void randomLetters() {
        // looping through 2D button array
        for (int i = 0; i < this.btnGridArray.length; i++) {
            for (int j = 0; j < this.btnGridArray[i].length; j++) {
                // checking if the cell is equal to '.', which means no letter
                if (getCellValue(i, j).equals(".")) {
                    setCellValue(i, j, strAlphabetsArray[randomizeInt(strAlphabetsArray.length)]);
                }
            }
        }
    }
    
    /**
     * 
     * @param intMax is the maximum integer set
     * @return a random integer within the range
     */
    private int randomizeInt(int intMax) {
        Random rand = new Random();
        return rand.nextInt(intMax);
    }
}
