import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<List<Integer>> graph;
    public static boolean[] visited;
    public static boolean flag;

    public static void dfs(int x, int pre){

        visited[x] = true;

        for(int num : graph.get(x)){
            if(!visited[num]){
                dfs(num, x);
            }
            else if(visited[num] && num!=pre){
                flag = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            int m = Integer.valueOf(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            visited = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.valueOf(st.nextToken());
                int b = Integer.valueOf(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    flag = true;
                    dfs(i, -1);
                    if (flag) {
                        cnt++;
                    }
                }
            }
            if(cnt==0){
                bw.write("Case " + t + ": No trees.\n");
            }
            else if(cnt==1){
                bw.write("Case " + t + ": There is one tree.\n");
            }
            else{
                bw.write("Case " + t + ": A forest of " + cnt + " trees.\n");
            }
            t++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}