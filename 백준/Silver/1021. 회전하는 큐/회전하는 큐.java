import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<M; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            list.add(i);
        }
        int result = 0;
        while (!queue.isEmpty()){
            int tem = queue.poll();
            int idxLeft = list.indexOf(tem);
            int idxRight = list.size()-idxLeft;
            if(idxLeft<=idxRight){
                while (idxLeft-->0){
                    int x = list.remove(0);
                    list.add(list.size(), x);
                    result++;
                }
            }
            else{
                while (idxRight-->0){
                    int x = list.remove(list.size()-1);
                    list.add(0, x);
                    result++;
                }
            }
            list.remove(0);
        }
        System.out.println(result);

        bw.flush();
        bw.close();
        br.close();
    }
}