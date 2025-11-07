import java.util.*;
class Solution {
    
    public int[] dx = {1, 0, 0, -1};
    public int[] dy = {0, -1, 1, 0};
    public String answer = "";
    public boolean flag = false;
    
    public void dfs(int x, int y, int r, int c, StringBuilder sb, int n, int m, int k){
        if(flag)
            return;
        
        if(x==r && y==c && k==0){
            answer = sb.toString();
            flag = true;
            return;
        }
        
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(0<=nx && nx<n && 0<=ny && ny<m){
                int dist = Math.abs(nx-r)+Math.abs(ny-c);

                if(k-1>=dist && (k-1-dist)%2==0){
                    String str = "";
                    switch (i){
                        case 0:
                            str = "d";
                            break;
                        case 1:
                            str = "l";
                            break;
                        case 2:
                            str = "r";
                            break;
                        case 3:
                            str = "u";
                            break;
                    }
                    dfs(nx, ny, r, c, sb.append(str), n, m, k-1);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[][] graph = new int[n][m];
        x = x-1;
        y= y-1;
        r = r-1;
        c = c-1;
        
        int dist = Math.abs(x-r)+Math.abs(y-c);
        if(k<dist || (k-dist)%2!=0)
            return "impossible";

        dfs(x, y, r, c, new StringBuilder(), n, m, k);
        
        return answer;
    }
}