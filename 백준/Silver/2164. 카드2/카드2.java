import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            queue.offer(i);
        }
        int cnt = 0;
        while (queue.size()!=1){
            if(cnt%2==0)
                queue.poll();
            else
                queue.offer(queue.poll());
            cnt++;
        }

        bw.write(String.valueOf(queue.poll()));
        bw.flush();
        bw.close();
        br.close();
    }
}