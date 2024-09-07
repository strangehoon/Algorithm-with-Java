// 4:00
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        int cnt = 0;
        for(int i=0; i<10; i++){
            String str = discount[i];
            map.put(str, map.getOrDefault(str, 0)-1);
            if(map.get(str)==0){
                map.remove(str);
            }
        }
        if(map.size()==0)
            cnt++;
        
        for(int i=10; i<discount.length; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0)-1);
            if(map.get(discount[i])==0){
                map.remove(discount[i]);
            }
            
            map.put(discount[i-10], map.getOrDefault(discount[i-10], 0)+1);
            if(map.get(discount[i-10])==0){
                map.remove(discount[i-10]);
            }
            if(map.size()==0)
                cnt++;
        }
        
        return cnt;
    }
}