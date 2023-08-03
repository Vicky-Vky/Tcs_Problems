import java.util.*;
public class CharAtOdd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res="";
        for(int i=0;i<str.length();i++){
            if(i%2!=0){
                res = res+str.charAt(i);
            }
        }
        System.out.println(res);
    }
}