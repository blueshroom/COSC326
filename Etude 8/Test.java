public class Test{
  
  public static void main(String[] args){
    
    GoldInteger n = new GoldInteger("1234");
    GoldInteger m = new GoldInteger("1234");
    n.multiply("6789");
    m.add("6789");
    System.out.println(n.toString());
    System.out.println(m.toString());
  
  }
}