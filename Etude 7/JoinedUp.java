import java.util.*;

public class JoinedUp{
  public static List<String> words = new ArrayList<String>();
  public static List<ArrayList<String>> singleLinkedOptions = new ArrayList<ArrayList<String>>();
  public static int[] firstCharIndex = new int[26];
  public static String inputWord;

  public static void main(String[] args){
    JoinedUp demo = new JoinedUp();
    demo.joinedUp();
  }
    
  public void joinedUp(){
    Scanner scan = new Scanner(System.in);
    inputWord = scan.next();
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
    
    findLinks(inputWord, new ArrayList<String>());
    
    //printing the results
    System.out.println(singleLinkedOptions.size());
    for(int i = 0; i < singleLinkedOptions.size(); i++){
      System.out.println("------------");
      for(int j = 0; j < singleLinkedOptions.get(i).size(); j++){
        System.out.println(singleLinkedOptions.get(i).get(j));
      }
    }
  }
  
  public void findLinks(String word, ArrayList<String> prevLinkedWords){
    ArrayList<String> linkedWords = prevLinkedWords;
    for(int i = 0; i < words.size(); i++){
      
      //finding the singleJoinedLen
      int singleJoinedLen = 0;
      if(word.length() > words.get(i).length()){
        singleJoinedLen = (words.get(i).length())/2;
        if(words.get(i).length() % 2 == 0){
          singleJoinedLen++;
        }
      } else {
        singleJoinedLen = word.length()/2;
        if(word.length() % 2 == 0){
          singleJoinedLen++;
        }
      }
      
      int pos = 0;
      boolean finished = false;
      while(finished){
        if((word.charAt((word.length()-1)-pos)) == words.get(i).charAt(pos)){
          System.out.println("WORD: " + word + " | " + "COMPRATOR: " + words.get(i));
          System.out.println(word.charAt((word.length()-1)-pos) + " | " + words.get(i).charAt(pos));
          pos++;
        } else {
          if(pos >= singleJoinedLen){
            linkedWords.add(words.get(i));
            findLinks(word, linkedWords);
          }
          finished = true;
        }
      }                                                     
    }
    singleLinkedOptions.add(linkedWords);
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
