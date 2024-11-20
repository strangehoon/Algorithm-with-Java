import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static class Row implements Comparable<Row>{
        int a;
        int b;

        public Row(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Row R){
            return this.b-R.b;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        Row[] arr = new Row[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            arr[i] = new Row(a, b);
        }

        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            int max_cnt = 0;
            for(int j=0; j<i; j++){
                if(arr[j].a<arr[i].a){
                    max_cnt = Math.max(max_cnt, dp[j]);
                }
            }
            dp[i] = max_cnt+1;
        }

        int max_result = 0;
        for(int i=0; i<n; i++){
            max_result = Math.max(max_result, dp[i]);
        }

        bw.write(String.valueOf(n-max_result));
        bw.flush();
        bw.close();
        br.close();
    }
}