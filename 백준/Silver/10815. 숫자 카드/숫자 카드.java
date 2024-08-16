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
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int M = Integer.valueOf(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr2[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0; i<M; i++){
            int back=0;
            int front=arr.length-1;
            int flag=0;
            while(back<=front){
                int mid = (back+front)/2;
                int num = arr2[i];
                if(arr[mid]<num){
                    back=mid+1;
                }
                else if(arr[mid]>num){
                    front = mid-1;
                }
                else{
                    flag=1;
                    break;
                }
            }
            bw.write(String.valueOf(flag)+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}