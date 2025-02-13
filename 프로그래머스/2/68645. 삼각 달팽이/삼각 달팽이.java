class Solution {
    public int[] solution(int n) {
    
        int[][] graph = new int[n][n];
        int num = 1;
        int[] nx = {1, 0, -1};
        int[] ny = {0, 1, -1};
        int x = -1;
        int y = 0;
        int idx = 0;
        int p = n;
        while(p>0){
            int q = p;
            while(q-->0){
                x += nx[idx%3];
                y += ny[idx%3];
                graph[x][y] = num++;
            }
            idx++;
            p--;
        }
        
        int[] answers = new int[num-1];
        int jdx = 0;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                answers[jdx++] = graph[i-1][j];
            }
        }
        return answers;
    }
}