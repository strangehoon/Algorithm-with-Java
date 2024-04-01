import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static int whiteCnt = 0;
    static int blueCnt = 0;
    public static void Recursion(int x, int y, int n){

        int std = graph[x][y];
        boolean flag = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(std!=graph[x+i][y+j]){
                    flag = false;
                    break;
                }
            }
            if(flag==false)
                break;
        }

        if(flag==true){
            if(graph[x][y]==0)
                whiteCnt++;
            else
                blueCnt ++;
        }
        else{
            // 1사
            Recursion(x, y, n/2);

            // 2사
            Recursion(x, y+n/2, n/2);

            // 3사
            Recursion(x+n/2, y, n/2);

            // 4사
            Recursion(x+n/2, y+n/2, n/2);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Recursion(0, 0, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);

    }
}