import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.valueOf(st.nextToken());
        final int INF= 1000000000;

        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(i==j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = INF;
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }

        for(int k = 1; k<=n; k++){
            for(int s=1; s<=n; s++){
                for(int e=1; e<=n; e++){
                    graph[s][e] = Math.min(graph[s][e], graph[s][k] + graph[k][e]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(graph[i][j]==INF)
                    bw.write("0 ");
                else
                    bw.write(graph[i][j] +" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}