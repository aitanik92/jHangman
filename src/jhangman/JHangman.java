/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhangman;

import java.util.Scanner;
import java.io.Console;
import java.io.IOException;

public class JHangman {

    public String progress;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declaring
        String word;
        String inputRead;
        int attemptsAmount = 0;
        char attempt;
        Scanner scanner = new Scanner(System.in);
        
        //checking input parameter
          if ((args.length) == 0) 
        {
            writeLine("No input argument found");
            System.exit(0);
        }  
    
        //using 1st parameter as a word  
        word = args[0];
        
        //pass word to the engine
        engine Game = new engine(word);
        
        //clearScreen();
        writeLine("The word to guess has " + Integer.toString(word.length()) + " letters:");
        writeLine(Game.getGameStatus());
        
       
        do  {
            writeLine("Type a char or try to guess the word : (" + Integer.toString(7 - attemptsAmount) + " lives left)");
            attempt = scanner.nextLine().charAt(0);
            if (Game.isAlreadyGuessed(attempt)) 
            { 
                clearScreen();
                writeLine(Character.toString(attempt) + " has already been guessed.");
                writeLine(Game.getGameStatus());

            }
            else
            {
                Game.applyGuess(attempt);
                clearScreen();
                writeLine(Game.getGameStatus());
                if (word.indexOf(attempt) < 0) 
                {
                   attemptsAmount += 1;    
                }
                
                
            }
            
            }
        
        while (attemptsAmount < 7);
        
    }
    
    public static void writeLine(String line)
    {
        System.out.println(line);
    }
    
    public static void clearScreen()
    
    {
        System.out.print("\033[H\033[2J");
    }   
    
  
    
}
