import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static boolean flag = true;
    public static int[] arr;
    public static void Sol(int pos, int sum){
        if(flag==false)
            return;
        if(sum==n){
            k--;
            if(k==0){
                System.out.print(arr[0]);
                for(int i=1; i<n; i++){
                    int tem = arr[i];
                    if(tem!=0) {
                        System.out.print("+" + tem);
                    }

                }
                flag = false;
            }
        } else if (sum!=n) {
            if(sum+1<=n) {
                arr[pos] = 1;
                Sol(pos + 1, sum + 1);
                arr[pos] = 0;
            }
            if(sum+2<=n) {
                arr[pos] = 2;
                Sol(pos + 1, sum + 2);
                arr[pos] = 0;
            }
            if(sum+3<=n) {
                arr[pos] = 3;
                Sol(pos + 1, sum + 3);
                arr[pos] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        Sol(0, 0);
        if(flag==true)
            System.out.print(-1);
        bw.flush();
        bw.close();
        br.close();
    }
}