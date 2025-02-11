import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 23:00
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] kevins = new int[N+1];
        for(int i=1; i<=N; i++){
            Queue<Integer> queue = new LinkedList<>();
            int[] distance = new int[N+1];
            Arrays.fill(distance, -1);
            queue.offer(i);
            distance[i] = 0;
            int num = 1;
            while(!queue.isEmpty()){
                int size = queue.size();
                while (size-- > 0) {
                    int now = queue.poll();
                    for(int next : graph.get(now)){
                        if(distance[next]==-1){
                            distance[next] = num;
                            queue.offer(next);
                        }
                    }
                }
                num++;
            }

            for(int j=1; j<=N; j++){
                kevins[i] += distance[j];
            }
        }

        int minValue = Integer.MAX_VALUE;
        int answer = -1;
        for(int i=1; i<=N; i++){
            if(minValue>kevins[i]){
                minValue = kevins[i];
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
