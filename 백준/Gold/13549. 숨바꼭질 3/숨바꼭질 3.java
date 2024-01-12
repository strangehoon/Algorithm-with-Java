import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int[] visited;

    public static int BFS(){
        Deque<Integer> deque = new LinkedList<>();
        visited = new int[100001];
        for(int i=0; i<100001; i++){
            visited[i] = -1;
        }
        deque.offer(N);
        visited[N] = 0;
        while (!deque.isEmpty()){
            Integer tem = deque.poll();
            if(tem==K){
                return visited[tem];
            }
            if (tem!=0 && tem*2<=100000 && visited[tem*2]==-1) {
                visited[tem*2] = visited[tem];
                deque.offerFirst(tem*2);
            }
            if(tem-1>=0 && visited[tem-1]==-1){
                visited[tem-1]= visited[tem]+1;
                deque.offer(tem-1);
            }
            if (tem+1<=100000 && visited[tem+1]==-1) {
                visited[tem+1] = visited[tem]+1;
                deque.offer(tem+1);
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