import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Sim1{
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
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

    public Sim1(int simId, String customerName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
}
class SolutionSimTransfer{
    public static Sim1[] transfercircle(Sim1[] simobj,String cirlce1,String circle2){
        Sim1 temp = null;
        Sim1[] sortArr = new Sim1[0];
        for(Sim1 x:simobj){
            if(x.getCircle().equals(cirlce1)){
                x.setCircle(circle2);
                sortArr = Arrays.copyOf(sortArr,sortArr.length+1);
                sortArr[sortArr.length-1]= x;
            }
        }
        for(int i =0;i<sortArr.length;i++){
            for(int j = i+1;j<sortArr.length;j++){
                if(sortArr[i].getRatePerSecond()<sortArr[j].getRatePerSecond()){
                    temp = sortArr[i];
                    sortArr[i] = sortArr[j];
                    sortArr[j] = temp;
                }
            }
        }
        return sortArr;
    }
}
public class SimTransfer {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        Scanner sc = new Scanner(System.in);
        Sim1[] simobj = new Sim1[5];
        for(int i=0;i<5;i++){
            int simId = Integer.parseInt(br.readLine());
            String customerName = br.readLine();
            double balance =  sc.nextDouble();
            double ratePerSecond = sc.nextDouble();
            String circle = br.readLine();

            Sim1 obj = new Sim1(simId,customerName,balance,ratePerSecond,circle);
            simobj[i] = obj;
        }
        String search_cirlce1 = br.readLine();
        String search_circle2 = br.readLine();

        Sim1[] resArr = SolutionSimTransfer.transfercircle(simobj,search_cirlce1,search_circle2);

        for(Sim1 x:resArr){
            System.out.println(x.getSimId()+" "+x.getCustomerName()+" "+x.getCircle()+" "+x.getRatePerSecond());
        }

        }
}