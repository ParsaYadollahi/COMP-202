import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleGame {
    private static Random random = new Random();

    public static void main(String[] args) {
        BattleGame.playGame("player.txt", "monster.txt", "spells.txt");
    }

    //Helper method to print character Data
    public static void printData(String fileNameC, String fileNameM) {
        Character character = (FileIO.readCharacter(fileNameC));
        Character monster = (FileIO.readCharacter(fileNameM));
        if (character == null || monster == null) {
            System.out.println("The game cannot be played");
            return;
        }
        System.out.println("Name: " + character.getName());
        System.out.println("Health: " + character.getCurrentHeath());
        System.out.println("Attack: " + character.getAttackValue());
        System.out.println("Number of Wins: " + character.getNumberWins());
        System.out.println();
        System.out.println("Name: " + monster.getName());
        System.out.println("Health: " + monster.getCurrentHeath());
        System.out.println("Attack: " + monster.getAttackValue());
        System.out.println("Number of Wins: " + monster.getNumberWins());
        System.out.println();
    }

    public static void playGame(String fileNameC, String fileNameM, String fileNameSpell) {
        ArrayList<Spell> spell = FileIO.readSpells(fileNameSpell);
        if (spell == null) {
            System.out.println("The game will be played without spells:");
            //Print characters data
            printData(fileNameC, fileNameM);
            System.out.println();

        } else {
            //Print characters data
            printData(fileNameC, fileNameM);

            Character.setSpells(spell);
            System.out.println("Here are the available spells:");
            Character.displaySpells(spell);
            System.out.println();
        }

        //Create new characters from the files
        Character character = (FileIO.readCharacter(fileNameC));
        Character monster = (FileIO.readCharacter(fileNameM));


        //Create new Scanner object
        Scanner read = new Scanner(System.in);
        String command;
        String quit = "quit";
        String attack = "attack";

        while (true) {
            System.out.println("Enter a command");
            command = read.nextLine();

            if (command.equalsIgnoreCase(attack)) {
                double damageCharacter = character.getAttackDamage(random.nextInt());
                //format to get 2 decimal numbers
                String damageStr = String.format("%1$.2f", damageCharacter);
                //Display how much damage the play did
                System.out.println(character.getName() + " attacks for " + damageStr + " damage!");
                //monster takes the input damage
                monster.takeDamage(damageCharacter);
                //Conditional statement if the monster gets knocked out
                if (monster.getCurrentHeath() <= 0) {
                    //Display the winner and increment his wins
                    System.out.println("The monster was knocked out");
                    System.out.println("Congrats! " + character.getName() + " won");
                    character.increaseWins();
                    FileIO.writeCharacter(character, fileNameC);
                    System.out.println(character.getName() + " has won: " + character.getNumberWins() + " times");
                    return;
                }
                //Display monsters current data
                System.out.println(monster.toString());
                System.out.println();

                //fetch damage that monster does
                double damageMonster = monster.getAttackDamage(random.nextInt());
                //Format to get 2 decimal
                damageStr = String.format("%1$.2f", damageMonster);

                //Display how much damage the monster did
                System.out.println(monster.getName() + " attacks for " + damageStr + " damage!");

                //Character takes the input damage
                character.takeDamage(damageMonster);

                //Conditional statement if the character gets knocked out
                if (character.getCurrentHeath() <= 0) {
                    //Display the winner and increment his wins
                    System.out.println(character.getName() + "was knocked out");
                    System.out.println("Oh no! You lost");
                    monster.increaseWins();
                    FileIO.writeCharacter(monster, fileNameM);
                    System.out.println(monster.getName() + " has won: " + monster.getNumberWins() + " times");
                    return;
                }
                //Display the characters current data
                System.out.println(character.toString());
                System.out.println();
            } else if (command.equalsIgnoreCase(quit)) { //The user inputs quit command
                System.out.println();
                System.out.println("GoodBye!");
                return; //Stop the program
            } else { //Invalid command (spell)
                double damageCharacter = Character.castSpell(command, random.nextInt());
                if(damageCharacter <= 0){
                    String damageStr = String.format("%1$.2f", damageCharacter);
                    System.out.println(character.getName() + " tried to cast" + command + ", but they failed");
                    System.out.println();
                    double damageMonster = monster.getAttackDamage(random.nextInt());
                    //Format to get 2 decimal
                    damageStr = String.format("%1$.2f", damageMonster);

                    //Display how much damage the monster did
                    System.out.println(monster.getName() + " attacks for " + damageStr + " damage!");

                    //Character takes the input damage
                    character.takeDamage(damageMonster);
                    //Conditional statement if the character gets knocked out
                    if (character.getCurrentHeath() <= 0) {
                        //Display the winner and increment his wins
                        System.out.println();
                        System.out.println("The player was knocked out");
                        System.out.println("Congrats! " + monster.getName() + " won");
                        monster.increaseWins();
                        FileIO.writeCharacter(monster, fileNameM);
                        System.out.println(monster.getName() + " has won: " + monster.getNumberWins() + " times");
                        return;
                    }
                    //Display the characters current data
                    System.out.println(character.toString());
                    System.out.println();
                  } else {
                    String damageStr = String.format("%1$.2f", damageCharacter);
                    System.out.println(character.getName() + " casts " + command + " dealing " + damageStr + " damage!");
                    monster.takeDamage(damageCharacter);
                    if (monster.getCurrentHeath() <= 0) {
                        //Display the winner and increment his wins
                        System.out.println("The monster was knocked out");
                        System.out.println("Congrats! " + character.getName() + " won");
                        character.increaseWins();
                        FileIO.writeCharacter(character, fileNameC);
                        System.out.println(character.getName() + " has won: " + character.getNumberWins() + " times");
                        return;
                    }
                    //Display monsters current data
                    System.out.println(monster.toString());
                    System.out.println();


                    //fetch damage that monster does
                    double damageMonster = monster.getAttackDamage(random.nextInt());
                    //Format to get 2 decimal
                    damageStr = String.format("%1$.2f", damageMonster);

                    //Display how much damage the monster did
                    System.out.println(monster.getName() + " attacks for " + damageStr + " damage!");

                    //Character takes the input damage
                    character.takeDamage(damageMonster);
                    //Conditional statement if the character gets knocked out
                    if (character.getCurrentHeath() <= 0) {
                        //Display the winner and increment his wins
                        System.out.println();
                        System.out.println("The player was knocked out");
                        System.out.println("Congrats! " + monster.getName() + " won");
                        monster.increaseWins();
                        FileIO.writeCharacter(monster, fileNameM);
                        System.out.println(monster.getName() + " has won: " + monster.getNumberWins() + " times");
                        return;
                    }
                    //Display the characters current data
                    System.out.println(character.toString());
                    System.out.println();
                }
            }
        }
    }
}
