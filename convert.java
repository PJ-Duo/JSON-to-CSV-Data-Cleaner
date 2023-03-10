import java.util.Arrays;

public class convert {
    public static void main(String[] args) {


        FileReader myFileReader = new FileReader("data.json");

        String[] data = myFileReader.getStringData(152584);

        String[] content = Arrays.copyOfRange(data, 1, data.length - 1);
        
        System.out.println(Arrays.toString(content));

        for (String line: content) {
            System.out.println(line);
        }

    }
}