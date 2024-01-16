import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static int[] arr;
    static int min_value;
    static int[] result;
    public static void DFS(int index, int cnt){
        if(cnt==N/2){
            min_value = Math.min(Calculate(), min_value);
            return;
        }
        if(index==N)
            return;
        for(int i=index; i<N; i++){
            result[cnt] = arr[i];
            DFS(i+1, cnt+1);
        }

    }

    public static int Calculate(){
        int start_team = 0;
        int link_team = 0;
        boolean[] check = new boolean[N];
        for(int i=0; i<N/2; i++){
            int tem = result[i];
            check[tem-1] = true;
        }
        // 스타트팀 점수 합계
        for(int i=0; i<N/2; i++){
            for(int j=i+1; j<N/2; j++){
                start_team += graph[result[i]-1][result[j]-1];
                start_team += graph[result[j]-1][result[i]-1];
            }
        }
        // 링크팀 점수 합계
        int[] tem = new int[N/2];
        int index = 0;
        for(int i=0; i<N; i++){
            if(check[i]==false)
                tem[index++] = i+1;
        }
        for(int i=0; i<N/2; i++){
            for(int j=i+1; j<N/2; j++){
                link_team += graph[tem[i]-1][tem[j]-1];
                link_team += graph[tem[j]-1][tem[i]-1];
            }
        }
        return Math.abs(start_team-link_team);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        arr = new int[N];
        result = new int[N/2];
        min_value = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
        bw.write(String.valueOf(min_value));
        bw.flush();
        bw.close();
        br.close();
    }
}