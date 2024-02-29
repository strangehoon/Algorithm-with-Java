import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            char[] arr = br.readLine().toCharArray();
            int[] alpha = new int[26];
            List<List<Integer>> posList = new ArrayList<>();
            for(int i=0; i<26; i++){
                posList.add(new ArrayList<>());
            }
            int K = Integer.parseInt(br.readLine());
            for(int i=0; i<arr.length; i++){
                alpha[arr[i]-'a'] += 1;
                posList.get(arr[i]-'a').add(i);
            }
            int min_value = Integer.MAX_VALUE;
            int max_value = Integer.MIN_VALUE;
            for(int i=0; i<26; i++){
                if(alpha[i]<K)
                    continue;
                int cnt = posList.get(i).size();
                for(int j=0; j<=cnt-K;j++){
                    int tem = posList.get(i).get(j+K-1)-posList.get(i).get(j)+1;
                    min_value = Math.min(min_value, tem);
                    max_value = Math.max(max_value, tem);
                }

            }

            if(min_value==Integer.MAX_VALUE && max_value==Integer.MIN_VALUE)
                bw.write(String.valueOf(-1)+"\n");
            else
                bw.write(String.valueOf(min_value)+" "+max_value +"\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}