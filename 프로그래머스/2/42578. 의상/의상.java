import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1],0)+1);
        }
        
        int cnt = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            cnt *= (entry.getValue()+1);
        }
        
        return cnt-1;
    }
}