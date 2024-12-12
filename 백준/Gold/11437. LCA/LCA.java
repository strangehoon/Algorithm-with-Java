import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static List<List<Integer>> graph;
    public static int[] dept;
    public static int[] parent;
    public static int n;

    public static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        boolean[] visited = new boolean[n+1];
        visited[x] = true;
        dept[x] = 0;
        parent[x] = 0;

        while (!queue.isEmpty()){
            int num = queue.poll();

            for(int tem : graph.get(num)){
                if(!visited[tem]){
                    visited[tem] = true;
                    dept[tem] = dept[num]+1;
                    parent[tem] = num;
                    queue.offer(tem);
                }
            }
        }
    }

    public static int execute(int v1, int v2){
        if(dept[v1]<dept[v2]){
            int tem = v1;
            v1 = v2;
            v2 = tem;
        }
        // dept 맞추기
        while (dept[v1]!=dept[v2]){
            v1 = parent[v1];
        }
        // 같은 조상이 나올 때 까지 두 노드 함께 올라가기
        while (v1!=v2){
            v1 = parent[v1];
            v2 = parent[v2];
        }
        return v1;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.valueOf(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dept = new int[n+1];
        parent = new int[n+1];

        bfs(1);

        int m = Integer.valueOf(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());
            int lca = execute(v1, v2);
            bw.write(String.valueOf(lca)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}