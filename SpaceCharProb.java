import java.util.Scanner;

public class SpaceCharProb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int spaceCount = 0 ;
        char[] wordChar=word.toCharArray();

        for(int i =0;i< wordChar.length;i++){
            if(Character.isWhitespace(wordChar[i])){
                spaceCount++;
            }

        }
        System.out.printf("No of spaces : %d and charecters : %d",spaceCount,wordChar.length-spaceCount);
    }
}