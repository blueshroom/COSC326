import java.util.*;

public class JoinedUp2{
  public static List<String> words = new ArrayList<String>();
  public static List<String> singleLinkedOption = new ArrayList<String>();
  public static List<String> doubleLinkedOption = new ArrayList<String>();
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
    
    smallestSingleLink = words.size();
    smallestDoubleLink = words.size();
    
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
    
    findSingleLinks(inputWord, new ArrayList<String>());
    findDoubleLinks(inputWord, new ArrayList<String>());
    
    if(smallestSingleLink == words.size()){
        System.out.println("0");
    } else {
        System.out.print((smallestSingleLink+1) + " " + inputWord + " ");
        for(int i = 0; i < singleLinkedOption.size(); i++){
        System.out.print(singleLinkedOption.get(i) + " ");
        }
        System.out.println();
    }
    
    if(smallestDoubleLink == words.size()){
        System.out.println("0");
    } else {
        System.out.print((smallestDoubleLink+1) + " " + inputWord + " ");
        for(int i = 0; i < doubleLinkedOption.size(); i++){
        System.out.print(doubleLinkedOption.get(i) + " ");
        }
        System.out.println();
    }
    
  }
  
  
  public void findSingleLinks(String word, ArrayList<String> prevSingleLinkedWords){
    //run through all the chars in the word.
    if(prevSingleLinkedWords.size() < smallestSingleLink){
        for(int i = 0; i < word.length(); i++){
          if((int)word.charAt(i) == '-'){
              i++;
          }
          int set = (int)word.charAt(i)-97;
          int j;
          if(set != 0){
            j = firstCharIndex[set-1];
          } else {
            j = 0;
          }
          //System.out.println(i + ":" + set);
          //while we are still in the current dictionary we want to look through.
          while(j <= firstCharIndex[set]){
            //checking that the substring of our word doesnt go longer than the one we are checking.
            if((word.substring(i).length()-1) <= words.get(j).length()-1 && !prevSingleLinkedWords.contains(words.get(j)) && word.charAt(i) == words.get(j).charAt(0)){
              //System.out.println(word.substring(i) + ":" + words.get(j).substring(0, word.length()-(i)));
              if(word.substring(i).equals(words.get(j).substring(0, word.length()-(i)))){

                //if it qualifies use that word for the next recursion.
                if(word.length() > words.get(j).length()){
                  double half = words.get(j).length();             
                  half = half/2;
                  half = Math.round(half);
                  //System.out.println("HALF: " + half);
                  if(word.length()-1 > half){
                    prevSingleLinkedWords.add(words.get(j));
                    //System.out.println("ADDING: " + words.get(j));
                    //if we havn't found the last word.
                    if(!words.get(j).equals(finalWord)){
                      findSingleLinks(words.get(j), prevSingleLinkedWords);
                    } else {
                      //found a link.
                      if(smallestSingleLink > prevSingleLinkedWords.size()){
                        singleLinkedOption = new ArrayList<String>();
                        for(String s : prevSingleLinkedWords){
                          singleLinkedOption.add(s);
                        }
                        smallestSingleLink = prevSingleLinkedWords.size();
                      }
                    }
                    //System.out.println("REMOVE: " + words.get(j));
                    prevSingleLinkedWords.remove(words.get(j));
                  }
                } else {
                  double half = word.length();
                  half = half/2;
                  half = Math.round(half);
                  //System.out.println("HALF: " + half);
                  if((words.get(j).length()) > half){
                    prevSingleLinkedWords.add(words.get(j));
                    //System.out.println("ADDING: " + words.get(j));
                    //if we havn't found the last word.
                    if(!words.get(j).equals(finalWord)){
                      findSingleLinks(words.get(j), prevSingleLinkedWords);
                    } else {
                      //found a link.
                      if(smallestSingleLink > prevSingleLinkedWords.size()){
                        singleLinkedOption = new ArrayList<String>();
                        for(String s : prevSingleLinkedWords){
                          singleLinkedOption.add(s);
                        }
                        smallestSingleLink = prevSingleLinkedWords.size();
                      }
                    }
                    //System.out.println("REMOVE: " + words.get(j));
                    prevSingleLinkedWords.remove(words.get(j));
                  }
                }

              }
            }
            j++;
          }

        }
    }
    
  
  
  }
  
  
  
  
  public void findDoubleLinks(String word, ArrayList<String> prevDoubleLinkedWords){
    if(prevDoubleLinkedWords.size() < smallestDoubleLink){
        //run through all the chars in the word.
        for(int i = 0; i < word.length(); i++){
          if((int)word.charAt(i) == '-'){
            i++;
          }
          int set = (int)word.charAt(i)-97;
          int j;
          if(set != 0){
            j = firstCharIndex[set-1];
          } else {
            j = 0;
          }
          //System.out.println(i + ":" + set);
          //while we are still in the current dictionary we want to look through.
          while(j <= firstCharIndex[set]){
            //checking that the substring of our word doesnt go longer than the one we are checking.
            if((word.substring(i).length()-1) <= words.get(j).length()-1 && !prevDoubleLinkedWords.contains(words.get(j)) && word.charAt(i) == words.get(j).charAt(0)){
              //System.out.println(word.substring(i) + ":" + words.get(j).substring(0, word.length()-(i)));
              if(word.substring(i).equals(words.get(j).substring(0, word.length()-(i)))){

                //if it qualifies use that word for the next recursion.
                if(word.length() < words.get(j).length()){
                  double half = words.get(j).length();             
                  half = half/2;
                  half = Math.round(half);
                  //System.out.println("HALF: " + half);
                  if((words.get(j).substring(0, word.length()-(i)).length()) >= half){
                    prevDoubleLinkedWords.add(words.get(j));
                    //System.out.println("ADDING: " + words.get(j));
                    //if we havn't found the last word.
                    if(!words.get(j).equals(finalWord)){
                      findDoubleLinks(words.get(j), prevDoubleLinkedWords);
                    } else {
                      //found a link.
                      if(smallestDoubleLink > prevDoubleLinkedWords.size()){
                        doubleLinkedOption = new ArrayList<String>();
                        for(String s : prevDoubleLinkedWords){
                          doubleLinkedOption.add(s);
                        }
                        smallestDoubleLink = prevDoubleLinkedWords.size();
                      }
                    }
                    //System.out.println("REMOVE: " + words.get(j));
                    prevDoubleLinkedWords.remove(words.get(j));
                  }
                } else {
                  double half = word.length();
                  half = half/2;
                  half = Math.round(half);
                  //System.out.println("HALF: " + half);
                  if((word.substring(i).length()) >= half){
                    prevDoubleLinkedWords.add(words.get(j));
                    //System.out.println("ADDING: " + words.get(j));
                    //if we havn't found the last word.
                    if(!words.get(j).equals(finalWord)){
                      findDoubleLinks(words.get(j), prevDoubleLinkedWords);
                    } else {
                      //found a link.
                      if(smallestDoubleLink > prevDoubleLinkedWords.size()){
                        doubleLinkedOption = new ArrayList<String>();
                        for(String s : prevDoubleLinkedWords){
                          doubleLinkedOption.add(s);
                        }
                        smallestDoubleLink = prevDoubleLinkedWords.size();
                      }
                    }
                    //System.out.println("REMOVE: " + words.get(j));
                    prevDoubleLinkedWords.remove(words.get(j));
                  }
                }

              }
            }
            j++;
          }

        }



      }
  }
                        
                        
}