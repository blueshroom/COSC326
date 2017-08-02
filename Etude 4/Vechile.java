public class Vechile{
  public static double desert =  2413.0;
  public static boolean finished = false;
  public static ArrayList<Stop> stops = new ArrayList<Stop>();
  
  public Vechicle(int amount) {
    double tank = 720.0;
    double potential = 0;
    int dropCanAmount = amount;
    double currentPos;
  }
  
  
  public static void main(String[] args) {
    Vechile vechile = new Vechile(30);
    while(!finished){
      potentail = how far you can go - how far you have to travel back.
        
    }
    
    
  }
  
  
  public static void pickup(Stop stop, double amount){
    stop.takeFuel(amount);
  }
  
  public static void dropOff(Stop stop, double amount){
    stop.addFuel(amount);
  }
  
  
  public static void driveForward(double pos, int currentPos){
    potential += tank/2;
    int i = 0; 
    while(potential > 0){
      if(stops.indexOf(i) != -1){
        Stop stop = stops.get(i);
        if(potential >= stops.position){
          //go to stop.
          currentPos = stop.position;
          //removing the fuel that was used.
          if(i > 0){
            potential -= stops.get(i-1).position;
            //stop.takeFuel(stop.position - stops.get(i-1).position));
          } else {
            potential -= stop.positon;
          }
          
        }
      }
      potential -= 1;
    }
  }
  
  
  
  
  
  
}

public static void driveBack(){
  //take note of where we need to pick up fuel to get back.
  //pick up fuel at correct spots and refuel when we get to the begginning.
}
  
