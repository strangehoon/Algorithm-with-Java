import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=N; i++){
            queue.offer(i);
        }
        int cnt = 1;
        while(!queue.isEmpty()){
            int tem = queue.poll();
            if(cnt!=K){
                queue.offer(tem);
                cnt++;
            }
            else{
                result.add(tem);
                cnt = 1;
            }
        }

        bw.write(String.valueOf('<'));
        for(int i=0; i<result.size(); i++){
            if(i!=result.size()-1){
                bw.write(String.valueOf(result.get(i) + ", "));
            }
            else{
                bw.write(String.valueOf(result.get(i))+'>');
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}