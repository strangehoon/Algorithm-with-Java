import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<number.length(); i++){
            int num = number.charAt(i)-'0';
            while(!stack.isEmpty() && stack.peek()<num && k!=0){
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        while(k-->0){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int num : stack){
            sb.append(num);
        }
        return sb.toString();
    }
}
