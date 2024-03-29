import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        int cnt = T.length()-S.length();
        StringBuilder sb = new StringBuilder(T);
        while (cnt-->0){
            if(sb.charAt(sb.length()-1)=='A'){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.deleteCharAt(sb.length()-1);
                sb.reverse();
            }
        }

        if(sb.toString().equals(S)){
            bw.write(String.valueOf(1));
        }
        else{
            bw.write(String.valueOf(0));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}