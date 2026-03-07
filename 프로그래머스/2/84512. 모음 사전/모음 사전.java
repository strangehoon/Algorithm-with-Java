import java.util.*;
// 2026-03-07
// 15:00 ~ 15:35

class Solution {
    
    char[] chArr = new char[]{'A', 'E', 'I', 'O', 'U'};
    int answer = 0;
    int order = 0;
    
    public void dfs(StringBuilder sb, String word){
            
        if(sb.toString().equals(word)){
            answer = order;
            return;
        }
        
        for(char ch : chArr){
            if(sb.length()<5){
                sb.append(ch);
                order++;
                dfs(sb, word);
                sb.deleteCharAt(sb.length()-1);    
            }
        }
    }
    
    public int solution(String word) {
        
        dfs(new StringBuilder(), word);
        return answer;
    }
}