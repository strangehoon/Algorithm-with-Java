import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] arr;
    static List<Character> result;
    static HashSet<Character> vowel;
    public static void DFS(int i, int x, int y){

        if(x+y==L){
            if(x>=1 && y>=2){
                String tem = "";
                for(char ch : result)
                    tem += ch;
                System.out.println(tem);
            }
            return;
        }
        if(i==C)
            return;

        result.add(arr[i]);
        if(vowel.contains(arr[i]))
            DFS(i+1, x+1, y);
        else
            DFS(i+1, x, y+1);

        result.remove(result.size()-1);
        DFS(i+1, x, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        result = new ArrayList<>();
        vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            char ch = st.nextToken().charAt(0);
            arr[i] = ch;
        }
        Arrays.sort(arr);

        DFS(0, 0, 0);

        bw.flush();
        bw.close();
        br.close();
    }
}