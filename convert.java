import java.util.Arrays;
import java.util.ArrayList;

public class convert {
    public static void main(String[] args) {

        FileReader myFileReader = new FileReader("data.json");

        String[] data = myFileReader.getStringData(152584);

        String[] content = Arrays.copyOfRange(data, 1, data.length - 1);

        String[] swearWords = { "fuck", "shit", "damn", "asshole", "bitch" };

     //   System.out.println(Arrays.toString(content));

     ArrayList<String> csv = new ArrayList<>();

        int s = 0;
        for (int i = 0; i < content.length; i++) {
            String temp = content[i].replace(':', ',');
            System.out.println(temp);
            s = 0;
            for (String word : temp.split("\\s+")) { // split string into words
                if (Arrays.asList(swearWords).contains(word.toLowerCase())) {
                    System.out.println("String contains a swear word: " + word);
                    s = 1;
                    break;
                }
            }
            if (s == 0){
                
                csv.add(temp);
            }
        }
        System.out.println(csv);
    }
}