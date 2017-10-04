import java.util.*;

public class Carpet {
  public static boolean[][] carpet;
  public static int x;
  public static int y;
  public static int[] state;
  public static ArrayList<int[]> bestState; 
  
  
  public Carpet(boolean[][] carpet, int[] state){
    this.carpet = carpet;
    this.state = state;
    this.bestState = new ArrayList<int[]>();
  }
  
  public Carpet(Carpet carpet){
    this.carpet = carpet.carpet;
    this.state = carpet.state;
    this.x = carpet.x;
    this.y = carpet.y;
    this.bestState = new ArrayList<int[]>();
  }
  
  public boolean[][] getCarpet(){
    return carpet;
  }
  
  public int[] getState(){
    return state;
  }
  
  public void setState(int[] state){
    this.state = state;
  }
  
  public void addBestState(){
    bestState.add(state);
  }
  
  public void setStateAsBest(){
    state = bestState.remove(bestState.size()-1);
  }
  
  
  public void printCarpet(){
    for(int i = 0; i<carpet.length; i++){
      for(int j = 0; j<carpet[i].length; j++){
        if(carpet[i][j]){
          System.out.print("1 ");
        } else {
          System.out.print("0 ");
        }        
      }
      System.out.println();
    }  
  }
  
  //holes created that can not be filled
  public boolean gapError(){
    return false;
    
  }
  
}