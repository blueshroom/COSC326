public class Stop{
  double position;
  double fuel;
  double fuelRequired;
  
  public Stop(double position, double fuelRequired){
    this.position = position;
    fuel = 0.0;
    this.fuelRequired = fuelRequired;
    
  }
  
  public void addFuel(double amount){
    fuel += amount;
  }
  
  public void takeFuel(double amount){
    if(amount > fuel){
      //make error.
    } else {
      fuel -= amount;
    }
  }

}
