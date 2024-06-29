import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static List<List<Integer>> graph;
    public static int[] visited;
    public static boolean result;
    public static void DFS(int x, int flag){
        visited[x] = flag;

        for(int tem : graph.get(x)){
            if(visited[tem]==0){
                DFS(tem, flag*-1);
            }
            else if(visited[tem]==flag){
                result = false;
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.valueOf(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int V = Integer.valueOf(st.nextToken());
            int E = Integer.valueOf(st.nextToken());
            visited = new int[V+1];
            graph = new ArrayList<>();
            result = true;
            for(int i=0; i<=V; i++){
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.valueOf(st.nextToken());
                int b = Integer.valueOf(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for(int i=1; i<=V; i++){
                if(visited[i]==0){
                    DFS(i, 1);
                    if(result==false){
                        break;
                    }
                }
            }
            if(result==true)
                bw.write(String.valueOf("YES")+"\n");
            else
                bw.write(String.valueOf("NO")+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}