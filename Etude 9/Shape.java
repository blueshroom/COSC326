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
    int failureCount = 0;

    
    findNextPos(carpet);
    while(!success){      
      if(failure){
        failureCount++;
        if(failureCount >= 19){
          return false;
        }
        triedPos.add(carpet.getState());
        carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
        findNextPos(carpet);
      }
      switch(z){
        // Square Block
        case 1:
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
          
        // Line Horizontal Block
        case 2:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1)) 
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
          
        // Line Vertical Block   
        case 3:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1])) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1])) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+3, carpet.getState()[1]))){
          //can insert vertical rotation
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+3][carpet.getState()[1]] = true;
          System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
          
          break;
          
          // J Left 270' Block
        case 4:
          
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1 , carpet.getState()[1] ))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 2, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 2, carpet.getState()[1] +1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]+1] = true;
          System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
        break;
        
        // J Neutral 0' Block
        case 5:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1])) && 
              !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] - 1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] - 2))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]-1] = true;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]-2] = true;
          System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
        
        break;
        
        // J Right 90' Block
        case 6:
          
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+ 1 )) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] + 1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 2, carpet.getState()[1] +1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0] + 2][carpet.getState()[1]+1] = true;
          System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
        
        break;
        // J Flip 180' Block
        case 7:
          
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1 , carpet.getState()[1] ))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1] +2))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = true;
        }
          
          //8 - 180 degree L
        case 8:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1] ))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2 , carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1] +1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
        break;
        
        //9 - 180 degree L 
        case 9:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1] ))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1 , carpet.getState()[1]  + 1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] +2))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]+2] = true;
          System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
        break;
        
        //10 -  90 degree L
        case 10:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2 , carpet.getState()[1] -1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] +2, carpet.getState()[1]))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0] + 2][carpet.getState()[1]-1] = true;
          System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
        break;
        
          //11 - Normal L
        case 11:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1] +1 ))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] , carpet.getState()[1]  + 2))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] +2))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = true;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]+2] = true;
          System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
        break;
         // normal S Block
        case 12:
        if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1]))
            && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] - 1))
            && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 2, carpet.getState()[1] - 1))) {
              //can insert
              carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
              carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]] = true;
              carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1] - 1] = true;
              carpet.getCarpet()[carpet.getState()[0] + 2][carpet.getState()[1] - 1] = true;
              System.out.println("Added Shape!");
              success = true;
              }else{
          failure = true;
        }
              break;
              
            // S block rotation
        case 13:
             if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1] + 1))
            && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] + 1))
            && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] + 2))) {
              carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
              carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1] + 1] = true;
              carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1] + 1] = true;
              carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1] + 2] = true;
              System.out.println("Added Shape!");
              success = true;
            } else {
              failure = true;
            }
            break;
            
            //T Flip 180' Block
        case 14:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]+1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]-1] = true;
        System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
          break;
          
          //T Left 270' Block
        case 15:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]-1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]-1] = true;
        System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
          break;
          
          //T Neutral 0' Block
        case 16:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]-1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]-1] = true;
        System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
          break;
          
          //T Right 90' Block
        case 17:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]-1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]-1] = true;
        System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
          break;
          
          //Z Horizontal Block
        case 18:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1 , carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1]+1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]+1] = true;
        System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
          break;
          
          //Z Vertical Block
        case 19:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]-1))) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = true;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]-1] = true;
        System.out.println("Added Shape!");
          success = true;
        }else{
          failure = true;
        }
          break;
          
        
        default:
          break;
      }
    }
    for(int i = 0; i < triedPos.size(); i++){
      carpet.getCarpet()[triedPos.get(i)[0]][triedPos.get(i)[1]] = false;
    }
    return true;
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