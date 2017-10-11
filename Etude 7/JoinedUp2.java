import java.util.*;

public class JoinedUp2{
  public static List<String> words = new ArrayList<String>();
  public static List<String> singleLinkedOptions = new ArrayList<String>();
  public static List<String> doubleLinkedOptions = new ArrayList<String>();
  public static int[] firstCharIndex = new int[26];
  public static String inputWord;
  public static String finalWord;
  public static int smallestSingleLink = 0;
  public static int smallestDoubleLink = 0;

  public static void main(String[] args){
//    long startTime = System.currentTimeMillis();
    
    inputWord = args[0];
    finalWord = args[1];
    JoinedUp2 demo = new JoinedUp2();
    demo.joinedUp();
    
//    long endTime   = System.currentTimeMillis();
//    long totalTime = endTime - startTime;
//    System.out.println("MILLISECONDS: " + totalTime);
  }
    
  public void joinedUp(){
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()){
      String word = scan.next();
      words.add(word);
    }
    
    Collections.sort(words);
    for(int i = 0; i < words.size(); i++){
      System.out.println(words.get(i));
    }
    
    //find the indexs of the first letter of each word
    char subject = 'a';
    firstCharIndex[((int)subject)-97] = 0;
    for(int i = 0; i < words.size(); i++){
      if(words.get(i).charAt(0) > subject){
        for(int j = subject; j < (words.get(i).charAt(0)); j++){
          firstCharIndex[j-97] = i;
        }
        subject = words.get(i).charAt(0);
        firstCharIndex[((int)subject)-97] = i; 
      }
    }
    
  }
  
  
  public void findSingleLinks(String word, ArrayList<String> prevSingleLinkedWords){
    //run through all the chars in the word.
    for(int i = 0; i < word.length(); i++){
      int set = (int)inputWord.charAt(i)-97;
      int j;
      if(set != 0){
        j = firstCharIndex[set-1];
      } else {
        j = 0;
      }
      //while we are still in the current dictionary we want to look through.
      while(j <= firstCharIndex[set]){
        if(word.substring(i).equals(words.get(j).substring(0, i+1))){
          
          //if it qualifies use that word for the next recursion.
          if(word.length() > words.get(j).length()){
            double half = words.get(j).length();
            half = half/2;
            if((words.get(j).length() - (i+1)) >= half){
              prevSingleLinkedWords.add(words.get(j));
              findSingleLinks(words.get(j), prevSingleLinkedWords);
              prevSingleLinkedWords.remove(words.get(j));
            }
          } else {
            double half = word.length();
            half = half/2;
            if((word.length() - (i+1)) >= half){
              prevSingleLinkedWords.add(words.get(j));
              findSingleLinks(words.get(j), prevSingleLinkedWords);
              prevSingleLinkedWords.remove(words.get(j));
            }
          }
          
        }
        j++;
      }
      
    }
    
  
  
  }
                        
                        
}