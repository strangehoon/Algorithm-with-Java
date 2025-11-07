import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        prices[prices.length-1] = 0;
        
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            int price = prices[i];
            while(!stack.isEmpty() && stack.peek()[1]>price){
                int[] tmp = stack.pop();
                answer[tmp[0]] = i-tmp[0];
            }
            stack.push(new int[]{i, price});
        }
        return answer;
    }
}