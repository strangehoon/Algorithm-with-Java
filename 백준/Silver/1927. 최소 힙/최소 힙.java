import java.io.*;
import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(heap.isEmpty()){
                    bw.write(String.valueOf(0 +"\n"));
                }
                else{
                    bw.write(String.valueOf(heap.poll() +"\n"));
                }
            }
            else{
                heap.offer(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}