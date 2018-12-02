package WarmUpA4.src;
import javax.sound.midi.SysexMessage;
import java.util.Random;

public class Cat {
    //Attributes
    private String name;
    private String breed;
    private int age;
    private String mood;

    //Constructor
    public Cat(String name, String breed, int age, String mood) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.mood = mood;
    }

    public String getMood() {
        return this.mood;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setMood(String inputedMood) {
        this.mood = inputedMood;
    }

    public void setAge(String inputedAge) {
        this.breed = inputedAge;
    }

    public void setName(String inputedName) {
        this.name = inputedName;
    }

    public void talk() {
        Random r = new Random();
        String catMood = this.mood;
        if (catMood == "sleepy") {
            System.out.println("meow");
        }
        if (catMood == "hungry") {
            System.out.println("RAWR!");
        }
        if (catMood == "angry") {
            System.out.println("hsssss");
        }
        if (catMood == "happy") {
            System.out.println("purrrr");
        }
        if (catMood == "crazy") {
            for (int i = 0; i < 10; i++) {
                char c = (char) (r.nextInt(26) + 'a');
                System.out.print(c);
            }
        } else {
            System.out.println("This cat has no emotion");
        }
    }

    public static void main(String[] args) {
        Cat c1 = new Cat("Cat1", "breed 1", 1, "mood 1");
        Cat c2 = new Cat("Cat2", "breed 2", 2, "mood 2");
        Cat c3 = new Cat("Cat3", "breed 3", 3, "mood 3");
        Cat c4 = new Cat("Cat4", "breed 4", 4, "mood 4");
        Cat c5 = new Cat("Cat5", "breed 5", 5, "mood 5");
        Cat[] catMoods = new Cat[5];
        catMoods[0] = c1;
        catMoods[1] = c2;
        catMoods[2] = c3;
        catMoods[3] = c4;
        catMoods[4] = c5;
        for (int i = 0; i < catMoods.length; i++) {
            catMoods[i].setMood("sleepy");
            catMoods[i].talk();
        }
    }
}
