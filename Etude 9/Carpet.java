public class Carpet {
  public static boolean[][] carpet;
  public static int x;
  public static int y;
  
  public Carpet(boolean[][] carpet){
    this.carpet = carpet;
  }
  
  public boolean[][] getCarpet(){
    return carpet;
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