import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
class Phone{
    private int phoneid;
    private String os;
    private String brand;
    private int price;

    public int getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(int phoneid) {
        this.phoneid = phoneid;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public Phone(int phoneid,String os,String brand,int price){
        this.phoneid =phoneid;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }
}
class SolutionDM{
    public static int findPriceForGivenBrand(Phone Phoneobj[],String brand){
        int sumOfPrice = 0;
        for(Phone x:Phoneobj){
            if(brand.equalsIgnoreCase(x.getBrand())){
                sumOfPrice += x.getPrice();
            }
        }
        if (sumOfPrice!=0){
            return sumOfPrice;
        }
        else
            return 0;
    }
    public static Phone getPhoneIdBasedOnOs(String os,Phone Phoneobj[]){
        for(Phone x:Phoneobj){
            if(os.equalsIgnoreCase(x.getOs())&&x.getPrice()>=50000){
                return x;
            }
        }
        return null;
    }
}
public class Device_Management {
    public static void main(String[] args)throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        Phone Phoneobj[]=new Phone[4];
        String strAr[]=new String[4];
        boolean valid = true;
        for(int i=0;i<4;i++){
            System.out.println("Enter Details");
            int phoneId = Integer.parseInt(br.readLine());
            String os = br.readLine();
            String brand = br.readLine();
            int price = Integer.parseInt(br.readLine());


            for (String temp : strAr){
                if(os.equals(temp) ){
                    valid = false;
                }
            }
            if(valid && price>0){
                Phone obj = new Phone(phoneId,os,brand,price);
                Phoneobj[i]=obj;
            }else
                System.out.println("Element Already Found or 0");
        }
        String searchBrand = br.readLine();
        String searchOs = br.readLine();

        int resSum = SolutionDM.findPriceForGivenBrand(Phoneobj,searchBrand);
        if(resSum>0){
            System.out.println(resSum);
        }else
            System.out.println("No Phone are Available with specified os and price range");
        Phone resObj = SolutionDM.getPhoneIdBasedOnOs(searchOs,Phoneobj);
        if(resObj!=null){
            System.out.println( resObj.getPhoneid());
        }else
            System.out.println("The Given Brand is Not available6");
    }
}