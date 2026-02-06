import java.util.*;

class Solution {
    
    public boolean isPalindrome(String str){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{'){
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i)==')'){
                if(stack.isEmpty() || stack.peek()!='('){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if(str.charAt(i)==']'){
                if(stack.isEmpty() || stack.peek()!='['){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else if(str.charAt(i)=='}'){
                if(stack.isEmpty() || stack.peek()!='{'){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
         
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        
        int cnt = 0;
        
        for(int i=0; i<s.length(); i++){
            String newStr = s.substring(i+1, s.length()) + s.substring(0, i+1);
            if(isPalindrome(newStr)){
                cnt++;
            }
        }
        
        return cnt;
    }
}