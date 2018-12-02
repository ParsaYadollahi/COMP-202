package question3;

public class Dog {
    //Initialize Attributes
    private String name;
    private String breed;

    //Constructor
    public Dog(String name, String breed){
        this.name  = name;
        this.breed = breed;
    }
    //method to return name
    public String getName(){
        return this.name;
    }
    //Method to calculate how many sheeps a dog can herd
    public int herd(){
        String lowerCasecbreed = this.breed.toLowerCase();
        if(lowerCasecbreed.contains("shepherd")){
            return 25;
        } if(lowerCasecbreed.contains("collie")){
            return 20;
        } if(lowerCasecbreed.contains("kelpie")) {
            return 30;
        } if(lowerCasecbreed.contains("teruven")){
            return 30;
        }else
            return 10;
    }
    //class that calculates how many sheep a specific dog can herd
    public static void main(String[] args){
        Dog d = new Dog("Parsa", "white shepherd");
        System.out.println(d.herd());
    }
}
