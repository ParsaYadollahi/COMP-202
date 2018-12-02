//Student Name: Parsa Yadollahi
//Student ID: 260869949
/*
 * A program that displays a square divided into two triangles.
 * The result is a triangle of " " staring from the left and a triangle of "*"
 * starting from the right. The display is a triangles from the right
 */
public class RightTriangle {
  
  
  public static void main(String[] args) { 
//    Arguments for inputs
    int x = Integer.parseInt(args[0]);
//    Call function to main method
    printRightTriangle(x);
  }
  /*Possible inputs and outputs:
   * 1) positive integers -> a triangle with rows and " " & "*" equal to the input
   * 2) negative integers -> Display "Error: input value must be >=0"
   * 3) input 0 -> display "" (nothing)
   */
  
//  A method that creates a square, divided into 2 triangles
//  First triangle starts with x-1 spaces and second triangle starts with 1 "*"
//  The ending of the square has 1 space and x-1 "*"
  public static void printRightTriangle(int x) {
//    Condition that all inputs must be non-negative
    if (x<0) {
//      Display the result for negative inputs
      System.out.println("Error: input value must be >= 0");
//      Condition for the non-negative entries
    } else {
//      An outter FOR loop that creates an inverted triangle that 
//      stars with x-1 spaces and decreases to 1 space at the last row
      for (int i = 1; i <= x; i++) {
//        An inner FOR loop the spaces creating a left triangle
        for (int j = 1; j <= x-i; j++) {
//        Display results for left triangle
          System.out.print(" ");
        }
//        A FOR loop that adds "*" at the end of the spaces in the previous
//        for loop to create a square or rectangle. This will make it look as if
//        there is a mirrored right hand triangle 
        for (int k = 1; k <= i; k++) {
//          Display results for right triangle
          System.out.print("*");
        }
//        When loop for "k" isnt satisfied, print a new line and start
//        the loop again to increase the number of "*"
        System.out.println();
      }
    }
  }
}