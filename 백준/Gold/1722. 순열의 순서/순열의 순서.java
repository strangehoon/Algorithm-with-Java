import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] V = new boolean[N+1];
        long[] A = new long[N];
        A[0] = 1;
        for(int i=1; i<N; i++){
            A[i] = A[i-1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        if(st.nextToken().equals("1")){
            long th = Long.parseLong(st.nextToken()) - 1;
            for(int i=N; i > 0; i--){
                long ith = th / A[i-1] + 1;
                th %= A[i-1]; 
                long count = 0; 
                int index = 0;
                while (count != ith){ 
                    index++; 
                    if(!V[index]) count++; 
                }
                V[index] = true;
                sb.append(index).append(" ");
            }
        }else{
            long th = 1;
            for(int i=N; i>0; i--){
                int data = Integer.parseInt(st.nextToken());
                int index = 0;
                int count = 0;
                while (index != data){
                    index++;
                    if(!V[index]) count++;
                }
                V[index] = true;
                th += (count-1) * A[i-1];
            }
            sb.append(th);
        }

        System.out.println(sb);

    }

}