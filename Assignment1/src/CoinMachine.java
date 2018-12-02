//Name: Parsa Yadollahi
//Student Number: 260869949

public class CoinMachine {
    
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("You need to enter two arguments to this program. Try typing 'run CoinMachine 400 215' in Dr. Java, or 'java VendingMachine 400 215' on the command line.");
            return;
        } 
        int cash = getInputInteger(args[0]);
        int price = getInputInteger(args[1]);

        //Calculate difference
        int cashReturned = cash - price;
        //Display Result
        System.out.println("Amount received:    " + cash);
        System.out.println("Cost of the item:   " + price);
        System.out.println("Required change:    " + cashReturned);
        
        //Calculate amount of Twoonies and amount remaining
        int twoonies = cashReturned/200;
        int remainaing = cashReturned%200;

        //Calculate amount of Loonies and amount remaining
        int loonies = remainaing/100;
        remainaing = remainaing%100;
        
        //Calculate amount of Quarters and amount remaining
        int quarter = remainaing/25;
        remainaing = remainaing%25;
        
        //Calculate amount of Dimes and amount remaining
        int dime = remainaing/10;
        remainaing = remainaing%10;

        //Calculate amount of Nickels
        int nickel = remainaing/5;
        
        //Display results
        System.out.println(" ");
        System.out.println("Change: ");
        System.out.println("    twoonies x " + twoonies);
        System.out.println("    loonie x " + loonies);
        System.out.println("    quarter x " + quarter);
        System.out.println("    dime x " + dime);
        System.out.println("    nickel x " + nickel);
    }
    
    public static int getInputInteger(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be an integer!");
        }
        
        // Error, return 0
        return 0;
    }
}