import java.util.Scanner;
public class Main {
    public int solution(int a, int b, int c, int[] arr){
        int result = 0;
        for(int i=0; i<100; i++){
            if(arr[i]==1){
                result+=a;
            } else if (arr[i]==2) {
                result+=(b*2);
            }
            else if(arr[i]==3){
                result+=(c*3);
            }
        }
        return result;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] arr = new int[100];
        for(int i=0; i<3; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int j=x; j<y; j++){
                arr[j] += 1;
            }
        }
        System.out.println(T.solution(A,B,C,arr));
    }
}