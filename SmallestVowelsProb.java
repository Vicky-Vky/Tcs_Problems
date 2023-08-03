import java.util.Arrays;
import java.util.Scanner;

public class SmallestVowelsProb {
    public static void main(String[] args){
        String[] vowels = {"a","e","i","o","u"};
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int i=0;i< vowels.length;i++){
            if(str.contains(vowels[i])){
                System.out.println(vowels[i]);
                break;
            }
        }

    }
}