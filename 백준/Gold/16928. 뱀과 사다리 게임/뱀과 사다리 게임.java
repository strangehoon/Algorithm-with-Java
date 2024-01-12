import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer, Integer> map;
    static int[] graph;
    static int[] visited;
    public static int BFS(){
        visited = new int[101];
        visited[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()){
            int x = queue.poll();
            if(x==100){
                return visited[100];
            }
            for(int i=1; i<=6; i++){
                int nx = x+i;
                // 주사위 -> 사다리 or 뱀 (X)
                if(nx<=100 && !map.containsKey(nx)){
                    if(visited[nx]==0 || visited[nx]>visited[x]+1) {
                        visited[nx] = visited[x] + 1;
                        queue.offer(nx);
                    }
                }
                // 주사위 -> 사다리 or 뱀 (O)
                else if (nx<=100 && map.containsKey(nx)) {
                    nx = map.get(nx);
                    if(visited[nx]==0 || visited[nx]>visited[x]+1) {
                        visited[nx] = visited[x] + 1;
                        queue.offer(nx);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        graph = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map.put(s, e);
        }

        bw.write(String.valueOf(BFS()));

        bw.flush();
        bw.close();
        br.close();
    }
}