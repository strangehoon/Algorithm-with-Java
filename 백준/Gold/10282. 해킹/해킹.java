import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;
    static int n;
    static List<List<Node>> graph;
    public static class Node implements Comparable<Node>{
        int now;
        int cost;

        public Node(int now, int cost){
            this.now = now;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost-o.cost;
        }
    }
    public static void Sol(int x){
        dp[x] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(x, 0));

        while (!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();
            int now = node.now;
            int nowCost = node.cost;
            if(dp[now]<nowCost)
                continue;
            for(Node tem : graph.get(now)){
                if(dp[tem.now]>nowCost+tem.cost){
                    dp[tem.now] = nowCost+tem.cost;
                    priorityQueue.offer(new Node(tem.now, nowCost+ tem.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            dp = new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Node(a, s));
            }

            Sol(c);
            int cnt = 0;
            int time = 0;
            for(int i=1; i<=n; i++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    cnt++;
                    time = Math.max(time, dp[i]);
                }
            }
            bw.write(String.valueOf(cnt)+" " + String.valueOf(time)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}