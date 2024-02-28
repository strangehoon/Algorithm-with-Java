import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] count = new int[4];
    public static void Resolve(char tem, boolean flag){
        if(flag == true){
            if(tem=='A')
                count[0] -= 1;
            else if (tem=='C') {
                count[1] -= 1;
            } else if (tem=='G') {
                count[2] -= 1;
            } else if (tem=='T') {
                count[3] -= 1;
            }
        }
        else{
            if(tem=='A')
                count[0] += 1;
            else if (tem=='C') {
                count[1] += 1;
            } else if (tem=='G') {
                count[2] += 1;
            } else if (tem=='T') {
                count[3] += 1;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            count[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int i=0; i<P; i++){
            char tem = arr[i];
            Resolve(tem, true);
        }
        if(count[0]<=0 && count[1]<=0 && count[2]<=0 && count[3]<=0){
            result ++;
        }
        for(int i=P; i<S; i++){
            char front = arr[i];
            char back = arr[i-P];
            Resolve(front, true);
            Resolve(back, false);
            if(count[0]<=0 && count[1]<=0 && count[2]<=0 && count[3]<=0){
                result ++;
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}