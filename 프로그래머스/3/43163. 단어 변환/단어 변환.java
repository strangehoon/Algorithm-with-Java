import java.util.*;
class Solution {
    int len;
    boolean[] visited;
    String[] words;
    String target;
    int result = Integer.MAX_VALUE;
    
    public void DFS(String str, int cnt){
        if(str.equals(target)){
            result = Math.min(result, cnt);
        }
        for(int i=0; i<len; i++){
            if(visited[i] ==false && CompareStr(str, words[i])){
                visited[i] = true;
                DFS(words[i], cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean CompareStr(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1)
            return true;
        else
            return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        len = words.length;
        visited = new boolean[len];
        this.words = words;
        this.target = target;
        
        DFS(begin, 0);
        if(result==Integer.MAX_VALUE)
            return 0;
        else
            return result;
    }
}