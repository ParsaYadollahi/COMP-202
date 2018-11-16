package question3;

public class Dog {
    //Attributes
    private String name;
    private String breed;

    //Constructor
    public Dog(String name, String breed){
        this.name  = name;
        this.breed = breed;
    }
    public String getName(){
        return this.name;
    }
    public int herd(){
        String lcbreed = this.breed.toLowerCase();
        if(lcbreed.contains("shepherd")){
            return 25;
        } if(lcbreed.contains("colie")){
            return 20;
        } if(lcbreed.contains("kelpies")) {
            return 30;
        } if(lcbreed.contains("teruvens")){
            return 30;
        }else
            return 10;
    }
    public static void main(String[] args){
        Dog d = new Dog("Parsa", "white shepherd");
        System.out.println(d.herd());
    }
}
