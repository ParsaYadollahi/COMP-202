//Name: Parsa Yadollahi
//Student Number: 260869949

public class InputAnalyzer {
    public static void main(String args[]) {
        if(args.length < 3) {
            System.out.println("You need to enter three arguments to this program. Try typing 'run InputAnalyzer 2.5 8 9' in Dr. Java, or 'java InputAnalyzer 2.5 8 9' on the command line.");
            return;
        } 
        double a = getInputDouble(args[0]);
        double b = getInputDouble(args[1]);
        double c = getInputDouble(args[2]);
        
        //========================
        //Enter your code below
        
        //Check if inputs are non negative
        Boolean isPositive = (a >= 0) && (b >= 0) && (c >= 0);
        //Display results
        System.out.println("The numbers " + a + ", " + b + ", and " + c + " are all non-negative: " + isPositive);
        
        //Check if at least one input is odd
        Boolean oneisodd = (a%2 == 1) || (b%2 == 1) || (c%2 == 1);
        //Display results
        System.out.println("At least one between " + a + ", " + b + ", and " + c + " is odd: " + oneisodd);
        
        //Check if inputs are entered in decreasing order
        Boolean decreasingly = (a > b) && (b > c);
        //Display results
        System.out.println("The numbers " + a + ", " + b + ", and " + c + " are in stricly decreasing order: " + decreasingly);
        
        //Check if inputs are all non-negative or decreasing
        Boolean posianddec = isPositive || decreasingly;
        //Display results
        System.out.println("The numbers " + a + ", " +  b + ", and " + c + " are either all non-negative or in a strictly decreasing order: " + posianddec);
        
        //Check if inputs are non-negative or not odd
        Boolean posiandeven = isPositive && ((a%2 == 0) && (b%2 == 0) && (c%2 == 0));
        //Display results
        System.out.println("The numbers " + a + ", " + b + ", and " + c + " are all non-negative numbers and none of them is odd: " + posiandeven);
        
    }
    
    public static double getInputDouble(String arg)
    {
        try {
            return Double.parseDouble(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be a number!");
        }
        
        // Error, return 0
        return 0;
    }
}