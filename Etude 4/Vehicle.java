import java.util.ArrayList;

public class Vehicle {
  public static double desert =  2413.0;
  public static boolean finished = false;
  public static ArrayList<Stop> stops = new ArrayList<Stop>();
  
  public double tank;
  public double cans;
  public double potential;
  public double currentPos;
  public int dropCanAmount;
  public int stopIndex;
  
  public Vehicle(int amount){
    this.tank = 720.0;
    this.cans = 960.0;
    this.potential = tank/2;
    //variable that we will change for testing.
    this.dropCanAmount = amount;
    this.stopIndex = 0;
    this.currentPos = 0;
  }
  
  
  public static void main(String[] args) {
    Vehicle vehicle = new Vehicle(4);
    while(!finished){
      //have fuel to continue.
      if(vehicle.potential > 0){
        //DO THIS NEXT ---> GOING FORWARD!
      } else {
        //ran out of fuel.
        if(stops.contains(vehicle.stopIndex+1)){
          arrivedAtStop(vehicle, stops.get(vehicle.stopIndex+1));
        }
        //going back to the start
        for(int i = vehicle.stopIndex; i > 0; i--){
          Stop stop = stops.get(vehicle.stopIndex);
          if(stop.fuel - stop.fuelRequired < 0){
            System.out.println("NOT ENOUGH FUEL, ERROR");
          } else {
            stop.fuel -= stop.fuelRequired;
          }
        }
        //fill up the car.
        vehicle.stopIndex = 0;
        vehicle.tank = 720;
        vehicle.cans = 960;
        vehicle.potential = vehicle.tank/2;
        //now at the start (stop[0]).
      }
    }
  }
                  
  
  public static void arrivedAtStop(Vehicle vehicle, Stop stop){
    //if there is enough fuel at the stop, fill the tank with fuel that can be used
    if(stop.fuel > stop.fuelRequired){
      if((stop.fuel - stop.fuelRequired) < (720 - vehicle.tank)){
        vehicle.tank += (stop.fuel - stop.fuelRequired);
      } else {
        stop.fuel -= (720 - vehicle.tank);
        vehicle.tank = 720.0;
      }
      //if there is not enough fuel to return to the previous stop, top it up before moving forward.
    } else {
      if(vehicle.cans > stop.fuelRequired){
        if(vehicle.potential <= 0){
          stop.fuel = vehicle.cans;
          vehicle.cans = 0;
        }
        vehicle.cans -= (stop.fuelRequired - stop.fuel);
        stop.fuel += (stop.fuelRequired - stop.fuel);
      }
    }
    
  }

}
