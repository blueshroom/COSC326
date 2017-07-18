import java.util.*;
import java.lang.Exception;

public class PokerHand {
    
    public static Scanner input = new Scanner(System.in);
    public static String inputLine = new String();
    public static String[] cards;
    public static String[] seperators = {"-", "/", " "};
    public static List<String> suits = new ArrayList<String>(Arrays.asList("C", "D", "H", "S"));
    public static List<String> royals = new ArrayList<String>(Arrays.asList("A", "J", "Q", "K"));
    public static String finalHand = new String();
    public static boolean invalid = false;
    

    public static void main(String[] args) {
        seperateCards();
        int i = 0;
        String result = "";
        //check and fix each card in the hand
        while(!invalid && i < 5){
            result = fixCard(cards[i]);
            System.out.println("Fixed Card: " + i);
            if(result.equals("invalid")){
              invalid = true;
            }
            finalHand = finalHand + (result + " ");
            i++;
        }
        if(!invalid){
            System.out.println(finalHand);
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
            System.out.println("cards were null");
            invalid = true;            
        }
    }
    
    public static String fixCard(String card){
        System.out.println("Fixing card: " + card);
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
                        return "invalid";
                }
            } else {
                finalValue = String.valueOf(numberValue);
                System.out.println(finalValue);
                
            }
        //if the next value is not a number.
        } else {
          value.toUpperCase();
                    if(royals.contains(value)){
                      finalValue = value;
                    } else if(value == "T"){
                      finalValue = "10";
                    } else {
                      return "invalid";
                    }
        }
        
        //correcting the suit
        suit = suit.toUpperCase();
        if(suits.contains(suit)){
          finalSuit = suit;
        } else {
          return "invalid";
        }
        
        if(finalValue != null && finalSuit != null){
          System.out.println(finalValue + finalSuit);
          return (finalValue + finalSuit);
        }
        return "invalid";
    }
    
}
