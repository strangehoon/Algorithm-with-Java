import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        int size = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int j = 0;
        int maxLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for(int i=0; i<gems.length; i++){
            String gem = gems[i];
            map.put(gem, map.getOrDefault(gem, 0)+1);
            while(map.size()==size){
                if(i-j+1<maxLen){
                    maxLen = i-j+1;
                    answer[0] = j+1;
                    answer[1] = i+1;
                }
                map.put(gems[j], map.get(gems[j])-1);
                if(map.get(gems[j])==0){
                    map.remove(gems[j]);
                }
                j++;
            }
        }
        return answer;
    }
}