import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            // 남학생일 경우
            if(a==1){
                int cnt = 1;
                while (true){
                    int tem = b*cnt;
                    if(tem>N)
                        break;
                    if(arr[tem]==0)
                        arr[tem]=1;
                    else
                        arr[tem]=0;
                    cnt++;
                }
            }
            // 여학생일 경우
            else{
                int cnt = 1;
                if(arr[b]==0)
                    arr[b]=1;
                else
                    arr[b]=0;
                while (true){
                    if(1<=b-cnt && b+cnt<=N){
                        if(arr[b-cnt]==arr[b+cnt]){
                            if(arr[b-cnt]==0){
                                arr[b-cnt]=1;
                                arr[b+cnt]=1;
                            }
                            else{
                                arr[b-cnt]=0;
                                arr[b+cnt]=0;
                            }
                            cnt ++;
                        }
                        else
                            break;
                    }
                    else
                        break;
                }
            }
        }
        for(int j=1; j<N+1; j++){
            bw.write(String.valueOf(arr[j])+" ");
            if(j%20==0)
                bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}