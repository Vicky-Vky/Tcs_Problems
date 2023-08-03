import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class AutonomousCar{
    private int carId;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestesPassed;
    private String environment;
    private String grade;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfTestsConducted() {
        return noOfTestsConducted;
    }

    public void setNoOfTestsConducted(int noOfTestsConducted) {
        this.noOfTestsConducted = noOfTestsConducted;
    }

    public int getNoOfTestesPassed() {
        return noOfTestesPassed;
    }

    public void setNoOfTestesPassed(int noOfTestesPassed) {
        this.noOfTestesPassed = noOfTestesPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public AutonomousCar(int carId,String brand,int noOfTestsConducted,int noOfTestesPassed,String environment){
        this.carId = carId;
        this.brand = brand;
        this.noOfTestesPassed = noOfTestesPassed;
        this.noOfTestsConducted = noOfTestsConducted;
        this.environment=environment;

    }
}

class Solutions{
    public static int findTestPassedByEnv(AutonomousCar Autonomousobj[],String environment){
        int sumOfPassed =0;
        for(AutonomousCar x:Autonomousobj){
            if(environment.equals(x.getEnvironment())){
                sumOfPassed = sumOfPassed + x.getNoOfTestesPassed();
            }
        }
        return sumOfPassed;
    }
    public static AutonomousCar updateCarGrade(AutonomousCar Autonomusobj[],String brand){

        for(AutonomousCar x:Autonomusobj){
            if(brand.equals(x.getBrand())){
                int rating = (x.getNoOfTestesPassed()*100)/x.getNoOfTestsConducted();
                if(rating>=80){
                    x.setGrade("A1");
                    return x;
                }
                else
                    x.setGrade("B1");
                return x;
            }
        }
        return null;
    }

}
public class Autonomous{
    public static void main(String[] args)throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader  br = new BufferedReader(ir);
        AutonomousCar Autonomousobj[] = new AutonomousCar[4];
        for(int i=0;i<4;i++){
            System.out.println("Enter Details");
            int carId = Integer.parseInt(br.readLine());
            String brand = br.readLine();
            int noOfTestConducted = Integer.parseInt(br.readLine());
            int noOfTestPassed = Integer.parseInt(br.readLine());
            String environment = br.readLine();

            AutonomousCar obj = new AutonomousCar(carId,brand,noOfTestConducted,noOfTestPassed,environment);
            Autonomousobj[i] = obj;
        }
        System.out.println("enter SearchEnvi");
        String searchEnvi = br.readLine();
        String searchBrand = br.readLine();
        int sumofPassedRes = Solutions.findTestPassedByEnv(Autonomousobj,searchEnvi);
        if(sumofPassedRes<=0){
            System.out.println("There are no Test Passed In this particular Event");
        }


        AutonomousCar tempObj = Solutions.updateCarGrade(Autonomousobj,searchBrand);
        if(tempObj!=null){
            System.out.println(sumofPassedRes);
            System.out.println(tempObj.getBrand()+"::"+tempObj.getGrade());
        }else
            System.out.println("No Car is available with the specified brand");
    }
}