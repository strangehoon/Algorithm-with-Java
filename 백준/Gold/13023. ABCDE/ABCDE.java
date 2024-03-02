import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static List<List<Integer>> graph;
    static boolean[]visited;
    public static boolean DFS(int x, int cnt){
        if(cnt==4){
            return true;
        }
        boolean flag = false;
        for(Integer tem : graph.get(x)){
            if(visited[tem]==false){
                visited[tem] = true;
                flag = DFS(tem, cnt+1);
                if(flag == true)
                    return true;
                visited[tem] = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean flag = false;
        for(int i=0; i<N; i++){
            visited = new boolean[N];
            visited[i] = true;
            flag = DFS(i, 0);
            if(flag==true)
                break;
        }
        bw.write(String.valueOf(flag==false ? 0 : 1));

        bw.flush();
        bw.close();
        br.close();
    }
}