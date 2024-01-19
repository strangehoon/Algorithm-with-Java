import java.io.*;
import java.util.*;
public class Main {
    static List<Pos> pizzaList;
    static Pos[] pizzaChoiceList;
    static int[][] graph;
    static int M, N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int min_value = Integer.MAX_VALUE;
    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void DFS(int index, int cnt){
        if(cnt==M){
            min_value = Math.min(min_value,Cal());
            return;
        }
        if(index>=pizzaList.size())
            return;
        for(int i=index; i< pizzaList.size(); i++){
            pizzaChoiceList[cnt] = pizzaList.get(i);
            DFS(i+1, cnt+1);
        }
    }
    public static int Cal(){
        int sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j]==1){
                    int tem = Integer.MAX_VALUE;
                    for(Pos pos : pizzaChoiceList){
                        tem = Math.min(tem,Math.abs(pos.x-i)+Math.abs(pos.y-j));
                    }
                    sum += tem;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        pizzaList = new ArrayList<>();
        pizzaChoiceList = new Pos[M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==2){
                    pizzaList.add(new Pos(i, j));
                }
            }
        }

        DFS(0, 0);
        bw.write(String.valueOf(min_value));
        bw.flush();
        bw.close();
        br.close();
    }
}