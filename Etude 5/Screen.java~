import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Screen extends JPanel {
  
  public ArrayList<double[]> squares = new ArrayList<double[]>(); 
  public HashMap<Integer, ArrayList<Square>> drawStack = new HashMap<Integer, ArrayList<Square>>();
  public static double dubScale;
  public static int initialScale;
  public static int scale;
  public static int size;
  public static int layers;
  public static int r;
  public static int g;
  public static int b;
  
  public Screen(ArrayList<double[]> squares, int size) {
    if(squares.size() > 0){
      //work out the size that the first square can be.
      double totalPercent = 0;
      for(int i = 0; i < squares.size(); i++){
        totalPercent += squares.get(i)[0];
      }
      double hypot = Math.sqrt(((size*size) + (size*size)));
      dubScale = hypot/totalPercent;
      //changing the 1% hypot length into the side lengths of the 1% square.
      dubScale = Math.sqrt((dubScale*dubScale)/2);
      //scale is the length and height of a square with 1% scale.
      initialScale = Integer.valueOf((int) Math.round(dubScale));
      scale = initialScale;
      
      this.squares = squares;
      this.size = size;
      repaint();
    }    
  }
  
  public void paint(Graphics draw) { 
    int x = 0;
    int y = 0;
    int set = 0;
    //for each square in the arrayList, draw it on the page.
    r = Integer.valueOf((int) Math.round(squares.get(set)[1]));
    g = Integer.valueOf((int) Math.round(squares.get(set)[2]));
    b = Integer.valueOf((int) Math.round(squares.get(set)[3]));
    draw.setColor(new Color(r, g, b));
    //draw the first square.
    x = ((size/2)-(Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2));
    y = ((size/2)-(Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2));
    draw.fillRect(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), 
                  Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)));
    
    //finding the new dimesions for the next square.
    scale = Integer.valueOf((int) Math.round(initialScale*squares.get(0)[0]));
    
    //starting the recursion for drawing the squares.
    if(squares.size() > 1){
      drawSquares(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), set+1);
      drawStack(draw);
    } 
  }
  
  public void drawSquares(int prevX, int prevY, int prevScale, int set){
    int x;
    int y;
    Square square;
    if(squares.size() > 1){
      for(int i = 0; i < 4; i++){  
        switch(i) {
          //topLSquare
          case 0:
            x = (prevX)-Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2;
            y = (prevY+prevScale)-Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2;
            r = Integer.valueOf((int) Math.round(squares.get(set)[1]));
            g = Integer.valueOf((int) Math.round(squares.get(set)[2]));
            b = Integer.valueOf((int) Math.round(squares.get(set)[3]));
            square = new Square(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), r, g, b);
            if(drawStack.containsKey(set)){
              drawStack.get(set).add(square);
            } else {
              drawStack.put(set, new ArrayList<Square>(Arrays.asList(square)));
              layers++;
            }
            if(squares.size()-1 > set){
              drawSquares(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), set+1);
            }
            break;
            //topRSquare
          case 1:
            x = (prevX+prevScale)-Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2;
            y = (prevY+prevScale)-Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2;
            r = Integer.valueOf((int) Math.round(squares.get(set)[1]));
            g = Integer.valueOf((int) Math.round(squares.get(set)[2]));
            b = Integer.valueOf((int) Math.round(squares.get(set)[3]));
            square = new Square(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), r, g, b);
            if(drawStack.containsKey(set)){
              drawStack.get(set).add(square);
            } else {
              drawStack.put(set, new ArrayList<Square>(Arrays.asList(square)));
              layers++;
            }
            if(squares.size()-1 > set){
              drawSquares(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), set+1);
            }
            break;
            //botRSquare
          case 2:
            x = (prevX+prevScale)-Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2;
            y = (prevY)-Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2;
            r = Integer.valueOf((int) Math.round(squares.get(set)[1]));
            g = Integer.valueOf((int) Math.round(squares.get(set)[2]));
            b = Integer.valueOf((int) Math.round(squares.get(set)[3]));
            square = new Square(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), r, g, b);
            if(drawStack.containsKey(set)){
              drawStack.get(set).add(square);
            } else {
              drawStack.put(set, new ArrayList<Square>(Arrays.asList(square)));
              layers++;
            }
            if(squares.size()-1 > set){
              drawSquares(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), set+1);
            }
            break;
            //botLSquare
          case 3:
            x = (prevX)-Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2;
            y = (prevY)-Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale))/2;
            r = Integer.valueOf((int) Math.round(squares.get(set)[1]));
            g = Integer.valueOf((int) Math.round(squares.get(set)[2]));
            b = Integer.valueOf((int) Math.round(squares.get(set)[3]));
            square = new Square(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), r, g, b);
            if(drawStack.containsKey(set)){
              drawStack.get(set).add(square);
            } else {
              drawStack.put(set, new ArrayList<Square>(Arrays.asList(square)));
              layers++;
            }
            if(squares.size()-1 > set){
              drawSquares(x, y, Integer.valueOf((int) Math.round(squares.get(set)[0]*initialScale)), set+1);
            }
            break;
          default:
            break;
        }
      }
    }
  }
  
  
  //drawing the layers of the quilt
  public void drawStack(Graphics draw){
    int i = 1;
    while(drawStack.containsKey(i)){
      ArrayList layer = drawStack.get(i);
      for(int j = 0; j < layer.size(); j++){
        Square square = (Square)layer.get(j);
        draw.setColor(new Color(square.r, square.g, square.b));
        draw.fillRect(square.x, square.y, square.scale, square.scale);
      }
      i++;
    }
  }
  
}
