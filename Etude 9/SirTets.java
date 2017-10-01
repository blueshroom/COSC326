import java.util.Scanner;
import java.util.*;

public class SirTets{
  public static int x;
  public static int y;
  public TreeNode root;
  
  public static void main(String []args){  
    SirTets demo = new SirTets(); 
    demo.sirTets();
  }
  
  public void sirTets() {
    Scanner scan = new Scanner(System.in);
    while(scan.hasNextInt()){
      x = scan.nextInt();
      y = scan.nextInt();
    }
    
    //if not divisable by 4, print zero
    if(((x*y)%4 != 0)){
      System.out.println(0);
    }

    int[] state = {0, 0};
    Carpet carpet = new Carpet(new boolean[x][y], state);
    buildCarpet(carpet, new TreeNode(0));
  }

  
  public void buildCarpet(Carpet carpet, TreeNode root){
    carpet.printCarpet();
    for(int i = 1; i <= 19; i++){   
      Shape shape = new Shape(i);
      if(shape.addToCarpet(carpet)){
        TreeNode child = new TreeNode(i);
        root.addChild(child);
        buildCarpet(carpet, child);
      }
    }
  }
  
  class TreeNode {
    private List<TreeNode> decisions = null;
    private Integer path = null;
    
    public TreeNode(Integer path){
      this.decisions = new ArrayList<TreeNode>();
      this.path = path;
    }
    
    public void addChild(TreeNode child){
      decisions.add(child);
    }
  }
  
}