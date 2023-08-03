import java.util.Scanner;

public class Reverse_string {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toLowerCase();
        String res = "";
        for(int i=str.length()-1;i>=0;i--){
            res +=str.charAt(i);
        }
        System.out.println(res);

    }
}