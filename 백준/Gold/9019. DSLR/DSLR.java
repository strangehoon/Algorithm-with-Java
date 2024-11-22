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
            int[] idxArr = new int[10000];
            Arrays.fill(idxArr, -1);
            char[] chArr = new char[10000];
            Stack<Character> stack = new Stack<>();

            while (!queue.isEmpty()){
                int n = queue.poll();

                if(n==B){
                    while (n!=A){
                        stack.push(chArr[n]);
                        n = idxArr[n];
                    }
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

                if(idxArr[dN]==-1){
                    idxArr[dN] = n;
                    chArr[dN] = 'D';
                    queue.offer(dN);
                }
                if(idxArr[sN]==-1){
                    idxArr[sN] = n;
                    chArr[sN] = 'S';
                    queue.offer(sN);
                }
                if(idxArr[lN]==-1){
                    idxArr[lN] = n;
                    chArr[lN] = 'L';
                    queue.offer(lN);
                }
                if(idxArr[rN]==-1){
                    idxArr[rN] = n;
                    chArr[rN] = 'R';
                    queue.offer(rN);
                }
            }
            int len = stack.size();
            while (len-- > 0) {
                bw.write(String.valueOf(stack.pop()));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
