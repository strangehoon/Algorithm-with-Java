import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack.push('(');
            }
            else if(ch==')'){
                if(stack.isEmpty()){
                    flag = false;
                }
                else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            flag = false;

        return flag;
    }
}