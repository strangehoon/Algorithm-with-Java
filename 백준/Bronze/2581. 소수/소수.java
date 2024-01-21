import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[N+1];
        check[1] = true;
        for(int i=2; i<= Math.sqrt(N); i++){
            for(int j=i+i; j<=N; j=j+i){
                check[j] = true;
            }
        }
        int sum = 0;
        int min_value = Integer.MAX_VALUE;
        for(int i=M; i<=N; i++){
            if(check[i]==false){
                sum += i;
                min_value = Math.min(min_value, sum);
            }
        }
        if(sum==0){
            bw.write(String.valueOf(-1));
        }
        else {
            bw.write(String.valueOf(sum) + "\n");
            bw.write(String.valueOf(min_value));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}