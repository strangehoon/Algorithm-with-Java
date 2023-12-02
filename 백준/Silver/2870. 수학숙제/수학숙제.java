import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public ArrayList<BigInteger> solution(int n, String[] str) {
		ArrayList<BigInteger> result = new ArrayList<>();
		for(String x : str) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<x.length(); i++){
				if(Character.isDigit(x.charAt(i))) {
					sb.append(x.charAt(i));
				}
				else {
					if(sb.length()!=0) {
						BigInteger bigint = new BigInteger(sb.toString());
						result.add(bigint);
						sb.delete(0, sb.length());
					}
				}
			}
			if(sb.length()!=0) {
				BigInteger bigint = new BigInteger(sb.toString());
				result.add(bigint);
			}
		}
		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.next();
		}
		for(BigInteger x:T.solution(n, arr)) {
			System.out.println(x);
		}
	}

}