import java.io.*;
import java.util.*;

public class Main {
    static char[][]graph;
    static int h,w;
    static boolean[][] visited;
    static int[][] dist;
    static List<Point> firePosList;
    static Point personPos;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static class Point{
        int x;
        int y;
        char ch;
        public Point(int x, int y, char ch){
            this.x = x;
            this.y = y;
            this.ch = ch;
        }
    }
    public static int BFS(){
        Queue<Point> queue = new LinkedList<>();
        for(Point pos : firePosList){
            queue.add(pos);
            visited[pos.x][pos.y] = true;
        }
        queue.add(personPos);
        visited[personPos.x][personPos.y] = true;
        while(!queue.isEmpty()){
            Point pos = queue.poll();
            if(pos.x==0||pos.x==h-1||pos.y==0||pos.y==w-1){
                if(pos.ch=='@')
                    return dist[pos.x][pos.y]+1;
            }

            for(int i=0; i<4; i++){
                int nx = pos.x+dx[i];
                int ny = pos.y+dy[i];
                if(0<=nx && nx<h && 0<=ny &&ny<w){
                    if(graph[nx][ny]=='.' && visited[nx][ny]==false){
                        if(pos.ch=='@')
                            dist[nx][ny] = dist[pos.x][pos.y] + 1;
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, pos.ch));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            graph = new char[h][w];
            visited = new boolean[h][w];
            dist = new int[h][w];
            firePosList = new ArrayList<>();
            for(int i=0; i<h; i++){
                String tem = br.readLine();
                for(int j=0; j<w; j++){
                    graph[i][j] = tem.charAt(j);
                    if(graph[i][j]=='*'){
                        firePosList.add(new Point(i,j,'*'));
                    } else if (graph[i][j]=='@') {
                        personPos = new Point(i,j,'@');
                    }
                }
            }
            int result = BFS();
            if(result==-1){
                bw.write(String.valueOf("IMPOSSIBLE\n"));
            }
            else
                bw.write(String.valueOf(result + "\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
