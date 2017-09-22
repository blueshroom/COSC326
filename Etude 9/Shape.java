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
  
  public boolean[][] addToCarpet(boolean[][] carpet){
    int x = 0;
    int y = 0;
    int[] state = {x,y};
    boolean success = false;
    
    while(!success){
      state = findNextPos(carpet, state);    
      
      switch(z){
        // S block
        case 1: 
          break;
          // Z block
        case 2:
          break;
          // T block   
        case 3:
          break;
          // square
        case 4:
          if (!(checkDirection(carpet, state[0], state[1]+1)) && !(checkDirection(carpet, state[0]+1, state[1])) && !(checkDirection(carpet, state[0]+1, state[1]+1))){
            //can insert
            carpet[state[0]][state[1]] = true;
            carpet[state[0]][state[1]+1] = true;
            carpet[state[0]+1][state[1]] = true;
            carpet[state[0]+1][state[1]+1] = true;
            System.out.println("Added Shape!");
            success = true;
          }
        break;
        // Line Block
        case 5:
          break;
          // J block
        case 6:
          break;
          // L block
        case 7:
          break; 
        default:
          break;
      }
    }
    return null;
  }
  
  //find an appropriate place to insert a piece
  public int[] findNextPos(boolean[][] carpet, int[] state){
    for(int x = state[0]; x < carpet.length; x++){
      for(int y = state[1]; y < carpet[x].length; y++){
        if(!carpet[x][y]){
          state[0] = x;
          state[1] = y;
          return state;
        }
      }
    }
    return state;
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