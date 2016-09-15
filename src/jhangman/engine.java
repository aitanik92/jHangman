/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jhangman;

/**
 *
 * @author Gaetano
 */
public class engine {
    
//Member Fields
    String mWordToGuess = "";
    String mGameStatus = "";
    
    //game constructor
    public engine(String word)
    {
    
        mWordToGuess = word;
        mGameStatus = getDashedWord(mWordToGuess);
    }
    
    public String getGameStatus()
    
    {
        return mGameStatus;
    }
    
    public void setGameStatus(String status)
    
    {
        mGameStatus = status;
    }
    
    
    public String getDashedWord(String word)
    {
        String temp = "";
        for (int i = 0; i < word.length(); i++) 
        {
            temp += "-";
        }
        return temp;
    }
    
    
    
    public static boolean isContained(char myChar, String myWord)
    {
        return myWord.indexOf(myChar) >-1;
    }
    
    public void applyGuess(char myChar)
    {
        
        char[] wordChars = mWordToGuess.toCharArray();
        char[] statusChars = mGameStatus.toCharArray();
        
                
        if (isContained(myChar,mWordToGuess)) 
        {
            
            
            for (int j = 0; j < mWordToGuess.length(); j++)
            {
                
                if (wordChars[j]== myChar)
                {
                    if (statusChars[j] == '-') 
                    {
                        //System.out.print("is statusChars("+j+") = - :" + Boolean.toString(statusChars[j] == '-' )+ "\n");
                        statusChars[j] = myChar;
                    }
                    
                }
               // System.console().readLine();
            }
            
            
        }
        setGameStatus(String.copyValueOf(statusChars));
    }
    
    public static void unMask()
    {
        
    }
    
    public boolean isAlreadyGuessed(char myChar)
    
    {
        return (mGameStatus.indexOf(myChar) >= 0);
    }
    
}
