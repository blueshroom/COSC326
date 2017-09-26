import java.util.ArrayList;

public class Shape{
  private int z;
  
  public Shape(int z){
    this.z = z;
  }
  
  public boolean addToCarpet(Carpet carpet){
    ArrayList<int[]> triedPos = new ArrayList<int[]>();
    boolean success = false;
    boolean failure = false;

    
    findNextPos(carpet);
    while(!success){      
      if(failure){
        triedPos.add(carpet.getState());
        carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
        findNextPos(carpet);
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
    for(int i = 0; i < triedPos.size(); i++){
      carpet.getCarpet()[triedPos.get(i)[0]][triedPos.get(i)[1]] = false;
    }
  }
  
  //trying to find the smallest state that is still false.
  //loop through all positions, if the x and y values are smaller or equal to the current smallest state, set it as the current.
  public void findNextPos(Carpet carpet){
    boolean foundFirst = false;
    for(int x = 0; x < carpet.getCarpet().length; x++){
      for(int y = 0; y < carpet.getCarpet()[x].length; y++){
        if(!carpet.getCarpet()[x][y]){
          if(!foundFirst){
            int[] tmp = {x, y};
            carpet.setState(tmp);
            foundFirst = true;
          }
          if((carpet.getState()[0] + carpet.getState()[1]) >= (x + y)){
            int[] tmp = {x, y};
            carpet.setState(tmp);
          }
        }
      }
    }
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