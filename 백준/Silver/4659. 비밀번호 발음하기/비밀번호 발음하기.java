import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static boolean prove(String str){
        int bowel = 0;
        int bowel_seq = 0;
        int consonant_seq = 0;
        char before = 0;
        for(char ch:str.toCharArray()){
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                bowel++;
                bowel_seq++;
                consonant_seq = 0;
                if(bowel_seq>=3)
                    return false;
            }
            else{
                consonant_seq++;
                bowel_seq = 0;
                if(consonant_seq>=3)
                    return false;
            }
            if(ch!='e' && ch!='o' && ch==before){
                return false;
            }
            before = ch;
        }
        if(bowel<1)
            return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("end"))
                break;
            boolean flag = prove(str);
            if(flag == true){
                bw.write(String.valueOf("<" + str +"> " +"is acceptable.\n"));
            }
            else
                bw.write(String.valueOf("<" + str +"> " +"is not acceptable.\n"));

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
