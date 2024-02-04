import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int num = 1;
        int sum = 0;
        while (true){
            sum += num;
            if(sum>=X){
                break;
            }
            else{
                num++;
            }
        }

        int start = sum-num+1;
        if(num%2==0){
            int x = 1;
            int y = num;
            for(int i=start+1; i<=X; i++){
                x++;
                y--;
            }
            bw.write(String.valueOf(x)+"/"+String.valueOf(y));
        }
        else {
            int x = num;
            int y = 1;
            for(int i=start+1; i<=X; i++){
                x--;
                y++;
            }
            bw.write(String.valueOf(x)+"/"+String.valueOf(y));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}