import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++)
            queue.offer(i);
        while (queue.size()>1){
            queue.poll();
            if(queue.size()==1)
                break;
            else{
                queue.offer(queue.poll());
            }
        }

        bf.write(String.valueOf(queue.poll()));
        bf.close();
        br.close();
    }
}