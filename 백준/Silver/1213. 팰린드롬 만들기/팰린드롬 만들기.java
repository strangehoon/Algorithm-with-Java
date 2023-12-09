import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char[] arr = new char[26];
        for(char x : str.toCharArray()){
            arr[x-65] += 1;
        }
        int flag = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(arr[i]%2==1){
                flag = i;
                cnt ++;
            }
            for(int j=0; j<arr[i]/2; j++){
                sb.append((char)(i+65));
            }
            arr[i]/=2;
        }
        if(str.length()%2==1){
            sb.append((char)(flag+65));
        }
        for(int i=25; i>=0; i--){
            for(int j=0; j<arr[i]; j++){
                sb.append((char)(i+65));
            }
        }
        if(cnt>1)
            bf.write("I'm Sorry Hansoo");
        else
            bf.write(sb.toString());
        bf.flush();
        bf.close();
        br.close();
    }
}