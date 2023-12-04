import java.util.Scanner;
public class Main {
    public Integer solution(int n, int k, int[] arr){
        int sum =0;
        int max_value = Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        max_value = sum;
        for(int i=k; i<n; i++){
            sum += arr[i];
            sum -= arr[i-k];
            max_value = Math.max(max_value, sum);
        }
        return max_value;

    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution(N,K,arr));

    }
}