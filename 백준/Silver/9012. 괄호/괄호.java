import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        for(String str: arr){
            Stack<Character> stack = new Stack<>();
            String result = "YES";
            for(char ch : str.toCharArray()){
                if(ch == '('){
                    stack.push(ch);
                }
                else{
                    if(stack.isEmpty()){
                        result="NO";
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty())
                result = "NO";
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}