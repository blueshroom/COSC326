import java.util.Scanner;
import java.util.*;

public class SirTets{
  public static int x;
  public static int y;
  public TreeNode root;
  public int layers;
  
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
    layers = (x*y/4);
    Carpet carpet = new Carpet(new boolean[x][y], state);
    buildCarpet(carpet, new TreeNode(0), 0);
  }

  
  public void buildCarpet(Carpet carpet, TreeNode root, int layer){
    carpet.printCarpet();  
    if(layer <= layers){
      for(int i = 1; i <= 19; i++){
        System.out.println(layer + ":" + i);
        Shape shape = new Shape(i);
        if(shape.addToCarpet(carpet)){
          TreeNode child = new TreeNode(i);
          root.addChild(child);
          buildCarpet(new Carpet(carpet), child, layer+1);
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