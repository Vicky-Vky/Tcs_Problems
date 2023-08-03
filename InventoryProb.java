import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
class Inventory{
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
    public Inventory(String inventoryId,int maximumQuantity,int currentQuantity,int threshold){
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }
}
class SolutionsInv{
    public static Inventory[] replinish(Inventory inventoryobj[],int limit){
        Inventory inventoryRes[] = new Inventory[0];
        for(Inventory x:inventoryobj){
            if(limit<=x.getThreshold()){
                inventoryRes = Arrays.copyOf(inventoryRes,inventoryRes.length+1);
                inventoryobj[inventoryobj.length-1]=x;
                return inventoryobj;
            }
        }
        return null;
    }
}
public class InventoryProb{
    public static void main(String[] args)throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        Inventory[] inventoryobj = new Inventory[4];
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter Details");
            String inventoryId = br.readLine();
            int maximumQuantity = Integer.parseInt(br.readLine());
            int currentQuantity = Integer.parseInt(br.readLine());
            int threshold = Integer.parseInt(br.readLine());

            Inventory obj = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
            inventoryobj[i] = obj;
        }
        int limit = Integer.parseInt(br.readLine());
        Inventory res[] = SolutionsInv.replinish(inventoryobj, limit);
        for(Inventory x: res){
            if(x.getThreshold()>75){
                System.out.println("Critical Filling");
            }
            if(x.getThreshold()>=50&& x.getThreshold()<75){
                System.out.println("Moderate FIlling");
            }
            else
                System.out.println("Non-Crtical Filling");

        }
    }
}