import java.util.Scanner;

public class VowelsConsonantCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        word = word.toLowerCase();
        char[] wordChar = word.toCharArray();
        int constcount = 0;
        int vowelscount = 0;

        for(int i=0;i<wordChar.length;i++){
            if(wordChar[i]=='a'||wordChar[i]=='e'||wordChar[i]=='i'||wordChar[i]=='o'||wordChar[i]=='u'){
                vowelscount++;
            }
            if(wordChar[i]>='a'&& wordChar[i]<='z'){
                constcount++;
            }
        }
        System.out.println("Vowels Count : "+vowelscount);
        System.out.println("Consonants Count : "+(constcount-vowelscount));
    }
}