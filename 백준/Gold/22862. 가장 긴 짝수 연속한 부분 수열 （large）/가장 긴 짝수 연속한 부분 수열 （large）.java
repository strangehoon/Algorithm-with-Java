import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int oddCnt = 0;
        int lastOddIdx = -1;
        int len = 0;
        for(int i=0; i<n; i++){
            if(arr[i]%2==0)
                len = Math.max(len, i-lastOddIdx-oddCnt);
            else{
                oddCnt++;
                if(oddCnt>k){
                    lastOddIdx++;
                    while(arr[lastOddIdx]%2==0){
                        lastOddIdx++;
                    }
                    oddCnt--;
                }
            }
        }

        bw.write(String.valueOf(len));
        bw.flush();
        bw.close();
        br.close();
    }
}
