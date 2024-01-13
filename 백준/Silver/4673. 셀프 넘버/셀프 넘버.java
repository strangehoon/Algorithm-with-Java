import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean [] check = new boolean[10001];
        for(int i=1; i<=10000; i++){
            int sum = i;
            String str = String.valueOf(i);
            for(char ch : str.toCharArray()){
                sum += ch-'0';
            }
            if(sum<=10000)
                check[sum] = true;
        }
        for(int i=1; i<=10000; i++){
            if(check[i]==false){
                System.out.println(i);
            }
        }
        br.close();
    }
}