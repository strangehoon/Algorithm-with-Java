import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int a = 0;
        int b = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='a')
                a++;
            else
                b++;
        }
        int cnt = 0;
        for(int i=0; i<a; i++){
            if(str.charAt(i)=='b')
                cnt++;
        }
        int b_cnt = cnt;
        int result = b_cnt;
        for(int i=a; i<a+str.length()-1; i++){
            if(str.charAt((i+str.length())%str.length())=='b')
                b_cnt++;
            if(str.charAt((i+str.length()-a)%str.length())=='b')
                b_cnt--;
            result = Math.min(result, b_cnt);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
