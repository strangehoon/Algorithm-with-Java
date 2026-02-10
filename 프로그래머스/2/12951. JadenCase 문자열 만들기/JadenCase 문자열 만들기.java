import java.util.*;
// 2026-02-10
// 11:25 ~ 11:45
class Solution {
    public String solution(String s) {
        
        int len = s.length();
        
        boolean flag = true;
        String lowerStr = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<len; i++){
            char ch = lowerStr.charAt(i);
            if(flag){
                if(Character.isLowerCase(ch)){
                    sb.append(Character.toUpperCase(ch));
                    flag = false;
                }
                else if(ch == ' '){
                    sb.append(ch);
                }
                else{
                    flag = false;
                    sb.append(ch);
                }
            }
            else{
                if(ch==' '){
                    flag = true;
                }    
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}