import java.util.*;
  
  public class Test{
    public static String input;
  
  public static void main(String[] args){
    
//    GoldInteger g = new GoldInteger("12345");
//    GoldInteger d = new GoldInteger("98765");
//    GoldInteger t = new GoldInteger("-1234");
    GoldInteger m = new GoldInteger("-3");
//    GoldInteger i = new GoldInteger("123456");
//    GoldInteger j = new GoldInteger("1234");
//    GoldInteger l = new GoldInteger("1234");
//    GoldInteger o = new GoldInteger("-987656");
//    GoldInteger p = new GoldInteger("111234");
//    GoldInteger q = new GoldInteger("1234");
//    GoldInteger r = new GoldInteger("25");
//    GoldInteger v = new GoldInteger("425");
//    GoldInteger s = new GoldInteger("-7894938");
//    GoldInteger y = new GoldInteger("100");
//    GoldInteger x = new GoldInteger("8789430");
//    GoldInteger a = new GoldInteger("9");
//    GoldInteger u = new GoldInteger("425");
//  
//    System.out.println("------multiply-------");   
//    t.multiply("6789");
//    System.out.println(t.toString());
//    System.out.println("------add-------");   
    m.add("5");   
    System.out.println(m.toString());
//    i.add("1234");
//    System.out.println(i.toString());
//    j.add("7892");
//    System.out.println(j.toString());
//    l.add("123456");
//    System.out.println(l.toString());
//    a.add("1");
//    System.out.println(a.toString());
//    System.out.println("---------subtract---------");   
//    d.subtract("8765"); 
//    System.out.println(d);
//    p.subtract("-1234");
//    System.out.println(p.toString());
//    o.subtract("1234"); 
//    System.out.println(o.toString());
//    q.subtract("-1234"); 
//    System.out.println(q.toString());
//    y.subtract("10"); 
//    System.out.println(y);
//    x.subtract("54"); 
//    System.out.println(x);
//    System.out.println("---------divide---------"); 
//    r.divide("24");
//    System.out.println(r.toString() + " " + r.getRemainder());
//    s.divide("24");
//    System.out.println(s.toString() + " " + s.getRemainder());
//    System.out.println("---------compare---------");
//    System.out.println(j.isGreaterThan("1112321"));
//    System.out.println(v.isGreaterThan("321"));
//    System.out.println(v.isLessThan("-12354363"));
//    System.out.println(v.isLessThan("12354363"));                  
//    System.out.println(o.isGreaterThan("-787839743"));
//    System.out.println(v.isEqualTo("425"));
//    System.out.println("---------gcd---------");
//    System.out.println(u.greatestCommonDivisor("25"));
    
    Scanner scan = new Scanner(System.in);
    GoldInteger n = new GoldInteger("0");
    while(scan.hasNextLine()){
      input = "";
      input += scan.nextLine();
      if(!input.equals("")){
        //if the input isn't a comment
        if(input.charAt(0) != '#'){
          String[] inputArray = input.split(" ");
          //if the split input has 3 strings in it.
          if(inputArray.length == 3){
            if(isNumber(inputArray[0])){
              n = new GoldInteger(inputArray[0]);
            } else {
              System.out.println(input);
              System.out.println("# Syntax error");
            }
            if(isNumber(inputArray[2])){
              if(inputArray[1].length() == 1 || inputArray[1].equals("gcd")){
                if(inputArray[1].equals("gcd")){           
                  System.out.println(input);
                  System.out.println("# " + n.greatestCommonDivisor(inputArray[2]));
                } else {
                  switch(inputArray[1].charAt(0)){
                    case '+':
                      n.add(inputArray[2]);
                      System.out.println(input);
                      System.out.println("# " + n.toString());
                      break;
                    case '-':
                      n.subtract(inputArray[2]);
                      System.out.println(input);
                      System.out.println("# " + n.toString());
                      break;
                    case '*':
                      n.multiply(inputArray[2]);
                      System.out.println(input);
                      System.out.println("# " + n.toString());
                      break;
                    case '/':
                      n.divide(inputArray[2]);
                      System.out.println(input);
                      System.out.println("# " + n.toString() + " " + n.getRemainder());
                      break;
                    case '<':
                      System.out.println(input);
                      System.out.println("# " + n.isLessThan(inputArray[2]));
                      break;
                    case '>':
                      System.out.println(input);
                      System.out.println("# " + n.isGreaterThan(inputArray[2]));
                      break;
                    case '=':
                      System.out.println(input);
                      System.out.println("# " + n.isEqualTo(inputArray[2]));
                      break;
                    default:
                      System.out.println(input);
                      System.out.println("# Syntax error");
                  }
                }
              } else {
                System.out.println(input);
                System.out.println("# Syntax error");
              }
            }
          } else {
            System.out.println(input);
            System.out.println("# Syntax error");
          }
        }
      }
    }
  }
  
  
  
  public static boolean isNumber(String s) {
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    
    return true;
  }
  
  
}