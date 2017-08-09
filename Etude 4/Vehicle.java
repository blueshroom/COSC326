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
        if(stops.contains(vehicle.stopIndex+1)){
          //Stop at the next stop avaliable.
          Stop stop = stops.get(vehicle.stopIndex+1);
          if(vehicle.potential > stop.position){
            vehicle.tank -= stop.position;
            vehicle.potential = vehicle.tank/2;
            arrivedAtStop(vehicle, stop);
          } else {
            //if we cant make it to the next stop, make a new one and add fuel to it.
            vehicle.tank -= vehicle.potential;
            Stop newStop = new Stop(stops.get(vehicle.stopIndex).position + vehicle.potential, vehicle.potential);
            vehicle.potential = 0;
            newStop.fuel = vehicle.cans;
            vehicle.cans = 0;
          }
        } else {
          //if we can make it to the end of the desert, do so.
          if((stops.get(vehicle.stopIndex).position + vehicle.potential) > 2413){
            vehicle.tank -= (2413 - stops.get(vehicle.stopIndex).position);
            finished = true;
          } else {
            //create a new stop once we have reached a new distance.
            vehicle.tank -= vehicle.potential;
            Stop newStop = new Stop(stops.get(vehicle.stopIndex).position + vehicle.potential, vehicle.potential);
            vehicle.potential = 0;
            newStop.fuel = vehicle.cans;
            vehicle.cans = 0;
          }
        }
      } else {
        //ran out of potential.
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
        System.out.println("T" + (stop.fuel - stop.fuelRequired));
      } else {
        System.out.println("T" + (720 - vehicle.tank));
        stop.fuel -= (720 - vehicle.tank);
        vehicle.tank = 720.0;
      }
      //if there is not enough fuel to return to the previous stop, top it up before moving forward.
    } else {
      //if we can meet the requriments for the fuel we need to drop off, drop all of our cans and go back.
      if(stop.fuelRequired > vehicle.cans){
        stop.fuel += vehicle.cans;
        vehicle.cans = 0;
        vehicle.potential = 0;
      } else {
        vehicle.cans -= (stop.fuelRequired - stop.fuel);
        stop.fuel = stop.fuelRequired;
      }
    }
  }
  
}
