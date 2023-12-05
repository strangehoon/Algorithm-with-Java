import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i =0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean flag = true;
            for(char ch : str.toCharArray()){
                if(stack.isEmpty() || stack.peek()!=ch){
                    stack.push(ch);
                } else if (!stack.isEmpty() && stack.peek()==ch) {
                    stack.pop();
                }
            }
            if(!stack.isEmpty()){
                flag = false;
            }
            if(flag==true)
                result++;
        }
        bf.write(String.valueOf(result));
        bf.flush();
        bf.close();
        br.close();
    }
}