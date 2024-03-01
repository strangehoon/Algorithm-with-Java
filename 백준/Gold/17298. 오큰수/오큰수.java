import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // code
        for(int i=0; i<N; i++){
            if(stack.isEmpty() || arr[stack.peek()]>=arr[i]){
                stack.push(i);
                result[i] = -1;
            }
            else{
                while (!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                    int tem = stack.pop();
                    result[tem] = arr[i];
                }
                stack.push(i);
                result[i] = -1;
            }
        }
        
        // output
        for(int i=0; i<N; i++){
            bw.write(String.valueOf(result[i])+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}