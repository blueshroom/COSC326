package forsale;

import java.util.ArrayList;

public class ThreeDaysLeft implements Strategy {
  ArrayList<Card> cardsPlayedFromDeck = new ArrayList<Card>();
  ArrayList<Card> cardsHeld = new ArrayList<Card>();
  ArrayList<Integer> bidsMadeEachRound = new ArrayList<Integer>();
  int rounds = 0;
  int bidsMadeThisRound = 0;
  
  
  public int bid(PlayerRecord p, AuctionState a){
    ArrayList<Card> cardsInAuction = a.getCardsInAuction();
    
    //if it is the first round add the cards in play to our record.
    if(rounds == 0){
      cardsPlayedFromDeck = cardsInAuction;
    }
    //if it is a new round of buying record which cards we know have been played
    //as well as updating our own hand, the round count and our score for the
    //last round for record keeping.
    //We need to also decide how much money we want to spend this round.
    if(cardsHeld.size() < p.getCards().size()){
      
      for(int i = 0; i < cardsInAuction.size(); i++){
        cardsPlayedFromDeck.add(cardsInAuction.get(i));
      }
      cardsHeld = p.getCards();
      bidsMadeThisRound = 0;
      rounds++;
      
      //deciding how much money to spend this round
      double avBids = 0;
      for(int i = 0; i < bidsMadeEachRound.size() i++){
        avBids += bidsMadeEachRound.get(i);
      }
      avBids = avBids/bidsMadeEachRound.size();
      //FINISH THIS, MAYBE USE A DIFFERENT METHOD OF DECISION
    }
    
    int largestCard = 1;
    int smallestCard = 30;
    //checking if all the cards values are clustered together
    for(int i = 0; i < cardsInAuction.size(); i++){
      if(cardsInAuction.get(i).getQuality() > largestCard){
        largestCard = cardsInAuction.get(i).getQuality();
      }
      if(cardsInAuction.get(i).getQuality() < smallestCard){
        smallestCard = cardsInAuction.get(i).getQuality();
      }    
    }
    if(cardsInAuction.size() > 2){
      if((largestCard - smallestCard + 1 - cardsInAuction.size()) < 1){
        bidsMadeThisRound++;
        bidsMadeEachRound.add(bidsMadeThisRound);
        return 0;
      }
    } else {
      if((largestCard - smallestCard + 1 - cardsInAuction.size()) < 2){
        bidsMadeThisRound++;
        bidsMadeEachRound.add(bidsMadeThisRound);
        return 0;
      }
    }
    
    //would have got to this point if the cards wern't clustered together.

  }
  
  public Card chooseCard(PlayerRecord p, SaleState s){
    
    
  }
  
}