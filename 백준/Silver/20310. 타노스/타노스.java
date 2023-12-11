import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder str = new StringBuilder(br.readLine());
        int cnt1 = 0;
        int cnt0 = 0;
        for(char ch:str.toString().toCharArray()){
            if(ch=='1')
                cnt1++;
            else if (ch=='0') {
                cnt0++;
            }
        }
        for(int i=0; i<cnt1/2; i++){
            str.deleteCharAt(str.toString().indexOf('1'));
        }
        for(int i=0; i<cnt0/2; i++){
            str.deleteCharAt(str.toString().lastIndexOf('0'));
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}