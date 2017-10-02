import java.util.*;

public class JoinedUp{
  public static List<String> words = new ArrayList<String>();
  public static int[] firstIndex = new int[26];

  public static void main(String[] args){
    
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()){
      String word = scan.next();
      System.out.println(word);
      words.add(word);
    }
    
    Collections.sort(words);
    
    char subject = 'a';
    firstIndex[subject-97] = 0;
    subject += 1;
    for(int i = 0; i < words.size(); i++){
      if(words.get(i).charAt(0) == subject){
        subject += 1;
        firstIndex[subject-97] = i; 
      }
    }
    
    for(int i = 0; i < 26; i++){
      System.out.println(firstIndex[i]);
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
