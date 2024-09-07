import java.util.*;
class Solution {
    public int solution(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int j=i; j<i+s.length(); j++){
                char ch = s.charAt(j%s.length());
                if(ch == '[' || ch == '(' || ch=='{')
                    stack.push(ch);
                else{
                    if(stack.isEmpty()){
                        flag=false;
                        break;
                    }
                    else{
                        char tem = stack.pop();
                        if((tem=='[' && ch==']')||(tem=='(' && ch==')')||(tem=='{' && ch=='}')) 
                            continue;
                        else{
                            flag=false;
                            break;
                        }
                    }
                }
                
            }
            if(stack.isEmpty() && flag==true)
                cnt++;
        }
        return cnt;
    }
}