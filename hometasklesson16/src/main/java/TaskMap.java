import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskMap {

    public static void main(String[] args) {

//        Task 1

        List<String> string = new ArrayList<>(List.of("a","b","c","d","a","d"));
        int size = string.size();

        Map<String, Boolean> stringMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String key = string.get(i);
            Boolean value = false;

            if (stringMap.containsKey(key)){
                continue;
            }

            for (int j = i + 1; j < size; j++) {

                if (string.get(j).equals(key)){
                    value = true;
                }
            }

            stringMap.put(key,value);

        }
        System.out.println(stringMap);

//        Task 2

        List<String> words = new ArrayList<>(List.of("moon","dog","cat"));
        int wordssize = words.size();

        Map<String,String> wordsMap = new HashMap<>();

        for (int i = 0; i < wordssize; i++) {

            String word = words.get(i);
            String key = word.substring(0, 1);
            String value = word.substring(word.length() - 1);
            wordsMap.put(key, value);

        }
        System.out.println(wordsMap);

    }
}
