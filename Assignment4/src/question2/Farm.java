package question3;

public class Farm {
    //Initialize Attributes
    private Sheep[] sheep;
    private Dog dog;
    private String name;

    //Constructors
    public Farm(String name, Dog dog, Sheep[] sheep){
        //Name of farm
        this.name = name;
        //Name of dog
        this.dog = dog;
        //Array of  sheep
        this.sheep = new Sheep[sheep.length];
        for(int i = 0; i < sheep.length; i++){
            this.sheep[i] = sheep[i];
        }
        //Conditional Statement if the amount of sheep is larger than the amount a dog can herd
        if (dog.herd() <= sheep.length){
            //Throw exception
            throw new IllegalArgumentException("The maximum number of sheep for this dog is " + dog.herd() + ". Received " + sheep.length + " sheep");
        }
    }
    //Return name
    public String getName(){
        return this.name;
    }
    //Return number of sheeps
    public int getNumSheep(){
        return this.sheep.length;
    }

    //Displays the name of the farm, the name of the dog on
    //the farm, as well as the names and ages of all of the sheep.
    public void printFarm(){
        System.out.println(this.name + dog.getName());
        //Loop for all sheep's name and age
        for(int i = 0; i < sheep.length; i++) {
            System.out.println(sheep[i].getName() + " " + sheep[i].getAge());
        }
    }
    //Calculate how many pounds of wool is sheared
    public double getWool(){
        double woolSheared = 0;
        //Loop going through all sheep
        for(int i = 0; i < sheep.length; i++){
            woolSheared += sheep[i].shear();
        }
        return woolSheared;
    }
}
