import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FirstProgram wordCount = new FirstProgram();

        Map<String, Integer> counts = wordCount.wordCount("This is the program to take a" +
                " sentence and print count of each word in the given sentence");
        if (null != counts && !counts.keySet().isEmpty())
            for (String key : counts.keySet()) {
                System.out.println("Count for word : " + key + " " + counts.get(key));
            }
    }
}
