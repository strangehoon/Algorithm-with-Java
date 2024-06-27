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

        String str = st.nextToken();
        String[] strArr = str.split("-");
        int result = 0;
        String initStr = strArr[0];
        for(String tem : initStr.split("\\+")){
            result += Integer.valueOf(tem);
        }

        for(int i=1; i<strArr.length; i++){
            String[] tem = strArr[i].split("\\+");
            for(String s : tem){
                result -= Integer.valueOf(s);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}