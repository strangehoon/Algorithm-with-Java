import java.util.*;
// 2026-02-26
// 11:10 ~ 11:30

class Solution {
    
    public int minCnt = 51;
    
    public boolean convertible(String a, String b){
        int len = a.length();
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(a.charAt(i)==b.charAt(i)){
                cnt++;
            }
        }
        if(len-1==cnt){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] visited, int cnt){
        
        if(begin.equals(target)){
            minCnt = Math.min(cnt, minCnt);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i] && convertible(begin, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, visited, cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        dfs(begin, target, words, visited, 0);
        
        if(minCnt==51){
            return 0;
        }
        else{
            return minCnt;
        }
    }
}