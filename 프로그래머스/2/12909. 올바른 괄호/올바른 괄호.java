import java.util.*;
class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(arr[i]=='('){
                stack.push('(');
            }
            else if(arr[i]==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
                else{
                    stack.push(')');
                }
            }
        }
        if(stack.size()>0){
            answer = false;
        }
        return answer;
    }
}