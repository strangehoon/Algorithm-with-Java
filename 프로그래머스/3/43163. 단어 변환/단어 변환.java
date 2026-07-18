// 2026/07/18
// 16:30 ~ 16:45

class Solution {
    
    public int answer = Integer.MAX_VALUE;
    public void dfs(String begin, String target, String[] words, boolean[] visited, int cnt){
        
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i] && canChange(begin, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, visited, cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean canChange(String begin, String word){
        
        int cnt = 0; 
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i)!=word.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1){
            return true;
        }
        return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
