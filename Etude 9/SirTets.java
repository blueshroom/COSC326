import java.util.Scanner;
import java.util.*;

public class SirTets{
  public static Carpet carpet;
  public static Carpet demoCarpet;
  public static int x;
  public static int y;
  public long layers;
  public long count;
  
  public static void main(String []args){  
    SirTets demo = new SirTets(); 
    demo.sirTets();
  }
  
  public void sirTets() {
    Scanner scan = new Scanner(System.in);
    while(scan.hasNextLine()){
      count = 0;
      int x = 0;
      int y = 0;
      if(scan.hasNextInt()){
        x = scan.nextInt();
        y = scan.nextInt();
      } else {
        System.out.println(0);
      }
      scan.nextLine();
      
      //if not divisable by 4, print zero2
      if(((x*y)%4 != 0)){
        System.out.println(0);
      } else {
       
        int[] state = {0, 0};  
        layers = (x*y/4);
        
        carpet = new Carpet(new boolean[y][x], state);
        buildCarpet(1);
        
        System.out.println(count);
      }
    }
  }
  
  
  public void buildCarpet(long layer){
    boolean success = false;
    int lastShape = 0;;
    if(layer <= layers){
      Shape shape = new Shape();
      
      // for each piece
      for(int i = 1; i <= 19; i++){
        //System.out.println(layer + ":" + i + " " + carpet.getCarpet());
        
        // if the boot fits
        shape = new Shape(i);
        if(shape.addToCarpet(carpet, true)){
          //carpet.printCarpet();
          lastShape = i;
          // recurse
          if(layer == layers){
            count++;
          }
          buildCarpet(layer+1);
          carpet.setStateAsBest();
          shape = new Shape(lastShape);
          shape.addToCarpet(carpet, false);
        }
      }
    }
    
  }

  
}