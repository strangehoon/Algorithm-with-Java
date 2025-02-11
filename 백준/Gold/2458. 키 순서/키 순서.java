import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void dfs(int num, List<List<Integer>> graph, boolean[] visited){
        for(int next : graph.get(num)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next, graph, visited);
            }
        }
    }

    public static int findCnt(int n, boolean[] visited){
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(visited[i])
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            reverseGraph.get(b).add(a);
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            int cnt = 0;
            boolean[] visited1 = new boolean[n+1];
            boolean[] visited2 = new boolean[n+1];
            dfs(i, graph, visited1);
            dfs(i, reverseGraph, visited2);
            cnt += findCnt(n, visited1);
            cnt += findCnt(n, visited2);
            if(cnt==n-1)
                answer ++;
        }
        System.out.println(answer);
    }
}
