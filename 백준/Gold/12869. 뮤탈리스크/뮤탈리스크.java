import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[][] hp = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1},
            {3, 1, 9},{1, 3, 9}, {1, 9, 3}};
    static boolean[][][] visited;
    static class Status{
        int a;
        int b;
        int c;

        public Status(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static int BFS(){
        Queue<Status> queue = new LinkedList<>();
        queue.offer(new Status(arr[0], arr[1], arr[2]));
        visited[arr[0]][arr[1]][arr[2]] = true;
        int cnt = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Status tem = queue.poll();
                int a = tem.a;
                int b = tem.b;
                int c = tem.c;
                for(int j=0; j<6; j++){
                    int na = Math.max(0,a-hp[j][0]);
                    int nb = Math.max(0,b-hp[j][1]);
                    int nc = Math.max(0,c-hp[j][2]);
                    if(na<=0 && nb<=0 && nc<=0){
                        return cnt;
                    }
                    if(visited[na][nb][nc]==false) {
                        visited[na][nb][nc] = true;
                        queue.offer(new Status(na, nb, nc));
                    }
                }
            }
            cnt ++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[3];
        visited = new boolean[61][61][61];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(BFS()));
        bw.flush();
        bw.close();
        br.close();
    }
}