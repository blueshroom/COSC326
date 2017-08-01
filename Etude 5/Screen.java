import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class Screen extends JPanel {
  
  public ArrayList<double[]> squares = new ArrayList<double[]>(); 
  public double dubScale;
  public int scale;
  public int size;

  public Screen(ArrayList<double[]> squares, int size) {
   //work out the size that the first square can be.
   double totalPercent = 0;
   for(int i = 0; i < squares.size(); i++){
        totalPercent += squares.get(i)[0];
   }
   double hypot = Math.sqrt(((size*size) + (size*size)));
   System.out.println("hypot: " + hypot);
   System.out.println("percent: " + totalPercent);
   dubScale = hypot/totalPercent;
   //changing the 1% hypot length into the side lengths of the 1% square.
   dubScale = Math.sqrt((dubScale*dubScale)/2);
   //scale is the length and height of a square with 1% scale.
   scale = Integer.valueOf((int) Math.round(dubScale));
   System.out.println("scale: " + scale);

//   sorting the quilt patterns. 
//   for(int i = 0; i < squares.size(); i++){
//        double currentValue = squares.get(i)[0];
//        int pos = i;
//        while(pos > 0 && squares.get(pos-1)[0] < currentValue){
//            squares.get(pos)[0] = squares.get(pos-1)[0];
//            pos--;
//        }
//        squares.get(pos)[0] = currentValue;
//    }
    this.squares = squares;
    this.size = size;
    repaint();
  }
  
  public void paint(Graphics draw) { 
    int topL = 0;
    int topR = 0;
    int botL = 0;
    int botR = 0;
    int x = 0;
    int y = 0;
    //for each square in the arrayList, draw it on the page.
    for(int i = 0; i < squares.size(); i++){
      double[] square = squares.get(i);
      Integer r = Integer.valueOf((int) Math.round(square[1]));
      Integer g = Integer.valueOf((int) Math.round(square[2]));
      Integer b = Integer.valueOf((int) Math.round(square[3]));
      draw.setColor(new Color(r, g, b));
      //draw the first square.
      if(i < 1){
        System.out.println("drawing");
        x = ((size/2)-(scale/2));
        y = ((size/2)-(scale/2));
        draw.fillRect(x, y, scale, scale);
      } else {
        //drawing the 4 squares clockwise.
        for(int j = 0; j < 4; j++){
          //finding the new dimesions for the next square.
          scale = squares.get(0)[5]*square[0];
          System.out.println("drawing");
          switch(j) {
            //topLSquare
            case 0:
              x = 
              y = 
              draw.fillRect(x, y, scale, scale);
              break;
            //topRSquare
            case 1:
              x = 
              y =
              draw.fillRect(x, y, scale, scale);
              break;
            //botRSquare
            case 2:
              x = 
              y =
              draw.fillRect(x, y, scale, scale);
              break;
            //botLSquare
            case 3:
              x = 
              y =
              draw.fillRect(x, y, scale, scale);
              break;
          }
        }   
      }
      //saving the dimensions of the square to the ArrayList.
      square[5] =  scale;
      squares.set(i, square)
    }
    
  }
  
  
  
  
}
