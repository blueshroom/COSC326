public class Test{
  
  public static void main(String[] args){
    
    GoldInteger n = new GoldInteger("1234");
    GoldInteger m = new GoldInteger("1234");
    GoldInteger i = new GoldInteger("123456");
    GoldInteger j = new GoldInteger("1234");
    GoldInteger l = new GoldInteger("1234");
    GoldInteger o = new GoldInteger("-987656");
    GoldInteger p = new GoldInteger("1234");
    GoldInteger q = new GoldInteger("12");
    GoldInteger r = new GoldInteger("1234");
    GoldInteger s = new GoldInteger("-1234");
    GoldInteger t = new GoldInteger("-4567");
    n.multiply("6789");
    System.out.println(n.toString());
    System.out.println("------------------"); 
    m.add("6789");   
    System.out.println(m.toString());
    i.add("1234");
    System.out.println(i.toString());
    j.add("7892");
    System.out.println(j.toString());
    l.add("123456");
    System.out.println(l.toString());
    System.out.println("------------------");   
    p.subtract("-1234");
    System.out.println(p.toString());
    o.subtract("1234");
    System.out.println(o.toString());
    q.subtract("-1234");
    System.out.println(q.toString());
    System.out.println("------------------");  
    System.out.println(r.isLessThan("4567"));
    System.out.println(s.isLessThan("-1234"));
    System.out.println(t.isLessThan("4567"));
    System.out.println("------------------"); 
    System.out.println(r.isGreaterThan("4567"));
    System.out.println(s.isGreaterThan("-1234"));
    System.out.println(t.isGreaterThan("4567"));
    System.out.println("------------------"); 
    System.out.println(r.isEqualTo("4567"));
    System.out.println(s.isEqualTo("-1234"));
    System.out.println(t.isEqualTo("4567"));
    
  
  }
}