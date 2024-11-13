import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());
        int len = Math.max(N,K)*2 +1;
        int[] arr = new int[len];
        int[] parent = new int[len];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        while (!queue.isEmpty()){
            int x = queue.poll();
            if(x==K){
                bw.write(String.valueOf(arr[x])+"\n");
                break;
            }

            if(x-1>=0 && arr[x-1]==0){
                arr[x-1] = arr[x]+1;
                parent[x-1] = x;
                queue.offer(x-1);
            }

            if(x+1<parent.length && arr[x+1]==0){
                arr[x+1] = arr[x]+1;
                parent[x+1] = x;
                queue.offer(x+1);
            }

            if(x*2<parent.length && arr[x*2]==0){
                arr[x*2] = arr[x]+1;
                parent[x*2] = x;
                queue.offer(x*2);
            }
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=K; i !=N; i=parent[i]){
            stack.push(i);
        }
        stack.push(N);

        while (!stack.isEmpty()){
            bw.write(String.valueOf(stack.pop())+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}