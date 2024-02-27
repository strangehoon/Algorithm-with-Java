import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        int[][] prefix_sum = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                prefix_sum[j][i] = prefix_sum[j-1][i] + graph[j][i];
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s_x = Integer.parseInt(st.nextToken());
            int s_y = Integer.parseInt(st.nextToken());
            int e_x = Integer.parseInt(st.nextToken());
            int e_y = Integer.parseInt(st.nextToken());
            int result = 0;
            for(int j=s_y; j<=e_y; j++){
                result += prefix_sum[e_x][j]-prefix_sum[s_x-1][j];
            }
            bw.write(String.valueOf(result)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}