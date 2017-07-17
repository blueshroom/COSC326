import java.util.*;

public class PokerHand {
    
    public static Scanner input = new Scanner(System.in);
    public static String inputLine = new String();
    public static String[] cards;
    public static char[] seperators = new char['-', '/', ' '];
    public static boolean invalid = false;
    

    public static void main(String[] args) {
        seperateCards();
        int i = 0;
        //check and fix each card in the hand
        while(!invalid && i < 5){
            fixCard(cards[i]);
            i++;
        }
        if(!invalid){
            //print out the cards correctly.
        } else {
            System.out.println("Invalid:" + inputLine);
        }
        
    }
    
    
    //seperates cards into an array.
    //determine if the cards are seperated properly.
    public static void seperateCards(){
        inputLine = input.nextLine();
        for(int i = 0; i < seperators.length(); i++){
            String[] hand;
            hand = line.spilt(seperators[i]);
            if(hand.length() == 5){
                cards = hand;
            }
        }
        if(cards == null){
            invalid = true;
        }
    }
    
    public static fixCard(String card){
        Scanner eval = new Scanner(card);
        String finalValue;
        String finalSuit;
        
        //if next value is a number.
        if(eval.hasNextInt()){
            int tokenNum = eval.next();
            if( tokenNum < 11 || token == 1){
                //switch the current value to its letter if required.
                switch(tokenNum){
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
                        invalid = true;
                        break;
                }
            } else {
                finalValue = String.valueOf(int);
            }
        //if the next value is not a number.
        } else {
            //first checking that there actually is a character there.
            if(eval.hasNext()){
                String tokenStr = eval.next();
                if(tokenStr.length() = 1){
                    tokenStr.toUpperCase();
                    switch(tokenStr){
                        case "T":
                            finalValue = "10";
                            break;
                        case "A":
                        case "J":
                        case "Q":
                        case "K":
                            finalValue = tokenStr;
                            break;
                        default:
                            invalid = true;
                            break;
                    }
                } else {
                    //if the char did not match any of the valid options it is not a valid card.
                    invalid = true;
                }
            } else {
                //if there was no tokens representing the card, it is not a valid card.
                invalid = true;
            }
        }
        
        //checking the next token after the value and setting the suit if applicable.
        if(eval.hasNext()){
            String tokenStr = eval.next();
            tokenStr.toUpperCase();
            switch(tokenStr){
                case: "C"
                case: "D"
                case: "H"
                case: "S"
                    finalSuit = tokenStr;
                    break;
                default:
                    invalid = true;
                    break;
            }
        } else {
            //no suit was representing in the card.
            invalid = true;
        }
    }
    
}
