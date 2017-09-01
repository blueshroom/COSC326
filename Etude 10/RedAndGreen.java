import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class RedAndGreen{
  public static HashMap<Integer, ArrayList<Integer>> numbers = new HashMap<Integer, ArrayList<Integer>>();
  public static int startNum = 1;
  public static int endNum = 8;
  
  
  public static void main(String[] args){
    for(int i = startNum; i < endNum; i++){
      numbers.put(i, new ArrayList<Integer>(Arrays.asList(1)));
    }
    
    for(int i = startNum; i < (numbers.size()+startNum); i++){
      findNearFactors(i);
    }
    for(int i = startNum; i < (numbers.size()+startNum); i++){
      String colour;
      String factors = "";
      String n = String.valueOf(i);
      ArrayList factorsList = numbers.get(i);
      //for(int h = 0; h < factorsList.size(); h++){
      //  System.out.println(factorsList.get(h));
      //  System.out.println();
      //}
      
      //find which colour to print
      if(isGreen(i)){
        colour = "G";
      } else {
        colour = "R";
      }
      
      //add the factors to the factors string for printing
      for(int j = 0; j < factorsList.size(); j++){
        factors = factors + String.valueOf((Integer)factorsList.get(j)) + ",";
      }     
      System.out.println(n + " " + factors + " " + colour);     
    }
  }
  
  public static boolean isGreen(int num){
    int greenCount = 0;
    int redCount = 0;
    ArrayList number = numbers.get(num);
    //1 is green
    if(num == 1){
      return true;
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
    //color is red
    if(greenCount > redCount){
      return false;
    }
    //colour is green
    return true;
  }
  
  public static void findNearFactors(int num){
    for(int i = 2; i < num; i++){
      //if it is a direct factor
      if(num%i==0){
        numbers.get(num).add(i);
      } else {
        //if it is a near factor
        if((num-1)%i==0){
          numbers.get(num).add(i);
        }
      }
    }
  }
  
}
