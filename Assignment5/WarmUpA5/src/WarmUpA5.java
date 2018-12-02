import java.io.*;
import java.util.ArrayList;

public class WarmUpQst1 {
    private ArrayList<String> Lines;
    private String[] allLines;

    public void Doc(ArrayList<String> Lines, String[] allLines) {
        this.Lines = Lines;
        this.allLines = allLines;
    }

    public static ArrayList<String> readFromFile(String fileName) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            //Take first line of the doc
            String currentLine = br.readLine();
            //Set this variable to nothing
            String allLines = "";
            //Loop though entire document
            while (currentLine != null) {
                //Add the current line (first line) to arrayList
                lines.add(currentLine);
                //Add the current line (first line) to variable
                allLines += currentLine + " ";
                //Read the next line
                currentLine = br.readLine();
                //Only call readline two to read all the lines
            }
            //Create an array with all the words in the String alllines
            String[] parts = allLines.split(" ");
            System.out.println("There are " + parts.length + " words in this document");
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        return lines;
    }

    public static void writeOnFile(ArrayList<String> lines, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < lines.size(); i++) {
                bw.write(lines.get(i));
                bw.newLine();
            }
            //Close it in this order
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went Wrong");
        }
    }

    public static void sortFile(ArrayList<String> lines){
        ArrayList <String> orderLines = new ArrayList<String>();
        int lengthOfString = 0;
        for(int k = 0; k < lines.size(); k++) {
            if (lines.get(k).length() > lengthOfString) {
                lengthOfString = lines.get(k).length();
            }
        }
        for(int i = 1; i < lengthOfString; i++) {
            int j = 0;
            while (j < lines.size()) {
                if ((lines.get(j)).length() == i) {
                    orderLines.add(lines.get(j));
                    //lines.remove(j);
                    //j--;
                }
                j++;
            }
        }
        System.out.println(orderLines);
    }
    public static ArrayList<String> numberedArray(ArrayList<String> lines, int x, int y){
        ArrayList<String> pickLines = new ArrayList<>();
        for(int i = 0; i < lines.size(); i++) {
            if (lines.get(i).length() == x) {
                //System.out.println("GOT IN");
                pickLines.add(lines.get(i));
            }
        }
            for(int j = 0; j < lines.size(); j++){
                if(lines.get(j).length() == y){
                    pickLines.add(lines.get(j));
                }
            }
        return pickLines;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> line = readFromFile("./dictionary.txt");
        System.out.println(numberedArray(line, 2, 3));
    }
}
