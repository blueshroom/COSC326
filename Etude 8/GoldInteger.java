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
      for(int i = 0; i < d.length(); i++){ 
        int x = Character.getNumericValue(n.charAt(i)); 
        int y = Character.getNumericValue(d.charAt(i)); 
        int z = x + y; 
        if(overflow){ 
          z++; 
        } 
        overflow = false; 
        if(z > 9){ 
          overflow = true; 
        } 
        result = Integer.toString(z).substring(1) + result; 
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
        result = Integer.toString(z).substring(1) + result; 
        i--; 
      } 
      if(i > 0){ 
        result = n.substring(0, i); 
      } 
    } else { 
      for(int i = 0; i < n.length(); i++){ 
        int x = Character.getNumericValue(n.charAt(i)); 
        int y = Character.getNumericValue(d.charAt(i)); 
        int z = x + y; 
        if(overflow){ 
          z++; 
        } 
        overflow = false; 
        if(z > 9){ 
          overflow = true; 
        } 
        result = Integer.toString(z).substring(1) + result; 
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
        result = Integer.toString(z).substring(1) + result; 
        i--; 
      } 
      if(i > 0){ 
        result = d.substring(0, i); 
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