import java.util.ArrayList;
import java.util.Arrays;

public class RedAndGreen{
  public static ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
  public static int startNum = 1;
  public static int endNum = 8;
  
  
  //green = 0, red = 1
  public static void main(String[] args){
    //initalise all ArrayLists with default green colour in index 0
    for(int i = startNum; i < endNum; i++){
      numbers.add(new ArrayList<Integer>(Arrays.asList(0)));
    }
    
    for(int i = startNum; i < (numbers.size()+startNum); i++){
      findNearFactors(i);
    }
    for(int i = startNum; i < (numbers.size()+startNum); i++){
      setColour(i);
    }
    
  }
  
  public static void setColour(int num){
    int greenCount = 0;
    int redCount = 0;
    ArrayList number = numbers.get(num);
    //1 stays green
    if(num == 1){
      return;
    }
    //see if more of nums near factors are green, if so, change it to red
    for(int i = 1; i < number.size(); i++){
      if((Integer)number.get(i) == 1){
        greenCount++;
      } else {
        //if the factor is green
        if((Integer)(numbers.get((Integer)number.get(i)).get(0)) == 0){
          greenCount++;
        } else {
        //factor is red
          redCount++;
        }
      }
    }
  }
  
  public static void findNearFactors(int num){
    for(int i = 0; i < num; i++){
      //if it is a direct factor
      if(num%i==0){
        numbers.get(num-startNum).add(i);
      } else {
        //if it is a near factor
        if((num-1)%i==0){
          numbers.get(num-startNum).add(i);
        }
      }
    }
  }
  
}
