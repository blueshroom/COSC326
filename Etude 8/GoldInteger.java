import java.util.*; 
   
public class GoldInteger { 
   
  private String d; 
   
  public GoldInteger(String digits){ 
    this.d = digits; 
  } 
   
  public String toString(){ 
    return d; 
  } 
   
  public void add(String n){ 
    String result = ""; 
    boolean overflow = false; 
    if(n.length() > d.length()){
      int diff = n.length() - d.length();
      for(int i = d.length()-1; i >= 0; i--){ 
        int x = Character.getNumericValue(n.charAt(i+diff)); 
        int y = Character.getNumericValue(d.charAt(i)); 
        int z = x + y; 
        if(overflow){ 
          z++; 
        } 
        overflow = false; 
        if(z > 9){ 
          overflow = true; 
        } 
        String number = Integer.toString(z);
        result = number.substring(number.length()-1) + result;
      }       
      int i = (n.length() - d.length()); 
      if(i == 0 && overflow){ 
        result = "1" + result;
        d = result;
        return; 
      } 
      while(overflow && i > 0){ 
        int z = Character.getNumericValue(n.charAt(i)); 
        z++; 
        overflow = false; 
        if(z > 9){ 
          overflow = true; 
        } 
        String number = Integer.toString(z);
        result = number.substring(number.length()-1) + result;
        i--; 
      } 
      if(i > 0){
        result = n.substring(0, i) + result; 
      } 
    } else {
      int diff = d.length() - n.length();
      for(int i = n.length()-1; i >= 0; i--){ 
        int x = Character.getNumericValue(n.charAt(i)); 
        int y = Character.getNumericValue(d.charAt(i+diff)); 
        int z = x + y; 
        if(overflow){ 
          z++; 
        } 
        overflow = false; 
        if(z > 9){ 
          overflow = true; 
        }
        String number = Integer.toString(z);
        result = number.substring(number.length()-1) + result; 
      }      
      int i = (d.length() - n.length()); 
      if(i == 0 && overflow){ 
        result = "1" + result; 
        d = result;
        return;
      } 
      while(overflow && i > 0){ 
        int z = Character.getNumericValue(d.charAt(i)); 
        z++; 
        overflow = false; 
        if(z > 9){ 
          overflow = true; 
        } 
        String number = Integer.toString(z);
        result = number.substring(number.length()-1) + result; 
        i--; 
      } 
      if(i > 0){ 
        result = d.substring(0, i) + result; 
      } 
    } 
    d = result;
  } 
  
  
  
  
  public void subtract(String n){ 
    String result = "";
    boolean steal = false;
    
    //if the number we are subtracting is larger
    if(n.length() > d.length()){
      int diff = n.length() - d.length();
      for(int i = 0; i < d.length(); i++){
        int x = Character.getNumericValue(d.charAt(i)); 
        int y = Character.getNumericValue(n.charAt(i+diff));
        if(steal){
            x -= 1;
            steal = false;
          }
          if(x < y){
            x += 10;
            steal = true;
            int z = x - y;
            result = Integer.toString(z).substring(1,1) + result;
          } else {
            int z = x - y;
            result = Integer.toString(z) + result;
          }
      }
      result = "-" + n.substring(0, diff-1) + result;
    //if our current number is larger
    } else if(n.length() < d.length()){
      int diff = (d.length() - n.length());
      for(int i = n.length()-1; i >= 0; i--){
        int x = Character.getNumericValue(d.charAt(i)); 
        int y = Character.getNumericValue(n.charAt(i));
        if(steal){
            x -= 1;
            steal = false;
          }
          if(x < y){
            x += 10;
            steal = true;
            int z = x - y;
            result = Integer.toString(z).substring(1,1) + result;
          } else {
            int z = x - y;
            result = Integer.toString(z) + result;
          }
      }
      for(int i = n.length(); i < diff; i++){
        if(steal){
          int z = Character.getNumericValue(d.charAt(i));
          z++;
          result = Integer.toString(z) + result;
          steal = false;
        }
        result = d.charAt(i) + result;
      }
    } else {
      //if the numbers are the same length
      int x = Character.getNumericValue(d.charAt(0)); 
      int y = Character.getNumericValue(n.charAt(0));
      //making sure the smaller number is the number getting subtracted
      if(y > x){
        for(int i = n.length()-1; i >= 0; i--){
          x = Character.getNumericValue(n.charAt(i)); 
          y = Character.getNumericValue(d.charAt(i));
          if(steal){
            x -= 1;
            steal = false;
          }
          if(x < y){
            x += 10;
            steal = true;
          }
          int z = x - y;
          result = Integer.toString(z) + result;
        }
        result = "-" + result;
      } else {
        for(int i = 0; i < n.length(); i++){
          x = Character.getNumericValue(d.charAt(i)); 
          y = Character.getNumericValue(n.charAt(i));
          if(steal){
            x -= 1;
            steal = false;
          }
          if(x < y){
            x += 10;
            steal = true;
          }
          int z = x - y;
          result = result + Integer.toString(z);
        }
      }
    }
    d = result;
  }
    
  
  
  
  
   
  public void multiply(String n){ 
    String result = ""; 
    List<Integer> overflowArray = new ArrayList<Integer>(); 
    int m; 
    if (d.length() > n.length()){ 
      m = d.length(); 
    }else{ 
      m = n.length(); 
    } 
    /*Increase for larger numbers*/ 
    m+=4; 
    for(int i =0; i < m ; i++){ 
      int carry = 0; 
      for(int j = 0; j < m; j++){ 
        int x, y; 
        if(j >= n.length() || i>= d.length()){ 
          x = 0; 
          y = 0; 
        }else{ 
        x = Character.getNumericValue(d.charAt(d.length()-1-i)); 
        y = Character.getNumericValue(n.charAt(n.length()-1-j)); 
        } 
        if(overflowArray.isEmpty()||overflowArray.size() <= (i+j)){ 
          overflowArray.add(i+j,0); 
        } 
        int z = (x*y) + overflowArray.get(i+j) + carry; 
        carry = z/10; 
        overflowArray.set(i+j,z%10); 
      } 
       
    } 
     
    for(int i = 0; i < overflowArray.size();i++){ 
      result = result + overflowArray.get(overflowArray.size()-1-i); 
    } 
    for(int i = 0; i < overflowArray.size()-1;i++){ 
      if(result.charAt(0) != '0'){ 
        break; 
      } 
      result = result.substring(1); 
    } 
    this.d = result; 
  } 
} 

   
 
//  n = 6789 
//  digits = 1234 
//     
//  9 + 4 = 13 
//  8 + 3 + 1 = 12 
//  7 + 2 + 1 = 10 
//  6 + 1 + 1 = 8 
//  8023