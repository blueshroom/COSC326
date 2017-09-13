import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

//possibly use this for SUPERSIZE it.
public class RedAndGreenE{
  //public static HashMap<Integer, ArrayList<Integer>> list = new HashMap<Integer, ArrayList<Integer>>();
  public static HashMap<Integer, Integer> factorList = new HashMap<Integer, Integer>();
  public static HashMap<Integer, Character> colours = new HashMap<Integer, Character>();
  public static StringBuffer output = new StringBuffer("");
  
  public static void main(String[] args){
    long startTime = System.currentTimeMillis();
    int startNum = 1;
    int endNum = 100000; 
    
    for(int i = startNum; i < endNum; i++){
      findNearFactorsE(i);
    }
    System.out.println(output);
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("MILLISECONDS: " + totalTime);
    
  }
  
  
  
  public static void findNearFactorsE(int num){
    int gCount = 0;
    int rCount = 0;
    if(num != 1){
      factorList.put(1, 1);
      gCount++;
      for(int i = 2; i < (num/2+1); i++){
        int factor = num/i;
        //if it is a new factor
        if(!factorList.containsValue(factor)){
          factorList.put(factorList.size() + 1, factor);
          if(colours.get(factor) == 'G'){
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
    factorList.clear();
  }
  
}
