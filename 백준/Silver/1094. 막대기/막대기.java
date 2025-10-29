import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        String str = Integer.toString(x, 2);
        int answer = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1')
                answer++;
        }

        System.out.println(answer);
    }
}