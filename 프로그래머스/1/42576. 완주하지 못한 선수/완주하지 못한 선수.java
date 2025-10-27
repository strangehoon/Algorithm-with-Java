import java.util.*;
class Solution {

    public String solution(String[] participants, String[] completions) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String participant : participants){
            map.put(participant, map.getOrDefault(participant, 0)+1);
        }
        
        for(String completion : completions){
            map.put(completion, map.get(completion)-1);
            if(map.get(completion)==0)
                map.remove(completion);
        }
        
        String answer = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            answer = entry.getKey();
        }
        return answer;
    }
}