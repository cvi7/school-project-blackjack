package me.potato.applications.enums;

public enum Card {

    ACE_OF_SPADES(1, Suit.SPADES),
    ACE_OF_HEARTS(1, Suit.HEARTS),
    ACE_OF_DIAMONDS(1, Suit.DIAMONDS),
    ACE_OF_CLUBS(1, Suit.CLUBS),

    TWO_OF_SPADES(2, Suit.SPADES),
    TWO_OF_HEARTS(2, Suit.HEARTS),
    TWO_OF_DIAMONDS(2, Suit.DIAMONDS),
    TWO_OF_CLUBS(2, Suit.CLUBS),

    THREE_OF_SPADES(3, Suit.SPADES),
    THREE_OF_HEARTS(3, Suit.HEARTS),
    THREE_OF_DIAMONDS(3, Suit.DIAMONDS),
    THREE_OF_CLUBS(3, Suit.CLUBS),

    FOUR_OF_SPADES(4, Suit.SPADES),
    FOUR_OF_HEARTS(4, Suit.HEARTS),
    FOUR_OF_DIAMONDS(4, Suit.DIAMONDS),
    FOUR_OF_CLUBS(4, Suit.CLUBS),

    FIVE_OF_SPADES(5, Suit.SPADES),
    FIVE_OF_HEARTS(5, Suit.HEARTS),
    FIVE_OF_DIAMONDS(5, Suit.DIAMONDS),
    FIVE_OF_CLUBS(5, Suit.CLUBS),

    SIX_OF_SPADES(6, Suit.SPADES),
    SIX_OF_HEARTS(6, Suit.HEARTS),
    SIX_OF_DIAMONDS(6, Suit.DIAMONDS),
    SIX_OF_CLUBS(6, Suit.CLUBS),

    SEVEN_OF_SPADES(7, Suit.SPADES),
    SEVEN_OF_HEARTS(7, Suit.HEARTS),
    SEVEN_OF_DIAMONDS(7, Suit.DIAMONDS),
    SEVEN_OF_CLUBS(7, Suit.CLUBS),

    EIGHT_OF_SPADES(8, Suit.SPADES),
    EIGHT_OF_HEARTS(8, Suit.HEARTS),
    EIGHT_OF_DIAMONDS(8, Suit.DIAMONDS),
    EIGHT_OF_CLUBS(8, Suit.CLUBS),

    NINE_OF_SPADES(9, Suit.SPADES),
    NINE_OF_HEARTS(9, Suit.HEARTS),
    NINE_OF_DIAMONDS(9, Suit.DIAMONDS),
    NINE_OF_CLUBS(9, Suit.CLUBS),

    TEN_OF_SPADES(10, Suit.SPADES),
    TEN_OF_HEARTS(10, Suit.HEARTS),
    TEN_OF_DIAMONDS(10, Suit.DIAMONDS),
    TEN_OF_CLUBS(10, Suit.CLUBS),

    JACK_OF_SPADES(10, Suit.SPADES),
    JACK_OF_HEARTS(10, Suit.HEARTS),
    JACK_OF_DIAMONDS(10, Suit.DIAMONDS),
    JACK_OF_CLUBS(10, Suit.CLUBS),

    QUEEN_OF_SPADES(10, Suit.SPADES),
    QUEEN_OF_HEARTS(10, Suit.HEARTS),
    QUEEN_OF_DIAMONDS(10, Suit.DIAMONDS),
    QUEEN_OF_CLUBS(10, Suit.CLUBS),

    KING_OF_SPADES(10, Suit.SPADES),
    KING_OF_HEARTS(10, Suit.HEARTS),
    KING_OF_DIAMONDS(10, Suit.DIAMONDS),
    KING_OF_CLUBS(10, Suit.CLUBS);

    private int value;
    private Suit suit;

    Card(int value, Suit suit) {

        this.value = value;
        this.suit = suit;

    }

    public int getValue() { return value; }

    public Suit getSuit() {
        return suit;
    }

}
