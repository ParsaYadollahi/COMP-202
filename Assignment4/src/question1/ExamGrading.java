package question1;

import java.util.Arrays;

public class ExamGrading {

    public static void main(String[] args) {
        char[][] responses = {{'C', 'A', 'B', 'B', 'C', 'A'}, {'A', 'A', 'B', 'B', 'B', 'B'},
        {'C', 'B', 'A', 'B', 'C', 'A'}, {'A', 'B', 'A', 'B', 'B', 'B'}};
        char[] solutions = {'C', 'A', 'B', 'B', 'C', 'C'};
            System.out.println(Arrays.deepToString(findSimilarAnswers(responses,solutions,1)));


    }

    //A method that returns an array of doubles calculating the grade of
    // a student at index depending on their answer
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

    //A method that returns an integer calculating the number of
    // wrong answers that are similar to another student
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

    //A method that returns an integer and compares a student at index with the others and
    //determines the likelihood of cheating (compares the two answers and determines how
    //many characters are the same and are wrong
    public static int numMatches(char[][] responses, char[] solutions, int index, int threshold) {
        //Initialize variable
        int numberOfStudents = 0;
        //for loop iterating through every subArray
        for (int i = 0; i < responses.length; i++) {
            //Conditional statement if the response are not the same
            if (responses[index] != responses[i]) {
                //"Refresh" variable to 0 so the answers don't add up
                int similarAnswers = 0;
                //Initialize variable calculating threshold
                similarAnswers = numWrongSimilar(responses[index], responses[i], solutions);
                //Conditional statement if the threshold is passed
                if (similarAnswers >= threshold) {
                    //increment variable
                    numberOfStudents += 1;
                }
            }
        }
        //return variable
        return numberOfStudents;
    }

    //A method that returns an int[][] where each index represents a student, and each sub-array lists
    //the indices of all students who have similar wrong answers to the student at that index.
    public static int[][] findSimilarAnswers(char[][] responses, char[] solutions, int threshold) {
        //Create new array of length equal to the responses
        int[][] similarAnswers = new int[responses.length][];
        //populate the subArrays
        //For loop itterating through subArrays
        for (int i = 0; i < responses.length; i++) {
            //Populate subArrays with integers
            similarAnswers[i] = new int[numMatches(responses, solutions, i, threshold)];
            //initialize variables
            int l = 0;
            //For loops for elements in subArray
            for(int j = 0; j < responses.length; j++){
                //Cant compare same students
                if(i != j) {
                    //Conditional Statement if the threshold is passed
                    if (numWrongSimilar(responses[i], responses[j], solutions) >= threshold) {
                        //input integer in subArray
                        similarAnswers[i][l] = j;
                        //Increment l
                        l++;
                    }
                }
            }
        }
        //Return value
        return similarAnswers;
    }
}