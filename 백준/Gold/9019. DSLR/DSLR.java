import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.valueOf(st.nextToken());
            int B = Integer.valueOf(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(A);
            String[] commandArr = new String[10000];
            commandArr[A] = "";

            while (!queue.isEmpty()){
                int n = queue.poll();

                if(n==B){
                    bw.write(commandArr[n]+"\n");
                    break;
                }

                String strN = String.valueOf(n);
                int lenN = strN.length();
                for(int i=0; i<4-lenN; i++){
                    strN = "0" + strN;
                }

                int dN = n*2%10000;
                int sN = n==0 ? 9999 : n-1;
                int lN = Integer.valueOf(strN.substring(1, 4) + strN.substring(0, 1));
                int rN = Integer.valueOf(strN.substring(3, 4)+ strN.substring(0, 3));

                if(commandArr[dN]==null){
                    commandArr[dN] = commandArr[n]+"D";
                    queue.offer(dN);
                }
                if(commandArr[sN]==null){
                    commandArr[sN] = commandArr[n]+"S";
                    queue.offer(sN);
                }
                if(commandArr[lN]==null){
                    commandArr[lN] = commandArr[n]+"L";
                    queue.offer(lN);
                }
                if(commandArr[rN]==null){
                    commandArr[rN] = commandArr[n]+"R";
                    queue.offer(rN);

                }
            }


        }

        bw.flush();
        bw.close();
        br.close();
    }
}
