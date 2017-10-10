import java.util.*;

public class JoinedUp{
  public static List<String> words = new ArrayList<String>();
  public static List<String> singleLinkedOptions = new ArrayList<String>();
  public static List<String> doubleLinkedOptions = new ArrayList<String>();
  public static int[] firstCharIndex = new int[26];
  public static String inputWord;
  public static String finalWord;
  public static int smallestSingleLink = 0;
  public static int smallestDoubleLink = 0;

  public static void main(String[] args){
    long startTime = System.currentTimeMillis();
    
    inputWord = args[0];
    finalWord = args[1];
    JoinedUp demo = new JoinedUp();
    demo.joinedUp();
    
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("MILLISECONDS: " + totalTime);
  }
    
  public void joinedUp(){
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()){
      String word = scan.next();
      words.add(word);
    }
    
//    Collections.sort(words);
//    for(int i = 0; i < words.size(); i++){
//      System.out.println(words.get(i));
//    }
    
    //find the indexs of the first letter of each word
//    char subject = 'a';
//    firstCharIndex[((int)subject)-97] = 0;
//    for(int i = 0; i < words.size(); i++){
//      if(words.get(i).charAt(0) > subject){
//        for(int j = subject; j < (words.get(i).charAt(0)); j++){
//          firstCharIndex[j-97] = i;
//        }
//        subject = words.get(i).charAt(0);
//        firstCharIndex[((int)subject)-97] = i; 
//      }
//    }
    
    findLinks(inputWord, new ArrayList<String>(), new ArrayList<String>(), true, true);
    
