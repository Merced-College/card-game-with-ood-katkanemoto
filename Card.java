/**
 * Represents a playing card with a suit and rank.
 * This class follows Java standards with proper encapsulation,
 * constructors, accessors, mutators, and toString method.
 * 
 * @author Kanemoto
 * @date June 18, 2025  
 * @version 1.0
 */

public class Card {
    
    // Constants for suits
    public static final String HEARTS = "Hearts";
    public static final String DIAMONDS = "Diamonds";
    public static final String CLUBS = "Clubs";
    public static final String SPADES = "Spades";
    
    // Constants for ranks
    public static final String ACE = "Ace";
    public static final String JACK = "Jack";
    public static final String QUEEN = "Queen";
    public static final String KING = "King";
    
    // Instance variables
    private String suit;
    private String rank;
    private int value;
    private String picture; 
    
    /**
     * Default constructor creates an Ace of Spades.
     */
    public Card() {
        this.suit = SPADES;
        this.rank = ACE;
        this.value = 1;
    }
    
    /**
     * Constructor with suit and rank parameters.
     * 
     * @param suit the suit of the card (Hearts, Diamonds, Clubs, Spades)
     * @param rank the rank of the card (Ace, 2-10, Jack, Queen, King)
     */
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = calculateValue(rank);
    }
    
   
    /**
     * Constructor with suit, rank, and value parameters.
     * 
     * @param suit the suit of the card
     * @param rank the rank of the card
     * @param value the numerical value of the card
     */
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    
    /**
     * Constructor to read in the objects in the order of the file text input
     * 
     * @param other the card to copy
     */
    public Card(String suit, String rank, int value, String picture) {
       
            this.suit = suit;
            this.rank = rank;
            this.value = value;
            this.picture = picture;
       
    }
    
    // Accessor methods (getters)
    
    /**
     * Gets the suit of the card.
     * 
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }
    
    /**
     * Gets the rank of the card.
     * 
     * @return the rank of the card
     */
    public String getRank() {
        return rank;
    }
    
    /**
     * Gets the numerical value of the card.
     * 
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Gets the picture of the card.
     * 
     * @return the picture of the card
     */
    public String getPicture() {
        return picture;
    }
    
    // Mutator methods (setters)
    
    /**
     * Sets the suit of the card.
     * 
     * @param suit the new suit for the card
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    /**
     * Sets the rank of the card.
     * 
     * @param rank the new rank for the card
     */
    public void setRank(String rank) {
        this.rank = rank;
        this.value = calculateValue(rank); // Update value when rank changes
    }
    
    /**
     * Sets the numerical value of the card.
     * 
     * @param value the new value for the card
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Sets both the rank and value of the card.
     * 
     * @param rank the new rank for the card
     * @param value the new value for the card
     */
    public void setRankAndValue(String rank, int value) {
        this.rank = rank;
        this.value = value;
    }
    
    /**
     * Sets the picture of the card.
     * 
     * @param picture the new picture for the card
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    // Utility methods
    
    /**
     * Calculates the numerical value based on the rank.
     * 
     * @param rank the rank of the card
     * @return the numerical value corresponding to the rank
     */
    private int calculateValue(String rank) {
        if (rank == null) {
            return 0;
        }
        
        switch (rank.toLowerCase()) {
            case "ace":
                return 1;
            case "jack":
                return 11;
            case "queen":
                return 12;
            case "king":
                return 13;
            default:
                // Try to parse as number (2-10)
                try {
                    int numValue = Integer.parseInt(rank);
                    if (numValue >= 2 && numValue <= 10) {
                        return numValue;
                    }
                } catch (NumberFormatException e) {
                    // Invalid rank, return 0
                }
                return 0;
        }
    }
    
    /**
     * Checks if this card is equal to another object.
     * Two cards are equal if they have the same suit and rank.
     * 
     * @param obj the object to compare with
     * @return true if the cards are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card card = (Card) obj;
        return suit != null ? suit.equals(card.suit) : card.suit == null &&
               rank != null ? rank.equals(card.rank) : card.rank == null;
    }
    
    /**
     * Returns a hash code for this card.
     * 
     * @return a hash code value for this card
     */
    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }
    
    /**
     * Returns a string representation of the card.
     * 
     * @return a string in the format "Rank of Suit (Value: X)"
     */
    @Override
    public String toString() {
        return rank + " of " + suit + " (Value: " + value + ")";
    }
    
    /**
     * Returns a short string representation of the card.
     * 
     * @return a string in the format "Rank of Suit"
     */
    public String toShortString() {
        return rank + " of " + suit;
    }
    
    /**
     * Checks if this card is a face card (Jack, Queen, or King).
     * 
     * @return true if the card is a face card, false otherwise
     */
    public boolean isFaceCard() {
        return JACK.equalsIgnoreCase(rank) || 
               QUEEN.equalsIgnoreCase(rank) || 
               KING.equalsIgnoreCase(rank);
    }
    
    /**
     * Checks if this card is an Ace.
     * 
     * @return true if the card is an Ace, false otherwise
     */
    public boolean isAce() {
        return ACE.equalsIgnoreCase(rank);
    }
    
    /**
     * Checks if the card is valid (has valid suit and rank).
     * 
     * @return true if the card is valid, false otherwise
     */
    public boolean isValid() {
        return isValidSuit(suit) && isValidRank(rank);
    }
    
    /**
     * Checks if a suit is valid.
     * 
     * @param suit the suit to validate
     * @return true if the suit is valid, false otherwise
     */
    private boolean isValidSuit(String suit) {
        return suit != null && 
               (HEARTS.equalsIgnoreCase(suit) || 
                DIAMONDS.equalsIgnoreCase(suit) || 
                CLUBS.equalsIgnoreCase(suit) || 
                SPADES.equalsIgnoreCase(suit));
    }
    
    /**
     * Checks if a rank is valid.
     * 
     * @param rank the rank to validate
     * @return true if the rank is valid, false otherwise
     */
    private boolean isValidRank(String rank) {
        if (rank == null) {
            return false;
        }
        
        // Check face cards and ace
        if (ACE.equalsIgnoreCase(rank) || 
            JACK.equalsIgnoreCase(rank) || 
            QUEEN.equalsIgnoreCase(rank) || 
            KING.equalsIgnoreCase(rank)) {
            return true;
        }
        
        // Check number cards (2-10)
        try {
            int numValue = Integer.parseInt(rank);
            return numValue >= 2 && numValue <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}