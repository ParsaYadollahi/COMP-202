package question1;

import java.util.Arrays;

public class ExamGrading {

    public static void main(String[] args) {
        char[][] responses = {{'A', 'B', 'C', 'D', 'B', 'A'}, {'C', 'B', 'D', 'D', 'B', 'B'}, {'C', 'B', 'D', 'D', 'C', 'C'}};
        char[] solutions = {'C', 'B', 'C', 'D', 'A', 'A'};
        System.out.println(numMatches(responses, solutions, 1, 2));
    }

    public static double[] gradeAllStudents(char[][] responses, char[] solutions) {
        double[] gradeAllStudents = new double[responses.length];
        //Iterate through all subArrays
        for (int i = 0; i < responses.length; i++) {
            //throw exception if the student answer to many or too little
            if (responses[i].length != solutions.length) {
                throw new IllegalArgumentException("Student number " + i + " gave " + responses[i].length + " answers while " + solutions.length + " were required");
            }
            double studentGrade = 0;
            double sumGrade = 0;
            //Iterate through all elements of the subArray
            for (int j = 0; j < responses[i].length; j++) {
                //Conditional statement if the element of the subArray is the same as the element of the solution
                if (responses[i][j] == solutions[j]) {
                    //Increment the grade
                    sumGrade += 1;
                    //Else statement the answer is incorrect
                } else sumGrade += 0;
            }
            //Calculate the students grade
            studentGrade = 100 * (sumGrade / responses[i].length);
            //Display the appropriate students grade
            gradeAllStudents[i] = studentGrade;
        }
        //return grades
        return gradeAllStudents;
    }

    //A method that calculate the number of wrong answers that are similar to another student
    public static int numWrongSimilar(char[] responseOne, char[] responseTwo, char[] solutions) {
        //Initialize variable
        int cheatedNumbers = 0;
        //For loop iterating through all the elements of the array
        for (int i = 0; i < solutions.length; i++) {
            //Conditional Statement if the element of the array 1 and 2 are the same
            // and if the the elements do not equal that of the solution
            if (responseOne[i] == responseTwo[i] && (responseOne[i] != solutions[i])) {
                //Increment variable
                cheatedNumbers += 1;
            } else cheatedNumbers += 0;
        }
        //Return variable integer
        return cheatedNumbers;
    }

    public static int numMatches(char[][] responses, char[] solutions, int index, int threshold) {
        int numberOfStudents = 0;
        for (int i = 0; i < responses.length; i++) {
            if (responses[index] != responses[i]) {
                int similarAnswers = 0;
                similarAnswers = numWrongSimilar(responses[index], responses[i], solutions);
                if (similarAnswers >= threshold) {
                    numberOfStudents += 1;
                }
            }
        }
        return numberOfStudents;
    }

    public static int[][] findSimilarAnswers(char[][] responses, char[] solutions, int threshold) {
        int[][] similarAnswers = new int[responses.length][];
        for(int i = 0; i < responses.length; i++){
            similarAnswers[i] = new int[numMatches(responses, solutions, i, threshold)];
        }
    }
}
