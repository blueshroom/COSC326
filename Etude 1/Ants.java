import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Ants {
    
    private static int scenarioTurns;
    private static char defaultType;
    private static HashMap<Character, String[]> scenarioDNA = new HashMap<Character, String[]>();
    private static HashMap<String, Character> plane = new HashMap<String, Character>();
    
    public static void main(String[] args) {
        // Receive input
        Scanner scan = new Scanner(System.in);
        // Input loop
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            //check if line is a comment, start loop again imediatly if line is a comment
            if(line.charAt(0) != '#'){
                //echo the input (not including comments)
                System.out.println(line);
                String[] lineArray = line.split(" ");
                switch (lineArray.length) {
                        //if the array has three elements then increase the array if required
                        //copy exsisting elements to the new array
                        //add the new elements to the new array
                    case 3:
                        if(scenarioDNA.isEmpty()){
                            defaultType = lineArray[0].charAt(0);
                        }
                        scenarioDNA.put(lineArray[0].charAt(0), lineArray);
                        break;
                        
                        //if the scanned line only has one element present
                        //set the number of scenarioTurns and run the simulation
                    case 1:
                        scenarioTurns = Integer.parseInt(line);
                        runSimulation();
                        scenarioDNA.clear();
                        plane.clear();
                        break;
                }
            }
        }
    }
    
    
    public static void runSimulation(){
        // Check line input for line of DNA or number of turns for scenario
        // Remember to ignore lines starting with hashes
        // Input line into scenarioDNA or scenarioTurns
        // If blank line, exit input loop
        int antX = 0;
        int antY = 0;
        // Initialize plane with default value
        int turnsPassed = 0;
        char lastAntDirection = 'N';
        char nextAntDirection = 'N';
        char currentType;
        // While number of turns passed is less than turns for scenario
        // Change current tile based on current state of tile
        // Change ant position based on last ant direction
        // End while loop for number of turns
        while(turnsPassed < scenarioTurns){
            //if the tile the ant is occuping does not exsist yet, create it
            if(!plane.containsKey(antX+","+antY)){
                plane.put(antX+","+antY, defaultType);
            }
            currentType = plane.get(antX+","+antY);
            //find the next direction and tile change based on the current type the ant is occupying
            if(scenarioDNA.get(currentType) != null){
                String[] sequence = scenarioDNA.get(currentType);
                switch(lastAntDirection){
                    case 'N':
                        nextAntDirection = sequence[1].charAt(0);
                        plane.put(antX+","+antY, sequence[2].charAt(0));
                        break;
                        
                    case 'E':
                        nextAntDirection = sequence[1].charAt(1);
                        plane.put(antX+","+antY, sequence[2].charAt(1));
                        break;
                        
                    case 'S':
                        nextAntDirection = sequence[1].charAt(2);
                        plane.put(antX+","+antY, sequence[2].charAt(2));
                        break;
                        
                    case 'W':
                        nextAntDirection = sequence[1].charAt(3);
                        plane.put(antX+","+antY, sequence[2].charAt(3));
                        break;
                }
            }
            //change the current position of the ant
            switch(nextAntDirection){
                case 'N':
                    antY++;
                    lastAntDirection = 'N';
                    break;
                    
                case 'E':
                    antX++;
                    lastAntDirection = 'E';
                    break;
                    
                case 'S':
                    antY--;
                    lastAntDirection = 'S';
                    break;
                    
                case 'W':
                    antX--;
                    lastAntDirection = 'W';
                    break;
            }
            turnsPassed++;
        }
        //print out the result and increment the scenario
        System.out.println("#"+" "+antX+" "+antY);
        System.out.println();
        
        // Loop through scenario DNA and print it out
        // Print out scenario turn
        // Print out final ant position
        // End currentScenario loop
    }
}
