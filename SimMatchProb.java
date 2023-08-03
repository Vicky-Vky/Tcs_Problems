import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.*;
class Sim{
    private int id;
    private String company;
    private int balance;
    private double ratePerSecond;
    private String circle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public Sim(int id, String company, int balance, double ratePerSecond, String circle) {
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
}
class SolutionSim{
    public static Sim[] matchAndSort(Sim[] simobj,String search_cirlce,double search_rate){
        int temp =0;
        Sim[] resArr = new Sim[0];
        int[] desArr = new int[0];
        for(Sim x:simobj){
            if((search_cirlce.equals(x.getCircle()))&&(search_rate>x.getRatePerSecond())){
                desArr = Arrays.copyOf(desArr,desArr.length+1);
                desArr[desArr.length-1] = x.getBalance();
                //System.out.println(Arrays.toString(desArr)+"BeforeSort");
            }
        }
        Arrays.sort(desArr);
        //System.out.println(Arrays.toString(desArr)+"After Sort");
        for(int i=0;i<desArr.length;i++){
            for(int j=i+1;j<desArr.length;j++){
                if(desArr[i]<desArr[j]){
                    temp = desArr[i];
                    desArr[i] = desArr[j];
                    desArr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(desArr)+"After des sort");

        for(int i =0;i< desArr.length;i++){
         for(Sim x : simobj){
             if( x.getBalance() == desArr[i]){
                 resArr = Arrays.copyOf(resArr,resArr.length+1);
                 resArr[resArr.length-1]= x;
             }
         }
        }
    return resArr;
    }
}
public class SimMatchProb {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir =  new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        Scanner sc = new Scanner(System.in);

        Sim[] simobj = new Sim[4];
        for(int i=0;i<4;i++){
            int id = Integer.parseInt(br.readLine());
            String company = br.readLine();
            int balancec = Integer.parseInt(br.readLine());
            double ratePerSecond = sc.nextDouble();
            String circle = br.readLine();

            Sim obj = new Sim(id,company,balancec,ratePerSecond,circle);
            simobj[i] = obj;
        }
        String search_circle = br.readLine();
        double search_rate = sc.nextDouble();

        Sim[] resArr = SolutionSim.matchAndSort(simobj,search_circle,search_rate);
        for(Sim x:resArr){
            System.out.println(x.getId());
        }
    }
}