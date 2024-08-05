import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static List<List<Integer>> graph;
    public static boolean[] flags;
    public static int cnt = 0;

    public static void remove(int x){
        flags[x] = true;
        for(int num : graph.get(x)){
            remove(num);
        }
    }

    public static void DFS(int x){
        if(flags[x])
            return;

        if(graph.get(x).isEmpty()){
            cnt++;
        }
        else if(graph.get(x).size()==1 && flags[graph.get(x).get(0)]){
            cnt++;
        }
        else{
            for(int num : graph.get(x)){
                DFS(num);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        flags = new boolean[N];
        graph = new ArrayList<>();
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }
        int start = -1;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.valueOf(st.nextToken());
            if(num==-1){
                start = i;
            }
            else{
                graph.get(num).add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        int E = Integer.valueOf(st.nextToken());

        remove(E);
        DFS(start);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}