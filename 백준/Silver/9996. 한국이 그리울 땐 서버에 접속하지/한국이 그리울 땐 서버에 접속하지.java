import java.io.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!='*'){
                sb.append(str.charAt(i));
            }
            else{
                sb.append("[a-z]*");
            }
        }
        for(String x :arr){
            if(Pattern.matches(sb.toString(), x)){
                bw.write("DA" +"\n");
            }
            else{
                bw.write("NE" +"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
