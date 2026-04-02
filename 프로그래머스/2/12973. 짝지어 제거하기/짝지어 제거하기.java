import java.util.*;
// 2026-04-02
// 16:45 ~ 16:55

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        }
        else{
            return 0;
        }
    }
}