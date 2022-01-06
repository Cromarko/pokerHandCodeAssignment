package pokerHand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sorter {
  public static final String TIE = "Unfortunately, the tie breaks were not enough. There is a tie.";
  public static void main(String[] args) {
    int winsPlayer1 = 0;
    int winsPlayer2 = 0;

    BufferedReader br = null;

    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      while (true) {
        String input = br.readLine();
        if (input == null) {
          break;
        }
        if (!input.matches("(?:[2-9TJQKA][SCHD] ){9}[2-9TJQKA][SCHD]")) {
          System.out.println("Wrong input format.");
          break;
        }

        String[] cards = input.split(" ");
        String[] handOneStr = Arrays.copyOfRange(cards, 0, 5);
        String[] handTwoStr = Arrays.copyOfRange(cards, 5, 10);

        Hand handOne = new Hand(handOneStr);
        Hand handTwo = new Hand(handTwoStr);

        handOne.sortCards();
        handTwo.sortCards();

        handOne.evaluate();
        handTwo.evaluate();
        int res = winner(handOne, handTwo);
        if (res == 1) {
          winsPlayer1++;
        } else if (res == 2) {
          winsPlayer2++;
        } else {
          System.out
            .println(TIE);
        }
      }

      System.out.println("Player 1: " + winsPlayer1 + " hands");
      System.out.println("Player 2: " + winsPlayer2 + " hands");

      System.exit(0);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int winner(Hand hand1, Hand hand2) {

    if (hand1.getHandCategory().getValue() > hand2.getHandCategory()
      .getValue()) {
      return 1;
    } else if (hand1.getHandCategory().getValue() < hand2.getHandCategory()
      .getValue()) {
      return 2;
    } else if (hand1.getHandValue() > hand2.getHandValue()) {
      return 1;
    } else if (hand1.getHandValue() < hand2.getHandValue()) {
      return 2;
    } else {
      for (int i = 4; i >= 0; i--) {
        if (hand1.getCard(i).getValue() > hand2.getCard(i).getValue()) {
          return 1;
        } else if (hand1.getCard(i).getValue() < hand2.getCard(i).getValue()) {
          return 2;
        }
      }
      return -1;
    }

  }
}