import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.valueOf(st.nextToken());
        while(T-->0){
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int k = Integer.valueOf(st.nextToken());
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                int n = Integer.valueOf(st.nextToken());
                if(ch=='I'){
                    pq.offer(n);
                    maxPq.offer(n);
                    map.put(n, map.getOrDefault(n, 0)+1);
                }
                else if(ch=='D' && n>0){
                    while(!maxPq.isEmpty()){
                        int num = maxPq.poll();
                        if(map.get(num)!=0){
                            map.put(num, map.get(num)-1);
                            break;
                        }
                    }
                }
                else{
                    while(!pq.isEmpty()){
                        int num = pq.poll();
                        if(map.get(num)!=0){
                            map.put(num, map.get(num)-1);
                            break;
                        }
                    }
                }
            }
            int max_value = 0;
            int min_value = 0;
            while(!maxPq.isEmpty()){
                int tem = maxPq.poll();
                if(map.get(tem)!=0){
                    max_value = tem;
                    break;
                }
            }
            while(!pq.isEmpty()){
                int tem = pq.poll();
                if(map.get(tem)!=0){
                    min_value = tem;
                    break;
                }
            }
            if(max_value==0 && min_value==0){
                bw.write("EMPTY\n");
            }
            else{
                bw.write(String.valueOf(max_value)+" ");
                bw.write(String.valueOf(min_value)+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}