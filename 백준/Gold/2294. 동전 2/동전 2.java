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
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        final int MAX_VALUE = 1000000;

        int[][] graph = new int[n+1][k+1];
        for(int i=1; i<=k; i++){
            graph[0][i] = MAX_VALUE;
        }

        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            int num = Integer.valueOf(br.readLine());
            arr[i] = num;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                graph[i][j] = graph[i-1][j];
                if(j-arr[i]>=0){
                    graph[i][j] = Math.min(graph[i][j], graph[i][j-arr[i]]+1);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, graph[i][k]);
        }
        if(answer==MAX_VALUE){
            bw.write(String.valueOf(-1));
        }
        else{
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}