import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int len = (int)Math.sqrt(B);
        boolean[] isDecimal = new boolean[len+1];
        isDecimal[1] = true;
        for(int i=2; i<= len; i++){
            for(int j=i+i; j<=len; j+=i){
                isDecimal[j] = true;
            }
        }

        int cnt = 0;
        for(int i=2; i<=len; i++){
            if(!isDecimal[i]){
                long num = i;
                while((double)i<=(double)B/(double)num){
                    if((double)A/(double)num<=i){
                        cnt++;
                    }
                    num *=i;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}