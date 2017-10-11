import java.util.*; 
   
public class GoldInteger {
   
  private String d;
  private String remainder;
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
  
  public String getRemainder(){
    return remainder;
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
    boolean done = false;
    
    //dealing with negatives
    if(d.charAt(0) == '-' && n.charAt(0) == '-'){
      d = d.substring(1);
      n = n.substring(1);
      this.add(n);
      d = "-" + d;
      done = true;
    } else if(n.charAt(0) == '-'){
      if(this.isGreaterThan(n.substring(1))){
        this.subtract(n.substring(1));
        done = true;
      } else {
        GoldInteger x = new GoldInteger(n.substring(1));
        x.subtract(d);
        d = x.toString();
        if(!d.equals("0")){
          d = "-" + d;          
        }
        done = true;
      }
    } else if(d.charAt(0) == '-'){
      d = d.substring(1);
      if(this.isGreaterThan(n)){
        this.subtract(n);
        if(!d.equals("0")){
          d = "-" + d;
        }
      } else {
        GoldInteger x = new GoldInteger(n);
        x.subtract(d);
        d = x.toString();        
      }
    //they are either both negative or not.
    } else if(done != true){
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
          int z = Character.getNumericValue(d.charAt(i-1)); 
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
      if(overflow){
        result = "1" + result;
      }
      d = result;
    }
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
      if(this.isGreaterThan(n)){
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
        d = result;
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
    //removing unessary zeros off the front
    int i = 0;
    while(d.charAt(i) == '0' && d.length() > 1){
      d = d.substring(i+1);
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
    int stolen;
    int pos;
    StringBuilder builder;
    if(steal){
      switch(change){
        case 1:    
          String tempD = d.substring(0, d.length()-result.length());
          pos = tempD.length()-1;
          while(steal){
            int x = Character.getNumericValue(tempD.charAt(pos));
            if(x != 0){
              x--;
              steal = false;
              if(tempD.length()-1 < pos){
                tempD = tempD.substring(0, pos) + x;
              } else {
                tempD = (tempD.substring(0, pos) + x) + tempD.substring(pos+1);
              }
            } else {
              pos--;
            }
          }
          builder = new StringBuilder(tempD);          
          if(tempD.length() > pos+1){
            //System.out.println("HERED: " + tempD.charAt(pos+1) + "|" + (pos+1));
            while(pos+1 < tempD.length() && tempD.charAt(pos+1) == '0'){
              builder.setCharAt(pos+1, '9');
              pos++;
            }
            d = builder.toString();
          } else {
            d = tempD;
          }
          break;
        case 2:
          String tempN = n.substring(0, n.length()-result.length());
          pos = tempN.length()-1;
          while(steal){
            int x = Character.getNumericValue(tempN.charAt(pos));
            if(x != 0){
              x--;
              steal = false;
              if(tempN.length()-1 < pos){
                tempN = tempN.substring(0, pos) + x;
              } else {
                tempN = (tempN.substring(0, pos) + x) + tempN.substring(pos+1);
              }
            } else {
              pos--;
            }
          }
          builder = new StringBuilder(tempN);
          //System.out.println("HEREN: " + tempN.charAt(pos+1) + "|" + (pos+1));
          while(pos+1 < tempN.length() && tempN.charAt(pos+1) == '0'){
            builder.setCharAt(pos+1, '9');
            pos++;
          }
          n = builder.toString();
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
  
  public void divide(String n){
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
    while(r.isGreaterThan(n) || r.isEqualTo(n)){
      //System.out.println("::::" + r + "||" + n);
      r.subtract(n);
      result.add("1");
      //System.out.println("RE: " + result.toString());
      //System.out.println("X: " + r.toString());
    }
    remainder = r.toString();
    d = result.toString();
    if(neg == true){
      d = "-" + d;
    }
    
    this.remainder = remainder;
  }
  
  
  public String greatestCommonDivisor(String n){
    GoldInteger dividend;
    GoldInteger divisor;
    GoldInteger quotient;
    GoldInteger remainder = new GoldInteger("-1");
    if(this.isGreaterThan(n)){
      dividend = new GoldInteger(d);
      divisor = new GoldInteger(n);
    } else {
      dividend = new GoldInteger(n);
      divisor = new GoldInteger(d);
    }
    while(!remainder.isEqualTo("0")){
      dividend.divide(divisor.toString());
      quotient = new GoldInteger(dividend.toString());
      remainder = new GoldInteger(dividend.getRemainder());
      
      if(remainder.isEqualTo("0")){
        return divisor.toString();
      }
      
      dividend = divisor;
      divisor = remainder;
    }
    return divisor.toString();
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