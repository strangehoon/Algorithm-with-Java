import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[]arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int max_value = Integer.MIN_VALUE;
        int sum = 0;
        int cnt = 1;
        for(int i=0; i<X; i++){
            sum += arr[i];
        }
        max_value = sum;
        for(int i=X; i<N; i++){
            sum += arr[i];
            sum -= arr[i-X];
            if(max_value<sum){
                max_value = sum;
                cnt = 1;
            } else if (max_value==sum) {
                cnt ++;
            }
        }

        if(max_value==0)
            System.out.println("SAD");
        else{
            System.out.println(max_value);
            System.out.println(cnt);
        }

    }
}