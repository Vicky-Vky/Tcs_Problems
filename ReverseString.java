import java.util.*;
public class ReverseString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int reverse =0;
        int remainder = 0;

        while(input!=0){
            remainder = input%10;
            reverse = reverse*10+remainder;
            input = input/10;
        }
        System.out.println(reverse);
    }
}