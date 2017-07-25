import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class Screen extends JPanel {
  
  public ArrayList<double[]> squares = new ArrayList<double[]>();
  
  public Screen(ArrayList<double[]> squares) {
    this.squares = squares;
    repaint();
  }
  
  public void paint(Graphics draw) {
    //for each square in the arrayList, draw it on the page.
    for(int i = 0; i < squares.size(); i++){
      double[] square = squares.get(i);
      Integer r = Integer.valueOf(Double.valueOf(square[1]).intValue());
      Integer g = Integer.valueOf(Double.valueOf(square[2]).intValue());
      Integer b = Integer.valueOf(Double.valueOf(square[3]).intValue());
      draw.setColor(new Color(r, g, b));
      draw.fillRect(200, 200, 100*(4-i), 100*(4-i));
    }    
  }
  
  
  
  
}
