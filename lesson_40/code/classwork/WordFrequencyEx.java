package classwork;

import java.util.HashMap;
import java.util.Map;

/// количество повторов слов в строке
public class WordFrequencyEx {

    public static void main(String[] args) {

        String[] words = {"a", "abc", "ab", "limit", "ab", "a", "ab", "limit", "a", "a", "a"};

        printWordFrequency(words);

    }

    private static void printWordFrequency(String[] words) {
// put in a map
        Map<String, Integer> result = new HashMap<>();

        for (String word : words) {
            if (!result.containsKey(word))
                result.put(word, 1);//если первый раз встретилась
            else {
                result.put(word, result.get(word) + 1);// если встретилась еще раз , то увеличиваем частоту на 1
            }

        }
        for (String word : result.keySet()){
            System.out.println("WOrd : "+ word + " , frequency :" + result.get(word));
        }
    }
}
