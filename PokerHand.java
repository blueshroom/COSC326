import java.util.*;
import java.lang.Exception;

public class PokerHand {
  
  public static Scanner input = new Scanner(System.in);
  public static String inputLine = new String();
  public static String[] cards;
  public static String[] seperators = {"-", "/", " "};
  public static List<String> suits = new ArrayList<String>(Arrays.asList("C", "D", "H", "S"));
  public static List<String> royals = new ArrayList<String>(Arrays.asList("J", "Q", "K", "A"));
  public static boolean invalid = false;
  
  
  public static void main(String[] args) {
    seperateCards();
    int i = 0;
    String fixedCard = "";
    //check and fix each card in the hand
    while(!invalid && i < 5){
      fixedCard = fixCard(cards[i]);
      if(fixedCard.equals("Invalid")){
        invalid = true;
      }
      cards[i] = fixedCard;
      i++;
    }
    if(!invalid){
      if(checkDuplicates() == "Invalid"){
        invalid = true;
      }
      System.out.println("Sorting");
      sortHand();
      if(!invalid){
        //printing the final hand.
        for(i = 0; i < cards.length; i++){
          System.out.print(cards[i] + " ");
        }
      } else {
        System.out.println("Invalid: " + inputLine);
      }
    } else {
      System.out.println("Invalid: " + inputLine);
    }
    
  }
  
  
  //seperates cards into an array.
  //determine if the cards are seperated properly.
  public static void seperateCards(){
    inputLine = input.nextLine();
    for(int i = 0; i < seperators.length; i++){
      String[] hand;
      hand = inputLine.split(seperators[i]);
      if(hand.length == 5){
        cards = hand;
      }
    }
    if(cards == null){
      System.out.println("ERROR: Cards wern't represented properly");
      invalid = true;            
    }
  }
  
  
  //takes a single card and fixes it into its correct syntax.
  public static String fixCard(String card){
    String finalValue;
    String finalSuit;
    String value;
    String suit;
    
    if(card.length() == 2){
      value = String.valueOf(card.charAt(0));
      suit = String.valueOf(card.charAt(1));
    } else if(card.length() == 3){
      value = String.valueOf(card.substring(0, 2));
      suit = String.valueOf(card.charAt(2));
    } else {
      return "invalid";
    }
    
    //if next value is a number.
    if(Character.isDigit(value.charAt(0))){
      int numberValue = Integer.parseInt(value);
      if( numberValue > 10 || numberValue == 1){
        //switch the current value to its letter if required.
        switch(numberValue){
          case 1:
            finalValue = "A";
            break;
          case 11:
            finalValue = "J";
            break;
          case 12:
            finalValue = "Q";
            break;
          case 13:
            finalValue = "K";
            break;
          default:
            return "Invalid";
        }
      } else {
        finalValue = String.valueOf(numberValue);        
      }
      //if the next value is not a number.
    } else {
      value.toUpperCase();
      if(royals.contains(value)){
        finalValue = value;
      } else if(value.equals("T")){
        finalValue = "10";
      } else {
        return "Invalid";
      }
    }
    
    //correcting the suit
    suit = suit.toUpperCase();
    if(suits.contains(suit)){
      finalSuit = suit;
    } else {
      return "Invalid";
    }
    
    if(finalValue != null && finalSuit != null){
      return (finalValue + finalSuit);
    }
    return "Invalid";
  }
  
  public static String checkDuplicates(){
    for(int i = 0; i < cards.length; i++){
      int cardCounter = 1;
      String value = getCardValue(cards[i]);
      String suit = getCardSuit(cards[i]);
      
      for(int j = 0; j < cards.length; j++){
        if(cardCounter > 4){
          //too many cards of the same value
          return "Invalid";
        }
        //if we are not looking at the card we are comparing to others.
        if(i != j){
          if(getCardValue(cards[j]).equals(value)){
            cardCounter++;
            if(getCardSuit(cards[j]).equals(suit)){
              //two identical cards
              return "Invalid";
            }
          }
        }
      } 
    }
    return "Success";
  }
  
  public static void sortHand(){
    //determining if the card is smaller than the one to the left of it.
    for(int i = 1; i < cards.length; i++){
      String currentCard = cards[i];
      int pos = i;
      System.out.println("currentCard = " + currentCard);
      while(pos > 0 && cardIsLarger(currentCard, cards[pos-1])){
        cards[pos] = cards[pos-1];
        pos--;
      }
      cards[pos] = currentCard;
    }
  }
  
  public static String getCardValue(String card){
    if(card.length() < 3){
      return card.substring(0, 1);
    } else {
      return card.substring(0, 2);
    }
  }
  
  public static String getCardSuit(String card){
    if(card.length() < 3){
      return card.substring(1);
    } else {
      return card.substring(2);
    }
  }
  
  //subject is the current card we are checking.
  //comparison is the card we are comparing the subject to, to see if the subject it smaller than it.
  public static boolean cardIsLarger(String subject, String comparison){
    //if the value of the card is the same as the one to the left of it.
    if(getCardValue(subject).equals(getCardValue(comparison))){
      //check the suit, if the card to the left has a smaller suit, make cardIsSmaller true.
      if(getCardSuit(subject).charAt(0) < getCardSuit(comparison).charAt(0)){
        return false;
      }
      //if the card is a J, Q, K or A.
    } else if((int)getCardValue(subject).charAt(0) > 4 || (int)getCardValue(comparison).charAt(0) > 4){
      if(royals.indexOf(getCardValue(subject)) < royals.indexOf(getCardValue(comparison))){
        return false;
      }
    } else {
      //if the value of the card is a number between 2-10 inclusive.
      if(Integer.valueOf(getCardValue(subject)) < Integer.valueOf(getCardValue(comparison))){
        return false;
      }
    }
    return true;
  }
  
}
