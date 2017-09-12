import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

//possibly use this for SUPERSIZE it.
public class RedAndGreen{
  public static HashMap<Integer, ArrayList<Integer>> list = new HashMap<Integer, ArrayList<Integer>>();
  public static HashMap<Integer, Character> colours = new HashMap<Integer, Character>();
  public static int startNum = 1;
  public static int endNum = 21;
  
  
  public static void main(String[] args){
    for(int i = startNum; i < endNum; i++){
      list.put(i, new ArrayList<Integer>(Arrays.asList(1)));
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
      
      //add the factors to the factors string for printing
      for(int j = 0; j < factorsList.size(); j++){
        factors = factors + String.valueOf((Integer)factorsList.get(j)) + ",";    
      }
      System.out.println(n + "  " + factors + " " + colours.get(i));
    }
  }
  
  public static void calculateColour(int num){
    int gCount = 0;
    int rCount = 0;
    colours.put(1, 'G');
    for(int i = 2; i <= num; i++){
      for(int j = 0; j < list.get(num).size(); j++){
        if(colours.get(list.get(num).get(j)) == 'G'){
          gCount++;
        } else {
          rCount++;
        }
      }
      if(gCount > rCount){
        colours.put(i, 'R');
      } else {
        colours.put(i, 'G');
      }
    }
  }
  
  public static void findNearFactors(int num){
    for(int i = 2; i < num; i++){
      //if it is a direct factor
      int factor = num/i;
      if(!(list.get(num).contains(factor))){
        list.get(num).add(factor);
      }
    }
  }
  
}
