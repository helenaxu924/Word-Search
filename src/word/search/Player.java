/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

import java.util.ArrayList;

/**
 * The Player class is used to define the player selections
 * @author helenaxu
 */
public class Player {
    
    // Declaring string to hold selected level
    String strLevel;
    //Declaring a string arraylist that holds all of the selections
    ArrayList<String> strSelections = new ArrayList<String>();
    // Declaring integers to hold the lose and win count of games
    int winCount, loseCount;
    
    /**
     * This is the Player class constructor
     * @param _level is a string that stores the selected level 
     */
    public Player(String _level) {
        strLevel = _level;
    }
    
    /**
     * 
     * @param strLocation is a string of the player's selected button's coordinates
     */
    public void addSelection(String strLocation) {
        strSelections.add(strLocation);
    }
    
    /**
     * This method clears the strSelections array list for new inputs
     */
    public void clearSelection() {
        strSelections = new ArrayList<String>();
    }
}
