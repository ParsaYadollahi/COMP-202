package question3;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;
import java.util.Random;
public class WoolFactory{
    //The provided code generates random ages for sheep, and picks random names from the below array
    //You can modify this list of names as you wish (add/remove/replace elements).
    private static String[] namesForSheep = {"Cerdic","Cynric","Ceawlin","Ceol","Ceolwulf","Cynegils",
            "Cenwalh","Seaxburh","Aescwine","Centwine","Ceadwalla","Ine","Aethelheard","Cuthred","Cynewulf",
            "Berhtric","Egbert","Aethelwulf","Aethelbald","Aethelberht","Aethelred","Hengest","Aesc","Octa",
            "Eormenric","Aethelbert I","Eadbald","Earconbert","Egbert I","Hlothere","Oswine","Wihtred",
            "Aethelbert II","Sigered","Egbert II","Eadberht II","Cuthred","Baldred","Aethelfrith","Edwin","St. Oswald",
            "Oswiu","Ecgfrith","Aldfrith","Osred I","Cenred","Osric","Ceolwulf","Eadberht",
            "Aethelwald","Alhred","Aethelred I","Aelfwald I","Eardwulf","Eanred","George V","Edward VIII",
            "George VI","Elizabeth II"};
    private static Random r = new Random(123);

    //returns a random String from the above array.
    private static String getRandomName(){
        int index = r.nextInt(namesForSheep.length);
        return namesForSheep[index];
    }
    //returns a random age for a sheep from 1 to 10
    private static int getRandomAge(){
        return r.nextInt(10)+1;
    }
    //End of provided name/age generation code.

    public static void main(String[] args){
        //Student Name: Parsa Yadollahi
        //Student Number: 260869949
        //Your code goes here.

        //Scanner asking for the users answer
        Scanner read = new Scanner(System.in);

        //Fetch the name of the farm
        System.out.println("What is the name of of your Farm?");
        String farmName = read.nextLine();

        //Fetch the name of the dog
        System.out.println("What is the name of your dog?");
        String dogName = read.nextLine();

        //Fetch the name of the dog and initialize
        System.out.println(("What kind of dog is " + dogName + " ?"));
        String breedName = read.nextLine();

        //Calculate the number of sheeps
        System.out.println("And how many Sheeps do you have?");
        int numberSheep = read.nextInt();

        //Create new array of length equal to that of the amount of sheep
        Sheep farmSheep[] = new Sheep[numberSheep];

        //Loop to get the name and age of every sheep
        for(int i = 0; i < numberSheep; i++){
            farmSheep[i] = new Sheep(getRandomName(), getRandomAge());
        }

        //Find name and breed of dog
        Dog dog = new Dog(dogName,breedName);

        //Display information of the farm
        Farm farmInfo = new Farm(farmName, dog, farmSheep);

        //Initialize the variable for the number of wooled sheared
        double wooledSheared = 0;

        //Calculate the amount of wool sheared
        for(int i=0;i<farmSheep.length;i++){
            wooledSheared += farmSheep[i].shear();
        }

        //print farm info
        farmInfo.printFarm();

        //Calculate the amount of money raised from the wool
        double priceWool = wooledSheared*1.45;

        //Display results
        System.out.println("We just sheared " + wooledSheared + "lbs of wool for a value of $" + priceWool);
    }
}