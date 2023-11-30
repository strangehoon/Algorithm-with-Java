import java.util.Scanner;
public class Main {
    public String solution(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(65<=str.charAt(i) && str.charAt(i)<=90){
                sb.append((char)((str.charAt(i)-65+13)%26+65));
            } else if (97<=str.charAt(i) && str.charAt(i)<=122) {
                sb.append((char)((str.charAt(i)-97+13)%26+97));
            } else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}