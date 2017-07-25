import java.awt.GridLayout;
import javax.swing.JFrame;
import java.util.Scanner;
import java.util.ArrayList;

public class Quilt extends JFrame {
  
  public static Scanner scan = new Scanner(System.in);
  public static ArrayList<double[]> squares = new ArrayList<double[]>();
  Screen s;
  
  public Quilt() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 800);
    setResizable(false);
    setTitle("A Patchwork Quilt");
    
    init();
  }
  
  public void init() {
    setLocationRelativeTo(null);
    setLayout(new GridLayout(1, 1, 0, 0));
    
    s = new Screen(squares);
    add(s);
    
    setVisible(true);
  }
  
  public static void main(String[] args){
    while(scan.hasNextLine()){
      String input = scan.nextLine();
      String[] values = input.split(" ");
      double[] square = new double[4];
      for(int i = 0; i < square.length; i++){
        square[i] = Double.parseDouble(values[i]);
      }
      squares.add(square);
    }
    new Quilt();
  }
  
}
