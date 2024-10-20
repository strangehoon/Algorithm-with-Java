import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static List<List<Integer>> graph;
    public static boolean[] visitedForDfs;
    public static boolean[] visitedForBfs;

    public static void DFS(int start){
        System.out.print(start + " ");
        visitedForDfs[start] = true;
        for(int num : graph.get(start)){
            if(!visitedForDfs[num]){
                DFS(num);
            }
        }

    }

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitedForBfs[start] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v +" ");
            for(int num : graph.get(v)){
                if(!visitedForBfs[num]){
                    visitedForBfs[num] = true;
                    queue.offer(num);
                }
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int V = Integer.valueOf(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        visitedForDfs = new boolean[N+1];
        visitedForBfs = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(graph.get(i));
        }

        DFS(V);
        System.out.println();
        BFS(V);
        
        bw.flush();
        bw.close();
        br.close();
    }
}