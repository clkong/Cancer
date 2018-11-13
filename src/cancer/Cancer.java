/*
 *Sean Luo 11/11/2018
 *Cancer.java
 *This is progrem calculates the Cancer.
 */
package cancer;
import java.io.*;
/**
 *
 * @author clkon
 */
public class Cancer {

    /**
     * @param args the command line arguments
     */
     public static String grid[][];
     public static int blobSize = 0;
    public static boolean cancer;
    public static void main(String[] args)  throws IOException  {
        int row, col;
        grid = new String[12][12];
       for (row = 0; row < 12; row++) {
      for (col = 0; col < 12; col++) {
        grid[row][col] = "+";
      }
    }
        for (int i = 0; i < 70; i++) {
      row = (int) (Math.random() * 10 + 1);
      col = (int) (Math.random() * 10 + 1);
      grid[row][col] = "-";
    }
        displayGrid();
        for (row = 0; row < 12; row++) {
          for (col = 0; col < 12; col++) {
             cancer = false;
              floodFill(row, col);
              if(cancer){
                  blobSize++;
              }
         }
        }
        System.out.println("The file had " + blobSize +
          " cancer spots in it");
        System.out.println("The new one is:");
        displayGrid();
    }
   public static void floodFill(int row, int col) {
        if (grid[row][col].equals("-")) {
            cancer = true;
            grid[row][col] = " ";
            floodFill(row - 1, col - 1);
            floodFill(row - 1, col);
            floodFill(row - 1, col + 1);
            floodFill(row, col - 1);
            floodFill(row, col + 1);
            floodFill(row + 1, col - 1);
            floodFill(row + 1, col);
            floodFill(row + 1, col + 1);
        }
    }
    public static void displayGrid() {
        String output = "";
        for (int row = 0; row < 12; row++) {
          for (int col = 0; col < 12; col++) {
            output += grid[row][col];
          }
          output += "\n";
        }
        System.out.println(output);
    }
}    

