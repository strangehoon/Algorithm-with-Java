import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.valueOf(br.readLine());
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());

            int[] demandTime = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                demandTime[i] = Integer.valueOf(st.nextToken());
            }

            List<List<Integer>> graph = new ArrayList<>();
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            int[] indegree = new int[n+1];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(st.nextToken());
                int y = Integer.valueOf(st.nextToken());
                graph.get(x).add(y);
                indegree[y]++;
            }
            int w = Integer.valueOf(br.readLine());

            int[] finishedTime = new int[n+1];

            Queue<Integer> queue = new LinkedList<>();
            for(int i=1; i<=n; i++){
                if(indegree[i]==0){
                    queue.offer(i);
                    finishedTime[i] = demandTime[i];
                }
            }

            while(!queue.isEmpty()){
                int num = queue.poll();

                for(int tem : graph.get(num)){
                    indegree[tem]--;
                    finishedTime[tem] = Math.max(finishedTime[tem], finishedTime[num]+demandTime[tem]);
                    if(indegree[tem]==0){
                        queue.offer(tem);
                    }
                }
            }

            bw.write(String.valueOf(finishedTime[w])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}