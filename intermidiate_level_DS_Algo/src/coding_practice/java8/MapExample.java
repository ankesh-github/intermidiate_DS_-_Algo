package coding_practice.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapExample  {
    public static void main(String [] args){
        Map<String, Integer> map = Map.of(
                "Alice", 30,
                "Bob", 25,
                "Charlie", 35
        );
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " is " + entry.getValue() + " years old.");
        }

        System.out.println(map.keySet());


        Map<String, Integer> sortedMap = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        java.util.LinkedHashMap::new
                ));

        LinkedHashMap<String, Integer> sortedByValue = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new

                ));

        System.out.println("Sorted by value: " + sortedByValue);


    }
}
