import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        int[] time = new int[N+1];
        int[] arr = new int[N+1];
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.valueOf(st.nextToken());
            while(true){
                int num = Integer.valueOf(st.nextToken());
                if(num==-1)
                    break;
                graph.get(num).add(i);
                arr[i] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N+1];
        for(int i=1; i<=N; i++){
            if(arr[i]==0) {
                queue.offer(i);
                result[i] = time[i];
            }
        }
        while(!queue.isEmpty()){
            int tem = queue.poll();
            for(int x : graph.get(tem)){
                result[x] = Math.max(result[x], result[tem]+time[x]);
                arr[x] -= 1;
                if(arr[x]==0){
                    queue.offer(x);
                }
            }
        }

        for(int i=1; i<=N; i++){
            bw.write(String.valueOf(result[i])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}