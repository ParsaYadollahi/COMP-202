import java.util.ArrayList;
import java.util.Random;

public class Character {
    //Initialize attributes
    private String name;
    private double attackValue;
    private double maxHealth;
    private double currentHeath;
    private int numberWins;
    private static ArrayList<Spell> spells;

    //Constructors
    public Character(String name, double attackValue, double maxHealth, int numberWins) {
        this.name = name;
        this.attackValue = attackValue;
        this.currentHeath = maxHealth;
        this.numberWins = numberWins;
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return this.name;
    }

    //initialize accessors
    public double getAttackValue() {
        return this.attackValue;
    }

    public double getMaxHealth() {
        return this.maxHealth;
    }

    public double getCurrentHeath() {
        return this.currentHeath;
    }

    public int getNumberWins() {
        return this.numberWins;
    }

    public String toString() {
        String currentHeathStr = String.format("%1$.2f", this.currentHeath);
        return this.name + "'s current Health is " + currentHeathStr;
    }

    public double getAttackDamage(int seed) {
        Random gen = new Random(seed);
        double randomNumb = gen.nextDouble() * 0.3;
        while (randomNumb == 0.0) {
            randomNumb = gen.nextDouble() * 0.3;
        }
        double randomValue = 1 - randomNumb;
        double damage = randomValue * this.attackValue;
        return damage;
    }

    public double takeDamage(double damage) {
        this.currentHeath = this.currentHeath - damage;
        return this.currentHeath;
    }

    public void increaseWins() {
        this.numberWins += 1;
    }

    public static void setSpells(ArrayList<Spell> spellsCopy) {
        // Iterate through all elements and add them to the new Arraylist
        spells = new ArrayList<>();
        for (int i = 0; i < spellsCopy.size(); i++) {
            spells.add(spellsCopy.get(i));
        }
    }

    public static void displaySpells(ArrayList<Spell> spells) {
        for (int i = 0; i < spells.size(); i++) {
            System.out.println(spells.get(i));
        }
    }

    public static double castSpell(String spellName, int x) {
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getName().equalsIgnoreCase(spellName)){
                return spells.get(i).getMagicDamage(x);
            }
        }
        return -1.0;
    }
}