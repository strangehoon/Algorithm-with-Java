import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];
        dpMax[0][0] = graph[0][0];
        dpMin[0][0] = graph[0][0];
        dpMax[0][1] = graph[0][1];
        dpMin[0][1] = graph[0][1];
        dpMax[0][2] = graph[0][2];
        dpMin[0][2] = graph[0][2];
        for(int i=1; i<N; i++){
            dpMax[i][0] = graph[i][0] + Math.max(dpMax[i-1][0], dpMax[i-1][1]);
            dpMin[i][0] = graph[i][0] + Math.min(dpMin[i-1][0], dpMin[i-1][1]);

            int temMax = Math.max(dpMax[i-1][0], dpMax[i-1][1]);
            dpMax[i][1] = graph[i][1] + Math.max(temMax, dpMax[i-1][2]);
            int temMin = Math.min(dpMin[i-1][0], dpMin[i-1][1]);
            dpMin[i][1] = graph[i][1] + Math.min(temMin, dpMin[i-1][2]);

            dpMax[i][2] = graph[i][2] + Math.max(dpMax[i-1][1], dpMax[i-1][2]);
            dpMin[i][2] = graph[i][2] + Math.min(dpMin[i-1][1], dpMin[i-1][2]);
        }
        int resultMax = Math.max(dpMax[N-1][0], dpMax[N-1][1]);
        resultMax = Math.max(resultMax, dpMax[N-1][2]);
        int resultMin = Math.min(dpMin[N-1][0], dpMin[N-1][1]);
        resultMin = Math.min(resultMin, dpMin[N-1][2]);

        bw.write(resultMax +" " + resultMin);
        bw.close();
        br.close();
    }
}
