import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)!=Math.abs(o2)){
                    return Math.abs(o1)-Math.abs(o2);
                }
                else {
                    return o1-o2;
                }
            }
        });
        while (N-->0){
            int x = Integer.parseInt(br.readLine());
            if(x!=0){
                priorityQueue.offer(x);
            }
            else{
                if(priorityQueue.isEmpty()){
                    bw.write(String.valueOf(0)+"\n");
                }
                else {
                    bw.write(String.valueOf(priorityQueue.poll())+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}