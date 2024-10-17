import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static class Top{
        int idx;
        int height;

        public Top(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        Stack<Top> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int[] result = new int[N];

        for(int i=N-1; i>=0; i--) {
            int num = arr[i];
            while (!stack.isEmpty()){
                Top top = stack.peek();
                if(top.height<num){
                    result[top.idx] = i+1;
                    stack.pop();
                }
                else{
                    break;
                }
            }
            stack.push(new Top(i, num));
        }

        for(int i=0; i<N; i++){
            bw.write(String.valueOf(result[i])+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}