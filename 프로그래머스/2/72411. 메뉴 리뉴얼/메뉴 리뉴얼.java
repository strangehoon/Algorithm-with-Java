import java.util.*;
// 2026-03-07
// 18:50 ~ 19:50

class Solution {
    
    public void comb(char[] charArr, int course, Map<String, Integer> map, String str, int idx){
        if(str.length()==course){
            map.put(str, map.getOrDefault(str, 0)+1);
            return;
        }
        
        for(int i=idx; i<charArr.length; i++){
            comb(charArr, course, map, str+charArr[i], i+1);
        }
    }
    
    public List<String> solution(String[] orders, int[] courses) {
        
        List<String> answers = new ArrayList<>();
        for(int course : courses){
            Map<String, Integer> map = new HashMap<>();
            for(String order : orders){
                char[] charArr = order.toCharArray();
                Arrays.sort(charArr);
                comb(charArr, course, map, "", 0);
            }
            
            int maxValue = 0;
            List<String> tempList = new ArrayList<>();
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue()>maxValue){
                    maxValue = entry.getValue();
                    tempList.clear();
                    tempList.add(entry.getKey());
                }
                else if(entry.getValue()==maxValue){
                    tempList.add(entry.getKey());
                }
            }
            
            if(maxValue > 1){
                for(String str : tempList){
                    answers.add(str);
                }
            }
        }
        Collections.sort(answers);
        return answers;
    }
}