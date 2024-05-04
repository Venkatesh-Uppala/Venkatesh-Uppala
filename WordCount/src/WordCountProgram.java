import java.util.Map;

public class WordCountProgram {
    public static void main(String[] args) {
        System.out.println("Hello world! Executing WordCount Program");

        if (args.length==0) {

            String defaultString = "This is the program to take a" +
                    " sentence and print count of each word in the given sentence";
            System.out.println("No Arguments are passed to program, So default sentence : "+defaultString+" : is used");
            args = new String[]{defaultString};
        }

        for (String arg : args) {
            wordCountResult(arg);
            System.out.println("----------------- XX ----------------");
        }
    }

    private static void wordCountResult(String arg) {
        FirstProgram wordCount = new FirstProgram();
        Map<String, Integer> counts = wordCount.wordCount(arg);
        if (null != counts && !counts.keySet().isEmpty()) {
            for (String key : counts.keySet()) {
                System.out.println("Count for word : " + key + " " + counts.get(key));
            }
        } else {
            System.out.println("Invalid String Or emptyString is passed");
        }
    }
}
