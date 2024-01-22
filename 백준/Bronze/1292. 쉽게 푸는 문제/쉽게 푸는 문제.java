import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[1001];

        int num = 1;
        int cursor = 1;
        boolean flag = true;
        while (flag){
            for(int i=0; i<num; i++){
                arr[cursor] = num;
                cursor++;
                if(cursor>1000){
                   flag = false;
                   break;
                }
            }
            num++;
        }
        int sum = 0;
        for(int i=A; i<=B; i++){
            sum += arr[i];
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}