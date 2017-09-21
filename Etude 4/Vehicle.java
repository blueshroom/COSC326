import java.util.*;

public class Vehicle {
  public static double desert =  2413.0;
  public static boolean finished = false;
  public static ArrayList<Stop> stops = new ArrayList<Stop>();
  
  public static double tank;
  public static double cans;
  public static double potential;
  public static double currentPos;
  public static int dropCanAmount;
  public static int stopIndex;
  
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
    Stop start = new Stop(0.0, 0.0);
    stops.add(start);
    while(!finished){
      //have fuel to continue.
      if(vehicle.potential > 0){
        if(stops.contains(vehicle.stopIndex+1)){
          //Stop at the next stop avaliable.
          Stop stop = stops.get(vehicle.stopIndex+1);
          if(vehicle.potential >= stop.position){
            vehicle.tank -= stop.position;
            vehicle.potential = vehicle.tank/2;
            vehicle.stopIndex++;
            System.out.println("F" + " - drove forwards from previous node");
            arrivedAtStop(vehicle, stop);
          } else {
            //if we cant make it to the next stop, make a new one and add fuel to it.
            vehicle.tank -= vehicle.potential;
            vehicle.stopIndex++;
            Stop newStop = new Stop(stops.get(vehicle.stopIndex-1).position + vehicle.potential, vehicle.potential);
            System.out.println("Created new Stop at: " + newStop.position);
            //inserting the new stop in the middle of the array
            ArrayList<Stop> temp = new ArrayList<Stop>();
            temp = (ArrayList<Stop>)stops.subList(0, vehicle.stopIndex);
            temp.add(newStop);
            temp.addAll(vehicle.stopIndex, stops);
            
            vehicle.potential = 0;
            newStop.fuel = vehicle.cans;
            vehicle.cans = 0;
          }
        } else {
          //if we can make it to the end of the desert, do so.
          if((stops.get(vehicle.stopIndex).position + vehicle.potential) > 2413){
            vehicle.tank -= (2413 - stops.get(vehicle.stopIndex).position);
            finished = true;
            System.out.println("FINISHED");
          } else {
            //create a new stop once we have reached a new distance.
            vehicle.tank -= vehicle.potential;
            vehicle.stopIndex++;
            Stop newStop = new Stop(stops.get(vehicle.stopIndex-1).position + vehicle.potential, vehicle.potential);
            stops.add(newStop);
            System.out.println("Created new Stop at: " + newStop.position);
            vehicle.potential = 0;
            newStop.fuel = vehicle.cans;
            vehicle.cans = 0;
          }
        }
      } else {
        //ran out of potential.
        if(stops.contains(vehicle.stopIndex+1)){
          vehicle.stopIndex++;
          arrivedAtStop(vehicle, stops.get(vehicle.stopIndex));
        }
        //going back to the start
        for(int i = vehicle.stopIndex; i > 0; i--){
          System.out.println("B" + " - drove backwards from preivous node");
          Stop stop = stops.get(vehicle.stopIndex);
          System.out.println("Current Node: " + stop.position);
          if(stop.fuel - stop.fuelRequired < 0){
            System.out.println("NOT ENOUGH FUEL AT STOP, ERROR");
          } else {
            stop.fuel -= stop.fuelRequired;
            System.out.println("S" + stop.position + ":" + "T" + stop.fuelRequired + " - picked up fuel and put into tank");
          }
        }
        //fill up the car.
        vehicle.stopIndex = 0;
        vehicle.tank = 720;
        vehicle.cans = 960;
        vehicle.potential = vehicle.tank/2;
        System.out.println("T" + vehicle.tank + " - filling tank from the start");
        System.out.println("C" + vehicle.tank + " - filling cans from the start");
        //now at the start (stop[0]).
      }
    }
  }
  
  
  public static void arrivedAtStop(Vehicle vehicle, Stop stop){
    //if there is enough fuel at the stop, fill the tank with extra fuel that can be used
    if(stop.fuel > stop.fuelRequired){
      if((stop.fuel - stop.fuelRequired) < (720 - vehicle.tank)){
        vehicle.tank += (stop.fuel - stop.fuelRequired);
        System.out.println("S" + stop.position + ":" + "T" + (stop.fuel - stop.fuelRequired) + " - picked up fuel and put into tank");
      } else {
        System.out.println("S" + stop.position + ":" + "T" + (720 - vehicle.tank) + " - picked up fuel and put into tank");
        stop.fuel -= (720 - vehicle.tank);
        vehicle.tank = 720.0;
      }
      //if there is not enough fuel to return to the previous stop, top it up before moving forward.
    } else {
      //if we can meet the requriments for the fuel we need to drop off, drop all of our cans and go back.
      if((stop.fuelRequired - stop.fuel) > vehicle.cans){
        stop.fuel += vehicle.cans;
        System.out.println("S" + stop.position + ":" + "D" + vehicle.cans + " - dump cans at current position in the desert");
        vehicle.cans = 0;
        vehicle.potential = 0;
      } else {
        vehicle.cans -= (stop.fuelRequired - stop.fuel);
        System.out.println("S" + stop.position + ":" + "D" + (stop.fuelRequired - stop.fuel) + " - dump cans at current position in the desert");
        stop.fuel = stop.fuelRequired;
      }
    }
  }
  
}
