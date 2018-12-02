//Student Name: Parsa Yadollahi
//Student ID: 260869949

//A program that detects birds by their physical traits
public class Classifier {
  
  public static void main(String[] args) {
    
//    Declare the inputs
//    Birds BeackSize in mm
    int BEAK_MM = Integer.parseInt(args[0]);
//    Birds ClawSize in mm
    int CLAW_MM = Integer.parseInt(args[1]);
//    Birds feathercolor
    String COLOR = args[2];
//    Initialize booleans
    boolean typeA = isTypeA(BEAK_MM,CLAW_MM,COLOR);
    boolean typeB = isTypeB(BEAK_MM,CLAW_MM,COLOR);
    boolean typeC = isTypeC(BEAK_MM,CLAW_MM,COLOR);
//    Display Results
//    TTT
    if (typeA && typeB && typeC) {
      System.out.println("The type of bird is A B C."); 
    }
//    TTF
    if (typeA && typeB && !typeC) {
      System.out.println ("The type of bird is A B.");
    }
//   TFF 
    if (typeA && !typeB && !typeC) {
      System.out.println ("The type of bird is A."); 
    }
//   FFF
    if (!typeA && !typeB && !typeC) {
      System.out.println ("This bird is not part of the study.");
    }
//   FFT
    if (!typeA && !typeB && typeC) {
      System.out.println ("The type of bird is C."); 
    }
//  FTT 
    if (!typeA && typeB && typeC) {
      System.out.println ("The type of bird is B C."); 
    }
//  FTF 
    if (!typeA && typeB && !typeC) {
      System.out.println ("The type of bird is B."); 
    }
//  TFT
    if (typeA && !typeB && typeC) {
      System.out.println("The type of bird is A C.");
    }
  }
  
  /* Possible Inputs & outputs:
   * 1)1 0 Grey: TYPE A
   * 2)2 1 Grey: TYPE A
   * 3)3 2 Grey: TYPE A
   * 4)4 3 Grey: TYPE A
   * 5)4 4 Grey: TYPE A B
   * 6)5 4 Grey: TYPE A
   * 7)4 4 Grey: TYPE A B
   * 8)4 5 Grey: TYPE B
   * 9)5 6 Grey: TYPE B
   * 10)5 7 Grey: TYPE B
   * 11)5 6 Blue: TYPE B C
   * 12)5 7 Blue: TYPE B C
   * 13)6 8 Blue: TYPE B
   * 14)6 9 Blue: TYPE B
   * 15)7 10 Blue: TYPE B
   * 16)8 11 Blue: TYPE B
   * 17)5 6 Blue: TYPE C
   * 18)5 7 Blue: TYPE C
   * 19)5 6 Green: TYPE C
   * 20)5 7 Green: TYPE C
   * 21)6 8 Green: TYPE C
   * 22)6 9 Green: TYPE C
   * 23)7 10 Green: TYPE C
   * 24)8 11 Green: TYPE C
   * 25)9 12 Green: TYPE C
   * 26)Any other input: "This bird is not part of the study 
   */
  
//    A method that takes three inputs: args[0,1,2] and
//    returns whether the bird is of TYPE A or not depending on the criterias of the table
  public static boolean isTypeA(int BEAK_MM, int CLAW_MM, String COLOR) {
//    Return True or False to the main method
//    Criterias for birds in TYPE A
    return ((BEAK_MM == 1) && (CLAW_MM == 0) && "Grey".equals(COLOR)) ||
      ((BEAK_MM == 2) && (CLAW_MM == 1) && "Grey".equals(COLOR)) || 
      ((BEAK_MM == 3) && (CLAW_MM == 2) && "Grey".equals(COLOR)) ||
      ((BEAK_MM == 4) && (CLAW_MM == 3) && "Grey".equals(COLOR)) || 
      ((BEAK_MM == 4 || BEAK_MM == 5) && (CLAW_MM == 4) && "Grey".equals(COLOR));
  }
  
//    A String method that takes tree inputs: args[0,1,2] and returns whether or not the 
//    bird is of TYPE B or not depending on the criterias of the table
  public static boolean isTypeB(int BEAK_MM, int CLAW_MM, String COLOR) {
//    Return True or False to the main method
//    Criterias for birds in TYPE B
    return (((BEAK_MM == 4) && ((CLAW_MM == 4) || (CLAW_MM == 5)) && "Grey".equals(COLOR))|| 
            ((BEAK_MM == 5) && ((CLAW_MM == 6) || (CLAW_MM == 7)) && ("Grey".equals(COLOR) || "Blue".equals(COLOR)))|| 
            ((BEAK_MM == 6) && ((CLAW_MM == 8) || (CLAW_MM == 9)) && "Blue".equals(COLOR)) ||
            ((BEAK_MM == 7) && (CLAW_MM == 10) && "Blue".equals(COLOR)) ||
            ((BEAK_MM == 8) && (CLAW_MM == 11) && "Blue".equals(COLOR)));
  }
  
//    A String method that takes three inputs:args[0,1,2] and returns whether or not the bird is 
//    of TYPE C or not depending on the criterias of the table
  public static boolean isTypeC(int BEAK_MM, int CLAW_MM, String COLOR) {
//    Return True or False to the main method
//    Criterias for the birds in TYPE C
    return (((BEAK_MM==5) && ((CLAW_MM == 6) || (CLAW_MM == 7)) && ("Blue".equals(COLOR) || "Green".equals(COLOR))) ||
            ((BEAK_MM==6) && ((CLAW_MM == 8) || (CLAW_MM == 9)) && "Green".equals(COLOR)) ||
            ((BEAK_MM==7) && (CLAW_MM==10) && "Green".equals(COLOR)) || 
            ((BEAK_MM==8) && (CLAW_MM==11) && "Green".equals(COLOR)) ||
            ((BEAK_MM==9) && (CLAW_MM==12) && "Green".equals(COLOR)));
  }
}


