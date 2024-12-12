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
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[] indegree = new int[n+1];
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.valueOf(st.nextToken());

            int preNum = Integer.valueOf(st.nextToken());

            for(int j=1; j<cnt; j++){
                int nowNum = Integer.valueOf(st.nextToken());
                graph.get(preNum).add(nowNum);
                indegree[nowNum]++;
                preNum = nowNum;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int num = queue.poll();
            result.add(num);

            for(int tem : graph.get(num)){
                indegree[tem]--;
                if(indegree[tem]==0){
                    queue.offer(tem);
                }
            }
        }

        if(result.size()!=n){
            bw.write("0\n");
        }
        else{
            for(int tem : result){
                bw.write(String.valueOf(tem)+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}