import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        char[] ascii = new char[26];
        String [] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        for(char x:arr[0].toCharArray()){
            ascii[x-65] += 1;
        }

        for(int i=1; i<n; i++){
            int flag = 0;
            char[]x = new char[26];
            for(char q : arr[i].toCharArray()){
                x[q-65] += 1;
            }

            for(int j=0; j<26; j++){
                if(ascii[j]!=x[j]){
                    flag += Math.abs(ascii[j]-x[j]);
                }
            }

            // 문자열 길이가 같은 경우
            if(arr[i].length()==arr[0].length()){
                if(flag == 0 || flag ==2){
                    cnt ++;
                }
            }
            // 문자열 길이가 다른 경우
            else {
                if(flag == 1){
                    cnt ++;
                }
            }
        }
        bf.write(String.valueOf(cnt));
        bf.close();
        br.close();
    }
}