    System.out.println("--------SINGLE-RESULT--------");
    System.out.print((smallestSingleLink+1) + " " + inputWord + " ");
    for(int i = 0; i < singleLinkedOptions.size(); i++){
      System.out.print(singleLinkedOptions.get(i) + " ");
    }
    System.out.println();
    
    
    System.out.println("--------DOUBLE-RESULT--------"); 
    System.out.print((smallestDoubleLink+1) + " " + inputWord + " ");
    for(int i = 0; i < doubleLinkedOptions.size(); i++){
      System.out.print(doubleLinkedOptions.get(i) + " ");
    }
    System.out.println();
    
  }
  
  public void findLinks(String word, ArrayList<String> prevSingleLinkedWords, ArrayList<String> prevDoubleLinkedWords, boolean single, boolean doubly){
    //setting the appropriate links
    ArrayList<String> singleLinkedWords = new ArrayList<String>();
    ArrayList<String> doubleLinkedWords = new ArrayList<String>();
    if(single && doubly){
      singleLinkedWords = new ArrayList<String>(prevSingleLinkedWords);
      doubleLinkedWords = new ArrayList<String>(prevDoubleLinkedWords);
    } else if(single){
      singleLinkedWords = new ArrayList<String>(prevSingleLinkedWords);
    } else {
      doubleLinkedWords = new ArrayList<String>(prevDoubleLinkedWords);
    }
    
    
    for(int i = 0; i < words.size(); i++){
      boolean invalidSingleWord = false;
      boolean invalidDoubleWord = false;
      if(single){
        if(singleLinkedWords.contains(words.get(i))){
          invalidSingleWord = true;
        }
      }        
      if(doubly){
        if(doubleLinkedWords.contains(words.get(i))){
          invalidDoubleWord = true;
        }
      }
      //finding the singleJoinedLen & doubleJoinedLen
      double singleJoinedLen = 0;
      double doubleJoinedLen = 0;
      if(word.length() > words.get(i).length()){
        singleJoinedLen = (words.get(i).length());
        singleJoinedLen = singleJoinedLen/2;
        doubleJoinedLen = word.length();
        doubleJoinedLen = doubleJoinedLen/2;
        
        singleJoinedLen = Math.round(singleJoinedLen);
        doubleJoinedLen = Math.round(doubleJoinedLen);
      } else {
        singleJoinedLen = word.length();
        singleJoinedLen = singleJoinedLen/2;
        doubleJoinedLen = (words.get(i).length());
        doubleJoinedLen = doubleJoinedLen/2;
        
        singleJoinedLen = Math.round(singleJoinedLen);
        doubleJoinedLen = Math.round(doubleJoinedLen);
      }
      
      
      int pos;
      boolean inputLarger;
      //setting how deep we check similarities between the words.
      if(word.length() > words.get(i).length()){
        pos = words.get(i).length();
        inputLarger = true;
      } else {
        pos = word.length();
        inputLarger = false;
      }
      
      boolean finished = false;
      while(!finished && pos > singleJoinedLen-1){
        String subString = word.substring(word.length()-pos);
        //System.out.println(subString + ":" + words.get(i).substring(0, subString.length()));
        if(!(subString.equals(words.get(i).substring(0, pos)))){
          pos--;
          if(pos < 1){
            finished = true;
          }
        } else {
          if(single && doubly && !invalidSingleWord && !invalidDoubleWord){
            single = false;
            doubly = false;
            //if it qualifies to be a singleJoined link.
            if((pos+1) >= singleJoinedLen){
              //System.out.println("----FOUND-SINGLE-LINK----");
              //System.out.println("ADDING SINGLE: " + words.get(i));
              singleLinkedWords.add(words.get(i));
              single = true;
            }  
            //if it qualifies to be a doublyJoined link.
            if((pos+1) >= doubleJoinedLen){
              //System.out.println("----FOUND-DOUBLE-LINK----");
              //System.out.println("ADDING DOUBLE: " + words.get(i));
              doubleLinkedWords.add(words.get(i));
              doubly = true;
            }
            
            //if we have found the last word.
            if(words.get(i).equals(finalWord)){
              if(single){
                singleLinkedOptions = new ArrayList<String>();
                for(String s : singleLinkedWords){
                  singleLinkedOptions.add(s);
                }
                if(smallestSingleLink == 0){
                  smallestSingleLink = singleLinkedWords.size();
                } else {
                  if(smallestSingleLink > singleLinkedWords.size()){
                    smallestSingleLink = singleLinkedWords.size();
                  }
                }
                //System.out.println("--------DONESINGLE--------");
                //System.out.println("REMOVING SINGLE: " + finalWord);
                singleLinkedWords.remove(finalWord);
                
              }
              if(doubly){               
                doubleLinkedOptions = new ArrayList<String>();
                for(String s : doubleLinkedWords){
                  doubleLinkedOptions.add(s);
                }
                if(smallestDoubleLink == 0){
                  smallestDoubleLink = doubleLinkedWords.size();
                } else {
                  if(smallestDoubleLink > doubleLinkedWords.size()){
                    smallestDoubleLink = doubleLinkedWords.size();
                  }
                }
                //System.out.println("--------DONEDOUBLE--------");
                //System.out.println("REMOVING DOUBLE: " + finalWord);
                doubleLinkedWords.remove(finalWord);
                
              }
            } else {
              if(smallestSingleLink != 0 && smallestSingleLink <= singleLinkedWords.size()){
                single = false;
              }
              if(smallestDoubleLink != 0 && smallestDoubleLink <= doubleLinkedWords.size()){   
                doubly = false;
              }
              findLinks(words.get(i), singleLinkedWords, doubleLinkedWords, single, doubly);
              //System.out.println("REMOVING SINGLE+DOUBLE: " + words.get(i));
              singleLinkedWords.remove(words.get(i));
              doubleLinkedWords.remove(words.get(i));
            }
            
          } else if(single && !invalidSingleWord){
            //if it qualifies to be a singleJoined link.
            if((pos+1) >= singleJoinedLen){
              //System.out.println("--------FOUND-SINGLE-LINK------");
              //System.out.println("ADDING: " + words.get(i));
              singleLinkedWords.add(words.get(i));
              
              //if we have found the last word.
              if(words.get(i).equals(finalWord)){
//                for(int j = 0; j < singleLinkedWords.size(); j++){
//                  System.out.print(singleLinkedWords.get(j) + " ");
//                }
//                System.out.println();
                singleLinkedOptions = new ArrayList<String>();
                for(String s : singleLinkedWords){
                  singleLinkedOptions.add(s);
                }
                if(smallestSingleLink == 0){
                  smallestSingleLink = singleLinkedWords.size();
                } else {
                  if(smallestSingleLink > singleLinkedWords.size()){
                    smallestSingleLink = singleLinkedWords.size();
                  }
                }
                //System.out.println("--------DONESINGLE--------");
                //System.out.println("REMOVING SINGLE: " + finalWord);
                singleLinkedWords.remove(finalWord);
                
              } else {
                if(smallestSingleLink != 0){
                  if(!(smallestSingleLink <= singleLinkedWords.size())){
                    findLinks(words.get(i), singleLinkedWords, doubleLinkedWords, true, false);
                  }
                } else {
                  findLinks(words.get(i), singleLinkedWords, doubleLinkedWords, true, false);
                }
                //System.out.println("REMOVING SINGLE: " + words.get(i));
                singleLinkedWords.remove(words.get(i));
              }
            }
          } else if(doubly && !invalidDoubleWord){
            //if it qualifies to be a doubleJoined link.
            if((pos+1) >= doubleJoinedLen){
              //System.out.println("--------FOUND-DOUBLE-LINK------");
              //System.out.println("ADDING DOUBLE: " + words.get(i));
              doubleLinkedWords.add(words.get(i));
              
              //if we have found the last word.
              if(words.get(i).equals(finalWord)){
                for(int j = 0; j < doubleLinkedWords.size(); j++){
                  System.out.print(doubleLinkedWords.get(j) + " ");
                }
                System.out.println();
                doubleLinkedOptions = new ArrayList<String>();
                for(String s : doubleLinkedWords){
                  doubleLinkedOptions.add(s);
                }
                if(smallestDoubleLink == 0){
                  smallestDoubleLink = doubleLinkedWords.size();
                } else {
                  if(smallestDoubleLink > doubleLinkedWords.size()){
                    smallestDoubleLink = doubleLinkedWords.size();
                  }
                }
                //System.out.println("--------DONEDOUBLE--------");
                //System.out.println("REMOVING DOUBLE: " + finalWord);
                doubleLinkedWords.remove(finalWord);
                
              } else {
                if(smallestDoubleLink != 0){
                  if(!(smallestDoubleLink <= doubleLinkedWords.size())){   
                    findLinks(words.get(i), singleLinkedWords, doubleLinkedWords, false, true);
                  }
                } else {
                  findLinks(words.get(i), singleLinkedWords, doubleLinkedWords, false, true);
                }
                //System.out.println("REMOVING DOUBLE: " + words.get(i));
                doubleLinkedWords.remove(words.get(i));
              }
            }
          }
          finished = true;
        }
      }
      
    }
    
    
  }

}