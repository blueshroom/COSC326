import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

//possibly use this for SUPERSIZE it.
public class RedAndGreen{
  public static HashMap<Integer, ArrayList<Integer>> list = new HashMap<Integer, ArrayList<Integer>>();
  public static HashMap<Integer, Character> colours = new HashMap<Integer, Character>();
  public static int startNum = 1;
  public static int endNum = 100;
  
  
  public static void main(String[] args){
    
    for(int i = startNum; i < endNum; i++){
      if(i != 1){
        list.put(i, new ArrayList<Integer>(Arrays.asList(1)));
      }     
    }
    
    for(int i = startNum; i < (list.size()+startNum); i++){
      findNearFactors(i);
    }
    for(int i = startNum; i < (list.size()+startNum); i++){
      calculateColour(i);
    }
    
    
    for(int i = startNum; i < (list.size()+startNum); i++){
      String colour = "";
      String factors = "";
      String n = String.valueOf(i);
      ArrayList factorsList = list.get(i);
      if(i != 1){
        //add the factors to the factors string for printing
        for(int j = 0; j < factorsList.size(); j++){
          factors = factors + String.valueOf((Integer)factorsList.get(j)) + ",";    
        }
      }
      System.out.println(n + "  " + factors + " " + colours.get(i));
    }
  }
  
  
  public static void calculateColour(int num){
    int gCount = 0;
    int rCount = 0;
    if(num != 1){
      for(int i = 0; i < list.get(num).size(); i++){
        if(colours.get(list.get(num).get(i)) == 'G'){
          gCount++;
        } else {
          rCount++;
        }
      }
      
      if(gCount > rCount){
        colours.put(num, 'R');
      } else {
        colours.put(num, 'G');
      }    
    } else {
      colours.put(num, 'G');
    }
  }
  
  public static void findNearFactors(int num){
    for(int i = 2; i < (num/2+1); i++){
      //if it is a direct factor
      int factor = num/i;
      if(!(list.get(num).contains(factor))){
        list.get(num).add(factor);
      }
    }
    
  }
  

  
}
