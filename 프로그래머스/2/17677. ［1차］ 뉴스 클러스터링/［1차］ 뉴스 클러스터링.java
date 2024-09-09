// 12:50
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
 
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++){
            String str = str1.substring(i, i+2);
            if(Character.isAlphabetic(str.charAt(0)) && Character.isAlphabetic(str.charAt(1))){
                str = str.toUpperCase();
                map1.put(str, map1.getOrDefault(str, 0)+1);
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            String str = str2.substring(i, i+2);
            if(Character.isAlphabetic(str.charAt(0)) && Character.isAlphabetic(str.charAt(1))){
                str = str.toUpperCase();
                map2.put(str, map2.getOrDefault(str, 0)+1);
            }
        }
        
        // 두 집합 모두 공집합
        if(map1.size()==0 && map2.size()==0)
            return 65536;
        
        // 교집합
        int cnt1 = 0;
        for(String str : map1.keySet()){
            if(map2.containsKey(str))
                cnt1 += Math.min(map1.get(str), map2.get(str));
        }
        
        // 합집합
        int cnt2 = 0;
        HashMap<String, Integer> map3 = new HashMap<>();
        for(String str : map1.keySet()){
            map3.put(str, Math.max(map3.getOrDefault(str, 0), map1.get(str)));
        }
        for(String str : map2.keySet()){
            map3.put(str, Math.max(map3.getOrDefault(str, 0), map2.get(str)));
        }
        for(String str : map3.keySet()){
            cnt2 += map3.get(str);
        }
        double rate = ((double)cnt1/(double)cnt2);
        int answer = (int)(rate*65536);
        return answer;
    }
}