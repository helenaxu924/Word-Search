/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

import java.util.ArrayList;
import java.util.Random;

/**
 * The PuzzleWord class is used to create, place, and organize the words in the word search
 * @author helenaxu
 */
public class PuzzleWord extends Word {
    // Declaring integers
    int intRow, intColumn;
    // Declaring booleans
    boolean blnIsMatched, blnIsBackwards;
    // Declaring string of direction horizontal, etc
    String strDirection;
    
    /**
     * This is the PuzzleWord class constructor
     * @param _strWord is the string of the word
     */
    public PuzzleWord(String _strWord){
        super(_strWord);
        intRow = 0;
        intColumn = 0;
        strDirection = "";
        blnIsMatched = false;
        blnIsBackwards = false;
    }
    
    /**
     * 
     * @param _intRow is the integer of the row of the cell
     * @param _intColumn is the integer of the column of the cell
     * @param _strDirection is the string of the direction of the word
     * @param _blnIsBackwards is the boolean of whether word is backwards or not
     */
    public void place(int _intRow, int _intColumn, String _strDirection, boolean _blnIsBackwards){
        intRow = _intRow;
        intColumn = _intColumn;
        strDirection = _strDirection;
        blnIsBackwards = _blnIsBackwards;
    }

    /**
     * 
     * @param playerSelection is the array list string of the number row and column of the selected cell
     * @return a boolean of whether the word is matched or not
     */
    public boolean checkPlacement(ArrayList<String> playerSelection){               
        // loop through each letter of the word
        for (int i = 0; i < this.strWord.length(); i++) {
            // declaring intCurrRow and intCurrColumn with initial 
            // value of where the word was placed on the grid
            int intCurrRow = intRow, intCurrColumn = intColumn;
            
            // switch statement to check which direction the word was placed in
            switch(strDirection) {
                case "horizontal":
                    // if the direction is horizontal, we move the intCurrColumn to right
                    intCurrColumn = intColumn + i;
                    break;
                case "vertical": 
                    // if the direction is vertical, we move the intCurrRow to down
                    intCurrRow = intRow + i;
                    break;
                case "diagonal":
                    // if the direction is diagonal both intCurrRow and intCurrColumn will move one cell
                    intCurrRow = intRow + i;
                    intCurrColumn = intColumn + i;
                    break;
                default:
                    break;
            }
            
            // declaring cellValue that stores current letter's coordinates on the grid
            String cellValue = Integer.toString(intCurrRow) + Integer.toString(intCurrColumn);
            // using searchCoords method to check current letter's 
            // coordinates against all the button selections by the player 
            boolean found = searchCoords(playerSelection, cellValue);
            
            // if not found then word is not matched and return
            if (!found) {
                blnIsMatched = false;
                return blnIsMatched;
            }
        }
        
        // if executes until this point then the boolean is true so it is matched
        blnIsMatched = true;
        
        return blnIsMatched;
    }
    
    /**
     * this method is used to get all the cell coordinates 
     * to deal with the whole word rather than one letter at a time (duplicate of above)
     * @return an arrayList of string coordinates of each letter placed on the grid from this word
     */
    public ArrayList<String> getWordSpan(){
        ArrayList<String> wordSpan = new ArrayList<String>();
        
        // loop through all the letter in the word
        for (int i = 0; i < this.strWord.length(); i++) {
            // declaring integers
            int intCurrRow = intRow, intCurrColumn = intColumn;
            switch(strDirection) {
                case "horizontal":
                    intCurrColumn = intColumn + i;
                    break;
                case "vertical": 
                    intCurrRow = intRow + i;
                    break;
                case "diagonal":
                    intCurrRow = intRow + i;
                    intCurrColumn = intColumn + i;
                    break;
                default:
                    break;
            }
            wordSpan.add(Integer.toString(intCurrRow) + Integer.toString(intCurrColumn));
        }
        
        return wordSpan;
    }
    
    /**
     * 
     * @param playerSelection is the array list of numbers that the player selected for cell location
     * @param strTarget is the target letter
     * @return 
     */
    public boolean searchCoords(ArrayList<String> playerSelection, String strTarget){
        for(int i = 0; i < playerSelection.size(); i++){
            // checking to see if the player selection is equal to it
            if(playerSelection.get(i).equals(strTarget))  {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @return true or false if word should be backwards or not
     */
    public boolean decideIsBackward() {
        int intChoice = randomizeInt(2);
        if (intChoice == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param intMax is the maximum row of the grid subtract the word length to make sure it fits
     * @return a randomized row
     */
    public int randomizeRowIndex(int intMax) {
        return randomizeInt(intMax - this.strWord.length());
    }
    
    /**
     * 
     * @param intMaxis the maximum column of the grid subtract the word length to make sure it fits
     * @return a randomized column
     */
    public int randomizeColumnIndex(int intMax) {
        return randomizeInt(intMax - this.strWord.length());
    }
    
    /**
     * 
     * @return a direction for the word
     */
    public String decideDirection() {
        int intChoice = randomizeInt(3);

        switch(intChoice) {
            case 1: 
                return "vertical";
            case 2: 
                return "diagonal";
            default:
                return "horizontal";
        }
    }
    
    /**
     * 
     * @param intMax a defined maximum range
     * @return a random number
     */
    private int randomizeInt(int intMax) {
        Random rand = new Random();
        return rand.nextInt(intMax);
    }
}
