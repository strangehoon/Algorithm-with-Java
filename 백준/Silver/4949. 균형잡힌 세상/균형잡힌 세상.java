import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            if(str.equals(".")){
                break;
            }
            boolean flag = true;
            for(char ch : str.toCharArray()){
                if(ch=='(' || ch=='['){
                    stack.push(ch);
                }
                else if (ch==')' || ch==']'){
                    if(stack.isEmpty()){
                        bw.write("no" +"\n");
                        flag = false;
                        break;
                    }
                    else{
                        char tem = stack.pop();
                        if(ch==')' && tem=='(')
                            continue;
                        else if (ch==']' && tem=='[') {
                            continue;
                        }
                        else {
                            bw.write("no" +"\n");
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag == true && !stack.isEmpty()){
                bw.write("no" +"\n");
            }
            else if(flag == true && stack.isEmpty()){
                bw.write("yes" +"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}