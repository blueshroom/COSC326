public class Test{
  
  public static void main(String[] args){
    
    GoldInteger n = new GoldInteger("1234");
    GoldInteger m = new GoldInteger("1234");
    GoldInteger i = new GoldInteger("123456");
    GoldInteger j = new GoldInteger("1234");
    GoldInteger l = new GoldInteger("1234");
    n.multiply("6789");
    System.out.println(n.toString());
    m.add("6789");   
    System.out.println(m.toString());
    i.add("1234");
    System.out.println(i.toString());
    j.add("7892");
    System.out.println(j.toString());
    l.add("123456");
    System.out.println(l.toString());
  
  }
}