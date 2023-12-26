import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean flag = true;
        for(int i=0; i<str.length(); i++){
            if(arr[i]=='X'){
                cnt++;
            } else if (arr[i]=='.') {
                for(int j=0; j<cnt/4; j++){
                    sb.append("AAAA");
                }
                cnt %= 4;
                for(int j=0; j<cnt/2; j++){
                    sb.append("BB");
                }
                cnt %=2;
                if(cnt!=0){
                    flag = false;
                    bw.write(String.valueOf(-1));
                    break;
                }
                else
                    sb.append('.');
            }
        }
        if(flag==true) {
            for (int j = 0; j < cnt / 4; j++) {
                sb.append("AAAA");
            }
            cnt %= 4;
            for (int j = 0; j < cnt / 2; j++) {
                sb.append("BB");
            }
            cnt %= 2;
            if (cnt != 0) {
                flag = false;
                bw.write(String.valueOf(-1));
            }
            if(flag==true){
                bw.write(sb.toString());
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
