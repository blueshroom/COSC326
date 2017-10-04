import java.util.*; 
   
public class GoldInteger {
   
  private String d;
  private String n;
   
  public GoldInteger(String digits){ 
    this.d = digits; 
  } 
   
  public String toString(){ 
    return d; 
  } 
  
  public void setString(String n){
    this.d = n;
  }
  
  //is our number less than the subject 'n'
  public boolean isLessThan(String n){
    if(d.charAt(0) == '-' && n.charAt(0) != '-'){
      return true;
    } else if(d.charAt(0) != '-' && n.charAt(0) == '-'){
      return false;
    } else {
      //both numbers are either negative or not.
      if(d.charAt(0) != '-'){
        if(d.length() > n.length()){
          return false;
        } else if(d.length() < n.length()){
          return true;
        }
        for(int i = 0; i < d.length(); i++){
          int x = Character.getNumericValue(d.charAt(i)); 
          int y = Character.getNumericValue(n.charAt(i));
          if(x > y){
            return false;
          } else if(x < y){
            return true;
          }
        }
        //will get here if they are equal
        return false;
      } else {
        //if they are negative, start at 1.
        if(d.length() > n.length()){
          return true;
        } else if(d.length() < n.length()){
          return false;
        }
        for(int i = 1; i < d.length(); i++){
          int x = Character.getNumericValue(d.charAt(i)); 
          int y = Character.getNumericValue(n.charAt(i));
          if(x > y){
            return true;
          } else if(x < y){
            return false;
          }
        }
        //will get here if they are equal
        return false;
      }
    }
  }
  
  
  
  public boolean isGreaterThan(String n){
    if(d.charAt(0) == '-' && n.charAt(0) != '-'){
      return false;
    } else if(d.charAt(0) != '-' && n.charAt(0) == '-'){
      return true;
    } else {
      //both numbers are positive
      if(d.charAt(0) != '-'){
        if(d.length() > n.length()){
          return true;
        } else if(d.length() < n.length()){
          return false;
        }
        for(int i = 0; i < d.length(); i++){
          int x = Character.getNumericValue(d.charAt(i)); 
          int y = Character.getNumericValue(n.charAt(i));
          if(x > y){
            return true;
          } else if(x < y){
            return false;
          }
        }
        //will get here if they are equal
        return false;
      } else {
        //if they are negative, start at 1.
        if(d.length() > n.length()){
          return false;
        } else if(d.length() < n.length()){
          return true;
        }
        for(int i = 1; i < d.length(); i++){
          int x = Character.getNumericValue(d.charAt(i)); 
          int y = Character.getNumericValue(n.charAt(i));
          if(x > y){
            return false;
          } else if(x < y){
            return true;
          }
        }
        //will get here if they are equal
        return false;
      }
    }
  }

