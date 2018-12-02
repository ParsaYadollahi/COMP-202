package question3;
import  java.util.Random;

public class Sheep {
    //Initialize Attributes
    private String name;
    private int age;
    private boolean hasWool;
    private static Random numberGenerator = new Random(123);

    //Build Constructors
    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
        this.hasWool = true;
    }
    //Constructor
    public String getName(){
        return this.name;
    }
    //Constructor
    public int getAge(){
        return this.age;
    }
    //Constructor
    public double shear(){
        //Initialize variables
        double woolPds = 0;
        double max = 10;
        double min = 6;
        //Shear the sheeps wool
        if (hasWool){
            woolPds = (min + (max-min)*numberGenerator.nextDouble());
            hasWool = false;
        } else {
            woolPds = 0;
        }
        //Return that the sheep can no longer be sheared
        return woolPds;
    }
    public static void main(String[] args){
        Sheep s = new Sheep("Parsa", 10);
        System.out.println(s.shear());
    }
}
