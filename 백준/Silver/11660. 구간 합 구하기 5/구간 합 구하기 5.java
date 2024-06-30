import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int[][] graph = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int num = Integer.valueOf(st.nextToken());
                graph[i][j] = num;
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sumArr[i][j] = sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1] + graph[i][j];
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(st.nextToken());
            int y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            int y2 = Integer.valueOf(st.nextToken());
            int result = sumArr[x2][y2]-sumArr[x2][y1-1]-sumArr[x1-1][y2]+sumArr[x1-1][y1-1];
            bw.write(String.valueOf(result)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}