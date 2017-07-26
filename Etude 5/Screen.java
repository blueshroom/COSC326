import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class Screen extends JPanel {
  
  public ArrayList<double[]> squares = new ArrayList<double[]>(); 
  public int scale;

  public Screen(ArrayList<double[]> squares, int size) {
   //work out the size that the first square can be.
   double totalPercent;
   for(int i = 0; i < squares.size(); i++){
        totalPercent += squares.get(i)[0];
   }
   double hypot = Math.sqrt((size^2 + size^2));
   int hypotRounded = Integer.valueOf((int) Math.round(hypot));
   scale = hypotRounded/totalPercent; 

   //sorting the quilt patterns. 
   for(int i = 0; i < squares.size(); i++){
        double currentValue = squares.get(i)[0];
        int pos = i;
        while(pos > 0 && squares.get(pos-1)[0] < currentValue){
            squares.get(pos)[0] = squares.get(pos-1)[0];
            pos--;
        }
        squares.get(pos)[0] = currentValue;
    }
    this.squares = squares;
    repaint();
  }
  
  public void paint(Graphics draw) {
    System.out.println(scale);  
    //for each square in the arrayList, draw it on the page.
    for(int i = 0; i < squares.size(); i++){
      double[] square = squares.get(i);
      System.out.println(square[0]);
      Integer r = Integer.valueOf(Double.valueOf(square[1]).intValue());
      Integer g = Integer.valueOf(Double.valueOf(square[2]).intValue());
      Integer b = Integer.valueOf(Double.valueOf(square[3]).intValue());
      draw.setColor(new Color(r, g, b));
      draw.fillRect(200, 200, 100*(4-i), 100*(4-i));
    }    
  }
  
  
  
  
}
