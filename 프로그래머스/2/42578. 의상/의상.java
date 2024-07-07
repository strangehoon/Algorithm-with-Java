import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = clothes.length;
        for(int i=0; i<len; i++){
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        Set<String> keySet = map.keySet();
        int result = 1;
        for(String str : keySet){
            result *= (map.get(str)+1);
        }
        result -= 1;
        return result;
    }
}