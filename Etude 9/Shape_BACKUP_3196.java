import java.util.ArrayList;

public class Shape{
  public int z;
  
  public Shape(int z){
    this.z = z;
  }
  
  public Shape(){
  }
  
  public boolean addToCarpet(Carpet carpet, boolean change){
    ArrayList<int[]> triedPos = new ArrayList<int[]>();
    boolean success = false;
    boolean failure = false;
    int failureCount = 0;
    
    if(change){
      findNextPos(carpet);
    }
    while(!success){
      if(failure && change){
        if(failure){
          return false;
        }
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
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1])) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1)) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]+1)) || !(change)){
          //can insert
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        } else {
          failure = true;
        }
        break;
        
        // Line Horizontal Block
        case 2:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1])) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1])) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+3, carpet.getState()[1])) || !(change)){
          //can insert horizontal rotation
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+3] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+3][carpet.getState()[1]] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        } else {
          failure = true;
        }
        break;
        
        // Line Vertical Block   
        case 3:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1)) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+2)) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+3)) || !(change)){
          //can insert vertical rotation
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+3][carpet.getState()[1]] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+3] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        
        break;
        
        // J Left 270' Block
        case 4:
          
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0] , carpet.getState()[1]+1 ))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] , carpet.getState()[1]+2))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] +2)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]+1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+2] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        // J Neutral 0' Block
        case 5:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0] , carpet.getState()[1]+1)) && 
              !(checkDirection(carpet.getCarpet(), carpet.getState()[0] - 1, carpet.getState()[1] + 1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] - 2, carpet.getState()[1] + 1)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]-1] = change;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]-2] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0] - 1][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0] -2][carpet.getState()[1]+1] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        
        break;
        
        // J Right 90' Block
        case 6:
          
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1] )) 
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] + 1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] +2)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]+1] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0] + 2][carpet.getState()[1]+1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]+2] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        
        break;
        // J Flip 180' Block
        case 7:
          
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0] , carpet.getState()[1]+1 ))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1] )) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = change;
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
          
        }      
        break;
        
        //8 - 180 degree L done
        case 8:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] , carpet.getState()[1]+2))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1])) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        //9 - 180 degree L done
        case 9:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1 , carpet.getState()[1] +1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1]+1)) || !(change)) {
          System.out.println("x: " + (carpet.getState()[0]+1) + " y: " + carpet.getState()[1]);
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]+2] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        //10 -  90 degree L done
        case 10:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] , carpet.getState()[1]+2))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]-1, carpet.getState()[1]+2)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = change;
          carpet.getCarpet()[carpet.getState()[0]-1][carpet.getState()[1]+2] = change;
          System.out.println("Added THINGasfsdsgcfsgsdfgssfgddghfgjfgjdfgjdvgjfhjfhjghjgfhjhg");
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        //11 - Normal L done
        case 11:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1]+1)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]+1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        // normal S Block
        case 12:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] - 1, carpet.getState()[1] + 1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] - 1, carpet.getState()[1] + 2)) || !(change)) {
          //can insert
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1] - 1] = change;
          carpet.getCarpet()[carpet.getState()[0] + 2][carpet.getState()[1] - 1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0] - 1][carpet.getState()[1] + 1] = change;
          carpet.getCarpet()[carpet.getState()[0] - 1][carpet.getState()[1] + 2] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        // S block rotation
        case 13:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 1, carpet.getState()[1] + 1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0] + 2, carpet.getState()[1] + 1)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1] + 1] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0] + 1][carpet.getState()[1] + 2] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0] + 2][carpet.getState()[1] + 1] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        } else {
          failure = true;
        }
        break;
        
        //T Natural Block done
        case 14:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+2))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]+1)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        //T Left 270' Block done
        case 15:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]-1, carpet.getState()[1]+1)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]-1][carpet.getState()[1]+1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        //T 180' Block done
        case 16:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+2))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]-1, carpet.getState()[1]+1)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+2] = change;
          carpet.getCarpet()[carpet.getState()[0]-1][carpet.getState()[1]+1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        //T Right 90' Block
        case 17:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+2, carpet.getState()[1])) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]-1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        //Z Horizontal Block
        case 18:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1 , carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]+2)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+1] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0]+2][carpet.getState()[1]+1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]+2] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        //Z Vertical Block
        case 19:
          if (!(checkDirection(carpet.getCarpet(), carpet.getState()[0]+1, carpet.getState()[1]))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0], carpet.getState()[1]+1))
                && !(checkDirection(carpet.getCarpet(), carpet.getState()[0]-1, carpet.getState()[1]+1)) || !(change)) {
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]] = change;
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]] = change;
<<<<<<< HEAD
          carpet.getCarpet()[carpet.getState()[0]+1][carpet.getState()[1]-1] = change;
          System.out.println((change ? "added" : "removed") + " Shape!: " + z);
=======
          carpet.getCarpet()[carpet.getState()[0]][carpet.getState()[1]+1] = change;
          carpet.getCarpet()[carpet.getState()[0]-1][carpet.getState()[1]+1] = change;
          System.out.println("Added Shape!");
>>>>>>> 7f5fed6ac5fde60f243ddeaa6d3006e2ae95abf1
          success = true;
          if(change){
            carpet.addBestState();
          }
          
        }else{
          failure = true;
        }
        break;
        
        
        default:
          break;
      }
    }
    if(change){
      for(int i = 0; i < triedPos.size(); i++){
        carpet.getCarpet()[triedPos.get(i)[0]][triedPos.get(i)[1]] = false;
      }
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
      if(carpet[y][x]){
        return true;
      }
    } catch(Exception e) {
      return true;
    }
    return false;
  }
  
  
}
