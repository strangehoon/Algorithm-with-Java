import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos{
        int x;
        int y;
        int z;

        public Pos(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int L,R,C;
    static int[][][] graph, visited;

    public static int BFS(Pos start){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        visited = new int[L][R][C];
        while (!queue.isEmpty()){
            Pos tem = queue.poll();
            for(int i=0; i<6; i++){
                int nx = tem.x+dx[i];
                int ny = tem.y+dy[i];
                int nz = tem.z+dz[i];
                if(0<=nx && nx<L && 0<=ny && ny<R && 0<=nz && nz<C){
                    if(graph[nx][ny][nz]=='.' && visited[nx][ny][nz]==0){
                        queue.offer(new Pos(nx,ny,nz));
                        visited[nx][ny][nz] = visited[tem.x][tem.y][tem.z]+1;
                    } else if (graph[nx][ny][nz]=='E') {
                        return visited[tem.x][tem.y][tem.z]+1;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0)
                break;
            graph = new int[L][R][C];
            Pos start = null;
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String str = br.readLine();
                    for(int k=0; k<str.length(); k++){
                        graph[i][j][k] = str.charAt(k);
                        if(graph[i][j][k]=='S'){
                            start = new Pos(i,j,k);
                        }
                    }
                }
                br.readLine();
            }
            int result = BFS(start);
            if(result==-1)
                bw.write("Trapped!\n");
            else
                bw.write("Escaped in " + result + " minute(s).\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}