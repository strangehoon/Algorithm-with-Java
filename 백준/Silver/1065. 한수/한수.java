import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        if(str.length()<3){
            bw.write(String.valueOf(Integer.valueOf(str)));
        }
        else {
            int result = 99;
            int N = Integer.valueOf(str);
            int[] arr = new int[3];
            for(int i=100; i<=N; i++){
                arr[0] = i/100;
                arr[1] = i/10%10;
                arr[2] = i%10;
                if(arr[0]-arr[1]==arr[1]-arr[2]){
                    result++;
                }
            }
            bw.write(String.valueOf(result));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}