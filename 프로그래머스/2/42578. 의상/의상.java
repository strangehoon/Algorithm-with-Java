import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clo : clothes){
            map.put(clo[1], map.getOrDefault(clo[1], 0)+1);
        }
        Set<String> set = map.keySet();
        int result = 1;
        for(String x : set){
            result *= (map.get(x)+1);
        }
        return result-1;
    }
}