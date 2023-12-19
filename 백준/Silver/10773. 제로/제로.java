import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++){
            int tem = Integer.parseInt(br.readLine());
            if(tem!=0)
                stack.push(tem);
            else
                stack.pop();
        }
        if(stack.size()==0)
            bw.write(String.valueOf(0));
        else{
            while (!stack.isEmpty()){
                sum += stack.pop();
            }
            bw.write(String.valueOf(sum));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
