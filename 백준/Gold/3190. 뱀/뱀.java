import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static class Dir{
        int x;
        char c;
        public Dir(int x, char c){
            this.x = x;
            this.c = c;
        }
    }

    public static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            graph[x][y]=1;
        }
        int L = Integer.parseInt(br.readLine());
        Dir[] dirs = new Dir[L];
        for(int i=0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            dirs[i] = new Dir(x, str.charAt(0));
        }
        List<Pos> posList = new ArrayList<>();
        posList.add(new Pos(0, 0));
        int dirI = 0;
        int i = 0;
        int time = 1;
        int x = 0;
        int y = 0;
        int tailCnt = 0;
        boolean flag = true;
        while (true){
            int dirTime = dirs[dirI].x;
            char dirChar = dirs[dirI].c;
            x += dx[i];
            y += dy[i];
            posList.add(0, new Pos(x, y));
            // 방향 바꾸기
            if(time==dirTime){
                if(dirChar=='D'){
                    i = (i+4+1)%4;
                } else if (dirChar=='L') {
                    i = (i+4-1)%4;
                }
                if(dirI<dirs.length-1){
                    dirI++;
                }
            }
            // 벽에 부딪히면 끝
            if(x<0 || x>=N || y<0 || y>=N){
                bw.write(String.valueOf(time));
                break;
            }
            // 꼬리 잡히면 끝
            for(int j=1; j<2+tailCnt; j++){
                if(posList.get(j).x==x && posList.get(j).y==y){
                    bw.write(String.valueOf(time));
                    flag = false;
                    break;
                }
            }
            if(flag==false)
                break;

            if(graph[x][y]==1){
                graph[x][y]=0;
                tailCnt++;
            }
            time++;
        }

        bw.close();
        br.close();
    }
}
