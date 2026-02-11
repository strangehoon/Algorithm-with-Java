import java.util.*;
// 2026-02-11
// 10:45 ~ 11:00
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<Character>();
        
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                else{
                    stack.pop();
                }
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }
        
        return answer;
    }
}