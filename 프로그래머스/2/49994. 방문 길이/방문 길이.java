class Solution {
    // 동 서 남 북
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(String dirs) {
        int x = 5;
        int y = 5;
        int cnt = 0;
        boolean[][][] visited = new boolean[11][11][4];
        
        for(int i=0; i<dirs.length(); i++){
            char ch = dirs.charAt(i);
            switch (ch){
                case 'U':
                    if(y-1>=0){
                        y += -1;
                        if(!visited[x][y][2]){
                            visited[x][y][2] = true;
                            visited[x][y+1][3] = true;
                            cnt++;
                        }
                    }
                    break;
                case 'L':
                    if(x-1>=0){
                        x += -1;
                        if(!visited[x][y][0]){
                            visited[x][y][0] = true;
                            visited[x+1][y][1] = true;
                            cnt++;
                        }
                    }
                    break;
                case 'R':
                    if(x+1<=10){
                        x += 1;
                        if(!visited[x][y][1]){
                            visited[x][y][1] = true;
                            visited[x-1][y][0] = true;
                            cnt++;
                        }
                    }
                    break;
                case 'D':
                    if(y+1<=10){
                        y += 1;
                        if(!visited[x][y][3]){
                            visited[x][y][3] = true;
                            visited[x][y-1][2] = true;
                            cnt++;
                        }
                    }
                    break;
            } 
        }

        return cnt;
    }
}