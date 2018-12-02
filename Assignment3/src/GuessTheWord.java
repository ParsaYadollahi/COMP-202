//Student Name: Parsa Yadollahi
//Student Number: 260869949

// do NOT touch the following import statement
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class GuessTheWord {

    private static final String[] words = {"perfect", "country", "pumpkin", "special", "freedom", "picture", "husband",
            "monster", "seventy", "nothing", "sixteen", "morning", "journey", "history", "amazing", "dolphin", "teacher",
            "forever", "kitchen", "holiday", "welcome", "diamond", "courage", "silence", "someone", "science", "revenge",
            "harmony", "problem", "awesome", "penguin", "youtube", "blanket", "musical", "thirteen", "princess", "assonant",
            "thousand", "language", "chipotle", "business", "favorite", "elephant", "children", "birthday", "mountain",
            "football", "kindness", "abdicate", "treasure", "strength", "together", "memories", "darkness", "sandwich",
            "calendar", "marriage", "building", "function", "squirrel", "tomorrow", "champion", "sentence", "daughter",
            "hospital", "identical", "chocolate", "beautiful", "happiness", "challenge", "celebrate", "adventure",
            "important", "consonant", "dangerous", "irregular", "something", "knowledge", "pollution", "wrestling",
            "pineapple", "adjective", "secretary", "ambulance", "alligator", "congruent", "community", "different",
            "vegetable", "influence", "structure", "invisible", "wonderful", "nutrition", "crocodile", "education",
            "beginning", "everything", "basketball", "weathering", "characters", "literature", "perfection", "volleyball",
            "homecoming", "technology", "maleficent", "watermelon", "appreciate", "relaxation", "abominable", "government",
            "strawberry", "retirement", "television", "silhouette", "friendship", "loneliness", "punishment", "university",
            "confidence", "restaurant", "abstinence", "blackboard", "discipline", "helicopter", "generation", "skateboard",
            "understand", "leadership", "revolution"};

    // this method takes an integer as input and returns a random String from the array above.
    // you can use it, but do NOT modify neither the method NOR the array above.
    public static String getRandomWord(int seed) {
        Random gen = new Random(seed);
        int randomIndex = gen.nextInt(words.length);
        return words[randomIndex];
    }

    //========================
    // Enter your code below

    //A method that returns true if the letter is a lower case, false otherwise
    public static boolean isValidGuess(char c) {
        //Initialize the array with the lowe case letters of the alphabet
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        //For loop to go through each of the elements in the array
        for (int i = 0; i < array.length; i++) {
            //Conditional Statement if the character chosen part of the lower case letter of the alphabet
            if (c == array[i]) {
                //If so, the return true
                return true;
            }
        }
        //If not return false
        return false;
    }

    //A method that returns the number of characters in a string as 0 in an array
    public static int[] generateArrayOfGuesses(String s) {
        //Initialize an new array with null as elements with the length of the string
        int[] n = new int[s.length()];
        //Return the array
        return n;
    }

    //A Method that returns an true if the char is in the String and updates the array
    //to 1 where the corresponding char is located in the string.
    public static boolean checkAndUpdate(String s, int[] guesses, char c) {
        //Create flag so if it enters the if statement then the variable changes to true
        boolean flag = false;
        //For loop to itterate through all elements in the String
        for (int i = 0; i < guesses.length; i++) {
            //If condition to enter if the string at index i matches the character
            if (c == s.charAt(i)) {
                //If entered, update the array at index equal to that of the string
                guesses[i] = 1;
                //Update flage if entered to true
                flag = true;
            }
        }
        //Return true of false
        return flag;
    }

    //A method that capitalizes the last characters guessed if it is part of the word
    public static String getWordToDisplay(String s, int[] guesses, char c) {
       // checkAndUpdate(s, guesses, c);
        //Initialize variables
        String t = "";
        //For loop to check if to add a capital letter or to keep the same letters
        for (int i = 0; i < guesses.length; i++) {
            //Conditional statement if input character matches the character in the String
            if (s.charAt(i) == c) {
                //Increment t in upper Case letter
                t += Character.toUpperCase(c);
                //Else if statement if the index of the array at i is equal to 1
            } else if (guesses[i] == 1) {
                //Increment to add a lower case letter
                t += s.charAt(i);
                //Else statement if input does not match the character or the array at index i is not 1
            } else {
                //Increment adding the symbol "-"
                t = t + "-";
            }
        }
        //Return String
        return t;
    }

    //A method that returns true if all the elements are equal to 1, false otherwise
    public static boolean isWordGuessed(int[] guesses) {
        //Initialize variable
        int total = 0;
        //For loop for the array
        for (int i = 0; i < guesses.length; i++) {
            //If condition if the array at index i is equal to 1, enter
            if (guesses[i] == 1) {
                //Increment the variable
                total += 1;
            }
        }
        //Conditional Statement if the sum of the for loop above adds to the length
        //of the array, then there is as every element in the aray
        if (total == guesses.length) {
            //return answer if true
            return true;
        }
        //If not return false
        return false;
    }

    public static void play(int n) {
        //Initialize variables
        int lives = 10;
        getRandomWord(n);
        int[] array = generateArrayOfGuesses(getRandomWord(n));
        //Display the introduction to the game
        System.out.println("Welcome to Guess The Word!");
        System.out.println("Your secret word has been generated. It has " + getRandomWord(n).length() + " characters. You have 10 lives. Good luck!");

        //Scanner to input the users answers
        Scanner read = new Scanner(System.in);
        //While loop for every character in the string or for every live
        while (lives > 0) {

            //Display number of lives left
            System.out.println("You have " + lives + " left. Please enter a character: ");
            //Initialize the String for the user to input the characters
            String c = read.nextLine();

            //If the users input is greater than one character, no change effected
            //on the number of lives and display an error
            if (c.length() > 1) {
                System.out.println("You can only enter one single character. Try again!");
                //no change to lives
                lives += 0;

                //else if condition if the user inputs a character that does not belong to the english alphabet
            } else if (!isValidGuess(c.charAt(0))) {
                //Display error
                System.out.println("The character must be a lower case letter of the English alphabet. Try again!");
                //No change to lives
                lives += 0;

                //else if condition if the character the user inputs is valid (lower case letter of the english
                // alphabet) but is not correct
            } else if (!checkAndUpdate(getRandomWord(n), array, c.charAt(0))) {
                //Display unchanged result, only with lower case letters or "-"
                System.out.println(getWordToDisplay(getRandomWord(n), array, c.charAt(0)));
                //Decrement lives
                lives--;

                //else if statement if the character the user inputs is valid and correct
            } else if (checkAndUpdate(getRandomWord(n), array, c.charAt(0))) {
                //Display changed result where the character that was input is capitalized
                System.out.println(getWordToDisplay(getRandomWord(n), array, c.charAt(0)));
                //no change to lives
                lives += 0;

                //if condition is the entire word is guesses (Array full of 1s)
            } if (isWordGuessed(array)) {
                //Display congratulation message for finding the word
                System.out.println("Congratulations you guessed the word!");
                System.out.println("The secret word is " + getRandomWord(n));
                //end the program if word is guessed correctly
                break;

                //if condition if lives reaches 0
            } if (lives == 0){
                //Display message that the user has not found the answer and is out of lives
                System.out.println("Too bad, you are out of lives");
                System.out.println("The secret word is " + getRandomWord(n));
                System.out.println(("Better luck next time!"));
            }
        }
        //Print a new line
        System.out.println();
    }

    //A
    public static void main(String[] args) {
        play(1234);
    }
}