import static java.lang.Math.random;
import java.util.Arrays;

public class WarmUpA3 {

  public static void main(String[] args) {
    int n[] = {1, 2, 3,2, -3, 100, -9, 0};
    System.out.println(countNegatives(n));
  }

  //Method that returns a string with half its characters
  public static String getfirstHalf(String s) {
    String halfWord = "";
    for (int i = 0; i < (s.length() / 2); i++) {
      char c = s.charAt(i);
      halfWord += c;
    }
    return halfWord;
  }

  //Method that returns the word where the first letter comes first in the alphabet
  public static String alphaString(String firstWord, String secondWord) {
    for (int i = 0; i <= firstWord.length(); i++) {
      if ((char) firstWord.charAt(i) < (char) secondWord.charAt(i)) {
        return firstWord;
      } else if ((char) firstWord.charAt(i) > (char) secondWord.charAt(i)) {
        return secondWord;
      }
    }
    return firstWord;
  }

  //Method that replaces all the letters in the word by another
  public static String replaceAll(String s, char c, char k) {
    String t = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        t += k;
      } else {
        t += s.charAt(i);
      }
    }
    return t;
  }
  //Method that creates an array of size n with random elements
  public static double[] generateRandomArray(int n) {
    double[] array = new double[n];
    for (int i = 0; i < array.length; i++) {
      array[i] = Math.random() * 5;
    }
    return array;
  }
  //Method that gets the largest elememt of an array
  public static int getLargestElement(int[] n) {
    int max = n[0];
    for (int i = 0; i < n.length; i++) {
      if (n[i] > max) {
        max = n[i];
      }
    }
    return max;
  }

  //Method the sums all the elements in an array
  public static int getSum(int[] n) {
    int sum = 0;
    for (int i = 0; i < n.length; i++) {
      sum += n[i];
    }
    return sum;
  }

  //Method that return the number of negative integers in an array
  public static int countNegatives(int[] n) {
    int negatives = 0;
    for(int i = 0; i <  n.length; i++ ) {
      if (n[i] < 0) {
        negatives++;
      }
    }
    return negatives;
  }
}