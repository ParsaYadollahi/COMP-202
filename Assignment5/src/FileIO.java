import java.io.*;
import java.util.ArrayList;

public class FileIO {

    public static Character readCharacter(String fileName) {
        //Initialize variables
        String nameOfChar = "";
        double attackValue = 0;
        double maxHealth = 0;
        int currentWins = 0;
        //Create new character
        Character character;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            //Read through all the lines and assign them to their appropriate variable
            nameOfChar = br.readLine();
            attackValue = Double.parseDouble(br.readLine());
            maxHealth = Double.parseDouble((br.readLine()));
            currentWins = Integer.parseInt(br.readLine());
            //Create the new character with data from file
            character = new Character(nameOfChar, attackValue, maxHealth, currentWins);
            //Close buffered and file reader
            br.close();
            fr.close();
            //Catch IO and file not found exceptions
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            //if so return null as answer
            return null;
        } catch (IOException e) {
            System.out.println("Something went Wrong");
            //if so return null as answer
            return null;
        }
        //return new character
        return character;
    }

    public static ArrayList<Spell> readSpells(String fileName) {
        ArrayList<Spell> spells = new ArrayList<Spell>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String spellLine = br.readLine();
            while (spellLine != null) {
                String[] spellParts = spellLine.split("\t");
                String nameOfSpell = spellParts[0];
                double minDamage = Double.parseDouble(spellParts[1]);
                double maxDamage = Double.parseDouble(spellParts[2]);
                double chanceOfSuccess = Double.parseDouble(spellParts[3]);
                // Add the spell to the ArrayList
                spells.add(new Spell(nameOfSpell, minDamage, maxDamage, chanceOfSuccess));
                spellLine = br.readLine();
            }
            br.close();
            fr.close();
            return spells;
        } catch (FileNotFoundException e) {
            System.out.println("Could not find File");
            return null;
        } catch (IOException e) {
            System.out.println("Something went wrong");
            return null;
        }
    }
    public static void writeCharacter(Character character,String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            // Write all the current info of the character in the file (double to String)
            bw.write(character.getName());
            bw.newLine();
            bw.write("" + character.getAttackValue());
            bw.newLine();
            bw.write("" + character.getMaxHealth());
            bw.newLine();
            bw.write("" + character.getNumberWins());
            bw.newLine();

            bw.close();
            fw.close();
            System.out.println("Successfully wrote to file " + fileName);
        } catch (IOException e){ // Catch exceptions
            System.out.println("Something went wrong when writing on the character File");
        }
    }
}
