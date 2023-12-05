import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int start = 0;
        char[] arr = str.toCharArray();
        int i = 0;
        while (i<str.length()){
            start++;
            for(char t : String.valueOf(start).toCharArray()){
                if(i<str.length() && arr[i]==t){
                    i++;
                }
            }
        }
        bf.write(String.valueOf(start));
        bf.flush();
        bf.close();
        br.close();
    }
}