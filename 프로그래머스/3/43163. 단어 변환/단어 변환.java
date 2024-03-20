class Solution {
    public String begin;
    public String target;
    public String[] words;
    public boolean[] visited;
    public int len;
    public int result = 0;
    
    public void DFS(String str, int cnt){
        if(str.equals(target)){
            if(result==0){
                result = cnt;
            }
            else{
                result = Math.min(result, cnt);
            }
            return;
        }
        
        for(int i=0; i<words.length; i++){
            int flag = 1;
            for(int j=0; j<len; j++){
                if(words[i].charAt(j)!=str.charAt(j)){
                    flag--;
                }
            }
            if(flag == 0 && visited[i]==false){
                visited[i] = true;
                DFS(words[i], cnt+1);
                visited[i] = false;
            }
        }
        
        
    }
    
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        this.len = begin.length();
        this.visited = new boolean[words.length];
        
        DFS(begin, 0);
        return result;
    }
}