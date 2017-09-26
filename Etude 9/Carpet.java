public class Carpet {
  public boolean[][] carpet;
  public int x;
  public int y;
  public int[] state;
  
  public Carpet(boolean[][] carpet, int[] state){
    this.carpet = carpet;
    this.state = state;
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