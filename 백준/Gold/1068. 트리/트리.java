import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static boolean[] deleted;
    static int[] parent;

    public static void BFS(int root){
        deleted[root] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int tem = queue.poll();
            for(int i=0; i<N; i++){
                if(parent[i]==tem){
                    deleted[i] = true;
                    queue.offer(i);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        deleted = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            parent[i] = Integer.parseInt(st.nextToken());
        }
        int deleteNum = Integer.parseInt(br.readLine());
        BFS(deleteNum);
        int cnt = 0;
        for(int i=0; i<N; i++){
            if(!deleted[i]){
                boolean flag = true;
                for(int j=0; j<N; j++){
                    if(deleted[j]==false && parent[j]==i){
                        flag = false;
                        break;
                    }
                }
                if(flag == true)
                    cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}