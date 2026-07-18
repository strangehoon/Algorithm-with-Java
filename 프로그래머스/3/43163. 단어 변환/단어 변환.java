// 2026/07/18
// 16:30 ~ 

class Solution {
    
    public int answer = Integer.MAX_VALUE;
    public int cnt = 0;
    public void dfs(String begin, String target, String[] words, boolean[] visited){
        
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i] && cal(begin, words[i])){
                visited[i] = true;
                cnt++;
                dfs(words[i], target, words, visited);
                visited[i] = false;
                cnt--;
            }
        }
    }
    
    public boolean cal(String begin, String word){
        
        int cnt = 0; 
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i)!=word.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}