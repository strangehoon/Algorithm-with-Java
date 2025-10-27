import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        int[] arr = new int[len];
        
        for(int i=0; i<len; i++){
            if((100-progresses[i])%speeds[i]!=0){
                arr[i] = (100-progresses[i])/speeds[i] +1;
            }
            else{
                arr[i] = (100-progresses[i])/speeds[i];
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=len-1; i>=0; i--){
            stack.push(arr[i]);
        }
        
        List<Integer> answer = new LinkedList<>();
        while(!stack.isEmpty()){
            int std = stack.pop();
            int cnt = 1;
            while(!stack.isEmpty() && stack.peek() <=std){
                stack.pop();
                cnt++;
            }
            answer.add(cnt);
        }
        return answer;
    }
}
