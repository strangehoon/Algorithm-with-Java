import java.util.Scanner;

public class Main {
    public int[] solution(String str){
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-97] += 1;
        }
        return arr;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = T.solution(str);
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}