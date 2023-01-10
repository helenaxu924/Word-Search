/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

/**
 * This is an abstract Word class that defines the structure of the word
 * @author helenaxu
 */
public abstract class Word {
    
    // Declaring a string variable to store a word in the wordsearch
    String strWord;
    
    /**
     * This is the Word abstract class constructor
     * @param _strWord is a string that holds the word
     */
    public Word(String _strWord){
        strWord = _strWord;
    }
    
    /**
     * 
     * @return the word that is split by each of the letters 
     */
    public String[] getLetters(){
        return strWord.split("");
    }
}
