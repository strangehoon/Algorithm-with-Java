import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        queue.offer(A);
        int cnt = 1;
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                long x = queue.poll();
                if(x>B){
                    continue;
                }
                if (x == B) {
                    flag = false;
                    bw.write(String.valueOf(cnt));
                    break;
                }
                queue.offer(x * 2);
                long tem = Long.parseLong(String.valueOf(x) + "1");
                queue.offer(tem);
            }
            if (flag == false) {
                break;
            }
            cnt++;
        }
        if(flag==true)
            bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
        br.close();
    }
}