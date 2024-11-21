import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int r = Integer.valueOf(st.nextToken());

        int[][] graph = new int[n][n];
        int[] itemCntArr = new int[n];
        final int INF = 100000;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            itemCntArr[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = INF;
            }
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken())-1;
            int b = Integer.valueOf(st.nextToken())-1;
            int l = Integer.valueOf(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], l);
            graph[b][a] = Math.min(graph[b][a], l);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int maxCnt = 0;
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(graph[i][j]<=m){
                    cnt += itemCntArr[j];
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        bw.write(String.valueOf(maxCnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
