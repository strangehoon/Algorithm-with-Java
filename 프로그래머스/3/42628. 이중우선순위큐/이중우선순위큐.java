import java.util.*;
class Solution {
    
    public int[] solution(String[] operations) {
        int[] answer = {0 ,0};
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();

        for(String str : operations){
            if(str.charAt(0)=='I'){
                String tem = str.substring(2, str.length());
                int num = Integer.valueOf(tem);
                pq.offer(num);
                minusPq.offer(num);
            }
            else if(str.charAt(0)=='D' && str.charAt(2)=='-'){
                if(!minusPq.isEmpty()){
                    int num = minusPq.poll();
                    pq.remove(num);
                }
            }
            else {
                if(!pq.isEmpty()){
                    int num = pq.poll();
                    minusPq.remove(num);
                }
            }
        }
        int max_value = 0;
        int min_value = 0;
        if(!pq.isEmpty()){
            max_value = pq.poll();
            minusPq.remove(max_value);    
        }
        if(!minusPq.isEmpty()){
            min_value = minusPq.poll();
        }
        answer[0] = max_value;
        answer[1] = min_value;
        return answer;
    }
}