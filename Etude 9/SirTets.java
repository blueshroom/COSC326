/*  S - 1
 *  Z - 2
 *  T - 3
 * SQ - 4
 *  I - 5
 *  J - 6
 *  L - 7
 */ 

import java.util.Scanner;

public class SirTets{
  public static int x;
  public static int y;
  
  
   public static void main(String []args){
   Scanner scan = new Scanner(System.in);
    while(scan.hasNextInt()){
      x = scan.nextInt();
      y = scan.nextInt();
    }
    
    Shape square = new Shape(4);
    Shape line = new Shape(5);
    int[] state = {0, 0};
    Carpet carpet = new Carpet(new boolean[x][y], state);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
    square.addToCarpet(carpet);
    carpet.printCarpet();
  }
}