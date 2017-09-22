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
    Carpet carpet = new Carpet(new boolean[x][y]);
    carpet.printCarpet();
    square.addToCarpet(carpet.getCarpet());
    carpet.printCarpet();
    square.addToCarpet(carpet.getCarpet());
    carpet.printCarpet();
    square.addToCarpet(carpet.getCarpet());
    carpet.printCarpet();
    square.addToCarpet(carpet.getCarpet());
    carpet.printCarpet();
    square.addToCarpet(carpet.getCarpet());
    carpet.printCarpet();
    square.addToCarpet(carpet.getCarpet());
    carpet.printCarpet();
  }
}