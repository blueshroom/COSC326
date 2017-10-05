import java.util.*;

public class JoinedUp{
  public static List<String> words = new ArrayList<String>();
  public static List<ArrayList<String>> singleLinkedOptions = new ArrayList<ArrayList<String>>();
  public static int[] firstCharIndex = new int[26];
  public static String inputWord;
  public static String finalWord;

  public static void main(String[] args){
    inputWord = args[0];
    finalWord = args[1];
    JoinedUp demo = new JoinedUp();
    demo.joinedUp();
  }
    
  public void joinedUp(){
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()){
      String word = scan.next();
      words.add(word);
    }
    
    Collections.sort(words);
//    for(int i = 0; i < words.size(); i++){
//      System.out.println(words.get(i));
//    }
    
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
    
    findLinks(inputWord, new ArrayList<String>());
    
    //printing the best results
    int smallest = words.size();
    ArrayList<String> smallestLink = new ArrayList<String>();
    for(int i = 0; i < singleLinkedOptions.size(); i++){
      if(singleLinkedOptions.get(i).size() < smallest){
        smallest = singleLinkedOptions.get(i).size();
        smallestLink = singleLinkedOptions.get(i);
      }
    }
    System.out.println("--------RESULT--------");
    if(smallest != words.size()){
      System.out.print((smallest+1) + " ");
    } else {
      System.out.print(0 + " ");
    }
    System.out.print(inputWord + " ");
    for(int i = 0; i < smallestLink.size(); i++){
      System.out.print(smallestLink.get(i) + " ");
    }
    System.out.println();

  }
  
  public void findLinks(String word, ArrayList<String> prevLinkedWords){
    ArrayList<String> linkedWords = prevLinkedWords;
    for(int i = 0; i < words.size(); i++){
      
      if(!(linkedWords.contains(words.get(i)))){
        
        //finding the singleJoinedLen
        long singleJoinedLen = 0;
        if(word.length() > words.get(i).length()){
          singleJoinedLen = (words.get(i).length())/2;
        } else {
          singleJoinedLen = word.length()/2;
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
        while(!finished){
          String subString = word.substring(word.length()-pos);
          System.out.println(subString + ":" + words.get(i).substring(0, subString.length()));
          if(!(subString.equals(words.get(i).substring(0, pos)))){
            pos--;
            if(pos < 1){
              finished = true;
            }
          } else {
            //if it qualifies to be a singleJoined link.
            if(pos >= singleJoinedLen){
              System.out.println("--------FOUND-LINK------");
              System.out.println("ADDING: " + words.get(i));
              linkedWords.add(words.get(i));
              
              //if we have found the last word.
              if(words.get(i).equals(finalWord)){
                for(int j = 0; j < linkedWords.size(); j++){
                  System.out.print(linkedWords.get(j) + " ");
                }
                System.out.println();
                ArrayList<String> copyLinkedWords = new ArrayList<String>();
                for(String s : linkedWords){
                  copyLinkedWords.add(s);
                }
                singleLinkedOptions.add(copyLinkedWords);
                linkedWords.remove(finalWord);
                System.out.println("--------DONE--------");
              } else {
                findLinks(words.get(i), linkedWords);
                System.out.println("REMOVING: " + words.get(i));
                linkedWords.remove(words.get(i));
              }
              
            }
            finished = true;
          }
        }                                                     
      }
      
      
    }
  }
    
  
  class TreeNode {
    private List<TreeNode> children = null;
    private TreeNode parent = null;
    private Integer value = null;
    
    public TreeNode(Integer value){
      this.children = new ArrayList<TreeNode>();
      this.value = value;
    }
    
    public void addChild(TreeNode child){
      child.parent = this;
      children.add(child);
      
    }
  }

}
