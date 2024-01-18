import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            String p = br.readLine();
            Deque<Integer> deque = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            String tem = br.readLine();
            String[] strArr = tem.substring(1, tem.length()-1).split(",");
            for(int i=0; i<N; i++){
                deque.offerLast(Integer.valueOf(strArr[i]));
            }
            int check = 1;
            boolean flag = true;
            for(int i=0; i<p.length(); i++){
                char x = p.charAt(i);{
                    if(x=='D'){
                        if(deque.size()==0){
                            bw.write("error\n");
                            flag = false;
                            break;
                        }
                        if(check==1)
                            deque.pollFirst();
                        else if (check==-1) {
                            deque.pollLast();
                        }
                    }
                    else if (x=='R') {
                        check *= -1;
                    }
                }
            }

            if(flag==true){
                int len = deque.size();
                if(len==0)
                    bw.write(String.valueOf("[]\n"));
                else {
                    bw.write(String.valueOf('['));

                    for (int i = 0; i < len - 1; i++) {
                        if (check == 1) {
                            bw.write(String.valueOf(deque.pollFirst()) + ',');
                        } else if (check == -1) {
                            bw.write(String.valueOf(deque.pollLast()) + ',');
                        }
                    }
                    bw.write(String.valueOf(deque.pollFirst()) + "]\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}