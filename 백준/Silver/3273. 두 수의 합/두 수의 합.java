import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int idx = 0;
        int jdx = n-1;
        int cnt = 0;

        while (idx<jdx){
            int sum = arr[idx] + arr[jdx];
            if(sum<x){
                idx ++;
            }
            else if(sum == x){
                idx ++;
                jdx --;
                cnt ++;
            }
            else{
                jdx --;
            }
        }

        System.out.println(cnt);
    }
}