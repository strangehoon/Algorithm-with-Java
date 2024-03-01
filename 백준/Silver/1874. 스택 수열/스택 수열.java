import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Character> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int number = 1;
        boolean flag = true;
        while (N-->0){
            int x = Integer.parseInt(br.readLine());
            while (number<=x){
                stack.push(number++);
                list.add('+');
            }
            if(number>x){
                int tem = stack.pop();
                if(tem==x){
                    list.add('-');
                }
                else {
                    bw.write(String.valueOf("NO")+"\n");
                    flag = false;
                    break;
                }
            }
        }
        if(flag==true) {
            for (int i = 0; i < list.size(); i++) {
                bw.write(String.valueOf(list.get(i)) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}