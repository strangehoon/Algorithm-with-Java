import java.util.Scanner;
public class Main {
    public String solution(String[] str){
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];
        for(String x : str){
            alpha[x.charAt(0)-97] += 1;
        }
        for(int i=0; i<26; i++){
            if(alpha[i]>=5){
                sb.append((char)(i+97));
            }
        }
        if(sb.toString().equals(""))
            sb.append("PREDAJA");
        return sb.toString();
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.next();
        System.out.println(T.solution(arr));;
    }
}