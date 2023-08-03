import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Medicine{
    private String MedicineName;
    private String batch;
    private String disease;
    private int price;

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Medicine(String MedicineName,String batch,String disease,int price){
        this.MedicineName = MedicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }
}
class SolutionMed{
    public static int[] getPriceByDisease(Medicine[] medobj,String disease){
        int[] res=new int[0];
        for(Medicine x: medobj){
            if(disease.equalsIgnoreCase(x.getDisease())){
                res = Arrays.copyOf(res,res.length+1);
                res[res.length-1] = x.getPrice();
            }
        }
        return res;
    }
}
public class MedicineProb{
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        Medicine[] medobj = new Medicine[4];
        for(int i=0;i<4;i++){
            System.out.println("Enter Details");
            String MedicineName = br.readLine();
            String batch = br.readLine();
            String disease = br.readLine();
            int price = Integer.parseInt(br.readLine());

            Medicine obj = new Medicine(MedicineName,batch,disease,price);
            medobj[i] = obj;
        }
        String searchDisease = br.readLine();
        int[] resArr =SolutionMed.getPriceByDisease(medobj,searchDisease);
        for(int x: resArr){
            System.out.println(x);
        }
    }
}