/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

import javax.swing.JFrame;

/**
 *
 * @author Helena Xu
 * August 25th, 2021
 * This program serves as my CPT for ICS4UE. It is a digital version of a word search game. 
 * There are three different levels and the code involves different topics and algorithms
 * we learned in class such as recursion, searching, and object oriented programming!
 */
public class WordSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // main method entry point that executes IntroScreen code 
        IntroScreen myGame = new IntroScreen();
        myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGame.setVisible(true);    
    }
    
}
