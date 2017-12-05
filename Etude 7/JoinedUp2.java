//Gavin Trebilcock
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
    for(String s : words){
      System.out.println(s +" ");
    }
    System.out.println();
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
    
    
//    double half;
//    if(inputWord.length() > finalWord.length()){
//      for(int i = 0; i < finalWord.length(); i++){
//        if(finalWord.substring(i).equals(inputWord.substring(0, finalWord.length()-(i)))){
//          //checking singleLen
//          half = finalWord.length();             
//          half = half/2;
//          half = Math.round(half);
//          if(i+1 >= half){
//            singleLinkedOption.add(finalWord);
//            smallestSingleLink = singleLinkedOption.size();
//          }
//          //checking doubleLen
//          half = inputWord.length();             
//          half = half/2;
//          half = Math.round(half);
//          if(i == 0){
//            i++;
//          }
//          if(i+1 > half){
//            doubleLinkedOption.add(finalWord);
//            smallestDoubleLink = doubleLinkedOption.size();
//          }
//        }
//      }
//      if(smallestSingleLink == words.size()){
//        findSingleLinks(inputWord, new ArrayList<String>());     
//      }
//      //System.out.println("-----------DONESINGLE-------------");
//      if(smallestDoubleLink == words.size()){
//        findDoubleLinks(inputWord, new ArrayList<String>());        
//      }
//      //System.out.println("-----------DONEDOUBLE-------------");
//    } else {
//      for(int i = 0; i < inputWord.length(); i++){
//        if(inputWord.substring(i).equals(finalWord.substring(0, inputWord.length()-(i)))){
//          //checking singleLen
//          half = inputWord.length();             
//          half = half/2;
//          half = Math.round(half);
//          if(i+1 >= half){
//            singleLinkedOption.add(finalWord);
//            smallestSingleLink = singleLinkedOption.size();
//          }
//          //checking doubleLen
//          half = finalWord.length();             
//          half = half/2;
//          half = Math.round(half);
//          if(i == 0){
//            i++;
//          }
//          if(i+1 > half){
//            doubleLinkedOption.add(finalWord);
//            smallestDoubleLink = doubleLinkedOption.size();
//          }
//        }
//      }
//      if(smallestSingleLink == words.size()){
//        findSingleLinks(inputWord, new ArrayList<String>());  
//      }
//      //System.out.println("-----------DONESINGLE-------------");
//      if(smallestDoubleLink == words.size()){
//        findDoubleLinks(inputWord, new ArrayList<String>());
//      }
//      //System.out.println("-----------DONEDOUBLE-------------");
//    }
    
    findSingleLinks(inputWord, new ArrayList<String>());
    System.out.println("-----------DONESINGLE-------------");
    findDoubleLinks(inputWord, new ArrayList<String>());
    System.out.println("-----------DONEDOUBLE-------------");
    
    
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
//        if((int)word.charAt(i) < 0){
//          System.out.println(set + ":" + word.charAt(i));
//        }
        int j;
        if(set > 0){
          j = firstCharIndex[set-1];
        } else {
          j = 0;
        }
        
        while(words.get(j).equals(inputWord)){
          if(j < words.size()){
            j++;
          }
        }
        
        
        
        //System.out.println(i + ":" + set);
        //while we are still in the current dictionary we want to look through.
        while(j <= firstCharIndex[set]){
          //checking that the substring of our word doesnt go longer than the one we are checking.
          if((word.substring(i).length()-1) <= words.get(j).length()-1 && !prevSingleLinkedWords.contains(words.get(j)) && word.charAt(i) == words.get(j).charAt(0)){
            double curHalf = word.length();
            curHalf = curHalf/2;
            curHalf = Math.round(curHalf);
            double subHalf = words.get(j).length();
            subHalf = subHalf/2;
            subHalf = Math.round(subHalf);
            if(word.substring(i).length() < words.get(j).length()){
              if(((word.substring(i).length() >= curHalf) || (words.get(j).substring(0, word.length()-(i)).length() >= subHalf)) && ((j < firstCharIndex[set]))){
                //System.out.println(word.substring(i) + ":" + words.get(j).substring(0, word.length()-(i)));
                if(!(word.substring(i).equals(words.get(j).substring(0, word.length()-(i))))){
                  if(j < words.size()){
                    j++;
                  }
                }
                if(words.get(j).equals(inputWord)){
                  if(j < words.size()){
                    j++;
                  }
                }
                if(word.substring(i).length() > words.get(j).length()){
                  j++;
                }
              }
            }
            
            if(word.substring(i).length() < words.get(j).length() && word.substring(i).charAt(0) == words.get(j).charAt(0)){           
              //System.out.println("SINGLE: " + word.substring(i) + ":" + words.get(j).substring(0, word.length()-(i)) + "------" + word + ":" + words.get(j));
              if(word.substring(i).equals(words.get(j).substring(0, word.length()-(i)))){
                
                //if it qualifies use that word for the next recursion.
                if(word.length() > words.get(j).length()){
                  double half = words.get(j).length();             
                  half = half/2;
                  half = Math.round(half);
                  //System.out.println("HALF: " + half);
                  if(words.get(j).substring(0, word.length()-(i)).length() >= half){
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
                  if((word.substring(i).length()) >= half){
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
          }
          j++;
        }        
      }
    }
    
    
    
  }
  
  
  
  
  public void findDoubleLinks(String word, ArrayList<String> prevDoubleLinkedWords){
    if(prevDoubleLinkedWords.size() < smallestDoubleLink){
      
      //run through all the chars in the word.     
      for(int i = 0; i < (word.length()/2+1); i++){
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
        //System.out.println(word.length()/2+1);
        //System.out.println(i + word);
       
        double subjectLen = words.get(j).length();
        subjectLen = subjectLen/2;
        while(words.get(j).equals(inputWord)){
            j++;
          }
        //System.out.println(words.get(j));
        //System.out.println(subjectLen + ":" + word.substring(i).length());
        while(subjectLen > word.substring(i).length() && j <= firstCharIndex[set]){
          j++;
          if(j < words.size()){
            subjectLen = words.get(j).length();
            subjectLen = subjectLen/2;
            //System.out.println(words.get(j));
            //System.out.println(subjectLen + ":" + word.substring(i).length());
          }
          while(words.get(j).equals(inputWord)){
            j++;
          }
        }
          
        //System.out.println(i + ":" + set);
        //while we are still in the current dictionary we want to look through.
        while(j <= firstCharIndex[set]){
          //checking that the substring of our word doesnt go longer than the one we are checking.
          if((word.substring(i).length()-1) <= words.get(j).length()-1 && !prevDoubleLinkedWords.contains(words.get(j)) && word.charAt(i) == words.get(j).charAt(0)){
            //System.out.println("DOUBLE: " + word.substring(i) + ":" + words.get(j).substring(0, word.length()-(i)) + "------" + word + ":" + words.get(j));
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
          if(j < words.size()){
            subjectLen = words.get(j).length();
            subjectLen = subjectLen/2;
            while(words.get(j).equals(inputWord)){
              j++;
            }
            //System.out.println(words.get(j));
            //System.out.println(subjectLen + ":" + word.substring(i).length());
            while(subjectLen > word.substring(i).length() && j <= firstCharIndex[set]){
              j++;
              if(j < words.size()){
                subjectLen = words.get(j).length();
                subjectLen = subjectLen/2;
                //System.out.println(words.get(j));
                //System.out.println(subjectLen + ":" + word.substring(i).length());
              }
              while(words.get(j).equals(inputWord)){
                j++;
              }
            }
          }
        }
        
      }
      
      
      
    }
  }
  
  
}
