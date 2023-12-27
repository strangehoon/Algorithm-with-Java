import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] arr;

    static int[] result;
    static boolean flag = true;
    public static void DFS(int index, int cnt, int sum){
        if(flag == false)
            return;
        if(cnt==7 && sum==100){
            flag = false;
            for(int i=0; i<result.length; i++){
                System.out.println(result[i]);
            }
        } else if (cnt==7 || sum>100) {
            return;
        } else{
            for(int i=index; i<9; i++){
                result[cnt] = arr[i];
                DFS(i+1, cnt+1, sum+arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[9];
        result = new int[7];
        for(int i=0; i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        DFS(0, 0, 0);
    }
}
