import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharProb {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String unique = "";
        String[] wordarr = word.split("");

        for(int i=0;i<wordarr.length;i++){
            if(unique.contains(wordarr[i])){
                continue;
            }else{
                unique+=wordarr[i];
            }
        }
        System.out.println(unique);
        }
    }
