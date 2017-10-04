import java.util.*;
  
  public class Test{
  
  public static void main(String[] args){
    GoldInteger g = new GoldInteger("12345");
    GoldInteger d = new GoldInteger("98765");
    GoldInteger n = new GoldInteger("-1234");
    GoldInteger m = new GoldInteger("1234");
    GoldInteger i = new GoldInteger("123456");
    GoldInteger j = new GoldInteger("1234");
    GoldInteger l = new GoldInteger("1234");
    GoldInteger o = new GoldInteger("-987656");
    GoldInteger p = new GoldInteger("111234");
    GoldInteger q = new GoldInteger("1234");
    GoldInteger r = new GoldInteger("425");
    GoldInteger v = new GoldInteger("425");
    GoldInteger s = new GoldInteger("-7894938");
    GoldInteger y = new GoldInteger("100");
  
    System.out.println("------multiply-------");   
    n.multiply("6789");    
    System.out.println("------add-------");   
    System.out.println(n.toString());
    m.add("6789");   
    System.out.println(m.toString());
    i.add("1234");
    System.out.println(i.toString());
    j.add("7892");
    System.out.println(j.toString());
    l.add("123456");
    System.out.println(l.toString());
    System.out.println("---------subtract---------");   
    d.subtract("8765"); 
    System.out.println(d);
    p.subtract("-1234");
    System.out.println(p.toString());
    o.subtract("1234"); 
    System.out.println(o.toString());
    q.subtract("-1234"); 
    System.out.println(q.toString());
    y.subtract("10");
    System.out.println(y);
    System.out.println("---------divide---------"); 
    System.out.println(r.divide("25"));
    System.out.println(r.toString());
    System.out.println(s.divide("-54"));
    System.out.println(s.toString());
    System.out.println("---------compare---------");
    System.out.println(j.isGreaterThan("1112321"));
    System.out.println(v.isGreaterThan("321"));
    System.out.println(v.isLessThan("-12354363"));
    System.out.println(v.isLessThan("12354363"));                  
    System.out.println(o.isGreaterThan("-787839743"));
    System.out.println(v.isEqualTo("425"));
 
  }
}