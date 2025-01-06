import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        final int INF = 1000000001;
        int answer = 0;
        
        for(int i=0; i<n; i++){
            int cnt = 0;
            double minValue = (double)(INF);
            for(int j=i-1; j>=0; j--){
                double slope = ((double)(arr[i]-arr[j]))/(i-j);
                if(slope<minValue){
                    cnt++;
                    minValue = slope;
                }
            }

            double maxValue = (double)(-INF);
            for(int j=i+1; j<n; j++){
                double slope = ((double)(arr[j]-arr[i]))/(j-i);
                if(slope>maxValue){
                    cnt++;
                    maxValue = slope;
                }
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}