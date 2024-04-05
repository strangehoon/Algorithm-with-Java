import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    Integer num = Integer.parseInt(st.nextToken());
                    deque.offerLast(num);
                    break;
                case "front":
                    Integer tem = deque.peekFirst();
                    if(tem==null)
                        bw.write(String.valueOf(-1)+"\n");
                    else
                        bw.write(String.valueOf(tem)+"\n");
                    break;
                case "back":
                    Integer tem2 = deque.peekLast();
                    if(tem2==null)
                        bw.write(String.valueOf(-1)+"\n");
                    else
                        bw.write(String.valueOf(tem2)+"\n");
                    break;
                case "pop":
                    Integer tem3 = deque.pollFirst();
                    if(tem3==null)
                        bw.write(String.valueOf(-1)+"\n");
                    else
                        bw.write(String.valueOf(tem3)+"\n");
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size())+"\n");
                    break;
                case "empty":
                    if(deque.isEmpty())
                        bw.write(String.valueOf(1)+"\n");
                    else
                        bw.write(String.valueOf(0)+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}