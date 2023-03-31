import java.util.Arrays;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.util.ArrayList;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;

public class convert {
    public static void main(String[] args) {

        FileReader myFileReader = new FileReader("data.json");

        String[] data = myFileReader.getStringData(152584);

        String[] content = Arrays.copyOfRange(data, 1, data.length - 1);

        String[] swearWords = { "fuck", "shit", "damn", "asshole", "bitch", "nigger", "nigga", "@", "<", "https",
                "http" };

        // System.out.println(Arrays.toString(content));

        ArrayList<String> csv = new ArrayList<>();

        int s = 0;
        for (int i = 0; i < content.length; i++) {
            String temp = content[i].replace("\": \"", "\",\"");
           // int index = content[i].indexOf("\": \"");

            // System.out.println(temp);
            s = 0;
            for (String word : temp.split("\\s+")) { // split string into words
                if (Arrays.asList(swearWords).contains(word.toLowerCase())) {
                    // System.out.println("String contains a swear word: " + word);
                    s = 1;
                    break;
                }
            }
            if (s == 0) {

                csv.add(temp);
            }
        }

        try {
            File myObj = new File(".//out.csv");

            if (myObj.createNewFile()) {

                System.out.println("File created: " + myObj.getName());

                FileWriter myWriter = new FileWriter(".//out.csv");
                // myWriter.write("msg, reply\\n");
                String[] sp = { "https", "<", ">", "@", "\\","//","{","}"};
                boolean dontWrite = false;
                for (int counter = 0; counter < csv.size(); counter++) {
                    dontWrite = false;
                    String myString = csv.get(counter);
                    String input = myString.substring(0, myString.length() - 1);

                    // String output = input.replaceAll("\"([^\"]*)\"",
                    // "$1".replaceAll("[^\\p{ASCII}\\p{L}\\p{N}\\p{P}\\s]+", ""));
                    String output = input.replace(':', ',').trim();
                    // if (output.contains("https") == false && output.contains("<") == false
                    // && output.contains("\\") == false && output.contains("{") == false) {

                    // }

                    for (int i = 0; i < sp.length; i++) {
                        if (output.contains(sp[i]) == true) {
                            dontWrite = true;
                            System.out.println(output);
                            break;
                        }
                    }

                    if (dontWrite != true) {
                        myWriter.write(output + "\n");
                    }
                    

                }

                myWriter.close();

            } else {

                System.out.println("File already exists.");

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // System.out.println(csv);
    }
}