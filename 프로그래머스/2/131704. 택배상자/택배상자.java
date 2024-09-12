// 10:50
import java.util.*;
class Solution {
    public int solution(int[] order) {

        Queue<Integer> orderQ = new LinkedList<>();
        for(int i=0; i<order.length; i++){
            orderQ.offer(order[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int idx = 0;
        int cnt = 0;

        while(num<= order.length && idx<order.length){
            if(num==order[idx]){
                cnt++;
                idx++;
                num++;
            }
            else if(stack.isEmpty() || stack.peek()!= order[idx]){
                stack.push(num);
                num++;
            }
            else if(stack.peek()==order[idx]){
                stack.pop();
                cnt++;
                idx++;
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()==order[idx]){
                cnt++;
                idx++;
                stack.pop();
            }
            else{
                break;
            }
        }
        
        return cnt;
    }
}