public class GoldInteger {
  
  private String d;
  
  public GoldInteger(String digits){
    this.d = digits;
  }
  
  public String toString(){
    return d;
  }
  
  public String add(String n){
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
        return result;
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
        return result;
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
    return result;
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