import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
public class Main
{
  public static void main(String[] args)
  {
   Scanner scan = new Scanner(System.in); 
   System.out.println("Welcome to Old Graduate! A variation of the card game, Old Maid! Below are the cards being used in the game, with an addition of a \"Graduate\" card that will be the number -1!\n"); 
    int[][] cards = new int[5][13]; 
    for (int row = 0; row < 4; row++)
    {
      int count = 0; 
      for (int col = 0; col < 13; col++)
      {
        count++; 
        cards[row][col] = count; 
        System.out.print(cards[row][col] + " ");
      }
      cards[4][1] = -1; 
      System.out.println();
    }
    System.out.print(cards[4][1] + "\n"); 
    System.out.println("\nWould you like to play Old Graduate? Type \"YES\"."); 
    String reply = scan.nextLine(); 
    if (reply.toUpperCase().equals("YES"))
    {
     System.out.println("\nHello! The game is simple, you will start with five cards. During your turn, you are required to draw two cards: one from the game deck and the other from your opponent's hands. Afterwards, you will have the chance to match cards in your deck that have the same number. Once all matches are completed, the person who is holding the Graduate Card (-1) is the loser.\n"); 
      Play b = new Play(); 
      b.player1();
    }
    else 
    {
      System.out.println("Aw that's too bad... I hope you'll come back to play!"); 
    }
  }
}
