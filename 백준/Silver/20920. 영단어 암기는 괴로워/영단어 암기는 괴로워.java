import java.io.*;
import java.util.*;

public class Main {

    public static class Word{
        String name;
        int cnt;
        int len;

        public Word(String name, int cnt, int len){
            this.name = name;
            this.cnt = cnt;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Word> words = new ArrayList<>();
        for(int i =0; i<N; i++){
            String word = br.readLine();
            if(word.length()>=M)
                map.put(word, map.getOrDefault(word, 0)+1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            Word word = new Word(entry.getKey(), entry.getValue(), entry.getKey().length());
            words.add(word);
        }
        Collections.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if(o1.cnt==o2.cnt){
                    if(o1.len==o2.len){
                        return o1.name.compareTo(o2.name);
                    }
                    else
                        return o2.len-o1.len;
                }
                else{
                    return  o2.cnt -o1.cnt;
                }
            }
        });
        for(Word word : words)
            bf.write(word.name +"\n");

        bf.flush();
        bf.close();
        br.close();
    }
}