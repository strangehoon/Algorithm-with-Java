// 11:00
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        String pre = words[0];
        set.add(pre);
        int[] result = new int[2];
        
        for(int i=1; i<words.length; i++){
            String now = words[i];
            if(pre.charAt(pre.length()-1)==now.charAt(0) && !set.contains(now)){
                set.add(now);
                pre = now;
            }
            else{
                result[0] = i%n+1;
                result[1] = i/n +1;
                break;
            }
        }

        return result;
    }
}