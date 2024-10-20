import java.util.Scanner;
import java.util.*; 
import java.util.ArrayList;
public class Play
{
  // public variables
  Scanner scan = new Scanner(System.in);
  ArrayList<Integer> deck1 = new ArrayList<Integer>(); 
  ArrayList<Integer> deck2 = new ArrayList<Integer>(); 
  int roundcount; 

  // method to check if overall deck still has cards  
  public boolean cardsleft(int[][] array) 
  { 
    boolean deck = false;
    for (int i[] : array) 
      {
        for (int j : i)
          {
            //if there are still cards that are not "0", then deck exists 
            if (j != 0)
            {
              deck = true; 
              break;
            }
          }
      }
    return deck;
  }

  public void matches()
  {
    System.out.println("\nYour current deck is: " + deck1 + "\nHow many matches do you have have? Example Answer: 0"); 
    int reply = scan.nextInt();
    System.out.print("\n");
    if (reply > 0)
    {
      System.out.println("Nice! Type the positions of the cards in your deck that are matched in corresponding order. Positions starts at 0."); 
      int a = scan.nextInt(); 
      int b = scan.nextInt(); 
      if (deck1.get(a) == deck1.get(b))
      {
        System.out.println("\nNice! This pair will be removed from your deck.\n"); 
        deck1.remove(a); 
        deck1.remove(b-1); 
      }
      else 
      {
        System.out.println("\nHmm... these two cards don't seem to be a match. Let's move on."); 
      }
    }

      if (reply > 1)
      {
        System.out.println("\nYour current deck is: " + deck1 + "\nType the positions of the cards in your deck that are matched in corresponding order. Positions starts at 0."); 
        int x = scan.nextInt(); 
        int y = scan.nextInt(); 
        if (deck1.get(x) == deck1.get(y))
        {
          System.out.println("\nNice! This pair will be removed from your deck.\n"); 
          deck1.remove(x); 
          deck1.remove(y-1); 
        }
        else 
        {
          System.out.println("\nHmm... these two cards don't seem to be a match. Let's move on."); 
        }
      }
  }

  public void opponentmatch()
  {
    for (int i = 0; i < deck2.size(); i++)
    {
      int check1 = deck2.get(i); 
      for (int j = i + 1; j < deck2.size(); j++)
      if (check1 == deck2.get(j))
      {
        deck2.remove(i); 
        deck2.remove(j-1); 
      }
    }
  }
  
  public void opponentgrab()
  {
    if (deck1.size() > 0)
      {
        int steal = (int)(Math.random() * deck1.size());
        {
            deck2.add(deck1.get(steal)); 
            deck1.remove(steal); 
        }
      }
  }

  public void playergrab()
  {
    //draw from opponent's cards
        if (deck2.size() > 0)
        {
        System.out.println("\nNow draw from your opponent's deck! They currently have " + deck2.size() + " cards. Reminder: positions start at 0."); 
        int choose = scan.nextInt(); 
        {
          if (choose < deck2.size())
          {
            deck1.add(deck2.get(choose)); 
            deck2.remove(choose); 
          }
          else if (choose > deck2.size() || choose < 0)
          {
            System.out.println("The position you chose does not exist in the number of cards your opponent has. Try again."); 
            int chooseagain = scan.nextInt(); 
            while (chooseagain < 0 || chooseagain > deck2.size() - 1)
              {
                System.out.println("Try again..."); 
                chooseagain = scan.nextInt(); 
              }
            deck1.add(deck2.get(chooseagain)); 
            deck2.remove(chooseagain); 
          }
          else
          {
          }
        }
        }
        else 
        {
          System.out.println("You cannot draw from your opponent's deck because they have run out of cards."); 
        }
  }
  
