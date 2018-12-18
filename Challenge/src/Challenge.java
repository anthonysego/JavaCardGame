/*
Program Name:           Challenge Card Game
Author:                 Anthony Sego
Date:                   3/02/2018
Purpose of Program:     Use a provided Card class to generate a program simulating the card game war
                        One card is drawn for each player (2 player game).  Value of cards is determined
                        and a winner is chosen based on higher card value.
                        cards are based on a random generator. So, same cards being drawn is possible
                        A loop is included to redraw cards should that happen because that's not possible with a real deck.
                        A loop is included to continue playing or quit.  Validation on input (yes or no required)
                        A loop is included to prevent players from drawing.  If cards have same value, then cards are delt again
                        until a winner is chosen.*/


import java.util.Scanner;

public class Challenge {

    
    public static void main(String[] args) {
        
        int playerOnePoints = 0;
        int playerTwoPoints = 0;
        String playAgainCheck = "yes";
        
        Scanner scan = new Scanner (System.in);
        
        //------------------------------------------------------------
        //Play again loop.  Game will loop as long as user enters yes.
        //------------------------------------------------------------
        while(playAgainCheck.equals("yes")){
            System.out.println("\n\n\t>>>------[ Starting a new round ]-----<<<\n"
                    + "\n\t\t----[ Dealing cards ]----\n");
            
            //----------------------------------------------------------------------------------
            //do while loop.  Runs at least once.  Draws cards, evaluates points to choose a winner
            //loop prevents a tie from occuring.  While points are equal, it will run again.
            //Program set to state it was a draw before running again
            //----------------------------------------------------------------------------------
            do{
            
                //--------------------------------------------------
                //Create player1 and 2 cards with Card constructor
                //--------------------------------------------------
                Card playerOneCard = new Card();
                Card playerTwoCard = new Card();

                //--------------------------------------------------------------
                //Loop to redraw player two card if it is the same as player one
                //random # gen will allow identical draw, 
                //but would not be possible in actual deck of cards
                //--------------------------------------------------------------
                while (playerOneCard.equals(playerTwoCard)){
                     playerTwoCard = new Card();
                }
                
                
                //------------------------------------------------------------
                //Uses card class toString() to print actual cards 
                //instead of the int values for face and suit variables
                //------------------------------------------------------------
                System.out.println("\t>>> Player 1 drew: " + playerOneCard + "\n");
                System.out.println("\t>>> Player 2 drew: " + playerTwoCard + "\n");
                
                
                //----------------------------------------------------------------
                //Uses getPoints() method from card class to determine card values
                //----------------------------------------------------------------
                playerOnePoints = playerOneCard.getPoints();
                playerTwoPoints = playerTwoCard.getPoints();

                
                
                //--------------------------------------------------------------
                //if else statements to determine winner based on value of cards
                //If neither it greater than the other, it's a tie.
                //prints message saying its a tie and runs loop again
                //--------------------------------------------------------------
                if(playerOnePoints > playerTwoPoints){
                    System.out.println("\n\t*** Player 1 wins this round ***\n");
                }
                else if(playerTwoPoints > playerOnePoints){
                    System.out.println("\n\t*** Player 2 wins this round ***\n");
                }

                else
                    System.out.println("\n\n\t***The score is a draw.  Dealing cards again***\n"
                            + "\n\n\t\t----[Dealing cards]----\n");
            }
            
            //------------------------------------------------------
            // while part of do while loop. Ensures there is no draw
            //------------------------------------------------------
            while(playerOnePoints == playerTwoPoints);
                
            
            //--------------------------------------------------------
            //Check to see if user(s) wants to play again
            //--------------------------------------------------------
            System.out.print("\n\t>>> Would you like to play again (yes or no): ");
            playAgainCheck = scan.nextLine();
            
            
            //-----------------------------------------------------------------------
            //validation to make sure user uses yes or no to continue or end program.
            //------------------------------------------------------------------------
            while(!((playAgainCheck.equals("yes")) || (playAgainCheck.equals("no")))){
                System.out.print("\t***Not a valid answer***"
                        + "\n\t>>Would you like to play again? (yes or no): ");
            playAgainCheck = scan.nextLine();
            
            }

        }
            
    }
        
}
    

