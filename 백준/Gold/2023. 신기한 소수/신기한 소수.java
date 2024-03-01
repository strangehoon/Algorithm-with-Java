import java.io.*;
public class Main {
    static int N;
    public static void DFS(int num, int len){
        if(len==N){
            if(IsPrime(num)){
                System.out.println(num);
            }
        }
        else{
            for(int i=0; i<=9; i++){
                int tem = num*10+i;
                if(IsPrime(tem)){
                    DFS(tem, len+1);
                }
            }
        }
    }

    public static boolean IsPrime(int num){
        for(int i=2; i<= Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
        bw.flush();
        bw.close();
        br.close();
    }
}