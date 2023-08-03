import java.lang.Math;
import java.util.Scanner;

public class PerfectSquare{
    public static int PerfectSquareCheck(int x){
        if(x>0){
            double a =x;
            int res = (int)Math.sqrt(a);

            if(res*res==a){
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int res = PerfectSquareCheck(input);
        if(res!=0){
            System.out.println("Yes Its Perfect Square..!!"+res);
        }else{
            System.out.println("Its not a Perfect Square..!!");
        }
    }
}