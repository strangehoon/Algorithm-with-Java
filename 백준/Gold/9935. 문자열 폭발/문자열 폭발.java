import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String bomb = br.readLine();
        int strLen = str.length();
        int bombLen = bomb.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<strLen; i++){
            stack.push(str.charAt(i));
            int cnt = 0;
            if(stack.size()>=bombLen){
                for(int j=0; j<bombLen; j++){
                    if(stack.get(j+stack.size()-bombLen)==bomb.charAt(j)){
                        cnt++;
                    }
                }
                if(cnt==bombLen){
                    for(int j=0; j<bombLen; j++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        if(size==0){
            bw.write("FRULA");
        }
        else {
            for(char ch : stack) {
                sb.append(ch);
            }
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}