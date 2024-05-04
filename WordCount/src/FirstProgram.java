import java.util.HashMap;
import java.util.Map;

public class FirstProgram {

    public Map<String, Integer> wordCount(String userInput) {
        Map<String, Integer> dataCount = new HashMap<>();

        if (null != userInput && userInput.length()>1) {
            String[] dataList = userInput.split(" ");
            Integer value;
            for (String data : dataList) {
                value = dataCount.get(data);
                if (null != value) {
                    dataCount.put(data, ++value);
                } else {
                    dataCount.put(data, 1);
                }
            }

        }
        return dataCount;
    }

}