class Solution {

    public int answer;
    
    public void dfs(String begin, String target, boolean[] visited, int cnt, String[] words){
        
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }   
           
        for(int i=0; i<words.length; i++){
            
            if(!visited[i]){
                int sameWordCnt = 0;
                for(int j=0; j<begin.length(); j++){
                    if(begin.charAt(j) == words[i].charAt(j))
                        sameWordCnt++;
                }
                if(sameWordCnt+1==begin.length()){
                    visited[i]=true;
                    dfs(words[i], target, visited, cnt+1, words);
                    visited[i]=false;
                }    
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        answer = Integer.MAX_VALUE;
        dfs(begin, target, visited, 0, words);
        return answer==Integer.MAX_VALUE ? 0 : answer;
    }
}