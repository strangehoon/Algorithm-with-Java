import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N+1];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            degree[b]++;
        }

        for(int i=1; i<=N; i++){
            if(degree[i]==0)
                queue.offer(i);
        }

        while (!queue.isEmpty()){
            int tem = queue.poll();
            bw.write(String.valueOf(tem) +" ");
            for(Integer x : graph.get(tem)){
                degree[x]--;
                if(degree[x]==0){
                    queue.offer(x);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}