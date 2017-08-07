public class Vechile {
  public static double desert =  2413.0;
  public static boolean finished = false;
  public static ArrayList<Stop> stops = new ArrayList<Stop>();
  
  public Vechicle(int amount) {
    double tank = 720.0;
    double cans = 960.0;
    double potential = tank/2;
    //variable that we will change for testing.
    int dropCanAmount = amount;
    int stopIndex = 0;
    double currentPos;
  }
  
  
  public static void main(String[] args) {
    Vechile vechile = new Vechile(4);
    while(!finished){
      //have fuel to continue.
      if(potential > 0){
        
        
      } else {
        //ran out of fuel.
        if(stops.contains(stopIndex+1)){
          arrivedAtStop(vechile, stops.get(stopIndex+1));
        }
        //going back to the start
        for(int i = stopIndex; i > 0; i--){
          Stop stop = stops.get(stopIndex);
          if(stop.fuel - stop.fuelRequired < 0){
            System.out.println("NOT ENOUGH FUEL, ERROR");
          } else {
            stop.fuel -= stop.fuelRequired;
          }
        }
        //fill up the car.
        vechile.stopIndex = 0;
        vechile.tank = 720;
        vechile.cans = 960;
        vechile.potential = tank/2;
        //now at the start (stop[0]).
      }
           
         
           
  
  public static void newStop(){
  }
  
  public static void pickup(Stop stop, double amount){
    stop.takeFuel(amount);
  }
  
  public static void dropOff(Stop stop, double amount){
    stop.addFuel(amount);
  }
  
  
  public static void arrivedAtStop(Vechile vechile, Stop stop){
    //if there is enough fuel at the stop, fill the tank with fuel that can be used
    if(stop.fuel > stop.fuelRequried){
      if((stop.fuel - stop.fuelRequired) < (720 - tank)){
        vechile.tank += (stop.fuel - stop.fuelRequired);
      } else {
        stop.fuel -= (720 - vechile.tank);
        vechile.tank = 720.0;
      }
      //if there is not enough fuel to return to the previous stop, top it up before moving forward.
    } else {
      if(vechile.cans > stop.fuelRequired){
        if(vechile.potential <= 0){
          stop.fuel = vechile.cans;
          vechile.cans = 0;
        }
        vechile.cans -= (stop.fuelRequired - stop.fuel);
        stop.fuel += (stop.fuelRequired - stop.fuel);
      }
    }
    
  }

public static void driveBack(){
  //take note of where we need to pick up fuel to get back.
  //pick up fuel at correct spots and refuel when we get to the begginning.
}
