import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        int right = 0;
        int left = 0;
        int max_value = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        while(left<=right){
            if(map.size()<set.size()){
                if(right==gems.length)
                    break;
                String str = gems[right];
                map.put(str, map.getOrDefault(str,0)+1);
                right++;
            }
            else{
                if(right-left<max_value){
                    max_value = right-left;
                    answer[0] = left+1;
                    answer[1] = right;
                }
                String str = gems[left];
                map.put(str, map.get(str)-1);
                if(map.get(str)==0){
                    map.remove(str);
                }
                left++;
            }
        }
        if(map.size()==set.size()){
            if(answer[0]==0 && answer[1]==0){
                answer[0] = left+1;
                answer[1] = gems.length;    
            }
        }
        return answer;
    }
}