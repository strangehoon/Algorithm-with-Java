import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static boolean isPall(int x){
        char[] arr = String.valueOf(x).toCharArray();
        boolean flag = true;
        for(int i=0; i<arr.length/2; i++){
            if(arr[i]!=arr[arr.length-1-i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // false : 소수, true : 소수 X
        boolean[] isDecimal = new boolean[2000000];
        isDecimal[1] = true;
        for(int i=2; i<2000000; i++){
            for(int j=i+i; j<2000000; j+=i){
                isDecimal[j] = true;
            }
        }
        int N = Integer.valueOf(st.nextToken());
        int result = 0;
        for(int i=N; i<=2000000; i++){
            if(!isDecimal[i] && isPall(i)){
                result = i;
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}