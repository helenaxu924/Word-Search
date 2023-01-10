

package word.search;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The PlayerFile class is used to read and write from the PlayerData.txt file along with 
 * keeping track of win and lose counts 
 * @author helenaxu
 */
public class PlayerFile extends File {
    public PlayerFile() {
        super("PlayerData.txt");
    }
    
    /**
     * 
     * @param blnPlayerWon is a boolean parameter that checks if the player has won the entire game
     */
    public void savePlayerData(boolean blnPlayerWon) {
        // Calling getPlayerData method from itself and assigning it to an integer array
        int[] intPlayerData = this.getPlayerData();
        // The first value of the integer array is assigned to an integer wincount, and the second is the losecount
        int winCount = intPlayerData[0], loseCount = intPlayerData[1];
        
        //checking parameter 
        if (blnPlayerWon) {
            // Adding 1 to win count as player won
            winCount++;
        } else {
                // Adding 1 to lose count as player lost using else statement
                loseCount++;
        }
        String strContent = Integer.toString(winCount)  + "\n" + Integer.toString(loseCount);
        // Calling .setContent method from itself using the implementation from the parent class 
        this.setContent(strContent);
    }
    
    /**
     * 
     * @return an integer of the player data of win and lose counts
     */
    public int[] getPlayerData() {
        // Declaring an integer array that stores two values of the playerdata
        int[] intPlayerData = new int[2];
        String[] strContent = this.getContent().split("\n");
        // separating the array by first and second value after parsing to int
        intPlayerData[0] = Integer.parseInt(strContent[0]);
        intPlayerData[1] = Integer.parseInt(strContent[1]);
        return intPlayerData;
    }
}
