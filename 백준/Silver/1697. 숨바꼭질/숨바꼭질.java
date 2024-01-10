import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int[] visited;

    public static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        visited = new int[100001];
        queue.offer(N);
        while (!queue.isEmpty()){
            Integer tem = queue.poll();
            if(tem==K){
                return visited[tem];
            }
            if(tem-1>=0 && visited[tem-1]==0){
                visited[tem-1]= visited[tem]+1;
                queue.offer(tem-1);
            }
            if (tem+1<=100000 && visited[tem+1]==0) {
                visited[tem+1] = visited[tem]+1;
                queue.offer(tem+1);
            }
            if (tem*2<=100000 && visited[tem*2]==0) {
                visited[tem*2] = visited[tem]+1;
                queue.offer(tem*2);
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = BFS();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
