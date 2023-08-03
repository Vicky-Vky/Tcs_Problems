import java.util.*;

public class StringLastFind{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1[] = str.split(" ");
        String result = "";
        for(String x:str1){
            if(x.length()==0){
                continue;
            }
            if(x.charAt(x.length()-1)>='0'&&x.charAt(x.length()-1)<='9'){
                continue;
            }
            result = result+""+ x.charAt(x.length()-1);

        }

        System.out.println(result);
    }

}