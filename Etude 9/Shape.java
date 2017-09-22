/*  S - 1
 *  Z - 2
 *  T - 3
 * SQ - 4
 *  I - 5
 *  J - 6
 *  L - 7
 */ 
public class Shape{
  private int z;
  
  public Shape(int z){
    this.z = z;
  }
  
  public boolean[][] addToCarpet(Carpet carpet){
    boolean success = false;
    boolean failure = false;

    
    findNextPosDown(carpet);
    while(!success){      
      if(failure){
        int[] tmp = {0, 0};
        carpet.setState(tmp);
        findNextPosAcross(carpet);
        failure = false;
      }
      switch(z){
        // S Block
        case 1: 
          break;
        // Z Block
        case 2:
          break;
        // T Block   
        case 3:
          break;
        // SQ Block
        case 4:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1)) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1])) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]+1))){
          //can insert
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = true;
          System.out.println("Added Shape!");
          success = true;
        } else {
          failure = true;
        }
          break;
        // I Block
        case 5:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1)) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+2)) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+3))){
          //can insert vertical rotation
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+3] = true;
          System.out.println("Added Shape!");
          success = true;
        } else if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1)) 
                     && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+2)) 
                     && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+3))){
          //can insert horizontal rotation
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+3] = true;
          System.out.println("Added Shape!");
          success = true;
        } else {
          failure = true;
        }
        break;
        // J Block
        case 6:
          break;
        // L Block
        case 7:
          break; 
        default:
          break;
      }
    }
    return null;
  }
  
  //find an appropriate place to insert a piece
  public void findNextPosDown(Carpet carpet){
    int y = carpet.getState()[0];
    int x = carpet.getState()[1];
    for(y = carpet.getState()[0]; y < carpet.getCarpet()[x].length; y++){
      for(x = carpet.getState()[1]; x < carpet.getCarpet().length; x++){
        if(!carpet.getCarpet()[x][y]){
          int[] tmp = {x, y};
          System.out.println(x +":"+ y);
          carpet.setState(tmp);
          return;
        }
      }
    }
    return;
  }
  
  //find an appropriate place to insert a piece
  public void findNextPosAcross(Carpet carpet){
    for(int x = carpet.getState()[0]; x < carpet.getCarpet().length; x++){
      for(int y = carpet.getState()[1]; y < carpet.getCarpet()[x].length; y++){
        if(!carpet.getCarpet()[x][y]){
          int[] tmp = {x, y};
          System.out.println(x +":"+ y);
          carpet.setState(tmp);
          return;
        }
      }
    }
    return;
  }
  
  public boolean checkDirection(boolean[][] carpet, int x, int y){
    try{
      if(carpet[x][y]){
        return true;
      }
    } catch(Exception e) {
      return true;
    }
    return false;
  }
  
  
}