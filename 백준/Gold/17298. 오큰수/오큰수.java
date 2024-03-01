import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Element{
        int pos;
        int value;
        public Element(int pos, int value){
            this.pos = pos;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        Stack<Element> stack2 = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1; i>=0; i--){
            stack.push(arr[i]);
        }
        int i= 0;

        while (!stack.isEmpty()){
            int tem = stack.pop();
            if(stack2.isEmpty() || stack2.peek().value>=tem){
                stack2.push(new Element(i, tem));
                result[i] = -1;
            }
            else {
                result[i] = -1;
                while (!stack2.isEmpty()&&stack2.peek().value<tem){
                    Element y = stack2.pop();
                    result[y.pos] = tem;
                }
                stack2.push(new Element(i, tem));
            }
            i++;
        }

        for(int j=0; j<N; j++){
            bw.write(String.valueOf(result[j])+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}