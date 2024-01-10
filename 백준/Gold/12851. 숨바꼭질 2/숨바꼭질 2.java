import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,K,time;
    static int[]visited;
    static int[] method;
    static boolean flag;

    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        while (!queue.isEmpty()&&flag==false){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int tem = queue.poll();
                if(tem-1>=0 && (visited[tem-1]==0 || visited[tem-1]==time)){
                    if(tem-1==K){
                        flag = true;
                    }
                    if(visited[tem-1]==0) {
                        visited[tem - 1] = time;
                        queue.offer(tem - 1);
                    }
                    method[tem-1]+=method[tem];
                }
                if (tem+1<=200000 && (visited[tem+1]==0||visited[tem+1]==time)) {
                    if(tem+1==K){
                        flag=true;
                    }
                    if(visited[tem+1]==0) {
                        visited[tem + 1] = time;
                        queue.offer(tem + 1);
                    }
                    method[tem+1]+=method[tem];
                }
                if (tem*2<=200000 && (visited[tem*2]==0||visited[tem*2]==time)) {
                    if(tem*2==K){
                        flag=true;
                    }
                    if(visited[tem*2]==0) {
                        visited[tem * 2] = time;
                        queue.offer(tem * 2);
                    }
                    method[tem*2]+=method[tem];
                }
            }
            time++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[200001];
        method = new int[200001];
        time = 1;
        method[N]=1;
        flag = false;
        if(N==K){
            bw.write(String.valueOf(0+"\n"));
            bw.write(String.valueOf(1));
        }
        else {
            BFS();
            bw.write(String.valueOf(visited[K] + "\n"));
            bw.write(String.valueOf(method[K]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
