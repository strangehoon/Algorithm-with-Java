import java.util.*;
class Solution {
    // 3:02-11   20-
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, String> graph = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();
        idxMap.put("-", -1);
        
        for(int i=0, len=enroll.length; i<len; i++){
            idxMap.put(enroll[i], i);
            graph.put(enroll[i], referral[i]);
        }

        
        int[] answers = new int[enroll.length];
        for(int i=0,len=seller.length; i<len; i++){
            String name = seller[i];
            int money = amount[i]*100;
            int idx = idxMap.get(name);
            int rest = (int)(money*0.1);
            while(!name.equals("-")){
                answers[idx] += (money-rest);
                name = graph.get(name);
                money = rest;
                if(money<1)
                    break;
                idx = idxMap.get(name);
                rest = (int)(money*0.1);
            }
        }

        return answers;
    }
}