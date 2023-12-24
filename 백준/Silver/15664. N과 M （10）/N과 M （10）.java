import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] arr;

    static boolean[] visited;

    static int[] result;

    static StringBuilder sb = new StringBuilder();

    static int before;

    public static void DFS(int i, int cnt, boolean[] visited){

        if(cnt >= M){
            for(int j=0; j<M; j++){
                sb.append(result[j] +" ");
            }
            sb.append("\n");
            return;
        }
        else if (i>=N)
            return;
        before = -1;
        for(int j=i; j<N; j++){
            if(before==arr[j]){
                continue;
            }
            else {
                if (visited[j] == false) {
                    visited[j] = true;
                    result[cnt] = arr[j];
                    before = arr[j];
                    DFS(j + 1, cnt + 1, visited);
                    before = arr[j];
                    visited[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        visited = new boolean[N];
        DFS(0,0, visited);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
