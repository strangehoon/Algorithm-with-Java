import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N-->0){
            boolean[] alpha = new boolean[26];
            boolean flag = true;
            String str = br.readLine();
            for(int i=0; i<str.length(); i++){
                int tem = str.charAt(i)-'a';
                if(alpha[tem]==false){
                    alpha[tem] = true;
                } else if (alpha[tem]==true && str.charAt(i)==str.charAt(i-1)) {
                    continue;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if(flag==true)
                cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}