import java.util.Scanner;
public class Main {
    public int solution(String str){
        StringBuilder sb = new StringBuilder(str);
        if(sb.toString().equals(sb.reverse().toString()))
            return 1;
        else
            return 0;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));;
    }
}