  public void player1()
  {
    // creating card pile
    int[][] cards = new int[5][13];
    for (int row = 0; row < 4; row++) 
      {
        int count = 0; 
        for (int col = 0; col < 13; col++)
        {
          count++; 
          cards[row][col] = count; 
        }
      }
      for (int row = 4; row < 5; row++)
      {
        for (int col = 0; col < 13; col++)
        {
          cards[row][col] = 0;
          cards[4][0] = -1; 
        }
      }
    
    System.out.println("After shuffling, this will be your beginning deck of cards!");
    for (int start = 0; start < 5; start++)
    {
      int row = (int)(Math.random() * 5); 
      int col = (int)(Math.random() * 13); 
      if (cards[row][col] != 0)
      {
        deck1.add(cards[row][col]); 
        cards[row][col] = 0; 
      }
      else 
      {
        while (cards[row][col] == 0)
        {
          row = (int)(Math.random() * 5); 
          col = (int)(Math.random() * 13); 
        }
        deck1.add(cards[row][col]); 
      }
    }
    
    for (int start = 0; start < 5; start++)
    {
      int row2 = (int)(Math.random() * 5); 
      int col2 = (int)(Math.random() * 13); 
      if (cards[row2][col2] != 0)
      {
        deck2.add(cards[row2][col2]); 
        cards[row2][col2] = 0; 
      }
      else 
      {
        while (cards[row2][col2] == 0)
        {
          row2 = (int)(Math.random() * 5); 
          col2 = (int)(Math.random() * 13); 
        }
        deck2.add(cards[row2][col2]); 
      }
    }
    
    //checks to see if deck2 has any matches, removes from deck2
    for (int i = 0; i < deck2.size(); i++)
    {
      int check = deck2.get(i); 
      for (int j = i + 1; j < deck2.size() - 1; j++)
      if (check == deck2.get(j))
      {
        deck2.remove(i); 
        deck2.remove(j-1); 
      }
    }
    
    System.out.println(deck1 + "\n"); 
    System.out.println("Do you have any matches? Type \"YES\" or \"NO\"."); 
    String answer = scan.nextLine(); 
    System.out.print("\n");
    if (answer.toUpperCase().equals("YES"))
    {
      System.out.println("Lucky draw! Type the positions of the cards in your deck that are matched in corresponding order. Positions start at 0."); 
      int a = scan.nextInt(); 
      int b = scan.nextInt(); 
      if (deck1.get(a) == deck1.get(b))
      {
        System.out.println("\nNice! This pair will be removed from your deck."); 
        deck1.remove(a); 
        deck1.remove(b-1); 
      }
      else 
      {
        System.out.println("\nHmm... these two cards don't seem to be a match. Let's move on."); 
      }
    }
    else
    {
      System.out.println("Having no pairs at the beginning is normal! Let's start the game by drawing more cards.");  
    }

    while (deck1.size() > 0)
      {
        roundcount++;
        System.out.println("\n\nStart Round " + roundcount + "!");
        
        // drawing card from overall deck
        if (cardsleft(cards))
        {
          System.out.println("A card will automatically be drawn from the overall deck.");
          int row3 = (int)(Math.random() * 5); 
          int col3 = (int)(Math.random() * 13); 
          if (cards[row3][col3] != 0)
          {
            deck1.add(cards[row3][col3]); 
            cards[row3][col3] = 0; 
          }
          else 
          {
            while (cards[row3][col3] == 0)
            {
              row3 = (int)(Math.random() * 5); 
              col3 = (int)(Math.random() * 13); 
            }
            deck1.add(cards[row3][col3]); 
          }
        }
        playergrab();
        matches(); 
        System.out.println("It's your opponent's turn! They will draw a card from the overall deck and a card from your hand as well.");
        //opponent takes from deck
        if (cardsleft(cards))
        {
          int row4 = (int)(Math.random() * 5); 
          int col4 = (int)(Math.random() * 13); 
          if (cards[row4][col4] != 0)
          {
            deck2.add(cards[row4][col4]); 
            cards[row4][col4] = 0; 
          }
          else 
          {
            while (cards[row4][col4] == 0)
            {
              row4 = (int)(Math.random() * 5); 
              col4 = (int)(Math.random() * 13); 
            }
            deck2.add(cards[row4][col4]); 
          }
        } 
        opponentgrab();
        opponentmatch();
    } 

    while (!(cardsleft(cards)))
      {
        playergrab(); 
        matches();
        opponentgrab(); 
        opponentmatch(); 
      }
    if (!(cardsleft(cards)))
    {
      {
        if (deck2.size() == 0 && deck1.size() == 1)
        {
          System.out.println("Darn! You ended up with the Graduate Card. Game Over."); 
        }
        else 
        {
          System.out.println("Congratulations! You beat your opponent and have graduated out of the game! They were stuck with the Graduate Card and have now become an \"Old Graduate\".");  
        }
      }
    }
  }     
}