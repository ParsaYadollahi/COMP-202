//Student Name: Parsa Yadollahi
//Student ID: 260869949
/*
 * A program that displays a triangle with entries rows equal 
 * to the input and "*" equal to the inputs starting from the left
 */
public class LeftTriangle {
  
  
  public static void main(String[] args) { 
//    Argument for the inputs
    int x = Integer.parseInt(args[0]);
//    Call function to main method
    printLeftTriangle(x);
  }
  
   /*Possible inputs:
   * 1) x = 0 => "" (nothing)
   * 2) x = any positive integer = triangle with x rows and x "*"
   * 3) x = any negative integer = Error: input value must be >=0
   */
//  A method that takes the argument as input and draws a right triangle
//  of height equal to the argument starting from the right and ending in the left
  public static void printLeftTriangle(int x) {
//    Condition if statement that the argument must be a non-negative integer
    if (x<0.0) {
//    Display results for negative inputs
      System.out.println("Error: input value must be >= 0");
//    Condition else statement for the non-negative inputs
    } else {
//      A FOR loop that prints a right triangle
      for (int i = 1; i <= x; i++) {
//      Prints "*" equal to the level of rows we're at
        for (int j = 1; j <= i; j++) {
//      Display result for positive inputs (triangle)
          System.out.print("*");
        }
//        When loop for "j" is not satisfied, print a new line and start
//        the loop again to increase the number of "*"
        System.out.println();
      }
    }
  }
}
