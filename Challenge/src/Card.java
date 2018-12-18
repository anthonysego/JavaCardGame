//************************************************************************
//	Card.java
//
//	Name of Programmer: Anthony Sego
//
//  Date created/updated:  3/02/2018
//
//	Generates 1 card from a standard 52-card deck
//      toString() modified with switch statements to get face and suit values for cards
//************************************************************************

import java.util.Random;

public class Card
{

	//***********************************************************************************
	//  Instance variables
	//		face:   integer representing face value (1-13)
	//		suit:	integer representing suit value (1-4)
	//	 Static constants (1 set for all card objects)
	//		SUIT_HIGH   Highest integer value to generate for a suit
	//      FACE_HIGH   Highest integer value to generate for a face
	//***********************************************************************************

	private int face, suit;
	private static final int SUIT_HIGH = 4;
	private static final int FACE_HIGH = 13;

	//***********************************************************************************
	//  Constructors
	//***********************************************************************************

	public Card()
	{
		//--------------------------------------------------------------------------------
		//  Default constructor.  This calls the newCard( ) method to avoid duplicate code
		//--------------------------------------------------------------------------------
		dealNewCard();
	}

	public Card(int face, int suit)
	{
		//--------------------------------------------------------------------------------
		//  Not used by Challenge but included if the Card class
		//  understanding that another program that uses the Card class
		//  may need to redeal (reset) a card to a specific value.
		//--------------------------------------------------------------------------------
		this.face = face;
		this.suit = suit;
	}

	//***********************************************************************************
	//  Accessors for suit and face
	//***********************************************************************************

	public int getSuit()
		{ return suit; }

	public int getFace()
		{ return face; }


	//***********************************************************************************
	//  Mutators for suit and face - Provided only for illustration
	//  See Security Note in assignment about this
	//***********************************************************************************

	public void setFace(int face)
		{	this.face = face; }

	public void setSuit(int suit)
		{	this.suit = suit; }

	//***********************************************************************************
	//  Additional Methods:  dealNewCard()
	//						 getPoints()
	//						 equals() which overrided the equals() method from Object
	//***********************************************************************************



	public void dealNewCard()
	{
		//--------------------------------------------------------------------------------
		//  newCard( ) "deals" a new card"
		//--------------------------------------------------------------------------------

		Random gen = new Random();
		face = gen.nextInt(FACE_HIGH) + 1;
		suit = gen.nextInt(SUIT_HIGH) + 1;
	}

	public int getPoints()
	{
		//--------------------------------------------------------------------------------
		//  getPoints( ) returns the point value of a card based upon the value of face
		//--------------------------------------------------------------------------------

		int points;
		switch (face)
		{	case 1: case 2: case 3:
			case 4: case 5: case 6:
			case 7: case 8: case 9:
				points = face;
				break;
			default:
				points = 10;
			}
		return points;
	}

	public boolean equals(Card secondCard)
	{
		//--------------------------------------------------------------------------------
		//  equals( ) returns true if 2 Card objects have the same face and suit values
		//--------------------------------------------------------------------------------

		if (face == secondCard.getFace() &&
		        suit == secondCard.getSuit())
		        return true;
		    else return false;
	}

        
        
        
        //--------------------------------------------------------------------------------
	//  Modified toString method to display actual face and suit
        //  values together in a clean format.
        //--------------------------------------------------------------------------------

 	public String toString()
	{
            String displayFace;
            String displaySuit;
            
            //--------------------------------------------------------------------------------
	    //  switch case to determine actual card from integers generated for face value
            //--------------------------------------------------------------------------------
            switch(face){
                case 1: 
                    displayFace = "Ace";
                    break;
                case 2: case 3: case 4:
                case 5: case 6: case 7:
                case 8: case 9: case 10:
                    displayFace = Integer.toString(face);
                    break;
                case 11:
                    displayFace = "Jack";
                    break;
                case 12:
                    displayFace = "Queen";
                    break;
                case 13:
                    displayFace = "King";
                    break;
                default:
                    displayFace = " error in card draw, try again";
                    break;
            }
            
            
            //--------------------------------------------------------------------------------
	    //  switch case to determine actual suit from integers generated for suit value
            //--------------------------------------------------------------------------------
            switch(suit){
                case 1: 
                    displaySuit = " of Hearts";
                    break;
                case 2: 
                    displaySuit = " of Diamonds";
                    break;
                case 3: 
                    displaySuit = " of Clubs";
                    break;
                case 4: 
                    displaySuit = " of Spades";
                    break;
                default:
                    displaySuit = " error in card draw, try again";
                    break;
            }
            
            
            return (displayFace + displaySuit);
	}
}
