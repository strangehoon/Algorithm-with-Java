import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = Integer.valueOf(br.readLine());
            if(max_heap.isEmpty() || max_heap.peek()>=num){
                max_heap.offer(num);
                if(max_heap.size()>min_heap.size()+1){
                    min_heap.offer(max_heap.poll());
                }
                bw.write(String.valueOf(max_heap.peek())+"\n");
            }
            else if(max_heap.peek()<num){
                min_heap.offer(num);
                if(max_heap.size()<min_heap.size()){
                    max_heap.offer(min_heap.poll());
                }
                bw.write(String.valueOf(max_heap.peek())+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}