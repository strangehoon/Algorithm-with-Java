import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);

        int i=0;
        int j=arr.length-1;
        int diff_value = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (i<j){
            int tem = Math.abs(arr[i]+arr[j]);
            if(diff_value>tem){
                diff_value = tem;
                answer[0] = arr[i];
                answer[1] = arr[j];
            }
            else {
                if(arr[i]+arr[j]>0){
                    j--;
                }
                else {
                    i++;
                }
            }
        }
        Arrays.sort(answer);
        bw.write(String.valueOf(answer[0])+" "+answer[1]);
        bw.flush();
        bw.close();
        br.close();
    }
}