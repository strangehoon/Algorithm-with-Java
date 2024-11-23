import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] A = new int[N+1];
        List<Integer> arr = new ArrayList<>();
        arr.add(-1000000001);
        int[] lis = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            int num = A[i];
            if(arr.get(arr.size()-1)<num){
                arr.add(num);
                lis[i] = arr.size()-1;
            }
            else{
                int lt = 1;
                int rt = arr.size()-1;
                while (lt<=rt){
                    int mid = (lt+rt)/2;
                    if(arr.get(mid)<num){
                        lt = mid+1;
                    }
                    else if (arr.get(mid)>=num) {
                        if (arr.get(mid - 1) < num) {
                            arr.set(mid, num);
                            lis[i] = mid;
                            break;
                        } else {
                            rt = mid-1;
                        }
                    }
                }
            }
        }
        int cnt = arr.size()-1;
        bw.write(cnt+"\n");

        Stack<Integer> stack = new Stack<>();
        for(int i=lis.length-1; i>=1; i--){
            if(lis[i]==cnt){
                stack.push(A[i]);
                cnt--;
            }
        }

        while (!stack.isEmpty()){
            bw.write(stack.pop()+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}