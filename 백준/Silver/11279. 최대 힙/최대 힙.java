import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        while (N-->0){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(priorityQueue.isEmpty())
                    bw.write(String.valueOf(0)+"\n");
                else
                    bw.write(String.valueOf(priorityQueue.poll())+"\n");
            }
            else
                priorityQueue.offer(x);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}