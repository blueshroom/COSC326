import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

//possibly use this for SUPERSIZE it.
public class RedAndGreenE{
  public static HashMap<Integer, Integer> factorList = new HashMap<Integer, Integer>();
  public static HashMap<Integer, Character> colours = new HashMap<Integer, Character>();
  public static StringBuffer output = new StringBuffer("");
  public static int startNum = 1;
  public static int endNum = 1000;
  
  public static void main(String[] args){
    long startTime = System.currentTimeMillis();
    
    findNearFactorsE(startNum);
      
    System.out.println(output);
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("MILLISECONDS: " + totalTime);
    
  }
  
  
  
  public static void findNearFactorsE(int num){
    HashMap<Integer, Integer> list;
    list = factorList;
    int gCount = 0;
    int rCount = 0;
    if(num != 1){
      list.put(1, 1);
      gCount++;
      for(int i = 2; i < (num/2+1); i++){
        int factor = num/i;
        //if it is a new factor
        if(!list.containsValue(factor)){
          list.put(list.size() + 1, factor);
          if(colours.get(factor-1) == 'G'){
            gCount++;
          } else {
            rCount++;
          }
        }        
      }
      
      if(gCount > rCount){
        colours.put(num, 'R');
        output.append('R');
      } else {
        colours.put(num, 'G');
        output.append('G');
      }
    } else {
      colours.put(num, 'G');
      output.append('G');
    }
    
    list = null;
    if((num + 1) <= endNum){
      findNearFactorsE(num+1);
    }
  }
  
  
}
