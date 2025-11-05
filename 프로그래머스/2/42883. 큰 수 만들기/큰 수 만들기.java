import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Stack<Integer> stack = new Stack<>();
        int cnt = k;
        for(int i=0; i<number.length(); i++){
            int num = number.charAt(i)-'0';
            while(!stack.isEmpty() && stack.peek()<num && cnt>0){
                stack.pop();
                cnt--;
            }
            stack.push(num);
        }
        
        while(stack.size()>number.length()-k){
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}