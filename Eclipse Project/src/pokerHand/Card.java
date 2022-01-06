package pokerHand;

public class Card implements Comparable < Card > {
  private int value;
  private char suit;

  public Card(String str) {
    char v = str.charAt(0);
    switch (v) {
    case 'T':
      this.value = 10;
      break;
    case 'J':
      this.value = 11;
      break;
    case 'Q':
      this.value = 12;
      break;
    case 'K':
      this.value = 13;
      break;
    case 'A':
      this.value = 14;
      break;
    default:
      this.value = Integer.parseInt("" + v);
      break;
    }

    this.suit = str.charAt(1);

  }

  public int compareTo(Card compareCard) {

    int compareValue = ((Card) compareCard).getValue();

    return this.value - compareValue;

  }

  public String toString() {
    String str = "";
    str = String.valueOf(this.value) + this.suit;
    return str;
  }

  public int getValue() {
    return this.value;
  }

  public char getSuit() {
    return this.suit;
  }
}