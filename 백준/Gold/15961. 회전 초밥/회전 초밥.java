import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] cnt = new int[d+1];
        int result = 1;
        int max_value = result;
        cnt[c] += 1;

        for(int i=0; i<k; i++){
            int tem = arr[i];
            if(cnt[tem]==0){
                result+= 1;
                cnt[tem]+=1;
            }
            else
                cnt[tem]+=1;
            max_value = Math.max(max_value, result);
        }
        int i=k;
        while(i!=(k-1)){
            if(cnt[arr[i]]==0){
                result+=1;
                cnt[arr[i]]+=1;
            }
            else
                cnt[arr[i]]+=1;
            if(cnt[arr[(i-k+N)%N]]==1){
                cnt[arr[(i-k+N)%N]]-=1;
                result-=1;
            }
            else
                cnt[arr[(i-k+N)%N]]-=1;
            max_value = Math.max(max_value, result);
            i = (i+1)%N;
        }


        bw.write(String.valueOf(max_value));
        bw.flush();
        bw.close();
        br.close();
    }
}