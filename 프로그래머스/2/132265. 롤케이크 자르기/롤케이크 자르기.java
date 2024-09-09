// 11:40
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<topping.length; i++){
            map.put(topping[i], map.getOrDefault(topping[i], 0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int i=0; i<topping.length; i++){
            Integer num = topping[i];
            map.put(num, map.get(num)-1);
            if(map.get(num)==0){
                map.remove(num);
            }
            set.add(num);
            if(set.size()==map.size())
                cnt++;
        }
        
        return cnt;
    }
}