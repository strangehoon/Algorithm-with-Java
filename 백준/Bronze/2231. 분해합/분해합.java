import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int i = 1;
        while (true){
           int sum = 0;
           String str = String.valueOf(i);
           sum += Integer.parseInt(str);
           for(char ch : str.toCharArray()){
               sum += ch-'0';
           }
           if(sum==N){
               bw.write(String.valueOf(i));
               break;
           } else if (i>N) {
               bw.write(String.valueOf(0));
               break;
           }
            i++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