  public boolean isEqualTo(String n){
    if(d.charAt(0) == '-' && n.charAt(0) != '-'){
      return false;
    } else if(d.charAt(0) != '-' && n.charAt(0) == '-'){
      return false;
    } else {
      //both numbers are either negative or not.
      if(d.charAt(0) != '-'){
        for(int i = 0; i < d.length(); i++){
          int x = Character.getNumericValue(d.charAt(i)); 
          int y = Character.getNumericValue(n.charAt(i));
          if(x > y){
            return false;
          } else if(x < y){
            return false;
          }
        }
        //will get here if they are equal
        return true;
      } else {
        //if they are negative, start at 1.
        for(int i = 1; i < d.length(); i++){
          int x = Character.getNumericValue(d.charAt(i)); 
          int y = Character.getNumericValue(n.charAt(i));
          if(x > y){
            return false;
          } else if(x < y){
            return false;
          }
        }
        //will get here if they are equal
        return true;
      }
    }
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
  
  public String addOpo(String n){ 
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
        return result;
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
        return result;
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
    return result;
  } 
  
  
  public void subtract(String n){
    String result = "";
    boolean steal = false;
    boolean rotation = false;
    boolean currentLargest = false;
    boolean currentNeg = false;
    boolean subjectNeg = false;
    //taking care of negatives
    if(d.charAt(0) == '-'){
      currentNeg = true;
      d = d.substring(1);
    }
    if(n.charAt(0) == '-'){
      subjectNeg = true;
      n = n.substring(1);
    }
    
    //if our number is the larger one
    if(n.length() < d.length()){
      int diff = d.length() - n.length();
      currentLargest = true;
      if(subjectNeg){
        String origD = d;
        add(n);
        result = d;
      } else if(currentNeg){
        String origD = d;
        add(n);
        result = origD.substring(0, diff) + d;
        result = "-" + d;
      } else if(currentNeg && subjectNeg){
        String origD = d;
        add(n);
        result = origD.substring(0, diff) + d;
        result = "-" + d;
      } else {
        result = subtractByBorrowing(d.substring(diff), n, 1);
        result = d.substring(0, diff) + result;
      }
      d = result;
      //if they are both the same length  
    } else if(n.length() == d.length()){
      int x = Character.getNumericValue(d.charAt(0)); 
      int y = Character.getNumericValue(n.charAt(0));
      if(x > y){
        int diff = d.length() - n.length();
        currentLargest = true;
        if(currentNeg && subjectNeg){
          add(n);
          result = "-" + d;
        } else if(currentNeg){
          add(n);
          result = "-" + d;
        } else if(subjectNeg){
          add(n);
          result = d;
        } else {
          this.n = n;
          result = subtractByBorrowing(d.substring(diff), n, 0);
        }
      } else {
        int diff = n.length() - d.length();
        currentLargest = true;
        if(currentNeg && subjectNeg){
          n = addOpo(n);
          result = "-" + n;
        } else if(subjectNeg){
          n = addOpo(n);
          result = n;
        } else if(currentNeg){
          n = addOpo(n);
          result = "-" + n;
          
        } else {
          this.n = n;
          result = subtractByBorrowing(n.substring(diff), d, 0);
        }
        d = result;
      }
      //other number is the larger one  
    } else {
      int diff = n.length() - d.length();
      currentLargest = true;
      if(currentNeg){
        String origN = n;
        n = addOpo(n);
        result = origN.substring(0, diff) + n;
        result = n;
      } else if(subjectNeg){
        String origN = n;
        n = addOpo(n);
        result = origN.substring(0, diff) + n;
        result = "-" + n;
      } else if(currentNeg && subjectNeg){
        String origN = n;
        n = addOpo(n);
        result = origN.substring(0, diff) + n;
        result = "-" + n;
      } else {
        this.n = n;
        result = subtractByBorrowing(n.substring(diff), d, 2);
        result = this.n.substring(0, diff) + result;
      }
      d = result;
    }
  }
    
  
  
  
  //stealFrom 0 = none, stealFrom 1 = d, stealFrom 2 = n
  public String subtractByBorrowing(String a, String b, int change){ 
    String result = "";
    boolean steal = false;
    for(int i = a.length()-1; i >= 0; i--){
      int x = Character.getNumericValue(a.charAt(i)); 
      int y = Character.getNumericValue(b.charAt(i));
      if(steal){
        x -= 1;
        steal = false;
      }
      if(x < y){
        x += 10;
        steal = true;
        int z = x - y;
        result = Integer.toString(z) + result;
      } else {
        int z = x - y;
        result = Integer.toString(z) + result;
      }
    }
    System.out.println("-----------");
    System.out.println(result);
    int stolen;
    if(steal){
      switch(change){
        case 1:
          System.out.println(d);
          stolen = Character.getNumericValue(d.charAt(a.length()-1));
          stolen -= 1;
          d = (d.substring(0, a.length()-1) + stolen);
          System.out.println(d);
          break;
        case 2:
          System.out.println(n);
          stolen = Character.getNumericValue(n.charAt(a.length()-1));
          stolen -= 1;
          n = (n.substring(0, a.length()-1) + stolen);
          System.out.println(n);
          break;
        default:
          break;
      }
    }
    return result;
  }
    
  
  
  
  
   
  public void multiply(String n){ 
    String result = ""; 
    List<Integer> overflowArray = new ArrayList<Integer>(); 
    int m;
    boolean neg = false;
    
    /*Checks for negatives*/
    if(d.charAt(0) == '-' && n.charAt(0) == '-'){
      neg = false;
      d = d.substring(1);
      n = n.substring(1);
    }else if(d.charAt(0) == '-'){
      neg = true;
      d = d.substring(1);
    }else if(n.charAt(0) == '-'){
      neg = true;
      n = n.substring(1);
    }
    
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
    if(neg == true){
      result = "-" + result;
    }
    this.d = result;
    
  }
  
  public String divide(String n){
    GoldInteger result = new GoldInteger("0");
    String remainder;
    boolean neg = false;
    /*Check for negatives*/
    if(d.charAt(0) == '-' && n.charAt(0) == '-'){
      neg = false;
      d = d.substring(1);
      n = n.substring(1);
    }else if(d.charAt(0) == '-'){
      neg = true;
      d = d.substring(1);
    }else if(n.charAt(0) == '-'){
      neg = true;
      n = n.substring(1);
    }
    GoldInteger r = new GoldInteger(d);
    Integer rInt = 0;
    //while(r.isGreaterThan(n) || r.isEqualTo(n)){
    while(Integer.parseInt(r.toString()) >= Integer.parseInt(n)){
      //r.subtract(n.toString());
      r.setString(Integer.toString(Integer.parseInt(r.toString()) - Integer.parseInt(n)));
      //result.add("1");
      rInt += 1;      
    }
    remainder = r.toString();
    d = rInt.toString();
    
    if(neg == true){
      d = "-" + d;
    }
    // if(d.length()+1 > n.length){
    
    return remainder;
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