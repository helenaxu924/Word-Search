/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

// importing required packages
import java.util.ArrayList;
import java.util.Random;

/**
 * The WordsFile class is used to read from the Words.txt file along with 
 * the game logic necessary to select words
 * @author helenaxu
 */
public class WordsFile extends File {
    
    /**
     * This is the WordsFile class constructor
     * Once this class is instantiated, Words.txt file is targeted
     */
    public WordsFile() {
        super("Words.txt");
    }
    
    /**
     * @param intAmount is the integer value of the amount of words required for each level
     * @return a string array that stores a list of all words with the required amount of words
     */
    public ArrayList<String> getWords(int intAmount){
        String rawText = this.getContent();
        
        String[] wordLines = rawText.split("\n");
        
        // converting all letters to lowercase
        for (int i = 0; i < wordLines.length; i++){
            wordLines[i] = wordLines[i].toLowerCase();
        }
        
        ArrayList<String> strTempLines = new ArrayList<String>();
        
        for(int i = 0; i < wordLines.length; i++ ) {
            if (wordLines[i].length() == 4) {
                strTempLines.add(wordLines[i]);
            }
        }
        
        // Recursion that loops through the string array list of the specified amount of 
        // words and removing a random word each time until only the specified amount of 
        // words are remaining (only 4, 5, or 6 words)
        shrinkList(strTempLines, intAmount);
        
        return strTempLines;
    }
    
    /**
     * Recursive method 
     * @param strTempLines 
     * @param intAmount 
     */
    private void shrinkList(ArrayList<String> strTempLines, int intAmount) {
        // Base case to avoid infinite loop
        if (strTempLines.size() == intAmount) return;
        
        Random rand = new Random();
        // generating random number within the size of the amount of words 
        int intRandom = rand.nextInt(strTempLines.size()-0) + 0;
        strTempLines.remove(intRandom);
        
        // calling it again in recursion 
        shrinkList(strTempLines, intAmount);
    }
}
