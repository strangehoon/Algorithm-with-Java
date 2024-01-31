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
            String command = st.nextToken();
            Integer x = null;
            if(command.equals("push_back") || command.equals("push_front")){
                x = Integer.parseInt(st.nextToken());
            }
            switch (command){
                case "push_front":
                    deque.offerFirst(x);
                    break;
                case "push_back":
                    deque.offerLast(x);
                    break;
                case "pop_front":
                    Integer tem1 = deque.pollFirst();
                    if(tem1==null)
                        bw.write(String.valueOf(-1)+"\n");
                    else
                        bw.write(String.valueOf(tem1)+"\n");
                    break;
                case "pop_back":
                    Integer tem2 = deque.pollLast();
                    if(tem2==null)
                        bw.write(String.valueOf(-1) +"\n");
                    else
                        bw.write(String.valueOf(tem2) +"\n");
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size()) +"\n");
                    break;
                case "empty":
                    boolean flag = deque.isEmpty();
                    if(flag==false)
                        bw.write(String.valueOf(0)+"\n");
                    else
                        bw.write(String.valueOf(1)+"\n");
                    break;
                case "front":
                    Integer tem3 = deque.peekFirst();
                    if(tem3==null)
                        bw.write(String.valueOf(-1) +"\n");
                    else
                        bw.write(String.valueOf(tem3) +"\n");
                    break;
                case "back":
                    Integer tem4 = deque.peekLast();
                    if(tem4==null)
                        bw.write(String.valueOf(-1) +"\n");
                    else
                        bw.write(String.valueOf(tem4) +"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}