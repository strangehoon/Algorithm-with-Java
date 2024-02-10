import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Character[] arr = new Character[str.length()];
        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i);
        }
        Arrays.sort(arr, new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        return o2-o1;
                    }
                });

        for(int i =0; i<str.length(); i++){
            bw.write(String.valueOf(arr[i]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}