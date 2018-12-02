import java.util.Random;
public class Spell {
    private String name;
    private double minDamage;
    private double maxDamage;
    private double chanceOfSuccess;

    public Spell(String nameOfSpell, double minDamage, double maxDamage, double chanceOfSuccess) {
        this.name = nameOfSpell;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.chanceOfSuccess = chanceOfSuccess;
        if ((minDamage < 0 || minDamage > maxDamage) || (chanceOfSuccess < 0 || chanceOfSuccess > 1)) {
            throw new IllegalArgumentException("bounds not respected");
        }
    }
    public String getName(){
        return this.name;
    }
    public double getMagicDamage(int seed){
        // Initialize variables and create random object
        Random gen = new Random(seed);
        double magicDamage = 0;
        double randomNumber = gen.nextDouble();

        //return 0 damage (fail)
        if(randomNumber > this.chanceOfSuccess){
            return magicDamage;
        } else { // Damage between the max and min damage
            magicDamage = ((randomNumber*(this.maxDamage-this.minDamage)) + minDamage);
            return magicDamage;
        }
    }
    public String toString(){
        return "Name: " +  this.name + " Damage: " + this.minDamage + "-" + this.maxDamage + " Chance: " + 100*this.chanceOfSuccess + "%";
    }
}
